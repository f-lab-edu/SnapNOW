package kr.flab.snapnow.domain.user.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import kr.flab.snapnow.core.enums.ResultCode;

@Getter
@RequiredArgsConstructor
public enum UserExceptionType implements ResultCode {

    // UserAccount
    IDENTITY_MUST_BE_PROVIDED("Email or providerId must be provided"),
    INVALID_EMAIL("Invalid email"),
    PASSWORD_CANNOT_BE_BLANK("Password cannot be blank"),
    AUTH_PROVIDER_CANNOT_BE_NULL("Auth provider cannot be null"),
    INVALID_PASSWORD("Invalid password"),

    // UserSetting
    INVALID_SETTING("Invalid matching setting category, type or option");

    private final String message;
}
