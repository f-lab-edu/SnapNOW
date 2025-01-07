package kr.flab.snapnow.domain.user.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import kr.flab.snapnow.core.enums.ResultCode;
import kr.flab.snapnow.domain.user.domain.constants.UserDeviceConstants;

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
    USER_NAME_ALREADY_EXISTS("User name already exists"),

    // UserDevice
    DEVICE_COUNT_EXCEEDED(
        "Device count exceeded (Max " + UserDeviceConstants.MAX_DEVICES + ")"),
    DEVICE_NOT_FOUND("Device not found"),
    DEVICE_ALREADY_EXISTS("Device already exists"),
    ;

    private final String message;
}

