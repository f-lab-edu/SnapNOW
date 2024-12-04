package kr.flab.snapnow.domain.user.useCase;

import kr.flab.snapnow.domain.user.domain.model.userAccount.UserCredential;

public interface UserCredentialUseCase {

    public UserCredential getCredential(Long userId);

    public void sendVerificationCode(String email);

    public void verifyCode(String email, String code);

    public void updatePassword(Long userId, String originalPassword, String newPassword);
}
