package kr.flab.snapnow.domain.user.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import kr.flab.snapnow.core.enums.ResultCode;

@Getter
@RequiredArgsConstructor
public enum UserExceptionType implements ResultCode {

    USER_NOT_FOUND("User not found"),
    DELETED_USER("Deleted user"),
    USER_ALREADY_EXISTS("User already exists"),

    // UserAccount
    EMAIL_AUTH_ATTEMPT_EXCEEDED("Email auth attempt exceeded"),
    INVALID_VERIFICATION_CODE("Invalid verification code"),
    EMAIL_NOT_VERIFIED("Email not verified"),

    // UserProfile
    USER_NAME_ALREADY_EXISTS("User name already exists");
    ;

    private final String message;
}

