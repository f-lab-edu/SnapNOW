package kr.flab.snapnow.domain.user.model.userSetting;

import java.util.Map;
import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.enums.setting.settingOption.NotificationSettingOption;
import kr.flab.snapnow.domain.user.enums.setting.settingType.NotificationSettingType;
import java.util.HashMap;

import lombok.Builder;

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
