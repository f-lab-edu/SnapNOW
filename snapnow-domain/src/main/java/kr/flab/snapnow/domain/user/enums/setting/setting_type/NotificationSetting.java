package kr.flab.snapnow.domain.user.enums.setting.setting_type;

import java.util.EnumSet;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.NotificationSettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.SettingOption;

@Getter
@RequiredArgsConstructor
public enum NotificationSetting implements SettingType {

    NEW_FOLLOWS("New Follows"),
    COMMENT("Comment"),
    LIKE("Like"),
    MENTION("Mention");

    private final String value;

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public EnumSet<? extends SettingOption> getOptions() {
        return EnumSet.allOf(NotificationSettingOption.class);
    }

    @Override
    public SettingCategory getCategory() {
        return SettingCategory.NOTIFICATION;
    }
}
