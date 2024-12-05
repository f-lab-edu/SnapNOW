package kr.flab.snapnow.domain.user.domain.model.userSetting;

import java.util.Map;
import java.util.HashMap;

import lombok.Builder;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.PrivacySettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.PrivacySettingType;
import kr.flab.snapnow.domain.user.domain.exception.InvalidSettingException;

@Builder
public class PrivacySettings extends UserSettings<PrivacySettingType, PrivacySettingOption> {

    public PrivacySettings() {
        super(null, SettingCategory.PRIVACY, new HashMap<>());

        this.category.getSettingType().forEach(settingType -> {
            this.settings.put((PrivacySettingType) settingType,
                (PrivacySettingOption) this.category.getDefaultSettingOption());
        });
    }

    @Builder
    private PrivacySettings(Long userId, SettingCategory category,
            Map<PrivacySettingType, PrivacySettingOption> settings) {
        super(userId, category, settings);
        if (!SettingCategory.PRIVACY.equals(category)) {
            throw new InvalidSettingException();
        }
        
    }
}
