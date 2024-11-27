package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ExceptionType;
import kr.flab.snapnow.core.enums.ResultCode;

public class NoPermissionException extends SnapnowException {

    public NoPermissionException() {
        super(ExceptionType.NO_PERMISSION);
    }

    public NoPermissionException(ResultCode resultCode) {
        super(resultCode);
    }

    public NoPermissionException(String message) {
        super(ExceptionType.NO_PERMISSION, message);
    }

    public NoPermissionException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public NoPermissionException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public NoPermissionException(String message, Throwable cause) {
        super(ExceptionType.NO_PERMISSION, message, cause);
    }

    public NoPermissionException(ResultCode resultCode, String message, Throwable cause) {
        super(resultCode, message, cause);
    }
}
