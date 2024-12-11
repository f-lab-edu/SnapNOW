package kr.flab.snapnow.domain.user.model.userSetting;

import java.util.Map;
import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.enums.setting.settingOption.PrivacySettingOption;
import kr.flab.snapnow.domain.user.enums.setting.settingType.PrivacySettingType;
import java.util.HashMap;

import lombok.Builder;

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
            throw new IllegalArgumentException("Invalid setting category");
        }
        
    }
}
