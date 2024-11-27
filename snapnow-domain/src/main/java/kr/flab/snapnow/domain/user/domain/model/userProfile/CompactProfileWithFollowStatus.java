package kr.flab.snapnow.domain.user.domain.model.userProfile;

import kr.flab.snapnow.domain.user.domain.enums.FollowStatus;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CompactProfileWithFollowStatus extends CompactProfile {

    private FollowStatus followStatus;
}
