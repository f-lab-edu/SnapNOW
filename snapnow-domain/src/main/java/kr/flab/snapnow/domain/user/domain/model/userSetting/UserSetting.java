package kr.flab.snapnow.domain.user.domain.model.userSetting;

import java.util.Map;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.SettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.SettingType;

public abstract class UserSetting<
    T extends Enum<T> & SettingType, U extends Enum<U> & SettingOption> {

    protected SettingCategory category;
    protected Map<T, U> settings;

    public void updateSetting(T settingType, U settingOption) {
        this.settings.put(settingType, settingOption);
    }
}
