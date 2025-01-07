package kr.flab.snapnow.application.user.output;

import kr.flab.snapnow.domain.user.model.userDevice.UserDevice;

public interface UserDeviceOutputPort {

    void insert(Long userId, String deviceId);

    UserDevice get(Long userId);

    int count(Long userId);

    int count(String deviceId);

    void delete(Long userId, String deviceId);
}
