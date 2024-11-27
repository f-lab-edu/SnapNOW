package kr.flab.snapnow.domain.user.enums.setting.settingType;

import java.util.EnumSet;

import lombok.RequiredArgsConstructor;
import lombok.Getter;
import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.enums.setting.settingOption.PrivacySettingOption;
import kr.flab.snapnow.domain.user.enums.setting.settingOption.SettingOption;

@Getter
@RequiredArgsConstructor
public enum PrivacySettingType implements SettingType {

    PRIVACY("Privacy");

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
