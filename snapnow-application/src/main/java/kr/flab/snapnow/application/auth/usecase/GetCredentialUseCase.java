package kr.flab.snapnow.application.auth.usecase;

import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;

public interface GetCredentialUseCase {

    UserCredential getCredential(Long userId);
}
