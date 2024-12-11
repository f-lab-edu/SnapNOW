package kr.flab.snapnow.domain.user.domain.model.userDevice;

import java.util.List;

import lombok.Getter;
import lombok.Builder;

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
        if (devices.size() > 5) {
            throw new IllegalArgumentException("Device count exceeded (Max 5)");
        }
    }
}

