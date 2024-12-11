package kr.flab.snapnow.application.user.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.user.model.User;
import kr.flab.snapnow.application.user.usecase.DeleteIdUseCase;
import kr.flab.snapnow.application.user.usecase.SignUpUseCase;
import kr.flab.snapnow.application.user.output.UserOutputPort;
import kr.flab.snapnow.application.email.output.EmailVerificationOutputPort;

@Service
@RequiredArgsConstructor
public class UserService implements SignUpUseCase, DeleteIdUseCase {

    private final UserOutputPort userOutputPort;
    private final EmailVerificationOutputPort emailVerificationOutputPort;

    public Token signUp(User user) {
        return null;
    }

    public void delete(Long userId, String password) {
    }
}
