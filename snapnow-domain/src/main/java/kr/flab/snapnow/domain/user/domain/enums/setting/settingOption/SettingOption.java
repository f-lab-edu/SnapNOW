package kr.flab.snapnow.domain.user.domain.enums.setting.settingOption;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;

public interface SettingOption {

    public String getCode();
    public String getValue();
    public SettingCategory getCategory();
}
