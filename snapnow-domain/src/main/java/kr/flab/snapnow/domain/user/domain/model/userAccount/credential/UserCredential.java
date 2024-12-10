package kr.flab.snapnow.domain.user.domain.model.userAccount.credential;

import kr.flab.snapnow.domain.user.domain.enums.account.AuthProvider;
import lombok.Getter;

@Getter
public abstract class UserCredential {

    protected AuthProvider authProvider;
    protected Email email;

    protected UserCredential(AuthProvider authProvider, Email email) {
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
