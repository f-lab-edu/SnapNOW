package kr.flab.snapnow.domain.user.enums.setting.settingOption;

import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PrivacySettingOption implements SettingOption {

    PRIVATE("Private"),
    PUBLIC("Public");

    private final String value;

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public SettingCategory getCategory() {
        return SettingCategory.PRIVACY;
    }
}
