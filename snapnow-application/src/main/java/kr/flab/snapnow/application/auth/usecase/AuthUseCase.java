package kr.flab.snapnow.application.auth.usecase;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.application.auth.usecase.dto.EmailSignInRequest;
import kr.flab.snapnow.application.auth.usecase.dto.OAuthSignInRequest;
import kr.flab.snapnow.application.auth.usecase.dto.ReissueRequest;
import kr.flab.snapnow.application.auth.usecase.dto.SignOutRequest;

public interface AuthUseCase {

    Token signIn(EmailSignInRequest request);

    Token signIn(OAuthSignInRequest request);

    Token reissue(ReissueRequest request);

    void signOut(SignOutRequest request);
}
