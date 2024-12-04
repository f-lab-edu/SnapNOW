package kr.flab.snapnow.domain.user.domain.model.userProfile;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.domain.exception.UserRequiredArgumentException;

@Getter
@Builder
public class UserProfile {

    private Long userId;
    private String userName;
    private String fullName;
    private String biography;
    private String profileImageUrl;

    protected UserProfile(Long userId, String userName, String fullName, String biography,
            String profileImageUrl) {
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
