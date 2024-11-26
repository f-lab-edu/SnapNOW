package kr.flab.snapnow.domain.user.entity;

import java.util.Map;

import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.enums.setting.setting_option.NotificationSettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.PrivacySettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.NotificationSetting;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.PrivacySetting;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSettingEntity {

    private Long userId;
    private Map<NotificationSetting, NotificationSettingOption> notificationSettings;
    private Map<PrivacySetting, PrivacySettingOption> privacySettings;
}
