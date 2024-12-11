package kr.flab.snapnow.domain.user.model.userDevice;

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
        if (devices == null || devices.isEmpty()) {
            throw new IllegalArgumentException("Devices are required");
        }
        if (devices.size() > 5) {
            throw new IllegalArgumentException("Device count exceeded (Max 5)");
        }
        this.userId = userId;
        this.devices = devices;
    }
}

