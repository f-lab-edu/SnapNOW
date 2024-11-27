package kr.flab.snapnow.domain.user.domain.model.userAccount;

import lombok.Builder;
import lombok.Getter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCredential {

    private Long id;
    private String email;
    private String password;
    private AuthProvider authProvider;
    private String providerId;
    private boolean verifiedEmail;
}
