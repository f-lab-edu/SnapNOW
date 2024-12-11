package kr.flab.snapnow.application.user.output;

import kr.flab.snapnow.domain.user.model.userAccount.UserAccount;

public interface UserAccountOutputPort {

    UserAccount get(Long userId);

    UserAccount update(UserAccount userAccount);
}
