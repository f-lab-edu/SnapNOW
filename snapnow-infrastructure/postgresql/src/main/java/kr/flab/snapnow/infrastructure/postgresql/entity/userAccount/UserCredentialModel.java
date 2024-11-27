package kr.flab.snapnow.infrastructure.postgresql.entity.userAccount;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;

@Getter
@Setter
@NoArgsConstructor
public class UserCredentialModel {

    private Long id;
    private String email;
    private String password;
    private AuthProvider authProvider;
    private String providerId;
    private boolean verifiedEmail;
}
