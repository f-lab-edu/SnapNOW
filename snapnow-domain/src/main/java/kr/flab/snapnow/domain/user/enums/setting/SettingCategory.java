package kr.flab.snapnow.domain.user.enums.setting;

import java.util.EnumSet;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import kr.flab.snapnow.domain.user.enums.setting.settingOption.NotificationSettingOption;
import kr.flab.snapnow.domain.user.enums.setting.settingOption.PrivacySettingOption;
import kr.flab.snapnow.domain.user.enums.setting.settingOption.SettingOption;
import kr.flab.snapnow.domain.user.enums.setting.settingType.NotificationSettingType;
import kr.flab.snapnow.domain.user.enums.setting.settingType.PrivacySettingType;
import kr.flab.snapnow.domain.user.enums.setting.settingType.SettingType;
import kr.flab.snapnow.domain.user.exception.InvalidSettingException;

@Getter
@RequiredArgsConstructor
public enum SettingCategory {

    NOTIFICATION(
        "Notification",
        EnumSet.allOf(NotificationSettingType.class),
        EnumSet.allOf(NotificationSettingOption.class)),
    PRIVACY(
        "Privacy",
        EnumSet.allOf(PrivacySettingType.class),
        EnumSet.allOf(PrivacySettingOption.class));

    private final String value;
    private final EnumSet<? extends SettingType> settingType;
    private final EnumSet<? extends SettingOption> settingOption;

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

    public static SettingCategory of(SettingType settingType) {
        for (SettingCategory category : SettingCategory.values()) {
            if (category.getSettingType().contains(settingType)) {
                return category;
            }
        }
        throw new InvalidSettingException();
    }

    public static SettingCategory of(SettingOption settingOption) {
        for (SettingCategory category : SettingCategory.values()) {
            if (category.getSettingOption().contains(settingOption)) {
                return category;
            }
        }
        throw new InvalidSettingException();
    }

    public static SettingCategory of(SettingType settingType, SettingOption settingOption) {
        if (isValidSetting(settingType, settingOption)) {
            return of(settingType);
        }
        throw new InvalidSettingException();
    }
}
