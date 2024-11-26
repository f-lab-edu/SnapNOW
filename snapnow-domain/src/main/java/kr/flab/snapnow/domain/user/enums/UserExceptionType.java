package kr.flab.snapnow.domain.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import kr.flab.snapnow.core.enums.ResultCode;

@Getter
@RequiredArgsConstructor
public enum UserExceptionType implements ResultCode {

    INVALID_SETTING("Invalid matching setting category, type or option");

    private final String message;
}
