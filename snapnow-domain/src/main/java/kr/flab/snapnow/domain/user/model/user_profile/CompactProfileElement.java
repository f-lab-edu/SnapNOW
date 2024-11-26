package kr.flab.snapnow.domain.user.model.user_profile;

import kr.flab.snapnow.domain.user.enums.FollowStatus;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CompactProfileElement extends CompactProfile {

    private FollowStatus followStatus;
}
