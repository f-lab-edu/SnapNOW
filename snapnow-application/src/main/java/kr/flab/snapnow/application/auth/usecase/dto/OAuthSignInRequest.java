package kr.flab.snapnow.application.auth.usecase.dto;

import lombok.Getter;
import lombok.Builder;

@Getter
@Builder
public class OAuthSignInRequest {

    private String providerId;
    private String deviceId;
}
