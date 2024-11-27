package kr.flab.snapnow.infrastructure.postgresql.entity.userProfile;

import lombok.Getter;
import lombok.Setter;

import kr.flab.snapnow.domain.user.domain.enums.FollowStatus;

@Getter
@Setter
public class CompactProfileWithFollowStatusModel extends CompactProfileModel {

    private FollowStatus followStatus;

    public CompactProfileWithFollowStatusModel() {
        super();
    }

    public void setFollowStatus(FollowStatus followStatus) {
        if (followStatus == null || followStatus == FollowStatus.BLOCKED) {
            this.followStatus = FollowStatus.NONE;
        } else {
            this.followStatus = followStatus;
        }
    }
}
