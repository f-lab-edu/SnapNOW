package kr.flab.snapnow.domain.auth;

import java.time.LocalDateTime;
import java.util.Objects;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.auth.enums.LoginStatus;
import kr.flab.snapnow.domain.auth.exception.LogoutDeviceException;
import kr.flab.snapnow.domain.auth.exception.ExpiredTokenException;

@Getter
@Builder
public class DeviceCredential {

    private Long userId;
    private String deviceId;
    private String refreshToken;
    private LocalDateTime expiredAt;
    private LoginStatus loginStatus;
    private LocalDateTime logTime;

    private DeviceCredential(Long userId, String deviceId,
            String refreshToken, LocalDateTime expiredAt, LoginStatus loginStatus, LocalDateTime logTime) {
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
        this.expiredAt = expiredAt;
        this.loginStatus = loginStatus;
        this.logTime = logTime;
    }

    public void login(String refreshToken, LocalDateTime expiredAt) {
        this.refreshToken = refreshToken;
        this.expiredAt = expiredAt;
        this.loginStatus = LoginStatus.LOGIN;
        this.logTime = LocalDateTime.now();
    }

    public void logout() {
        this.refreshToken = null;
        this.expiredAt = null;
        this.loginStatus = LoginStatus.LOGOUT;
        this.logTime = LocalDateTime.now();
    }

    public void reissue(String refreshToken, LocalDateTime expiredAt) {
        if (this.loginStatus == LoginStatus.LOGOUT) {
            throw new LogoutDeviceException();
        }
        if (this.expiredAt.isBefore(LocalDateTime.now())) {
            throw new ExpiredTokenException();
        }

        this.refreshToken = refreshToken;
        this.expiredAt = expiredAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        DeviceCredential that = (DeviceCredential) obj;
        return Objects.equals(userId, that.userId)
                && Objects.equals(deviceId, that.deviceId)
                && Objects.equals(refreshToken, that.refreshToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, deviceId, refreshToken);
    }
}

