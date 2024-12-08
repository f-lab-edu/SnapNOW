package kr.flab.snapnow.domain.auth.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.domain.auth.jwt.JwtProvider;
import kr.flab.snapnow.domain.auth.model.Token;
import kr.flab.snapnow.domain.auth.useCase.AuthUseCase;
import kr.flab.snapnow.domain.user.useCase.UserCredentialUseCase;
import kr.flab.snapnow.domain.auth.repository.RefreshRepository;
import kr.flab.snapnow.domain.user.domain.model.userAccount.EmailCredential;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserCredential;
import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final JwtProvider jwtProvider;
    private final UserCredentialUseCase userCredentialUseCase;
    private final RefreshRepository refreshRepository;

    public Token signIn(String email, String password) {
        UserCredential userCredential = userCredentialUseCase.getCredential(email);
        Token token;

        if (userCredential.getAuthProvider() != AuthProvider.EMAIL) {
            throw new IllegalStateException("This user hasn't signed up with email");
        }
        if (!((EmailCredential) userCredential).getPassword().matches(password)) {
            throw new IllegalStateException("Password is not matched");
        }
        token = jwtProvider.createToken(userCredential);
        refreshRepository.insert(email, token.getRefreshToken());

        return token;
    }

    public Token createToken(UserCredential userCredential) {
        return jwtProvider.createToken(userCredential);
    }

    public Token refreshToken(String email, Token token) {
        Token newToken;

        jwtProvider.validateToken(token.getRefreshToken());
        refreshRepository.delete(email);
        newToken = jwtProvider.createToken(token);
        refreshRepository.insert(email, newToken.getRefreshToken());

        return newToken;
    }

    public void signOut(String email) {
        refreshRepository.delete(email);
    }
}
