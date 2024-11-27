package kr.flab.snapnow.domain.user.domain.model.userSetting;

import java.util.Map;
import java.util.HashMap;

import lombok.Getter;
import lombok.Builder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.PrivacySettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.PrivacySettingType;
import kr.flab.snapnow.domain.user.domain.exception.InvalidSettingException;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PrivacySetting extends UserSetting<PrivacySettingType, PrivacySettingOption> {

    private SettingCategory category;
    private Map<PrivacySettingType, PrivacySettingOption> settings;

    public PrivacySetting() {
        this.category = SettingCategory.PRIVACY;
        this.settings = new HashMap<>();

        this.category.getSettingType().forEach(settingType -> {
            this.settings.put((PrivacySettingType) settingType, PrivacySettingOption.PUBLIC);
        });
    }

    public static class PrivacySettingBuilder {

        public PrivacySetting build() {
            if (!SettingCategory.PRIVACY.equals(category)) {
                throw new InvalidSettingException();
            }
            return new PrivacySetting(category, settings);
        }
    }
}
