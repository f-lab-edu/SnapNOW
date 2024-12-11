package kr.flab.snapnow.domain.user.exception;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.user.enums.UserExceptionType;

public class DeviceNotFoundExcpetion extends BadRequestException {

    public DeviceNotFoundExcpetion() {
        super(UserExceptionType.DEVICE_NOT_FOUND.getMessage());
    }

    public DeviceNotFoundExcpetion(String message) {
        super(message);
    }

    public DeviceNotFoundExcpetion(Throwable cause) {
        super(UserExceptionType.DEVICE_NOT_FOUND.getMessage(), cause);
    }

    public DeviceNotFoundExcpetion(String message, Throwable cause) {
        super(message, cause);
    }
}
