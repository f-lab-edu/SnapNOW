package kr.flab.snapnow.domain.user.model.userProfile;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.follow.model.Follow;

@Getter
@Builder
public class FullProfile {

    private UserProfile userProfile;

    private int postCount;
    private int followerCount;
    private int followingCount;

    private Follow follow;

    @Builder
    protected FullProfile(UserProfile userProfile, int postCount, int followerCount,
            int followingCount, Follow follow) {
        this.postCount = postCount;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
        this.follow = follow;
    }
}
