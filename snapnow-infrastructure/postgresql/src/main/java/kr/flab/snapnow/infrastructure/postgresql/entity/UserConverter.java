package kr.flab.snapnow.infrastructure.postgresql.entity;

import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccount;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserCredential;
import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.domain.model.userSetting.PrivacySetting;
import kr.flab.snapnow.domain.user.domain.model.userSetting.NotificationSetting;
import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;

public class UserConverter {

    public static UserAccount toUserAccount(UserEntity userEntity) {
        return UserAccount.builder().id(userEntity.getId()).email(userEntity.getEmail())
                .authProvider(userEntity.getAuthProvider()).providerId(userEntity.getProviderId())
                .name(userEntity.getName()).birthDay(userEntity.getBirthDay())
                .phoneNumber(userEntity.getPhoneNumber()).gender(userEntity.getGender())
                .locale(userEntity.getLocale()).verifiedEmail(userEntity.isVerifiedEmail()).build();
    }
    
    public static UserCredential toUserCredential(UserEntity userEntity) {
        return UserCredential.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .authProvider(userEntity.getAuthProvider())
                .providerId(userEntity.getProviderId())
                .password(userEntity.getPassword())
                .verifiedEmail(userEntity.isVerifiedEmail())
                .build();
    }

    public static UserProfile toUserProfile(UserProfileEntity userProfileEntity) {
        return UserProfile.builder()
                .userId(userProfileEntity.getId())
                .userName(userProfileEntity.getUserName())
                .fullName(userProfileEntity.getFullName())
                .biography(userProfileEntity.getBiography())
                .profileImageUrl(userProfileEntity.getProfileImageUrl())
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
        return NotificationSetting.builder().userId(userSettingEntity.getUserId())
                .category(SettingCategory.NOTIFICATION)
                .settings(userSettingEntity.getNotificationSettings()).build();
    }
    
    public static UserEntity toUserEntity(UserAccount userAccount) {
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

    public static UserProfileEntity toUserProfileEntity(UserProfile userProfile) {
        return UserProfileEntity.builder()
                .id(userProfile.getUserId())
                .userName(userProfile.getUserName())
                .fullName(userProfile.getFullName())
                .biography(userProfile.getBiography())
                .profileImageUrl(userProfile.getProfileImageUrl())
                .build();
    }

    public static UserSettingEntity toUserSettingEntity(NotificationSetting notificationSetting, PrivacySetting privacySetting) {
        return UserSettingEntity.builder()
                .userId(notificationSetting.getUserId())
                .notificationSettings(notificationSetting.getSettings())
                .privacySettings(privacySetting.getSettings())
                .build();
    }
}
