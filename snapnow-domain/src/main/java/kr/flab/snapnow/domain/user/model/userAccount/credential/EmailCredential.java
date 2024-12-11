package kr.flab.snapnow.domain.user.model.userAccount.credential;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import kr.flab.snapnow.domain.user.enums.account.AuthProvider;

@Getter
@SuperBuilder
public class EmailCredential extends UserCredential {

    private String password;

    private EmailCredential(Email email, String password) {
        super(AuthProvider.EMAIL, email);
        if (password == null) {
            throw new IllegalArgumentException("Password is required");
        }
        this.password = password;
    }
}
