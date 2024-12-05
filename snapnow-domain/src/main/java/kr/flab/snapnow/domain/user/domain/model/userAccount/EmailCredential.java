package kr.flab.snapnow.domain.user.domain.model.userAccount;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;

@Getter
@Builder
public class EmailCredential extends UserCredential {

    private Password password;

    @Builder
    private EmailCredential(Email email, Password password) {
        super(AuthProvider.EMAIL, email);
        this.password = password;
    }
}
