package kr.flab.snapnow.infrastructure.postgresql.entity;

import kr.flab.snapnow.infrastructure.postgresql.entity.userAccount.*;
import kr.flab.snapnow.infrastructure.postgresql.entity.userProfile.*;
import kr.flab.snapnow.infrastructure.postgresql.entity.userSetting.*;

import kr.flab.snapnow.domain.user.domain.model.userAccount.*;
import kr.flab.snapnow.domain.user.domain.model.userProfile.*;
import kr.flab.snapnow.domain.user.domain.model.userSetting.*;
import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;

public class UserConverter {

    public static UserAccount toUserAccount(UserAccountEntity userAccountEntity) {
        UserCredential userCredential = UserCredential.builder()
                .userId(userAccountEntity.getUserId())
                .email(userAccountEntity.getEmail())
                .authProvider(userAccountEntity.getAuthProvider())
                .providerId(userAccountEntity.getProviderId())
                .verifiedEmail(userAccountEntity.isVerifiedEmail())
                .build();

        return UserAccount.builder()
                .credential(userCredential)
                .name(userAccountEntity.getName())
                .birthDay(userAccountEntity.getBirthDay())
                .phoneNumber(userAccountEntity.getPhoneNumber())
                .gender(userAccountEntity.getGender())
                .locale(userAccountEntity.getLocale())
                .build();
    }

    public static UserCredential toUserCredential(UserCredentialModel userCredentialModel) {
        return UserCredential.builder()
                .userId(userCredentialModel.getUserId())
                .email(userCredentialModel.getEmail())
                .authProvider(userCredentialModel.getAuthProvider())
                .providerId(userCredentialModel.getProviderId())
                .password(userCredentialModel.getPassword())
                .verifiedEmail(userCredentialModel.isVerifiedEmail())
                .build();
    }

    public static UserProfile toUserProfile(UserProfileEntity userProfileEntity) {
        return UserProfile.builder()
                .userId(userProfileEntity.getUserId())
                .userName(userProfileEntity.getUserName())
                .fullName(userProfileEntity.getFullName())
                .biography(userProfileEntity.getBiography())
                .profileImageUrl(userProfileEntity.getProfileImageUrl())
                .build();
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

    public static PrivacySettings toPrivacySetting(UserSettingEntity userSettingEntity) {
        return PrivacySettings.builder()
                .userId(userSettingEntity.getUserId())
                .category(SettingCategory.PRIVACY)
                .settings(userSettingEntity.getPrivacySettings())
                .build();
    }

    public static NotificationSettings toNotificationSetting(UserSettingEntity userSettingEntity) {
        return NotificationSettings.builder()
                .userId(userSettingEntity.getUserId())
                .category(SettingCategory.NOTIFICATION)
                .settings(userSettingEntity.getNotificationSettings())
                .build();
    }
    
    public static UserAccountEntity fromUserAccount(UserAccount userAccount) {
        return UserAccountEntity.builder()
                .email(userAccount.getCredential().getEmail())
                .password(userAccount.getCredential().getPassword())
                .authProvider(userAccount.getCredential().getAuthProvider())
                .providerId(userAccount.getCredential().getProviderId())
                .verifiedEmail(userAccount.getCredential().isVerifiedEmail())
                .name(userAccount.getName())
                .gender(userAccount.getGender())
                .locale(userAccount.getLocale())
                .birthDay(userAccount.getBirthDay())
                .phoneNumber(userAccount.getPhoneNumber())
                .build();
    }

    public static UserProfileEntity fromUserProfile(UserProfile userProfile) {
        return UserProfileEntity.builder()
                .userId(userProfile.getUserId())
                .userName(userProfile.getUserName())
                .fullName(userProfile.getFullName())
                .biography(userProfile.getBiography())
                .profileImageUrl(userProfile.getProfileImageUrl())
                .build();
    }

    public static UserSettingEntity fromNotificationSetting
        (NotificationSettings notificationSetting, PrivacySettings privacySetting) {
        return UserSettingEntity.builder()
                .userId(notificationSetting.getUserId())
                .notificationSettings(notificationSetting.getSettings())
                .privacySettings(privacySetting.getSettings())
                .build();
    }
}
