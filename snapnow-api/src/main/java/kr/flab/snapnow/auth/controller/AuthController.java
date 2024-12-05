package kr.flab.snapnow.auth.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import kr.flab.snapnow.core.dto.ApiResponse;
import kr.flab.snapnow.auth.service.AuthService;
import kr.flab.snapnow.auth.model.dto.response.TokenResponse;
import kr.flab.snapnow.auth.model.dto.request.EmailLoginRequest;
import kr.flab.snapnow.auth.model.dto.request.SignUpRequest;
import kr.flab.snapnow.auth.model.dto.request.TokenReissueRequest;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/refresh")
    public ApiResponse<TokenResponse> reissueToken(@RequestBody TokenReissueRequest refreshRequest) {
        return ApiResponse.success(authService.refreshToken(refreshRequest));
    }

    @PostMapping("/signup")
    public ApiResponse<TokenResponse> signup(
        @RequestParam(value = "profileImage", required = false) MultipartFile profileImage, 
        @RequestPart SignUpRequest signupRequest) {
        return ApiResponse.success(authService.signup(signupRequest, profileImage));
    }

    @PostMapping("/login")
    public ApiResponse<TokenResponse> login(@RequestBody EmailLoginRequest loginRequest) {
        return ApiResponse.success(authService.login(loginRequest));
    }

    @DeleteMapping("/logout")
    public ApiResponse<Void> logout(@AuthenticationPrincipal UserDetails userDetails) {

        authService.logout(Long.parseLong(userDetails.getUsername()));
        return ApiResponse.success();
    }
}
