package kr.flab.snapnow.application.auth.usecase.dto;

import lombok.Getter;
import lombok.Builder;

@Getter
@Builder
public class SignOutRequest {

    private Long userId;
    private String deviceId;
}
