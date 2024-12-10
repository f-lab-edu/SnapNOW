package kr.flab.snapnow.domain.user.domain.model.userAccount.credential;

import lombok.Getter;
import kr.flab.snapnow.domain.user.domain.enums.account.AuthProvider;
import lombok.Builder;

@Getter
@Builder
public class EmailCredential extends UserCredential {

    private String password;

    @Builder
    private EmailCredential(Email email, String password) {
        super(AuthProvider.EMAIL, email);
        if (password == null) {
            throw new IllegalArgumentException("Password is required");
        }
        this.password = password;
    }
}
