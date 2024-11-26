package kr.flab.snapnow.domain.user.enums.setting.type;

import java.util.EnumSet;

import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.enums.setting.option.SettingOption;

public interface SettingType {

    String getCode();

    String getValue();
    EnumSet<? extends SettingOption> getOptions();
    SettingCategory getCategory();
}
