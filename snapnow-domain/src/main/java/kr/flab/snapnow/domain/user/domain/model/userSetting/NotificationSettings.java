package kr.flab.snapnow.domain.user.domain.model.userSetting;

import java.util.Map;
import java.util.HashMap;

import lombok.Builder;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.NotificationSettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.NotificationSettingType;

@Builder
public class NotificationSettings extends UserSettings<
    NotificationSettingType, NotificationSettingOption> {

    public NotificationSettings() {
        super(null, SettingCategory.NOTIFICATION, new HashMap<>());

        this.category.getSettingType().forEach(settingType -> {
            this.settings.put((NotificationSettingType) settingType,
                    (NotificationSettingOption) this.category.getDefaultSettingOption());
        });
    }

    @Builder
    private NotificationSettings(Long userId, SettingCategory category,
            Map<NotificationSettingType, NotificationSettingOption> settings) {
        super(userId, category, settings);

        if (!SettingCategory.NOTIFICATION.equals(category)) {
            throw new IllegalArgumentException("Invalid setting category");
        }
    }
}
