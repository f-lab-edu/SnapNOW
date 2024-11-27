package kr.flab.snapnow.domain.user.domain.model.userSetting;

import java.util.Map;
import java.util.HashMap;

import lombok.Getter;
import lombok.Builder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.NotificationSettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.NotificationSettingType;
import kr.flab.snapnow.domain.user.domain.exception.InvalidSettingException;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NotificationSetting extends UserSetting<NotificationSettingType, NotificationSettingOption> {

    private Long userId;
    private SettingCategory category;
    private Map<NotificationSettingType, NotificationSettingOption> settings;

    public NotificationSetting() {
        this.category = SettingCategory.NOTIFICATION;
        this.settings = new HashMap<>();

        this.category.getSettingType().forEach(settingType -> {
            this.settings.put((NotificationSettingType) settingType, NotificationSettingOption.ALL);
        });
    }

    public static class NotificationSettingBuilder {

        public NotificationSetting build() {
            if (!SettingCategory.NOTIFICATION.equals(category)) {
                throw new InvalidSettingException();
            }
            return new NotificationSetting(userId, category, settings);
        }
    }
}
