package kr.flab.snapnow.user.model.dto.response.setting;

import java.util.Map;

import lombok.experimental.SuperBuilder;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.PrivacySettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.PrivacySettingType;
import kr.flab.snapnow.domain.user.domain.exception.InvalidSettingException;

@SuperBuilder
public class PrivacySettingResponse
    extends UserSettingResponse<PrivacySettingType, PrivacySettingOption> {

    protected PrivacySettingResponse(
        SettingCategory category, Map<PrivacySettingType, PrivacySettingOption> settings) {
        if (!SettingCategory.PRIVACY.equals(category)) {
            throw new InvalidSettingException();
        }
        this.category = category;
        this.settings = settings;
    }
}
