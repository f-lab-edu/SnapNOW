package kr.flab.snapnow.application.auth.usecase;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;

public interface AuthUseCase {

    Token signIn(Email email, String password, String deviceId);

    Token issue(Email email, String deviceId);

    Token reissue(Token token, String deviceId);

    void signOut(Email email, String deviceId);
}
