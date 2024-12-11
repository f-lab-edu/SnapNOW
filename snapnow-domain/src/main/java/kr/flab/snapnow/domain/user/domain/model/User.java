package kr.flab.snapnow.domain.user.domain.model;

import java.util.List;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccount;
import kr.flab.snapnow.domain.user.domain.model.userDevice.UserDevice;
import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.domain.model.userSetting.UserSettings;
import kr.flab.snapnow.domain.user.domain.model.userSetting.NotificationSettings;
import kr.flab.snapnow.domain.user.domain.model.userSetting.PrivacySettings;

@Getter
@Builder
public class User {

    private Long userId;
    private UserAccount account;
    private UserProfile profile;
    private List<UserSettings> settings;
    private UserDevice devices;

    private User(Long userId, UserAccount account, UserProfile profile,
            List<UserSettings> settings, UserDevice devices) {
        if (account == null) {
            throw new IllegalArgumentException("Account is required");
        }
        if (profile == null) {
            throw new IllegalArgumentException("Profile is required");
        }
        if (devices == null) {
            throw new IllegalArgumentException("User device is required");
        }
        if (settings == null) {
            settings = new ArrayList<>();
            settings.add(new NotificationSettings());
            settings.add(new PrivacySettings());
        }

        this.userId = userId;
        this.account = account;
        this.profile = profile;
        this.settings = settings;
        this.devices = devices;
    }
}

