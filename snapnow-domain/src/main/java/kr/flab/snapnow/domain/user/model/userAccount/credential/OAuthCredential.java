package kr.flab.snapnow.domain.user.model.userAccount.credential;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import kr.flab.snapnow.domain.user.enums.account.AuthProvider;

@Getter
@SuperBuilder
public class OAuthCredential extends UserCredential {

    private String providerId;

    private OAuthCredential(AuthProvider authProvider, String providerId, Email email) {
        super(authProvider, email);
        if (providerId == null) {
            throw new IllegalArgumentException("Provider ID is required");
        }
        this.providerId = providerId;
    }
}
