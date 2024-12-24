package kr.flab.snapnow.application.auth.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import kr.flab.snapnow.domain.auth.DeviceCredential;
import kr.flab.snapnow.domain.auth.enums.LoginStatus;
import kr.flab.snapnow.domain.auth.exception.LogoutDeviceException;
import kr.flab.snapnow.application.auth.output.DeviceCredentialOutputPort;

public class DeviceCredentialServiceT {
    
    private Long userId;
    private String deviceId;
    private DeviceCredential deviceCredential;

    @Mock
    private DeviceCredentialOutputPort deviceCredentialOutputPort;

    @InjectMocks
    private DeviceCredentialService deviceCredentialService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        userId = 1L;
        deviceId = "deviceId";
        deviceCredential = DeviceCredential.builder()
            .id(1L)
            .userId(userId)
            .deviceId(deviceId)
            .loginStatus(LoginStatus.LOGIN)
            .refreshToken("refreshToken")
            .logTime(LocalDateTime.now())
            .build();

        when(deviceCredentialOutputPort.get(userId, deviceId))
            .thenReturn(deviceCredential);
    }

    @Test
    void get() {
        // when
        DeviceCredential result = deviceCredentialService.get(userId, deviceId);

        // then
        assertEquals(deviceCredential, result);
    }

    @Test
    void login() {
        // given
        String refreshToken = "newRefreshToken";

        // when
        deviceCredentialService.login(userId, deviceId, refreshToken);

        // then
        verify(deviceCredentialOutputPort).update(deviceCredential);
        assertEquals(LoginStatus.LOGIN, deviceCredential.getLoginStatus());
        assertEquals(refreshToken, deviceCredential.getRefreshToken());
    }

    @Test
    void logout() {
        // when
        deviceCredentialService.logout(userId, deviceId);

        // then
        verify(deviceCredentialOutputPort).update(deviceCredential);
        assertEquals(LoginStatus.LOGOUT, deviceCredential.getLoginStatus());
        assertNull(deviceCredential.getRefreshToken());
    }

    @Test
    void reissue() {
        // given
        String refreshToken = "newRefreshToken";

        // when
        deviceCredentialService.reissue(userId, deviceId, refreshToken);

        // then
        verify(deviceCredentialOutputPort).update(deviceCredential);
        assertEquals(LoginStatus.LOGIN, deviceCredential.getLoginStatus());
        assertEquals(refreshToken, deviceCredential.getRefreshToken());
    }

    @Test
    void reissue_when_device_logout() {
        // given
        deviceCredential.logout();

        // when & then
        assertThrows(LogoutDeviceException.class,
                () -> deviceCredentialService.reissue(userId, deviceId, "newRefreshToken"));
    }
}
