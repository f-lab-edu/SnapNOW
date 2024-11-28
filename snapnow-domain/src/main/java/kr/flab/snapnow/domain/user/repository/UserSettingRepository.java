package kr.flab.snapnow.domain.user.repository;

import kr.flab.snapnow.domain.user.domain.model.userSetting.NotificationSetting;
import kr.flab.snapnow.domain.user.domain.model.userSetting.PrivacySetting;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.SettingType;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.SettingOption;

public interface UserSettingRepository {

    void insert(NotificationSetting notificationSetting, PrivacySetting privacySetting);

    void update(NotificationSetting notificationSetting);

    void update(PrivacySetting privacySetting);

    NotificationSetting findNotificationSettingById(Long userId);

    PrivacySetting findPrivacySettingById(Long userId);

    SettingOption findSettingOptionByIdAndType(
        Long userId, Enum<? extends SettingType> settingType);
}
