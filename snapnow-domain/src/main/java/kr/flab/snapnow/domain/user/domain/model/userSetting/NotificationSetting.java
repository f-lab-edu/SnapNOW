package kr.flab.snapnow.domain.user.domain.model.userSetting;

import java.util.HashMap;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.NotificationSettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.NotificationSettingType;
import kr.flab.snapnow.domain.user.domain.exception.InvalidSettingException;

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
