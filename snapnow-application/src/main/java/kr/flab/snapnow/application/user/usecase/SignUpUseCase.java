package kr.flab.snapnow.application.user.usecase;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.user.model.User;

public interface SignUpUseCase {

    public Token signUp(User user);
}
