package kr.flab.snapnow.domain.user.domain.enums;

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
    NEUTRAL("Neutral");

    private final String value;

    public String getCode() {
        return name();
    }
}
