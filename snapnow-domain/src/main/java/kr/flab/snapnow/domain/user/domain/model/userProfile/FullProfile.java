package kr.flab.snapnow.domain.user.domain.model.userProfile;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import kr.flab.snapnow.domain.user.domain.enums.FollowStatus;

@Getter
@SuperBuilder
public class FullProfile extends UserProfile {

    private int postCount;
    private int followerCount;
    private int followingCount;

    private FollowStatus followStatus;
}
