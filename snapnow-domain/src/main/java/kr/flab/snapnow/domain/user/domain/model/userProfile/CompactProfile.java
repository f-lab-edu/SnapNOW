package kr.flab.snapnow.domain.user.domain.model.userProfile;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import kr.flab.snapnow.domain.user.domain.exception.UserRequiredArgumentException;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompactProfile {

    private Long userId;
    private String userName;
    private String profileImageUrl;

    protected CompactProfile(Long userId, String userName, String profileImageUrl) {
        if (userId == null) {
            throw new UserRequiredArgumentException("User ID is required");
        }
        if (userName == null) {
            throw new UserRequiredArgumentException("User name is required");
        }
        if (profileImageUrl == null) {
            throw new UserRequiredArgumentException("Profile image URL is required");
        }

        this.userId = userId;
        this.userName = userName;
        this.profileImageUrl = profileImageUrl;
    }
}
