package kr.flab.snapnow.domain.user.repository;

import kr.flab.snapnow.domain.user.domain.model.userSetting.NotificationSettings;
import kr.flab.snapnow.domain.user.domain.model.userSetting.PrivacySettings;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.SettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.SettingType;

public interface UserSettingRepository {

    void update(Long userId, SettingType settingType, SettingOption settingOption);

    NotificationSettings findNotificationSetting(Long userId);

    PrivacySettings findPrivacySetting(Long userId);

    SettingOption findSettingOption(
        Long userId, Enum<? extends SettingType> settingType);
}
