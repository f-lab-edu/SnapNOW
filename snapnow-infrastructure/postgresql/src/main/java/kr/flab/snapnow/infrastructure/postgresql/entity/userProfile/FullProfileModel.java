package kr.flab.snapnow.infrastructure.postgresql.entity.userProfile;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.FollowStatus;

@Getter
@Setter
@NoArgsConstructor
public class FullProfileModel {

    private Long userId;
    private String userName;
    private String fullName;
    private String biography;
    private String profileImageUrl;

    private int postCount;
    private int followerCount;
    private int followingCount;

    private FollowStatus followStatus;

    public void setFollowStatus(FollowStatus followStatus) {
        if (followStatus == null || followStatus == FollowStatus.BLOCKED) {
            this.followStatus = FollowStatus.NONE;
        } else {
            this.followStatus = followStatus;
        }
    }
}
