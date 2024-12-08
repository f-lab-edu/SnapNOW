package kr.flab.snapnow.domain.user.domain.model.userAccount;

import lombok.Getter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import kr.flab.snapnow.domain.user.domain.exception.InvalidPasswordException;

@Getter
public class Password {

    private static final int SALT_ROUNDS = 12;
    private static final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder(SALT_ROUNDS);

    private String value;

    public static String encode(String password) {
        return passwordEncoder.encode(password);
    }
    
    public Password(String password) {
        validatePassword(password);
        this.value = password;
    }

    public boolean matches(String password) {
        return passwordEncoder.matches(password, this.value);
    }

    private void validatePassword(String password) {
        if (password == null || password.isBlank()) {
        throw new InvalidPasswordException();
        }
    }
}
