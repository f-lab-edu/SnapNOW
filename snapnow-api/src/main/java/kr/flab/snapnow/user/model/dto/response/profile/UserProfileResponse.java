package kr.flab.snapnow.user.model.dto.response.profile;

import lombok.Getter;
import lombok.Builder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.follow.domain.enums.FollowNotification;
import kr.flab.snapnow.domain.follow.domain.enums.FollowStatus;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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

    private Long fromUserId;
    private FollowStatus followStatus;
    private FollowNotification followNotification;

    public static class UserProfileResponseBuilder {

        public UserProfileResponse build() {
            // Todo: count 입력 시 단위에 따른 텍스트 변환 로직 추가 (builer override)
            return new UserProfileResponse(userId, userName, fullName, profileImageUrl, postCount,
                    postCountText, followerCount, followerCountText, followingCount,
                    followingCountText, fromUserId, followStatus, followNotification);
        }
    }
}
