package kr.flab.snapnow.user.dto.response.profile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.enums.FollowStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    // follower 알림 설정

    private boolean isPrivate;

    // Todo: count 입력 시 단위에 따른 텍스트 변환 로직 추가 (builer override)
}
