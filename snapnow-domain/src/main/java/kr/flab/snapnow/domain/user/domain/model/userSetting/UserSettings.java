package kr.flab.snapnow.domain.user.domain.model.userSetting;

import java.util.Map;

import lombok.Getter;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.SettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.SettingType;

@Getter
public abstract class UserSettings<
    T extends Enum<T> & SettingType, U extends Enum<U> & SettingOption> {

    private Long userId;
    protected SettingCategory category;
    protected Map<T, U> settings;

    protected UserSettings(Long userId, SettingCategory category, Map<T, U> settings) {
        this.userId = userId;
        this.category = category;
        this.settings = settings;
    }

    public SettingOption getSettingOption(T settingType) {
        return this.settings.get(settingType);
    }
}
