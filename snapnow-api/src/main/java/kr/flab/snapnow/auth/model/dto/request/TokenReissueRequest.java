package kr.flab.snapnow.auth.model.dto.request;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TokenReissueRequest {

    private String refreshToken;
}
