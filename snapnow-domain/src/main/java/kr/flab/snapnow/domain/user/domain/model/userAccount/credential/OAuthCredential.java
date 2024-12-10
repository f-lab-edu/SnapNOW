package kr.flab.snapnow.domain.user.domain.model.userAccount.credential;

import lombok.Getter;
import kr.flab.snapnow.domain.user.domain.enums.account.AuthProvider;
import lombok.Builder;

@Getter
@Builder
public class OAuthCredential extends UserCredential {

    private String providerId;

    @Builder
    private OAuthCredential(AuthProvider authProvider, String providerId, Email email) {
        super(authProvider, email);
        if (providerId == null) {
            throw new IllegalArgumentException("Provider ID is required");
        }
        this.providerId = providerId;
    }
}
