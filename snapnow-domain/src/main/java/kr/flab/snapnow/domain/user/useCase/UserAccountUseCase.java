package kr.flab.snapnow.domain.user.useCase;

import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccountInfo;

public interface UserAccountUseCase {

    public UserAccountInfo getUserAccountInfo(Long userId);

    public UserAccountInfo updateUserAccountInfo(Long userId, UserAccountInfo userAccountInfo);
}
