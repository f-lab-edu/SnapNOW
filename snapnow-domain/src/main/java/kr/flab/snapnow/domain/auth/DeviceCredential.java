package kr.flab.snapnow.domain.auth;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.auth.enums.LoginStatus;
import kr.flab.snapnow.domain.auth.exception.LogoutDeviceException;

@Getter
@Builder
public class DeviceCredential {

    private Long id;
    private Long userId;
    private String deviceId;
    private String refreshToken;
    private LoginStatus loginStatus;
    private LocalDateTime logTime;

    private DeviceCredential(Long id, Long userId, String deviceId,
            String refreshToken, LoginStatus loginStatus, LocalDateTime logTime) {
        if (userId == null) {
            throw new IllegalArgumentException("Device Credentail requires User ID");
        }
        if (deviceId == null) {
            throw new IllegalArgumentException("Device Credentail requires Device ID");
        }
        if (loginStatus == null) {
            loginStatus = LoginStatus.LOGOUT;
        }
        if (logTime == null) {
            logTime = LocalDateTime.now();
        }
        this.userId = userId;
        this.deviceId = deviceId;
        this.refreshToken = refreshToken;
        this.loginStatus = loginStatus;
        this.logTime = logTime;
    }

    public void login(String refreshToken) {
        this.refreshToken = refreshToken;
        this.loginStatus = LoginStatus.LOGIN;
        this.logTime = LocalDateTime.now();
    }

    public void logout() {
        this.refreshToken = null;
        this.loginStatus = LoginStatus.LOGOUT;
        this.logTime = LocalDateTime.now();
    }

    public void reissue(String refreshToken) {
        if (this.loginStatus == LoginStatus.LOGOUT) {
            throw new LogoutDeviceException();
        }
        this.refreshToken = refreshToken;
    }
}

