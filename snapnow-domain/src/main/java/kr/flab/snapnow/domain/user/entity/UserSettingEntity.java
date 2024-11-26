package kr.flab.snapnow.domain.user.entity;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import kr.flab.snapnow.core.entity.BaseEntity;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.NotificationSettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_option.PrivacySettingOption;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.NotificationSetting;
import kr.flab.snapnow.domain.user.enums.setting.setting_type.PrivacySetting;

@Getter
@SuperBuilder
public class UserSettingEntity extends BaseEntity {

    private Long userId;
    private Map<NotificationSetting, NotificationSettingOption> notificationSettings;
    private Map<PrivacySetting, PrivacySettingOption> privacySettings;

    public UserSettingEntity(
        Long userId,
        Map<NotificationSetting, NotificationSettingOption> notificationSettings,
        Map<PrivacySetting, PrivacySettingOption> privacySettings) {
        super();

        this.userId = userId;
        this.notificationSettings = notificationSettings;
        this.privacySettings = privacySettings;
    }

    public UserSettingEntity(
        Long userId,
        Map<NotificationSetting, NotificationSettingOption> notificationSettings,
        Map<PrivacySetting, PrivacySettingOption> privacySettings,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt) {
        super(createdAt, updatedAt, deletedAt);

        this.userId = userId;
        this.notificationSettings = notificationSettings;
        this.privacySettings = privacySettings;
    }
}
