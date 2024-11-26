package kr.flab.snapnow.domain.user.model.user_profile;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import kr.flab.snapnow.domain.user.enums.FollowStatus;

@Getter
@SuperBuilder
public class FullProfile extends UserProfile {

    private int postCount;
    private int followerCount;
    private int followingCount;

    private String postCountText;
    private String followerCountText;
    private String followingCountText;

    private FollowStatus followStatus;

    // Todo: count 입력 시 단위에 따른 텍스트 변환 로직 추가 (builer override)
}
