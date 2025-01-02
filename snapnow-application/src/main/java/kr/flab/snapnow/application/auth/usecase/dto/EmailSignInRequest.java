package kr.flab.snapnow.application.auth.usecase.dto;

import lombok.Getter;
import lombok.Builder;

@Getter
@Builder
public class EmailSignInRequest {

    private String email;
    private String password;
    private String deviceId;
}
