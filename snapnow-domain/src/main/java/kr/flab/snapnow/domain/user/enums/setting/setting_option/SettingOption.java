package kr.flab.snapnow.domain.user.enums.setting.setting_option;

import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;

public interface SettingOption {

    String getCode();
    String getValue();
    SettingCategory getCategory();
}
