package kr.flab.snapnow.application.auth.usecase.dto;

import lombok.Getter;
import lombok.Builder;

@Getter
@Builder
public class ReissueRequest {

    private String refreshToken;
    private String deviceId;
}
