package kr.flab.snapnow.application.user.usecase;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.application.user.usecase.dto.UserCreateDto;

public interface SignUpUseCase {

    public Token signUp(UserCreateDto user);
}
