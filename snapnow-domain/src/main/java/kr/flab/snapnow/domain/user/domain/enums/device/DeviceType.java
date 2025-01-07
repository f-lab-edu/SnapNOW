package kr.flab.snapnow.domain.user.domain.enums.device;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DeviceType {

    ANDROID("Android"),
    IOS("iOS"),
    WEB("Web"),
    OTHER("Other"),
    ;

    private final String value;

    public static DeviceType of(String deviceType) {
        return DeviceType.valueOf(deviceType.toUpperCase());
    }
}
