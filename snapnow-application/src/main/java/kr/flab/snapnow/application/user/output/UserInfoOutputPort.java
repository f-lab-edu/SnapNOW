package kr.flab.snapnow.application.user.output;

import kr.flab.snapnow.domain.user.model.userAccount.UserInfo;

public interface UserInfoOutputPort {

    public void insert(UserInfo userInfo);

    public UserInfo get(Long userId);

    public void update(UserInfo userInfo);

    public void delete(Long userId);
}
