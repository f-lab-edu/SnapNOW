package kr.flab.snapnow.user.dto.response.setting;

import lombok.experimental.SuperBuilder;

import kr.flab.snapnow.domain.user.enums.setting.setting_option.PrivacySettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.PrivacySettingType;

@SuperBuilder
public class PrivacySettingElement
    extends UserSettingElement<PrivacySettingType, PrivacySettingOption> {

    public PrivacySettingElement(PrivacySettingType settingType) {
        super(settingType, PrivacySettingOption.PUBLIC);
    }

    public PrivacySettingElement(PrivacySettingType settingType, PrivacySettingOption settingOption) {
        super(settingType, settingOption);
    }
}
