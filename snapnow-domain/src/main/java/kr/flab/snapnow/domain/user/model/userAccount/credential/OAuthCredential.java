package kr.flab.snapnow.domain.user.model.userAccount.credential;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.enums.account.AuthProvider;

@Getter
@Builder
public class OAuthCredential extends UserCredential {

    private Long userId;
    private AuthProvider authProvider;
    private Email email;
    private String providerId;

    private OAuthCredential(
        Long userId, AuthProvider authProvider, Email email, String providerId) {
        super(userId, authProvider, email);

        if (providerId == null) {
            throw new IllegalArgumentException("Provider ID is required");
        }
        this.userId = userId;
        this.authProvider = authProvider;
        this.email = email;
        this.providerId = providerId;
    }
}
