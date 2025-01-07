package kr.flab.snapnow.application.auth.service;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import kr.flab.snapnow.domain.user.enums.device.DeviceType;
import kr.flab.snapnow.domain.user.model.userDevice.Device;
import kr.flab.snapnow.domain.user.model.userDevice.UserDevice;
import kr.flab.snapnow.domain.auth.DeviceCredential;
import kr.flab.snapnow.application.user.service.DeviceService;
import kr.flab.snapnow.application.user.service.UserDeviceService;
import kr.flab.snapnow.application.user.output.UserDeviceOutputPort;

@ExtendWith(MockitoExtension.class)
public class UserDeviceServiceTest {

    @Mock
    private DeviceService deviceService;

    @Mock
    private DeviceCredentialService deviceCredentialService;

    @Mock
    private UserDeviceOutputPort userDeviceOutputPort;

    @InjectMocks
    private UserDeviceService userDeviceService;

    @Test
    void insert() {
        // given
        Long userId = 1L;
        String deviceId = "deviceId";
        Device device = Device.builder()
                .deviceId(deviceId)
                .deviceType(DeviceType.ANDROID)
                .build();
        DeviceCredential deviceCredential = DeviceCredential.builder()
                .deviceId(deviceId)
                .userId(userId)
                .build();

        // when
        when(userDeviceOutputPort.count(deviceId)).thenReturn(0);

        // then
        userDeviceService.insert(userId, device);
        verify(deviceService).insert(device);
        verify(deviceCredentialService).insert(deviceCredential);
        verify(userDeviceOutputPort).insert(userId, deviceId);
    }

    @Test
    void count() {
        // given
        Long userId = 1L;

        // when
        when(userDeviceOutputPort.count(userId)).thenReturn(1);

        // then
        assertEquals(1, userDeviceService.count(userId));
    }

    @Test
    void countByDeviceId() {
        // given
        String deviceId = "deviceId";

        // when
        when(userDeviceOutputPort.count(deviceId)).thenReturn(1);

        // then
        assertEquals(1, userDeviceService.count(deviceId));
    }

    @Test
    void delete() {
        // given
        Long userId = 1L;
        String deviceId = "deviceId";

        // when
        when(userDeviceOutputPort.count(deviceId)).thenReturn(1);

        // then
        userDeviceService.delete(userId, deviceId);
        verify(userDeviceOutputPort).delete(userId, deviceId);
        verify(deviceService).delete(deviceId);
    }

    @Test
    void deleteAll() {
        // given
        Long userId = 1L;
        Device device = Device.builder()
                .deviceId("deviceId")
                .deviceType(DeviceType.ANDROID)
                .build();
        Device device2 = Device.builder()
                .deviceId("deviceId2")
                .deviceType(DeviceType.ANDROID)
                .build();
        UserDevice userDevice = UserDevice.builder()
                .userId(userId)
                .devices(Arrays.asList(device, device2))
                .build();

        // when
        when(userDeviceOutputPort.get(userId)).thenReturn(userDevice);
        when(userDeviceOutputPort.count(device.getDeviceId())).thenReturn(1);
        when(userDeviceOutputPort.count(device2.getDeviceId())).thenReturn(1);

        // then
        userDeviceService.deleteAll(userId);
        verify(userDeviceOutputPort).deleteAll(userId);
        verify(deviceService).delete(device.getDeviceId());
        verify(deviceService).delete(device2.getDeviceId());
    }
}
