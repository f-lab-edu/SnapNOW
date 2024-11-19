package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ExceptionCode;
import kr.flab.snapnow.core.enums.ResultCode;

public class NoPermissionException extends SnapnowException {

    public NoPermissionException() {
        super(ExceptionCode.NO_PERMISSION);
    }

    public NoPermissionException(ResultCode resultCode) {
        super(resultCode);
    }

    public NoPermissionException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public NoPermissionException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }
}
