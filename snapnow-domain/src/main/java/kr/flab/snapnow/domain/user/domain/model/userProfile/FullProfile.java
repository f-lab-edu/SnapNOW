package kr.flab.snapnow.domain.user.domain.model.userProfile;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.FollowStatus;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FullProfile extends UserProfile {

    private int postCount;
    private int followerCount;
    private int followingCount;

    private FollowStatus followStatus;

    private FullProfile(
            Long userId, String userName, String fullName, String biography, String profileImageUrl,
            int postCount, int followerCount, int followingCount, FollowStatus followStatus) {
        super(userId, userName, fullName, biography, profileImageUrl);

        if (followStatus == null) {
            followStatus = FollowStatus.SELF;
        }

        this.postCount = postCount;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
        this.followStatus = followStatus;
    }
}
