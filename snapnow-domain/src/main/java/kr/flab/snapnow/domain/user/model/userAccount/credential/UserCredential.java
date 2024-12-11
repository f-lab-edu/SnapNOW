package kr.flab.snapnow.domain.user.model.userAccount.credential;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import kr.flab.snapnow.domain.user.enums.account.AuthProvider;

@Getter
@SuperBuilder
public abstract class UserCredential {

    protected Long userId;
    protected AuthProvider authProvider;
    protected Email email;

    protected UserCredential(Long userId, AuthProvider authProvider, Email email) {
        if (authProvider == null) {
            throw new IllegalArgumentException("Auth provider is required");
        }
        if (email == null) {
            throw new IllegalArgumentException("Email is required");
        }
        this.authProvider = authProvider;
        this.email = email;
    }
}
