package kr.flab.snapnow.user.model.dto.response.setting;

import lombok.experimental.SuperBuilder;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.NotificationSettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.NotificationSettingType;

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
