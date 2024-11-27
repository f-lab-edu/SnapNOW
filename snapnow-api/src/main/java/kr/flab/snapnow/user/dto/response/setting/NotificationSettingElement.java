package kr.flab.snapnow.user.dto.response.setting;

import lombok.experimental.SuperBuilder;
import kr.flab.snapnow.domain.user.enums.setting.settingOption.NotificationSettingOption;
import kr.flab.snapnow.domain.user.enums.setting.settingType.NotificationSettingType;

@SuperBuilder
public class NotificationSettingElement 
    extends UserSettingElement<NotificationSettingType, NotificationSettingOption> {

    public NotificationSettingElement(NotificationSettingType settingType) {
        super(settingType, NotificationSettingOption.ALL);
    }

    public NotificationSettingElement(
        NotificationSettingType settingType, NotificationSettingOption settingOption) {
        super(settingType, settingOption);
    }
}
