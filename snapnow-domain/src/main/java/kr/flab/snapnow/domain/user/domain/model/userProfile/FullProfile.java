package kr.flab.snapnow.domain.user.domain.model.userProfile;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.domain.enums.FollowStatus;

@Getter
@Builder
public class FullProfile {

    private UserProfile userProfile;

    private int postCount;
    private int followerCount;
    private int followingCount;

    private FollowStatus followStatus;

    @Builder
    protected FullProfile(
            UserProfile userProfile,
            int postCount, int followerCount, int followingCount, FollowStatus followStatus) {
        if (followStatus == null) {
            followStatus = FollowStatus.SELF;
        }

        this.postCount = postCount;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
        this.followStatus = followStatus;
    }

    @Builder
    protected FullProfile(Long userId, String userName, String fullName, String biography, String profileImageUrl,
            int postCount, int followerCount, int followingCount, FollowStatus followStatus) {
        this(UserProfile.builder()
                .userId(userId)
                .userName(userName)
                .fullName(fullName)
                .biography(biography)
                .profileImageUrl(profileImageUrl)
                .build(), postCount, followerCount, followingCount, followStatus);
    }
}
