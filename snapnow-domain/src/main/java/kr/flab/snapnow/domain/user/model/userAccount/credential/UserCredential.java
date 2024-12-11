package kr.flab.snapnow.domain.user.model.userAccount.credential;

import lombok.Getter;

import kr.flab.snapnow.domain.user.enums.account.AuthProvider;

@Getter
public abstract class UserCredential {

    protected Long userId;
    protected AuthProvider authProvider;
    protected Email email;

    public UserCredential(Long userId, AuthProvider authProvider, Email email) {
        if (authProvider == null) {
            throw new IllegalArgumentException("Auth provider is required");
        }
        if (email == null) {
            throw new IllegalArgumentException("Email is required");
        }

        this.userId = userId;
        this.authProvider = authProvider;
        this.email = email;
    }
}
