package kr.flab.snapnow.application.auth.service;

import java.util.List;
import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.domain.auth.DeviceCredential;
import kr.flab.snapnow.domain.auth.enums.LoginStatus;
import kr.flab.snapnow.application.auth.output.DeviceCredentialOutputPort;

@Service
@RequiredArgsConstructor
public class DeviceCredentialService {

    private final DeviceCredentialOutputPort deviceCredentialOutputPort;

    public void insert(DeviceCredential deviceCredential) {
        deviceCredentialOutputPort.insert(deviceCredential);
    }

    public DeviceCredential get(Long userId, String deviceId) {
        return deviceCredentialOutputPort.get(userId, deviceId);
    }

    public List<DeviceCredential> getAll(Long userId) {
        return deviceCredentialOutputPort.getAll(userId);
    }

    public boolean isLogin(Long userId, String deviceId) {
        DeviceCredential deviceCredential = get(userId, deviceId);

        return deviceCredential.getLoginStatus() == LoginStatus.LOGIN;
    }

    public void login(Long userId, String deviceId, String refreshToken, LocalDateTime expriedAt) {
        DeviceCredential deviceCredential = get(userId, deviceId);

        deviceCredential.login(refreshToken, expriedAt);
        deviceCredentialOutputPort.update(deviceCredential);
    }

    public void logout(Long userId, String deviceId) {
        DeviceCredential deviceCredential = get(userId, deviceId);

        deviceCredential.logout();
        deviceCredentialOutputPort.update(deviceCredential);
    }

    public void reissue(
        Long userId, String deviceId, String refreshToken, LocalDateTime expriedAt) {
        DeviceCredential deviceCredential = get(userId, deviceId);

        deviceCredential.reissue(refreshToken, expriedAt);
        deviceCredentialOutputPort.update(deviceCredential);
    }

    public void delete(Long userId, String deviceId) {
        deviceCredentialOutputPort.delete(userId, deviceId);
    }
}
