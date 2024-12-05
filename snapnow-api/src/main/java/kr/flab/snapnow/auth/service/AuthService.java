package kr.flab.snapnow.auth.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.flab.snapnow.jwt.JwtProvider;

import kr.flab.snapnow.auth.model.dto.response.TokenResponse;
import kr.flab.snapnow.auth.model.dto.request.EmailLoginRequest;
import kr.flab.snapnow.auth.model.dto.request.TokenReissueRequest;
import kr.flab.snapnow.auth.model.dto.request.SignUpRequest;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtProvider jwtProvider;

    public TokenResponse createToken(Long userId) {
        TokenResponse token = jwtProvider.createToken(userId);

        // Todo: refresh token 캐시에 저장
        return token;
    }

    public TokenResponse refreshToken(TokenReissueRequest refreshRequest) {
        jwtProvider.validateToken(refreshRequest.getRefreshToken());
        Long userId = jwtProvider.getUserId(refreshRequest.getRefreshToken());

        // Todo: refresh token 캐시에 저장
        return createToken(userId);
    }

    public TokenResponse login(EmailLoginRequest loginRequest) {
        Long userId = 1L;

        // Todo: 로그인 검증 로직 추후 추가
        return createToken(userId);
    }

    public TokenResponse signup(SignUpRequest signupRequest, MultipartFile profileImageFile) {
        Long userId = 1L;

        // Todo: 회원가입 로직 추가. Oauth, Email 모두 여기서 처리
        return createToken(userId);
    }

    public void logout(Long userId) {
        // Todo: Refresh Token 캐시에서 삭제
        return;
    }
}
