package kr.flab.snapnow.application.auth.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import kr.flab.snapnow.domain.user.model.userAccount.credential.EmailCredential;

@Service
@RequiredArgsConstructor
public class PasswordService {

    private final BCryptPasswordEncoder passwordEncoder;

    public boolean isValidPassword(String password) {
        return password.length() >= 8
                && password.matches(".*[a-zA-Z].*")
                && password.matches(".*\\d.*");
    }

    public String encodePassword(String password) {
        return null;
    }

    public boolean isPasswordMatch(String password, String passwordToMatch) {
        return false;
    }

    public void updatePassword(EmailCredential credential, String newPassword) {
    }
}
