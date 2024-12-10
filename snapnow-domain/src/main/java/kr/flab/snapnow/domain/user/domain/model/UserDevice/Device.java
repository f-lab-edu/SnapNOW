package kr.flab.snapnow.domain.user.domain.model.UserDevice;

import lombok.Builder;
import lombok.Getter;

import kr.flab.snapnow.domain.user.domain.enums.device.DeviceType;

@Getter
@Builder
public class Device {

    private String deviceId;
    private DeviceType deviceType;
    private String deviceModel;
    private String deviceOs;
    private String deviceOsVersion;

    @Builder
    private Device(String deviceId, DeviceType deviceType,
            String deviceModel, String deviceOs, String deviceOsVersion) {
        if (deviceId == null) {
            throw new IllegalArgumentException("Device ID is required");
        }
        if (deviceType == null) {
            throw new IllegalArgumentException("Device type is required");
        }
    }
}
