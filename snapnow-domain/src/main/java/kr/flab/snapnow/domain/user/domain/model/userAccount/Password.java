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

    public static boolean matches(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }

    public Password(String password) {
        validatePassword(password);
        this.value = password;
    }

    private void validatePassword(String password) {
        if (password == null || password.isBlank()) {
        throw new InvalidPasswordException();
        }
    }
}
