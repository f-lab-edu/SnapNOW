package kr.flab.snapnow.application.user.output;

import kr.flab.snapnow.domain.user.model.userDevice.Device;

public interface DeviceOutputPort {

    void insert(Device device);

    void delete(String deviceId);
}
