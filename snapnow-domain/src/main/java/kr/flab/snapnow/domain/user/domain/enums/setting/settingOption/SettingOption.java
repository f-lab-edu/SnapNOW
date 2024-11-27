package kr.flab.snapnow.domain.user.domain.enums.setting.settingOption;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;

public interface SettingOption {

    String getCode();
    String getValue();
    SettingCategory getCategory();
}