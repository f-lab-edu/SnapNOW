package kr.flab.snapnow.domain.user.domain.exception;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.user.domain.enums.UserExceptionType;

public class DeviceCountExceededException extends BadRequestException {

    public DeviceCountExceededException() {
        super(UserExceptionType.DEVICE_COUNT_EXCEEDED.getMessage());
    }

    public DeviceCountExceededException(String message) {
        super(message);
    }

    public DeviceCountExceededException(Throwable cause) {
        super(UserExceptionType.DEVICE_COUNT_EXCEEDED.getMessage(), cause);
    }

    public DeviceCountExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}
