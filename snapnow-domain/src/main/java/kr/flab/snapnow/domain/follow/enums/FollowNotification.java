package kr.flab.snapnow.domain.follow.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FollowNotification {

    ALL("All", "Accept all follow activities"),
    SOME("Some", "Accept only snap request and tag"),
    TURN_OFF("Turn Off", "Turn off all activities");

    private final String value;
    private final String description;

    public static FollowNotification getDefault() {
        return ALL;
    }
}
