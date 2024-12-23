package kr.flab.snapnow.domain.user.model.userDevice;

import kr.flab.snapnow.domain.user.enums.device.DeviceType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Device {

    private String deviceId;
    private String deviceToken;

    private DeviceType deviceType;
    private String deviceModel;
    private String deviceOs;
    private String deviceOsVersion;

    @Builder
    private Device(String deviceId, String deviceToken,
            DeviceType deviceType, String deviceModel, String deviceOs, String deviceOsVersion) {
        if (deviceId == null) {
            throw new IllegalArgumentException("Device ID is required");
        }
        if (deviceType == null) {
            throw new IllegalArgumentException("Device type is required");
        }
        // TODO: 디바이스 토큰 필수. 현재 구현이 안되어있어 생략...
    }

    public void updateDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
