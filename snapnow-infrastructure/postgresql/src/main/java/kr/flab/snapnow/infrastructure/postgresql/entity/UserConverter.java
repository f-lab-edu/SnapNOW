package kr.flab.snapnow.infrastructure.postgresql.entity;

import kr.flab.snapnow.infrastructure.postgresql.entity.userAccount.*;
import kr.flab.snapnow.infrastructure.postgresql.entity.userProfile.*;
import kr.flab.snapnow.infrastructure.postgresql.entity.userSetting.*;

import kr.flab.snapnow.domain.user.domain.model.userAccount.*;
import kr.flab.snapnow.domain.user.domain.model.userProfile.*;
import kr.flab.snapnow.domain.user.domain.model.userSetting.*;
import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;

public class UserConverter {

    public static UserAccount toUserAccount(UserEntity userEntity) {
        return UserAccount.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .authProvider(userEntity.getAuthProvider())
                .providerId(userEntity.getProviderId())
                .name(userEntity.getName())
                .birthDay(userEntity.getBirthDay())
                .phoneNumber(userEntity.getPhoneNumber())
                .gender(userEntity.getGender())
                .locale(userEntity.getLocale())
                .verifiedEmail(userEntity.isVerifiedEmail())
                .build();
    }

    public static UserCredential toUserCredential(UserCredentialModel userCredentialModel) {
        return UserCredential.builder()
                .id(userCredentialModel.getId())
                .email(userCredentialModel.getEmail())
                .authProvider(userCredentialModel.getAuthProvider())
                .providerId(userCredentialModel.getProviderId())
                .password(userCredentialModel.getPassword())
                .verifiedEmail(userCredentialModel.isVerifiedEmail())
                .build();
    }

    public static UserProfile toUserProfile(UserProfileEntity userProfileEntity) {
        return UserProfile.builder().userId(userProfileEntity.getId())
                .userName(userProfileEntity.getUserName()).fullName(userProfileEntity.getFullName())
                .biography(userProfileEntity.getBiography())
                .profileImageUrl(userProfileEntity.getProfileImageUrl()).build();
    }

    public static FullProfile toFullProfile(FullProfileModel fullProfileModel) {
        return FullProfile.builder()
                .userId(fullProfileModel.getUserId())
                .userName(fullProfileModel.getUserName())
                .fullName(fullProfileModel.getFullName())
                .biography(fullProfileModel.getBiography())
                .profileImageUrl(fullProfileModel.getProfileImageUrl())
                .postCount(fullProfileModel.getPostCount())
                .followerCount(fullProfileModel.getFollowerCount())
                .followingCount(fullProfileModel.getFollowingCount())
                .followStatus(fullProfileModel.getFollowStatus())
                .build();
    }

    public static CompactProfile toCompactProfile(CompactProfileModel compactProfileModel) {
        return CompactProfile.builder()
                .userId(compactProfileModel.getUserId())
                .userName(compactProfileModel.getUserName())
                .profileImageUrl(compactProfileModel.getProfileImageUrl())
                .build();
    }

    public static CompactProfileWithFollowStatus toCompactProfileWithFollowStatus(CompactProfileWithFollowStatusModel compactProfileWithFollowStatusModel) {
        return CompactProfileWithFollowStatus.builder()
                .userId(compactProfileWithFollowStatusModel.getUserId())
                .userName(compactProfileWithFollowStatusModel.getUserName())
                .profileImageUrl(compactProfileWithFollowStatusModel.getProfileImageUrl())
                .followStatus(compactProfileWithFollowStatusModel.getFollowStatus())
                .build();
    }

    public static PrivacySetting toPrivacySetting(UserSettingEntity userSettingEntity) {
        return PrivacySetting.builder()
                .userId(userSettingEntity.getUserId())
                .category(SettingCategory.PRIVACY)
                .settings(userSettingEntity.getPrivacySettings())
                .build();
    }

    public static NotificationSetting toNotificationSetting(UserSettingEntity userSettingEntity) {
        return NotificationSetting.builder()
                .userId(userSettingEntity.getUserId())
                .category(SettingCategory.NOTIFICATION)
                .settings(userSettingEntity.getNotificationSettings())
                .build();
    }
    
    public static UserEntity fromUserAccount(UserAccount userAccount) {
        return UserEntity.builder()
                .email(userAccount.getEmail())
                .password(userAccount.getPassword())
                .authProvider(userAccount.getAuthProvider())
                .providerId(userAccount.getProviderId())
                .verifiedEmail(userAccount.isVerifiedEmail())
                .name(userAccount.getName())
                .gender(userAccount.getGender())
                .locale(userAccount.getLocale())
                .birthDay(userAccount.getBirthDay())
                .phoneNumber(userAccount.getPhoneNumber())
                .build();
    }

    public static UserProfileEntity fromUserProfile(UserProfile userProfile) {
        return UserProfileEntity.builder()
                .id(userProfile.getUserId())
                .userName(userProfile.getUserName())
                .fullName(userProfile.getFullName())
                .biography(userProfile.getBiography())
                .profileImageUrl(userProfile.getProfileImageUrl())
                .build();
    }

    public static UserSettingEntity fromNotificationSetting
        (NotificationSetting notificationSetting, PrivacySetting privacySetting) {
        return UserSettingEntity.builder()
                .userId(notificationSetting.getUserId())
                .notificationSettings(notificationSetting.getSettings())
                .privacySettings(privacySetting.getSettings())
                .build();
    }
}
