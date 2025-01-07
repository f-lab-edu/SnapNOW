package kr.flab.snapnow.application.auth.usecase;

import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;

public interface GetCredentialUseCase {

    UserCredential get(Long userId);

    UserCredential get(Email email);
}
