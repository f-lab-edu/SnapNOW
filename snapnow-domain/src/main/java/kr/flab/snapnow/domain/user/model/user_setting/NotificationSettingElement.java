package kr.flab.snapnow.domain.user.model.user_setting;

import lombok.experimental.SuperBuilder;

import kr.flab.snapnow.domain.user.enums.setting.setting_option.NotificationSettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.NotificationSettingType;

@SuperBuilder
public class NotificationSettingElement 
    extends UserSettingElement<NotificationSettingType, NotificationSettingOption> {

    public NotificationSettingElement(NotificationSettingType settingType) {
        super(settingType, NotificationSettingOption.ALL);
    }

    public NotificationSettingElement(NotificationSettingType settingType, NotificationSettingOption settingOption) {
        super(settingType, settingOption);
    }
}
