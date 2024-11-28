package kr.flab.snapnow.auth.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import kr.flab.snapnow.core.enums.ResultCode;

@Getter
@RequiredArgsConstructor
public enum AuthExceptionType implements ResultCode {

    REFRESH_TOKEN_NOT_FOUND("Refresh token not found"),
    WRONG_PASSWORD("Wrong password"),
    INVALID_TOKEN("Invalid token"),
    EXPIRED_TOKEN("Expired token"),
    INVALID_SIGNATURE("Invalid signature"),
    UNSUPPORTED_TOKEN("Unsupported token"),
    ILLEGAL_ARGUMENT_TOKEN("Token is empty or invalid");

    private final String message;
}
