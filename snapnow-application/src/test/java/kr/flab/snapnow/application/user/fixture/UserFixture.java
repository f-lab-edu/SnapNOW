package kr.flab.snapnow.application.user.fixture;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import kr.flab.snapnow.domain.user.enums.account.*;
import kr.flab.snapnow.domain.user.enums.device.DeviceType;
import kr.flab.snapnow.domain.user.model.userAccount.credential.*;
import kr.flab.snapnow.domain.user.model.userAccount.*;
import kr.flab.snapnow.domain.user.model.userProfile.*;
import kr.flab.snapnow.domain.user.model.userSetting.*;
import kr.flab.snapnow.domain.user.model.userDevice.*;
import kr.flab.snapnow.application.user.usecase.dto.UserCreateDto;

public class UserFixture {

    public static EmailCredential createEmailCredential() {
        return EmailCredential.builder()
                .email(new Email("test@test.com"))
                .password("test")
                .build();
    }

    public static OAuthCredential createOAuthCredential() {
        return OAuthCredential.builder()
                .email(new Email("test@test.com"))
                .authProvider(AuthProvider.GOOGLE)
                .providerId("test")
                .build();
    }
    
    public static UserInfo createUserInfo() {
        return UserInfo.builder()
                .name("test")
                .birthDay(LocalDate.of(2000, 1, 1))
                .phoneNumber("010-1234-5678")
                .build();
    }

    public static UserProfile createUserProfile() {
        return UserProfile.builder()
                .userName("test")
                .profileImageUrl("https://test.com/test.jpg")
                .build();
    }
    
    public static NotificationSettings createNotificationSettings() {
        return new NotificationSettings();
    }

    public static PrivacySettings createPrivacySettings() {
        return new PrivacySettings();
    }

    public static List<UserSettings> createUserSettings() {
        return Arrays.asList(createNotificationSettings(), createPrivacySettings());
    }

    public static Device createDevice() {
        return Device.builder()
                .deviceId("test")
                .deviceType(DeviceType.ANDROID)
                .build();
    }

    public static UserDevice createUserDevice() {
        return UserDevice.builder()
                .devices(Arrays.asList(createDevice()))
                .build();
    }

    public static UserCreateDto createUserCreateDto() {
        return UserCreateDto.builder()
                .credential(createEmailCredential())
                .profile(createUserProfile())
                .device(createDevice())
                .build();
    }
}

