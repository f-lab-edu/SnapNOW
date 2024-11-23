package kr.flab.snapnow.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode implements ResultCode {

    BAD_REQUEST("Bad Request"),
    UNAUTHORIZED("Unauthorized request"),
    NO_PERMISSION("No permission"),
    NOT_FOUND("Resource not found"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    ILLEGAL_ARGUMENT("Illegal argument"),
    TIMEOUT("Timeout");

    private final String message;
}
