package kr.flab.snapnow.domain.user.model.user_setting;

import java.util.HashMap;

import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.NotificationSettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.NotificationSettingType;
import kr.flab.snapnow.domain.user.exception.InvalidSettingException;

public class NotificationSetting extends UserSetting<NotificationSettingType, NotificationSettingOption> {

    public NotificationSetting() {
        this.category = SettingCategory.NOTIFICATION;
        this.settings = new HashMap<>();

        this.category.getSettingType().forEach(settingType -> {
            this.settings.put((NotificationSettingType) settingType, NotificationSettingOption.ALL);
        });
    }

    public static class NotificationSettingBuilder {

        public static NotificationSetting category(SettingCategory category) {
            if (!SettingCategory.NOTIFICATION.equals(category)) {
                throw new InvalidSettingException();
            }
            return new NotificationSetting();
        }
    }
}
