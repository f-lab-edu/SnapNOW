package kr.flab.snapnow.domain.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import kr.flab.snapnow.core.enums.ResultCode;

@Getter
@RequiredArgsConstructor
public enum AuthExceptionType implements ResultCode {

    USER_NOT_MATCH_PASSWORD("User not match password"),
    ;

    private final String message;
}
