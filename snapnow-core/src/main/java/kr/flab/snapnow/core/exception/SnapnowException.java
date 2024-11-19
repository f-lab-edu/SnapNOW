package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ResultCode;

public class SnapnowException extends RuntimeException {

    private final ResultCode code;

    protected SnapnowException(ResultCode code) {
        super(code.getMessage());
        this.code = code;
    }

    protected SnapnowException(ResultCode code, String message) {
        super(message);
        this.code = code;
    }

    protected SnapnowException(ResultCode code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    protected SnapnowException(ResultCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ResultCode getResultCode() {
    return code;
    }
}
