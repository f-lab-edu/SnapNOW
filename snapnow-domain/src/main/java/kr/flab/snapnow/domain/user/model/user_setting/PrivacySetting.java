package kr.flab.snapnow.domain.user.model.user_setting;

import java.util.HashSet;

import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.PrivacySettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.PrivacySettingType;
import kr.flab.snapnow.domain.user.exception.InvalidSettingException;

public class PrivacySetting extends UserSetting<PrivacySettingType, PrivacySettingOption> {

    public PrivacySetting() {
        this.category = SettingCategory.PRIVACY;
        this.settings = new HashSet<>();

        this.category.getSettingType().forEach(settingType -> {
            this.settings.add(new PrivacySettingElement((PrivacySettingType) settingType));
        });
    }

    public static class PrivacySettingBuilder {

        public static PrivacySetting category(SettingCategory category) {
            if (!SettingCategory.PRIVACY.equals(category)) {
                throw new InvalidSettingException();
            }
            return new PrivacySetting();
        }
    }
}
