package kr.flab.snapnow.domain.auth.exception;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.auth.enums.AuthExceptionType;

public class LogoutDeviceException extends BadRequestException {

    public LogoutDeviceException() {
        super(AuthExceptionType.LOGOUT_DEVICE);
    }

    public LogoutDeviceException(String message) {
        super(AuthExceptionType.LOGOUT_DEVICE, message);
    }

    public LogoutDeviceException(Throwable cause) {
        super(AuthExceptionType.LOGOUT_DEVICE, cause);
    }

    public LogoutDeviceException(String message, Throwable cause) {
        super(AuthExceptionType.LOGOUT_DEVICE, message, cause);
    }
}
