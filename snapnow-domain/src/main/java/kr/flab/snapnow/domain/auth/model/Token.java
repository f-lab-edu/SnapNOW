package kr.flab.snapnow.domain.auth.model;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class Token {

    private String accessToken;
    private String refreshToken;
}
