package kr.flab.snapnow.domain.user.model.userProfile;

import kr.flab.snapnow.domain.user.enums.FollowStatus;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CompactProfileWithFollowStatus extends CompactProfile {

    private FollowStatus followStatus;
}
