package kr.flab.snapnow.domain.user.model.user_setting;

import java.util.HashSet;

import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.NotificationSettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.NotificationSettingType;
import kr.flab.snapnow.domain.user.exception.InvalidSettingException;

public class NotificationSetting extends UserSetting<NotificationSettingType, NotificationSettingOption> {

    public NotificationSetting() {
        this.category = SettingCategory.NOTIFICATION;
        this.settings = new HashSet<>();

        this.category.getSettingType().forEach(settingType -> {
            this.settings.add(new NotificationSettingElement((NotificationSettingType) settingType));
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
