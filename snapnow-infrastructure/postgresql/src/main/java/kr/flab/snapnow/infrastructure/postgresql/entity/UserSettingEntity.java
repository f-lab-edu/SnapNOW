package kr.flab.snapnow.infrastructure.postgresql.entity;

import java.util.Map;

import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.NotificationSettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingOption.PrivacySettingOption;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.NotificationSettingType;
import kr.flab.snapnow.domain.user.domain.enums.setting.settingType.PrivacySettingType;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSettingEntity {

    private Long userId;
    private Map<NotificationSettingType, NotificationSettingOption> notificationSettings;
    private Map<PrivacySettingType, PrivacySettingOption> privacySettings;
}
