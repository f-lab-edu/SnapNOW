package kr.flab.snapnow.domain.user.model.user_setting;

import java.util.Set;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;

import kr.flab.snapnow.domain.user.enums.setting.SettingCategory;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.SettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.SettingType;

@Getter
@SuperBuilder
@NoArgsConstructor
public abstract class UserSetting<
    T extends Enum<T> & SettingType, U extends Enum<U> & SettingOption> {

    protected SettingCategory category;
    protected Set<UserSettingElement<T, U>> settings;

    public UserSetting(SettingCategory category) {
        this.category = category;
        this.settings = new HashSet<>();

        this.category.getSettingType().forEach(settingType -> {
            this.settings.add((UserSettingElement<T, U>) new UserSettingElement<>(settingType));
        });
    }

    public void updateSetting(UserSettingElement<T, U> setting) {
        this.settings.stream()
            .filter(s -> s.getSettingType().equals(setting.getSettingType()))
            .findFirst()
            .ifPresent(s -> s.updateSettingOption(setting.getSettingOption()));
    }

    public void updateSetting(T settingType, U settingOption) {
        this.settings.stream().filter(setting -> setting.getSettingType().equals(settingType))
                .findFirst().ifPresent(setting -> setting.updateSettingOption(settingOption));
    }
}
