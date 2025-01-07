package kr.flab.snapnow.application.user.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import kr.flab.snapnow.application.user.output.DeviceOutputPort;
import kr.flab.snapnow.domain.user.model.userDevice.Device;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceOutputPort deviceOutputPort;

    public void insert(Device device) {
        deviceOutputPort.insert(device);
    }

    public void delete(String deviceId) {
        deviceOutputPort.delete(deviceId);
    }
}
