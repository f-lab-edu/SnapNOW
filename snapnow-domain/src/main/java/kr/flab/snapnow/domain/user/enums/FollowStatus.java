package kr.flab.snapnow.domain.user.enums;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public enum FollowStatus {

    FOLLOWING("following"),
    FOLLOWED("followed"),
    BLOCKED("blocked"),
    SELF("self");

    private String value;
}
