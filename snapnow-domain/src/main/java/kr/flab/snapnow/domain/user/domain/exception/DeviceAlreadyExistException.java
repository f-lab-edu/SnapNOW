package kr.flab.snapnow.domain.user.domain.exception;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.user.domain.enums.UserExceptionType;

public class DeviceAlreadyExistException extends BadRequestException {

    public DeviceAlreadyExistException() {
        super(UserExceptionType.DEVICE_ALREADY_EXISTS.getMessage());
    }

    public DeviceAlreadyExistException(String message) {
        super(message);
    }

    public DeviceAlreadyExistException(Throwable cause) {
        super(UserExceptionType.DEVICE_ALREADY_EXISTS.getMessage(), cause);
    }

    public DeviceAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
