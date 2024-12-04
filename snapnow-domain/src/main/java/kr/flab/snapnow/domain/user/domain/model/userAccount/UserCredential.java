package kr.flab.snapnow.domain.user.domain.model.userAccount;

import lombok.Builder;
import lombok.Getter;

import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;
import kr.flab.snapnow.domain.user.domain.exception.IdentityRequiredException;
import kr.flab.snapnow.domain.user.domain.exception.InvalidEmailException;
import kr.flab.snapnow.domain.user.domain.exception.InvalidPasswordException;

@Getter
@Builder
public class UserCredential {

    private Long userId;
    private String email;
    private String password;
    private AuthProvider authProvider;
    private String providerId;
    private boolean verifiedEmail;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    @Builder
    private UserCredential(String email, String password, AuthProvider authProvider, String providerId,
            boolean verifiedEmail) {

        validateIdentity(email, providerId);
        validateEmail(email);
        validatePassword(password);

        this.email = email;
        this.password = password;
        this.authProvider = authProvider;
        this.providerId = providerId;
        this.verifiedEmail = verifiedEmail;
    }

    public void updateEmail(String email) {
        if (this.email != null) {
            throw new IllegalStateException("Email is already set");
        }

        validateEmail(email);
        this.email = email;
    }

    public void updatePassword(String originalPassword, String newPassword) {
        if (this.providerId != null) {
            throw new IllegalStateException("Password cannot be updated for social accounts");
        }
        if (!this.password.equals(originalPassword)) {
            throw new InvalidPasswordException();
        }
        validatePassword(newPassword);
        this.password = newPassword;
    }

    public void updateVerifiedEmail() {
        if (this.email == null) {
            throw new IllegalStateException("Email is not set");
        }
        this.verifiedEmail = true;
    }

    private void validateIdentity(String email, String providerId) {
        if (email == null || providerId == null) {
            throw new IdentityRequiredException();
        }
    }

    private void validateEmail(String email) {
        if (email != null && !email.matches(EMAIL_REGEX)) {
            throw new InvalidEmailException();
        }
    }

    private void validatePassword(String password) {
        if (password == null || password.isBlank()) {
            throw new InvalidPasswordException();
        }
    }
}
