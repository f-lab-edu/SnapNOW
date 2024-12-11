package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ExceptionType;
import kr.flab.snapnow.core.enums.ResultCode;

public class ForbiddenException extends SnapnowException {

    public ForbiddenException() {
        super(ExceptionType.FORBIDDEN);
    }

    public ForbiddenException(ResultCode resultCode) {
        super(resultCode);
    }

    public ForbiddenException(String message) {
        super(ExceptionType.FORBIDDEN, message);
    }

    public ForbiddenException(Throwable cause) {
        super(ExceptionType.FORBIDDEN, cause);
    }
}
