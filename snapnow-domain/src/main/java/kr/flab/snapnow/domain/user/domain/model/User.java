package kr.flab.snapnow.domain.user.domain.model;

import java.util.List;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccount;
import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.domain.model.userSetting.UserSettings;
import kr.flab.snapnow.domain.user.domain.model.userSetting.NotificationSettings;
import kr.flab.snapnow.domain.user.domain.model.userSetting.PrivacySettings;
import kr.flab.snapnow.domain.user.domain.exception.UserRequiredArgumentException;

@Getter
@Builder
public class User {

    private Long userId;
    private UserAccount account;
    private UserProfile profile;
    private List<UserSettings> settings;

    private User(Long userId, UserAccount account, UserProfile profile, List<UserSettings> settings) {
        if (account == null) {
            throw new UserRequiredArgumentException("Account is required");
        }
        if (profile == null) {
            throw new UserRequiredArgumentException("Profile is required");
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
    }
}
