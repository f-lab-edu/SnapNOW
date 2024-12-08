package kr.flab.snapnow.domain.user.useCase;

import kr.flab.snapnow.domain.auth.model.Token;
import kr.flab.snapnow.domain.user.domain.model.User;

public interface SignUpUseCase {

    public Token signUp(User user);
}
