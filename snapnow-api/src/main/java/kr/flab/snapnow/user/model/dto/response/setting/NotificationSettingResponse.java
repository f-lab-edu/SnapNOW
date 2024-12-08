package kr.flab.snapnow.user.model.dto.response.setting;

import java.util.Map;

import lombok.experimental.SuperBuilder;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.NotificationSettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.NotificationSettingType;
import kr.flab.snapnow.domain.user.domain.exception.InvalidSettingException;

@SuperBuilder
public class NotificationSettingResponse
        extends UserSettingResponse<NotificationSettingType, NotificationSettingOption> {

    protected NotificationSettingResponse(SettingCategory category,
            Map<NotificationSettingType, NotificationSettingOption> settings) {
        if (!SettingCategory.NOTIFICATION.equals(category)) {
            throw new InvalidSettingException();
        }
        this.category = category;
        this.settings = settings;
    }
}
