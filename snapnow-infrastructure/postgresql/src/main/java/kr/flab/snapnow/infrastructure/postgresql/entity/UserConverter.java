package kr.flab.snapnow.infrastructure.postgresql.entity;

import kr.flab.snapnow.infrastructure.postgresql.entity.userAccount.*;
import kr.flab.snapnow.infrastructure.postgresql.entity.userProfile.*;
import kr.flab.snapnow.infrastructure.postgresql.entity.userSetting.*;

import kr.flab.snapnow.domain.user.domain.model.userAccount.*;
import kr.flab.snapnow.domain.user.domain.model.userProfile.*;
import kr.flab.snapnow.domain.user.domain.model.userSetting.*;
import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.follow.domain.model.Follow;
import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;

public class UserConverter {

    public static UserAccount toUserAccount(UserAccountEntity userAccountEntity) {
        Email email = new Email(userAccountEntity.getEmail(), userAccountEntity.isVerifiedEmail());
        Password password = new Password(userAccountEntity.getPassword());
        UserCredential userCredential;

        if (userAccountEntity.getAuthProvider() == AuthProvider.EMAIL) {
            userCredential = EmailCredential.builder()
                    .email(email)
                    .password(password)
                    .build();
        } else {
            userCredential = OAuthCredential.builder()
                    .email(email)
                    .providerId(userAccountEntity.getProviderId())
                    .authProvider(userAccountEntity.getAuthProvider())
                    .build();
        }
        UserAccountInfo userAccountInfo = UserAccountInfo.builder()
                .name(userAccountEntity.getName())
                .gender(userAccountEntity.getGender())
                .locale(userAccountEntity.getLocale())
                .build();

        return UserAccount.builder()
                .userId(userAccountEntity.getUserId())
                .credential(userCredential)
                .info(userAccountInfo)
                .build();
    }

    public static UserCredential toUserCredential(UserCredentialModel userCredentialModel) {
        UserCredential userCredential;
        if (userCredentialModel.getAuthProvider() == AuthProvider.EMAIL) {
            userCredential = EmailCredential.builder()
                    .email(new Email(userCredentialModel.getEmail(),
                            userCredentialModel.isVerifiedEmail()))
                    .password(new Password(userCredentialModel.getPassword()))
                    .build();
        } else {
            userCredential = OAuthCredential.builder()
                    .email(new Email(userCredentialModel.getEmail()))
                    .providerId(userCredentialModel.getProviderId())
                    .authProvider(userCredentialModel.getAuthProvider())
                    .build();
        }
        return userCredential;
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
        UserProfile userProfile = UserProfile.builder()
                .userId(fullProfileModel.getUserId())
                .userName(fullProfileModel.getUserName())
                .fullName(fullProfileModel.getFullName())
                .biography(fullProfileModel.getBiography())
                .profileImageUrl(fullProfileModel.getProfileImageUrl())
                .build();
        Follow follow = Follow.builder()
                .userId(fullProfileModel.getFromUserId())
                .targetUserId(fullProfileModel.getUserId())
                .followStatus(fullProfileModel.getFollowStatus())
                .followNotification(fullProfileModel.getFollowNotification())
                .build();

        return FullProfile.builder()
                .userProfile(userProfile)
                .postCount(fullProfileModel.getPostCount())
                .followerCount(fullProfileModel.getFollowerCount())
                .followingCount(fullProfileModel.getFollowingCount())
                .follow(follow)
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
                .email(userAccount.getCredential().getEmail().getValue())
                .password(userAccount.getCredential() instanceof EmailCredential ?
                        ((EmailCredential) userAccount.getCredential()).getPassword().getValue() :
                        null)
                .authProvider(userAccount.getCredential().getAuthProvider())
                .providerId(userAccount.getCredential() instanceof OAuthCredential ?
                        ((OAuthCredential) userAccount.getCredential()).getProviderId() :
                        null)
                .verifiedEmail(userAccount.getCredential().getEmail().isVerifiedEmail())
                .name(userAccount.getInfo().getName())
                .gender(userAccount.getInfo().getGender())
                .locale(userAccount.getInfo().getLocale())
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
