package kr.flab.snapnow.domain.user.domain.model.userAccount;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;

@Getter
@Builder
public class OAuthCredential extends UserCredential {

    private String providerId;

    @Builder
    private OAuthCredential(AuthProvider authProvider, String providerId, Email email) {
        super(authProvider, email);
        this.providerId = providerId;
    }
}
