package kr.flab.snapnow.domain.user.model.userSetting;

import java.util.Map;
import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.enums.setting.settingOption.SettingOption;
import kr.flab.snapnow.domain.user.enums.setting.settingType.SettingType;
import lombok.Getter;

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
