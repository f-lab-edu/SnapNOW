package kr.flab.snapnow.application.auth.usecase;

import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;

public interface CredentialUseCase {

    UserCredential getCredential(Long userId);

    void updatePassword(Long userId, String originalPassword, String newPassword);
}
