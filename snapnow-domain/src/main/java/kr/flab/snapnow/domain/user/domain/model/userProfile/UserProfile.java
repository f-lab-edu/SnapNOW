package kr.flab.snapnow.domain.user.domain.model.userProfile;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import kr.flab.snapnow.domain.user.domain.exception.UserRequiredArgumentException;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserProfile {

    private Long userId;
    private String userName;
    private String fullName;
    private String biography;
    private String profileImageUrl;

    protected UserProfile(
            Long userId, String userName, String fullName, String biography,
            String profileImageUrl) {
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
        this.fullName = fullName;
        this.biography = biography;
        this.profileImageUrl = profileImageUrl;
    }
}
