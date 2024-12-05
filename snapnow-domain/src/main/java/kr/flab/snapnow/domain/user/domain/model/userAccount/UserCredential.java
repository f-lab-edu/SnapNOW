package kr.flab.snapnow.domain.user.domain.model.userAccount;

import lombok.Getter;

import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;

@Getter
public abstract class UserCredential {

    protected AuthProvider authProvider;
    protected Email email;

    protected UserCredential(AuthProvider authProvider, Email email) {
        this.authProvider = authProvider;
        this.email = email;
    }
}
