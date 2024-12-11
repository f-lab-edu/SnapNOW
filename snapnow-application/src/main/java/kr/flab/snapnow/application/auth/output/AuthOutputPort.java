package kr.flab.snapnow.application.auth.output;

import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;

public interface AuthOutputPort {

    UserCredential getCredential(Email email);
}
