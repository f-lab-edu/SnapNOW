package kr.flab.snapnow.domain.auth.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import kr.flab.snapnow.core.enums.ResultCode;

@Getter
@RequiredArgsConstructor
public enum AuthExceptionType implements ResultCode {

    // email verification
    EMAIL_AUTH_ATTEMPT_EXCEEDED("Email auth attempt exceeded"),
    INVALID_VERIFICATION_CODE("Invalid verification code"),
    EMAIL_NOT_VERIFIED("Email not verified"),

    // password
    INVALID_PASSWORD("Password should be at least 8 characters long and contain at least one letter and one number"),
    WRONG_PASSWORD("Wrong password"),

    // token
    INVALID_TOKEN("Invalid token"),
    EXPIRED_TOKEN("Token has been expired"),
    LOGOUT_DEVICE("Device has already been logged out"),
    ;

    private final String message;
}
