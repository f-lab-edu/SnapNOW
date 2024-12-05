package kr.flab.snapnow.user.model;

import java.util.List;
import java.util.stream.Collectors;
import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;
import kr.flab.snapnow.domain.user.domain.model.User;
import kr.flab.snapnow.domain.user.domain.model.userAccount.Email;
import kr.flab.snapnow.domain.user.domain.model.userAccount.EmailCredential;
import kr.flab.snapnow.domain.user.domain.model.userAccount.OAuthCredential;
import kr.flab.snapnow.domain.user.domain.model.userAccount.Password;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccount;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccountInfo;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserCredential;
import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.FullProfile;
import kr.flab.snapnow.domain.user.domain.model.userSetting.NotificationSettings;
import kr.flab.snapnow.domain.user.domain.model.userSetting.PrivacySettings;

import kr.flab.snapnow.user.model.dto.response.account.AccountResponse;
import kr.flab.snapnow.user.model.dto.response.profile.UserProfileResponse;
import kr.flab.snapnow.user.model.dto.response.profile.ProfilesResponse;
import kr.flab.snapnow.user.model.dto.response.profile.ProfileElement;
import kr.flab.snapnow.user.model.dto.response.setting.NotificationSettingResponse;
import kr.flab.snapnow.user.model.dto.response.setting.PrivacySettingResponse;
import kr.flab.snapnow.user.model.dto.request.account.UserCreateRequest;


public class UserConverter {

    public static AccountResponse toAccountResponse(UserAccount userAccount) {
        return AccountResponse.builder()
                .email(userAccount.getCredential().getEmail().getValue())
                .authProvider(userAccount.getCredential().getAuthProvider())
                .name(userAccount.getInfo().getName())
                .birthDay(userAccount.getInfo().getBirthDay())
                .phoneNumber(userAccount.getInfo().getPhoneNumber())
                .gender(userAccount.getInfo().getGender())
                .locale(userAccount.getInfo().getLocale())
                .build();
    }

    public static UserProfileResponse toUserProfileResponse(FullProfile fullProfile) {
        return UserProfileResponse.builder()
                .userId(fullProfile.getUserProfile().getUserId())
                .userName(fullProfile.getUserProfile().getUserName())
                .fullName(fullProfile.getUserProfile().getFullName())
                .profileImageUrl(fullProfile.getUserProfile().getProfileImageUrl())
                .postCount(fullProfile.getPostCount())
                .followerCount(fullProfile.getFollowerCount())
                .followingCount(fullProfile.getFollowingCount())
                .followStatus(fullProfile.getFollow().getFollowStatus())
                .followNotification(fullProfile.getFollow().getFollowNotification())
                .build();
    }

    public static ProfilesResponse toProfilesResponse(
            List<UserProfile> userProfiles) {
        return ProfilesResponse.builder()
                .profiles(userProfiles.stream()
                        .map(UserConverter::toProfileElement).collect(Collectors.toList()))
                .build();
    }

    public static NotificationSettingResponse toNotificationSettingResponse(
            NotificationSettings notificationSetting) {
        return NotificationSettingResponse.builder()
                .category(notificationSetting.getCategory())
                .settings(notificationSetting.getSettings())
                .build();
    }

    public static PrivacySettingResponse toPrivacySettingResponse(PrivacySettings privacySetting) {
        return PrivacySettingResponse.builder()
                .category(privacySetting.getCategory())
                .settings(privacySetting.getSettings())
                .build();
    }

    public static User toUser(UserCreateRequest userCreateRequest, String profileImageUrl) {
        Email email = new Email(userCreateRequest.getEmail());
        Password password = new Password(userCreateRequest.getPassword());
        UserCredential userCredential;

        if (userCreateRequest.getOAuthToken() != null) {
                // Todo: jwt로 AuthProvider 추출
            userCredential = OAuthCredential.builder()
                    .email(email)
                    .providerId(userCreateRequest.getOAuthToken())
                    .authProvider(AuthProvider.GOOGLE)
                    .build();
        } else {
            userCredential = EmailCredential.builder()
                    .email(email)
                    .password(password)
                    .build();
        }
        UserAccountInfo userAccountInfo = UserAccountInfo.builder()
                .name(userCreateRequest.getName())
                .gender(userCreateRequest.getGender())
                .locale(userCreateRequest.getLocale())
                .birthDay(userCreateRequest.getBirthDay())
                .phoneNumber(userCreateRequest.getPhoneNumber())
                .build();

        UserAccount userAccount = UserAccount.builder()
                .credential(userCredential)
                .info(userAccountInfo)
                .build();

        UserProfile userProfile = UserProfile.builder()
                .userName(userCreateRequest.getUserName())
                .fullName(userCreateRequest.getFullName())
                .biography(userCreateRequest.getBiography())
                .profileImageUrl(profileImageUrl)
                .build();

        return User.builder()
                .account(userAccount)
                .profile(userProfile)
                .build();
    }

    private static ProfileElement toProfileElement(UserProfile userProfile) {
        return ProfileElement.builder()
                .userId(userProfile.getUserId())
                .userName(userProfile.getUserName())
                .profileImageUrl(userProfile.getProfileImageUrl())
                .followStatus(userProfile.getFollowStatus())
                .build();
    }
}
