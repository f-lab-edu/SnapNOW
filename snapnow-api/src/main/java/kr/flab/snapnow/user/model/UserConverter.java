package kr.flab.snapnow.user.model;

import java.util.List;
import java.util.stream.Collectors;

import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccount;
import kr.flab.snapnow.domain.user.domain.model.userProfile.FullProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.CompactProfileWithFollowStatus;
import kr.flab.snapnow.domain.user.domain.model.userSetting.NotificationSetting;
import kr.flab.snapnow.domain.user.domain.model.userSetting.PrivacySetting;

import kr.flab.snapnow.user.model.dto.response.account.AccountResponse;
import kr.flab.snapnow.user.model.dto.response.profile.UserProfileResponse;
import kr.flab.snapnow.user.model.dto.response.profile.ProfilesResponse;
import kr.flab.snapnow.user.model.dto.response.profile.ProfileElement;
import kr.flab.snapnow.user.model.dto.response.setting.NotificationSettingResponse;
import kr.flab.snapnow.user.model.dto.response.setting.PrivacySettingResponse;


public class UserConverter {

    public static AccountResponse toAccountResponse(UserAccount userAccount) {
        return AccountResponse.builder()
                .email(userAccount.getEmail())
                .authProvider(userAccount.getAuthProvider())
                .name(userAccount.getName())
                .birthDay(userAccount.getBirthDay())
                .phoneNumber(userAccount.getPhoneNumber())
                .gender(userAccount.getGender())
                .locale(userAccount.getLocale())
                .build();
    }

    public static UserProfileResponse toUserProfileResponse(FullProfile fullProfile) {
        return UserProfileResponse.builder()
                .userId(fullProfile.getUserId())
                .userName(fullProfile.getUserName())
                .fullName(fullProfile.getFullName())
                .profileImageUrl(fullProfile.getProfileImageUrl())
                .postCount(fullProfile.getPostCount())
                .followerCount(fullProfile.getFollowerCount())
                .followingCount(fullProfile.getFollowingCount())
                .followStatus(fullProfile.getFollowStatus()).build();
    }

    public static ProfilesResponse toProfilesResponse(
            List<CompactProfileWithFollowStatus> fullProfiles) {
        return ProfilesResponse.builder()
                .profiles(fullProfiles.stream()
                        .map(UserConverter::toProfileElement).collect(Collectors.toList()))
                .build();
    }

    public static NotificationSettingResponse toNotificationSettingResponse(
            NotificationSetting notificationSetting) {
        return NotificationSettingResponse.builder()
                .category(notificationSetting.getCategory())
                .settings(notificationSetting.getSettings())
                .build();
    }

    public static PrivacySettingResponse toPrivacySettingResponse(PrivacySetting privacySetting) {
        return PrivacySettingResponse.builder()
                .category(privacySetting.getCategory())
                .settings(privacySetting.getSettings())
                .build();
    }

    private static ProfileElement toProfileElement(
            CompactProfileWithFollowStatus compactProfileWithFollowStatus) {
        return ProfileElement.builder()
                .userId(compactProfileWithFollowStatus.getUserId())
                .userName(compactProfileWithFollowStatus.getUserName())
                .profileImageUrl(compactProfileWithFollowStatus.getProfileImageUrl())
                .followStatus(compactProfileWithFollowStatus.getFollowStatus())
                .build();
    }
}
