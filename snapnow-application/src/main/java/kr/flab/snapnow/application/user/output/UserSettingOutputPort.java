package kr.flab.snapnow.application.user.output;

import kr.flab.snapnow.domain.user.model.userSetting.UserSettings;

public interface UserSettingOutputPort {

    public void insert(UserSettings userSettings);

    public void delete(Long userId);
}
