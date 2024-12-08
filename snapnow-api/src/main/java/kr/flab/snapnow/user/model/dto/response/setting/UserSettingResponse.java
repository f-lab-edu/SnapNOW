package kr.flab.snapnow.user.model.dto.response.setting;

import java.util.Map;

import lombok.experimental.SuperBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.SettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.SettingType;

@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class UserSettingResponse<
    T extends Enum<T> & SettingType, U extends Enum<U> & SettingOption> {

    protected SettingCategory category;
    protected Map<T, U> settings;
}
