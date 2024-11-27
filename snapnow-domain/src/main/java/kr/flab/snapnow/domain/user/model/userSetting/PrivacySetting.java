package kr.flab.snapnow.domain.user.model.userSetting;

import java.util.HashMap;

import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.enums.setting.settingOption.PrivacySettingOption;
import kr.flab.snapnow.domain.user.enums.setting.settingType.PrivacySettingType;
import kr.flab.snapnow.domain.user.exception.InvalidSettingException;

public class PrivacySetting extends UserSetting<PrivacySettingType, PrivacySettingOption> {

    public PrivacySetting() {
        this.category = SettingCategory.PRIVACY;
        this.settings = new HashMap<>();

        this.category.getSettingType().forEach(settingType -> {
            this.settings.put((PrivacySettingType) settingType, PrivacySettingOption.PUBLIC);
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
