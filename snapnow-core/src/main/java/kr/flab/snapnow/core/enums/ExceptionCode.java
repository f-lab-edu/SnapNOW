package kr.flab.snapnow.core.enums;

public enum ExceptionCode implements ResultCode {

    BAD_REQUEST("Bad Request"),
    UNAUTHORIZED("Unauthorized request"),
    NO_PERMISSION("No permission"),
    NOT_FOUND("Resource not found"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    ILLEGAL_ARGUMENT("Illegal argument"),
    TIMEOUT("Timeout");

    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
