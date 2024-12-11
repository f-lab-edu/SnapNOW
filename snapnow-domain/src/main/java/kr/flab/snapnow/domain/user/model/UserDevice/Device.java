package kr.flab.snapnow.domain.user.model.userDevice;

import kr.flab.snapnow.domain.user.enums.device.DeviceType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Device {

    private String deviceId;
    private DeviceType deviceType;
    private String deviceModel;
    private String deviceOs;
    private String deviceOsVersion;

    private String refreshToken;

    @Builder
    private Device(String deviceId, DeviceType deviceType, String deviceModel,
            String deviceOs, String deviceOsVersion, String refreshToken) {
        if (deviceId == null) {
            throw new IllegalArgumentException("Device ID is required");
        }
        if (deviceType == null) {
            throw new IllegalArgumentException("Device type is required");
        }
    }
}
