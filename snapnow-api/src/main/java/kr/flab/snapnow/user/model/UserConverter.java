package kr.flab.snapnow.user.model;

import java.util.List;
import java.util.stream.Collectors;

import kr.flab.snapnow.domain.user.domain.model.User;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccount;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserCredential;
import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.FullProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.CompactProfileWithFollowStatus;
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
                .email(userAccount.getCredential().getEmail())
                .authProvider(userAccount.getCredential().getAuthProvider())
                .name(userAccount.getName())
                .birthDay(userAccount.getBirthDay())
                .phoneNumber(userAccount.getPhoneNumber())
                .gender(userAccount.getGender())
                .locale(userAccount.getLocale())
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
                .followStatus(fullProfile.getFollowStatus()).build();
    }

    public static ProfilesResponse toProfilesResponse(
            List<CompactProfileWithFollowStatus> userProfiles) {
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
            return PrivacySettingResponse.builder().category(privacySetting.getCategory())
                            .settings(privacySetting.getSettings()).build();
    }

    public static User toUser(UserCreateRequest userCreateRequest, String profileImageUrl) {
        UserCredential userCredential = UserCredential.builder()
                .email(userCreateRequest.getEmail())
                .password(userCreateRequest.getPassword())
                .providerId(userCreateRequest.getOAuthToken())
                .build();
        UserAccount userAccount = UserAccount.builder()
                .credential(userCredential)
                .name(userCreateRequest.getName())
                .gender(userCreateRequest.getGender())
                .locale(userCreateRequest.getLocale())
                .birthDay(userCreateRequest.getBirthDay())
                .phoneNumber(userCreateRequest.getPhoneNumber())
                .build();
        UserProfile userProfile = UserProfile.builder()
                .userName(userCreateRequest.getUserName())
                .fullName(userCreateRequest.getFullName())
                .biography(userCreateRequest.getBiography())
                .profileImageUrl(profileImageUrl)
                .build();
        return User.builder().account(userAccount).profile(userProfile).build();
    }

    private static ProfileElement toProfileElement(
            CompactProfileWithFollowStatus userProfile) {
        return ProfileElement.builder()
                .userId(userProfile.getUserId())
                .userName(userProfile.getUserName())
                .profileImageUrl(userProfile.getProfileImageUrl())
                .followStatus(userProfile.getFollowStatus())
                .build();
    }
}
