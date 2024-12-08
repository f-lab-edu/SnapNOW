package kr.flab.snapnow.user.model.dto.request.setting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.SettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.SettingType;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserSettingUpdateRequest {

    private SettingCategory settingCategory;
    private SettingType settingType;
    private SettingOption settingOption;
}