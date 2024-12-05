package kr.flab.snapnow.domain.user.repository;

import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccount;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserCredential;

public interface UserAccountRepository {

    UserAccount find(Long userId);

    UserCredential getCredential(Long userId);

    UserAccount update(UserAccount userAccount);

    void updateVerifiedEmail(Long userId);

    void updatePassword(Long userId, String password);
}
