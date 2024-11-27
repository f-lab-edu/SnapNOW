package kr.flab.snapnow.user.model.dto.response.profile;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.domain.enums.FollowStatus;

@Getter
@Builder
public class UserProfileResponse {

    private Long userId;
    private String userName;
    private String fullName;
    private String profileImageUrl;

    private int postCount;
    private String postCountText;
    private int followerCount;
    private String followerCountText;
    private int followingCount;
    private String followingCountText;

    private FollowStatus followStatus;
    // Todo: follower 알림 설정 필드 추가
    // Todo: count 입력 시 단위에 따른 텍스트 변환 로직 추가 (builer override)
}
