package kr.flab.snapnow.domain.user.domain.enums.setting.settingOption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;

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
