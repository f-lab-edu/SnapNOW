package kr.flab.snapnow.domain.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import kr.flab.snapnow.core.enums.ResultCode;

@Getter
@RequiredArgsConstructor
public enum UserExceptionType implements ResultCode {

    USER_NOT_FOUND("User not found"),
    DELETED_USER("Deleted user"),
    USER_ALREADY_EXISTS("User already exists"),

    // UserProfile
    USER_NAME_ALREADY_EXISTS("User name already exists"),

    // UserDevice
    DEVICE_COUNT_EXCEEDED("Device count exceeded (Max 5)"),
    DEVICE_NOT_FOUND("Device not found"),
    DEVICE_ALREADY_EXISTS("Device already exists"),
    ;

    private final String message;
}

