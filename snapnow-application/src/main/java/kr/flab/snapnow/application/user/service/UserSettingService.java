package kr.flab.snapnow.application.user.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import kr.flab.snapnow.application.user.output.UserSettingOutputPort;
import kr.flab.snapnow.domain.user.model.userSetting.NotificationSettings;
import kr.flab.snapnow.domain.user.model.userSetting.PrivacySettings;

@Service
@RequiredArgsConstructor
public class UserSettingService {

    private final UserSettingOutputPort userSettingOutputPort;

    public void insert(Long userId) {
        NotificationSettings notificationSettings = new NotificationSettings();
        PrivacySettings privacySettings = new PrivacySettings();

        userSettingOutputPort.insert(notificationSettings);
        userSettingOutputPort.insert(privacySettings);
    }

    public void delete(Long userId) {
        userSettingOutputPort.delete(userId);
    }
}
