package kr.flab.snapnow.domain.user.model.user_setting;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.NotificationSettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.PrivacySettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.SettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.NotificationSettingType;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.PrivacySettingType;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.SettingType;
import kr.flab.snapnow.domain.user.exception.InvalidSettingException;
import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;


@Getter
public class UserSettingElement<
    T extends Enum<T> & SettingType, U extends Enum<U> & SettingOption> {

    protected T settingType;
    protected U settingOption;

    public UserSettingElement(T settingType) {
        this.settingType = settingType;

        if (settingType instanceof NotificationSettingType) {
            this.settingOption = (U) NotificationSettingOption.ALL;
        } else if (settingType instanceof PrivacySettingType) {
            this.settingOption = (U) PrivacySettingOption.PUBLIC;
        }
    }

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
