package kr.flab.snapnow.domain.user.enums.account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthProvider {

    EMAIL("email"),
    KAKAO("kakao"),
    NAVER("naver"),
    GOOGLE("google"),
    APPLE("apple");

    private final String value;

    public String getCode() {
        return name();
    }
}
