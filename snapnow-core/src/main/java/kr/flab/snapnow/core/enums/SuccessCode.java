package kr.flab.snapnow.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessCode implements ResultCode {

    SUCCESS("Success");

    private final String message;
}
