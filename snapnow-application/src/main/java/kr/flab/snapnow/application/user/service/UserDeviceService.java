package kr.flab.snapnow.application.user.service;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.flab.snapnow.application.auth.service.DeviceCredentialService;
import kr.flab.snapnow.application.user.output.UserDeviceOutputPort;
import kr.flab.snapnow.domain.user.model.userDevice.UserDevice;
import kr.flab.snapnow.domain.user.model.userDevice.Device;
import kr.flab.snapnow.domain.auth.DeviceCredential;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserDeviceService {

    private final DeviceService deviceService;
    private final DeviceCredentialService deviceCredentialService;
    private final UserDeviceOutputPort userDeviceOutputPort;

    @Transactional
    public void insert(Long userId, Device device) {
        if (count(device.getDeviceId()) == 0) {
            deviceService.insert(device);
        }

        DeviceCredential deviceCredential = DeviceCredential.builder()
            .deviceId(device.getDeviceId())
            .userId(userId)
            .build();
        deviceCredentialService.insert(deviceCredential);
        userDeviceOutputPort.insert(userId, device.getDeviceId());
    }

    public int count(Long userId) {
        return userDeviceOutputPort.count(userId);
    }

    public int count(String deviceId) {
        return userDeviceOutputPort.count(deviceId);
    }

    @Transactional
    public void delete(Long userId, String deviceId) {
        userDeviceOutputPort.delete(userId, deviceId);

        if (count(deviceId) == 1) {
            deviceService.delete(deviceId);
        }
    }

    @Transactional
    public void deleteAll(Long userId) {
        UserDevice userDevice = userDeviceOutputPort.get(userId);
        List<Device> devices = userDevice.getDevices();

        userDeviceOutputPort.deleteAll(userId);
        for (Device device : devices) {
            delete(userId, device.getDeviceId());
        }
    }
}
