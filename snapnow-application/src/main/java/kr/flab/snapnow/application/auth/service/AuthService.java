package kr.flab.snapnow.application.auth.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.application.auth.usecase.dto.EmailSignInRequest;
import kr.flab.snapnow.application.auth.usecase.dto.OAuthSignInRequest;
import kr.flab.snapnow.application.auth.usecase.dto.IssueRequest;
import kr.flab.snapnow.application.auth.usecase.dto.ReissueRequest;
import kr.flab.snapnow.application.auth.usecase.dto.SignOutRequest;
import kr.flab.snapnow.application.auth.usecase.AuthUseCase;
import kr.flab.snapnow.application.auth.output.TokenOutputPort;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final TokenOutputPort tokenOutputPort;

    public Token signIn(EmailSignInRequest request) {
        return null;
    }

    public Token signIn(OAuthSignInRequest request) {
        return null;
    }

    public Token issue(IssueRequest request) {
        return null;
    }

    public Token reissue(ReissueRequest request) {
        return null;
    }
    
    public void signOut(SignOutRequest request) {
    }
}

