package kr.flab.snapnow.application.auth.service;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import kr.flab.snapnow.domain.auth.exception.InvalidPasswordException;
import kr.flab.snapnow.domain.auth.exception.WrongPasswordException;
import kr.flab.snapnow.domain.user.model.userAccount.credential.EmailCredential;

@Service
public class PasswordService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String validateAndEncodePassword(String password) {
        if (!isValidPassword(password)) {
            throw new InvalidPasswordException();
        }

        return encodePassword(password);
    }

    public void updatePassword(
        EmailCredential credential, String originalPassword, String newPassword) {
        if (!isPasswordMatch(originalPassword, credential.getPassword())) {
            throw new WrongPasswordException();
        }
        if (!isValidPassword(newPassword)) {
            throw new InvalidPasswordException();
        }

        String encodedNewPassword = encodePassword(newPassword);
        credential.updatePassword(encodedNewPassword);
    }

    public boolean isValidPassword(String password) {
        return password.length() >= 8 && password.length() <= 15
                && password.matches(".*[a-zA-Z].*")
                && password.matches(".*\\d.*");
    }

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean isPasswordMatch(String passwordToMatch, String password) {
        return passwordEncoder.matches(passwordToMatch, password);
    }
}
