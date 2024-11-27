package kr.flab.snapnow.user.dto.response.setting;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import kr.flab.snapnow.domain.user.enums.setting.setting_option.SettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.SettingType;
import kr.flab.snapnow.domain.user.exception.InvalidSettingException;
import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;

@Getter
@SuperBuilder
public abstract class UserSettingElement<
    T extends Enum<T> & SettingType, U extends Enum<U> & SettingOption> {

    protected T settingType;
    protected U settingOption;

    public UserSettingElement(T settingType, U settingOption) {
        if (!SettingCategory.isValidSetting(settingType, settingOption)) {
            throw new InvalidSettingException();
        }

        this.settingType = settingType;
        this.settingOption = settingOption;
    }

    public Map<T, U> getSettingMap() {
        return new HashMap<>(Map.of(this.settingType, this.settingOption));
    }

    public void updateSettingOption(U settingOption) {
        if (!SettingCategory.isValidSetting(this.settingType, settingOption)) {
            throw new InvalidSettingException();
        }

        this.settingOption = settingOption;
    }
}
