package kr.flab.snapnow.user.model.dto.response.profile;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.follow.domain.enums.FollowStatus;

@Getter
@Builder
public class ProfileElement {

    private Long userId;
    private String userName;
    private String profileImageUrl;
    private FollowStatus followStatus;
}
