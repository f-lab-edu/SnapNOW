package kr.flab.snapnow.user.model.dto.response.setting;

import java.util.HashSet;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.NotificationSettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.NotificationSettingType;
import kr.flab.snapnow.domain.user.domain.exception.InvalidSettingException;

public class NotificationSettingResponse
    extends UserSettingResponse<NotificationSettingType, NotificationSettingOption> {

    public NotificationSettingResponse() {
        this.category = SettingCategory.NOTIFICATION;
        this.settings = new HashSet<>();

        this.category.getSettingType().forEach(settingType -> {
            this.settings.add(new NotificationSettingElement((NotificationSettingType) settingType));
        });
    }

    public static class NotificationSettingBuilder {

        public static NotificationSettingResponse category(SettingCategory category) {
            if (!SettingCategory.NOTIFICATION.equals(category)) {
                throw new InvalidSettingException();
            }
            return new NotificationSettingResponse();
        }
    }
}
