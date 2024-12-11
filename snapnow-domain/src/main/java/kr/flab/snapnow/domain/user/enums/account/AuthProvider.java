package kr.flab.snapnow.domain.user.enums.account;

import java.util.Arrays;

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

    public static AuthProvider of(String value) {
        return Arrays.stream(AuthProvider.values())
                .filter(authProvider -> authProvider.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid AuthProvider value: " + value));
    }

    public String getCode() {
        return name();
    }
}
