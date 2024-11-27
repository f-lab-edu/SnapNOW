package kr.flab.snapnow.domain.user.model.user_setting;

import java.util.Map;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;

import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.SettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.SettingType;

@Getter
@SuperBuilder
@NoArgsConstructor
public abstract class UserSetting<
    T extends Enum<T> & SettingType, U extends Enum<U> & SettingOption> {

    protected SettingCategory category;
    protected Map<T, U> settings;

    public void updateSetting(T settingType, U settingOption) {
        this.settings.put(settingType, settingOption);
    }
}
