package kr.flab.snapnow.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType implements ResultCode {

    BAD_REQUEST("Bad Request"),
    UNAUTHORIZED("Unauthorized request"),
    NOT_FOUND("Resource not found"),
    FORBIDDEN("Forbidden"),
    ;

    private final String message;
}
