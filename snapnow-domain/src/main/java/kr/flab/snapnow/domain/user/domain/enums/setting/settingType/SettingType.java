package kr.flab.snapnow.domain.user.domain.enums.setting.settingType;

import java.util.EnumSet;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.SettingOption;

public interface SettingType {

    String getCode();
    String getValue();
    EnumSet<? extends SettingOption> getOptions();
    SettingCategory getCategory();
}
