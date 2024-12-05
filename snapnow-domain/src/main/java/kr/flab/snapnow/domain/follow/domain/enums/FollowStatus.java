package kr.flab.snapnow.domain.follow.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FollowStatus {

    FOLLOWING("following"),
    FOLLOWED("followed"),
    BLOCKED("blocked"),
    NONE("none"),
    SELF("self");

    private final String value;
}
