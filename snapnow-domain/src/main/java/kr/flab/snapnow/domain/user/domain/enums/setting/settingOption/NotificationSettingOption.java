package kr.flab.snapnow.domain.user.domain.enums.setting.settingOption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;

@Getter
@RequiredArgsConstructor
public enum NotificationSettingOption implements SettingOption {

    ALL("All"),
    FROM_FOLLOWER("From Follower"),
    OFF("Off");

    private final String value;

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public SettingCategory getCategory() {
        return SettingCategory.NOTIFICATION;
    }
}
