package kr.flab.snapnow.domain.user.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.domain.auth.model.Token;
import kr.flab.snapnow.domain.auth.service.AuthService;
import kr.flab.snapnow.domain.user.domain.model.User;
import kr.flab.snapnow.domain.user.useCase.UserCredentialUseCase;
import kr.flab.snapnow.domain.user.useCase.SignUpUseCase;
import kr.flab.snapnow.domain.user.useCase.DeleteIdUseCase;
import kr.flab.snapnow.domain.user.repository.UserRepository;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserCredential;
import kr.flab.snapnow.domain.user.domain.model.userAccount.EmailCredential;
import kr.flab.snapnow.domain.user.domain.exception.EmailVerificationException;

@Service
@RequiredArgsConstructor
public class UserService implements SignUpUseCase, DeleteIdUseCase {

    private final UserRepository userRepository;
    private final UserCredentialUseCase userCredentialUseCase;
    private final AuthService authService;

    @Override
    public Token signUp(User user) {
        UserCredential userCredential = user.getAccount().getCredential();

        if (userCredential instanceof EmailCredential
            && !userCredential.getEmail().isVerified()) {
            throw new EmailVerificationException();
        }

        userRepository.insert(user);
        return authService.createToken(userCredential);
    }

    @Override
    public void delete(Long userId, String deleteReason) {
        UserCredential userCredential = userCredentialUseCase.getCredential(userId);
        
        if (!userCredential.getEmail().isVerified()) {
            throw new EmailVerificationException("Email verfication is needed before delete account");
        }
        userRepository.delete(userId, deleteReason);
    }
}
