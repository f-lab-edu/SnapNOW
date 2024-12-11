package kr.flab.snapnow.domain.user.enums.account;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {

    UNKNOWN("Unknown"),
    PRIVATE("Private"),
    MALE("Male"),
    FEMALE("Female"),
    BISEXUAL("Bysexual"),
    NEUTRAL("Neutral"),
    ;

    private final String value;

    public static Gender getDefault() {
        return UNKNOWN;
    }

    public static Gender of(String value) {
        return Arrays.stream(Gender.values())
                .filter(gender -> gender.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Gender value: " + value));
    }


    public String getCode() {
        return name();
    }
}
