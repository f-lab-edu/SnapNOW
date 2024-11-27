package kr.flab.snapnow.user.dto.response.profile;

import kr.flab.snapnow.domain.user.enums.FollowStatus;

import lombok.Getter;
import lombok.Builder;

@Getter
@Builder
public class ProfileElement {

    private Long userId;
    private String userName;
    private String profileImageUrl;
    private FollowStatus followStatus;
}
