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
    IDENTITY_REQUIRED("Email or providerId must be provided"),
    INVALID_EMAIL("Invalid email"),
    INVALID_PASSWORD("Invalid password"),
    AUTH_PROVIDER_CANNOT_BE_NULL("Auth provider cannot be null"),
    ACCOUNT_NOT_FOUND("Account not found"),
    ACCOUNT_ALREADY_EXISTS("Account already exists"),

    // UserProfile
    USER_PROFILE_NOT_FOUND("User profile not found"),
    USER_NAME_ALREADY_EXISTS("User name already exists"),

    // UserSetting
    INVALID_SETTING("Invalid matching setting category, type or option");

    private final String message;
}
