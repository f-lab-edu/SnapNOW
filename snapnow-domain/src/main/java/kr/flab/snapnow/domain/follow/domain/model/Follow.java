package kr.flab.snapnow.domain.follow.domain.model;

import lombok.Getter;
import lombok.Builder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import kr.flab.snapnow.domain.follow.domain.enums.FollowStatus;
import kr.flab.snapnow.domain.follow.domain.enums.FollowNotification;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Follow {

    private Long userId;
    private Long targetUserId;

    private FollowStatus followStatus;
    private FollowNotification followNotification;

    private Follow(Long userId, Long targetUserId, FollowStatus followStatus,
            FollowNotification followNotification) {
        if (userId == null) {
            userId = targetUserId;
        }
        if (userId == targetUserId || followStatus == null) {
            followStatus = FollowStatus.SELF;
        }
        if (followStatus == FollowStatus.FOLLOWING && followNotification == null) {
            followNotification = FollowNotification.getDefault();
        }
        if (followStatus != FollowStatus.FOLLOWING && followNotification != null) {
            followNotification = null;
        }
        this.userId = userId;
        this.targetUserId = targetUserId;
        this.followStatus = followStatus;
        this.followNotification = followNotification;
    }

    public void updateFollowNotification(FollowNotification followNotification) {
        if (followStatus != FollowStatus.FOLLOWING) {
            return;
        }
        if (followNotification == null) {
            followNotification = FollowNotification.getDefault();
        }
        this.followNotification = followNotification;
    }
}
