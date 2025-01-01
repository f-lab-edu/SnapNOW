package kr.flab.snapnow.domain.user.domain.model.userDevice;

import java.util.List;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.domain.constants.UserDeviceConstants;
import kr.flab.snapnow.domain.user.domain.enums.UserExceptionType;

@Getter
@Builder
public class UserDevice {

    private Long userId;
    private List<Device> devices;

    @Builder
    private UserDevice(Long userId, List<Device> devices) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID is required");
        }
        if (devices == null) {
            throw new IllegalArgumentException("Devices are required");
        }
        if (devices.size() > UserDeviceConstants.MAX_DEVICES) {
            throw new IllegalArgumentException(
                UserExceptionType.DEVICE_COUNT_EXCEEDED.getMessage());
        }
    }
}

