package kr.flab.snapnow.domain.user.model.userProfile;

import lombok.Getter;
import lombok.Builder;
import kr.flab.snapnow.domain.follow.enums.FollowStatus;

@Getter
@Builder
public class UserProfile {

    private Long userId;
    private String userName;
    private String fullName;
    private String biography;
    private String profileImageUrl;

    private FollowStatus followStatus;

    protected UserProfile(Long userId, String userName, String fullName, String biography,
            String profileImageUrl, FollowStatus followStatus) {
        if (userName == null) {
            throw new IllegalArgumentException("User name is required");
        }
        if (profileImageUrl == null) {
            throw new IllegalArgumentException("Profile image URL is required");
        }
        if (followStatus == null) {
            followStatus = FollowStatus.SELF;
        }

        this.userId = userId;
        this.userName = userName;
        this.fullName = fullName;
        this.biography = biography;
        this.profileImageUrl = profileImageUrl;
        this.followStatus = followStatus;
    }
}
