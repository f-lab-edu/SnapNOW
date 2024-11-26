package kr.flab.snapnow.domain.user.enums.setting.setting_type;

import java.util.EnumSet;

import lombok.RequiredArgsConstructor;
import lombok.Getter;
import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.PrivacySettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.SettingOption;

@Getter
@RequiredArgsConstructor
public enum PrivacySetting implements SettingType {

    PUBLIC("public"),
    PRIVATE("private");

    private final String value;

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public EnumSet<? extends SettingOption> getOptions() {
        return EnumSet.allOf(PrivacySettingOption.class);
    }

    @Override
    public SettingCategory getCategory() {
        return SettingCategory.PRIVACY;
    }
}
