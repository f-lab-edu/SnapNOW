package kr.flab.snapnow.domain.user.domain.enums.setting.settingType;

import java.util.EnumSet;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.NotificationSettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.SettingOption;

@Getter
@RequiredArgsConstructor
public enum NotificationSettingType implements SettingType {

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
