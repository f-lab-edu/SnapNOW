package kr.flab.snapnow.application.auth.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.domain.auth.DeviceCredential;
import kr.flab.snapnow.application.auth.output.DeviceCredentialOutputPort;

@Service
@RequiredArgsConstructor
public class DeviceCredentialService {

    private final DeviceCredentialOutputPort deviceCredentialOutputPort;

    public DeviceCredential get(Long userId, String deviceId) {
        return null;
    }

    public boolean isLogin(Long userId, String deviceId) {
        return false;
    }

    public void login(Long userId, String deviceId, String refreshToken) {
    }

    public void logout(Long userId, String deviceId) {
    }

    public void reissue(Long userId, String deviceId, String refreshToken) {
    }
}
