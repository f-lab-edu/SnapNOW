package kr.flab.snapnow.application.user.output;

import kr.flab.snapnow.domain.user.model.userAccount.UserAccount;
import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;

public interface UserAccountOutputPort {

    UserAccount get(Long userId);

    UserCredential getCredential(Long userId);

    UserCredential getCredential(Email email);

    UserAccount update(UserAccount userAccount);

    void updatePassword(Long userId, String password);
}
