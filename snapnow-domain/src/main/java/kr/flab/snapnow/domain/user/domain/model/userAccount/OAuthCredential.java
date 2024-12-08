package kr.flab.snapnow.domain.user.domain.model.userAccount;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;
import kr.flab.snapnow.domain.user.domain.exception.UserRequiredArgumentException;

@Getter
@Builder
public class OAuthCredential extends UserCredential {

    private String providerId;

    @Builder
    private OAuthCredential(AuthProvider authProvider, String providerId, Email email) {
        super(authProvider, email);
        if (providerId == null) {
            throw new UserRequiredArgumentException("Provider ID is required");
        }
        this.providerId = providerId;
    }
}
