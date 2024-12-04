package kr.flab.snapnow.domain.user.useCase;

import java.util.List;

import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.SettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.SettingType;
import kr.flab.snapnow.domain.user.domain.model.userSetting.NotificationSettings;
import kr.flab.snapnow.domain.user.domain.model.userSetting.PrivacySettings;

public interface UserSettingCase {

    public List<SettingType> getSettingTypes();

    public NotificationSettings getNotificationSettings(Long userId);

    public PrivacySettings getPrivacySettings(Long userId);

    public void updateSetting(Long userId, SettingType type, SettingOption option);
}
