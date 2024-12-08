package kr.flab.snapnow.infrastructure.postgresql.entity.userProfile;

import kr.flab.snapnow.domain.follow.domain.enums.FollowNotification;
import kr.flab.snapnow.domain.follow.domain.enums.FollowStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

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

    private Long fromUserId;
    private FollowStatus followStatus;
    private FollowNotification followNotification;

    public void setFollowStatus(FollowStatus followStatus) {
        if (followStatus == null) {
            this.followStatus = FollowStatus.SELF;
        } else if (followStatus == FollowStatus.BLOCKED) {
            this.followStatus = FollowStatus.NONE;
        } else {
            this.followStatus = followStatus;
        }
    }
}
