package kr.flab.snapnow.user.model.dto.response.setting;

import java.util.HashSet;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.PrivacySettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.PrivacySettingType;
import kr.flab.snapnow.domain.user.domain.exception.InvalidSettingException;

public class PrivacySettingResponse
    extends UserSettingResponse<PrivacySettingType, PrivacySettingOption> {

    public PrivacySettingResponse() {
        this.category = SettingCategory.PRIVACY;
        this.settings = new HashSet<>();

        this.category.getSettingType().forEach(settingType -> {
            this.settings.add(new PrivacySettingElement((PrivacySettingType) settingType));
        });
    }

    public static class PrivacySettingBuilder {

        public static PrivacySettingResponse category(SettingCategory category) {
            if (!SettingCategory.PRIVACY.equals(category)) {
                throw new InvalidSettingException();
            }
            return new PrivacySettingResponse();
        }
    }
}
