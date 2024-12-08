package kr.flab.snapnow.domain.auth.useCase;

import kr.flab.snapnow.domain.auth.model.Token;

public interface AuthUseCase {

    public Token signIn(String email, String password);

    public Token refreshToken(String email, Token token);

    public void signOut(String email);
}
