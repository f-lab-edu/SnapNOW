package kr.flab.snapnow.domain.user.domain.model.userProfile;

import kr.flab.snapnow.domain.user.domain.enums.FollowStatus;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import kr.flab.snapnow.domain.user.domain.exception.UserRequiredArgumentException;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompactProfileWithFollowStatus extends CompactProfile {

    private FollowStatus followStatus;

    private CompactProfileWithFollowStatus(
            Long userId, String userName, String profileImageUrl, FollowStatus followStatus) {
        super(userId, userName, profileImageUrl);

        if (followStatus == null) {
            throw new UserRequiredArgumentException("Follow status is required");
        }
        this.followStatus = followStatus;
    }
}
