package kr.flab.snapnow.domain.user.enums.setting;

import java.util.EnumSet;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.NotificationSettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.PrivacySettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.SettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.NotificationSetting;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.PrivacySetting;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.SettingType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SettingCategory {

    NOTIFICATION(
        "Notification",
        EnumSet.allOf(NotificationSetting.class),
        EnumSet.allOf(NotificationSettingOption.class)),
    PRIVACY(
        "Privacy",
        EnumSet.allOf(PrivacySetting.class),
        EnumSet.allOf(PrivacySettingOption.class));

    private final String value;
    private final EnumSet<? extends SettingType> settingType;
    private final EnumSet<? extends SettingOption> settingOption;

    public static boolean isValidSetting(
        Enum<? extends SettingType> settingType,
        Enum<? extends SettingOption> settingOption) {
        return (NOTIFICATION.getSettingType().contains((SettingType) settingType)
                && NOTIFICATION.getSettingOption().contains((SettingOption) settingOption))
                || (PRIVACY.getSettingType().contains((SettingType) settingType)
                && PRIVACY.getSettingOption().contains((SettingOption) settingOption));
    }

    public static boolean isValidSetting(SettingType settingType, SettingOption settingOption) {
        return NOTIFICATION.getSettingType().contains(settingType)
            && NOTIFICATION.getSettingOption().contains(settingOption)
            || PRIVACY.getSettingType().contains(settingType)
            && PRIVACY.getSettingOption().contains(settingOption);
    }

    public static boolean isValidSetting(
        SettingCategory settingCategory,
        SettingType settingType,
        SettingOption settingOption) {
        return settingCategory.getSettingType().contains(settingType)
            && settingCategory.getSettingOption().contains(settingOption);
    }
}
