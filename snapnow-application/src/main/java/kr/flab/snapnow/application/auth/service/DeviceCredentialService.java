package kr.flab.snapnow.application.auth.service;

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

    public boolean isLogin(Long userId, String deviceId) {
        DeviceCredential deviceCredential = get(userId, deviceId);

        return deviceCredential.getLoginStatus() == LoginStatus.LOGIN;
    }

    public void login(Long userId, String deviceId, String refreshToken) {
        DeviceCredential deviceCredential = get(userId, deviceId);

        deviceCredential.login(refreshToken);
        deviceCredentialOutputPort.update(deviceCredential);
    }

    public void logout(Long userId, String deviceId) {
        DeviceCredential deviceCredential = get(userId, deviceId);

        deviceCredential.logout();
        deviceCredentialOutputPort.update(deviceCredential);
    }

    public void reissue(Long userId, String deviceId, String refreshToken) {
        DeviceCredential deviceCredential = get(userId, deviceId);

        deviceCredential.reissue(refreshToken);
        deviceCredentialOutputPort.update(deviceCredential);
    }

    public void delete(Long userId, String deviceId) {
        deviceCredentialOutputPort.delete(userId, deviceId);
    }
}
