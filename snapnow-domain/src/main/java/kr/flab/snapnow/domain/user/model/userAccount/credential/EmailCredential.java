package kr.flab.snapnow.domain.user.model.userAccount.credential;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.enums.account.AuthProvider;

@Getter
@Builder
public class EmailCredential extends UserCredential {

    private Long userId;
    private final AuthProvider authProvider = AuthProvider.EMAIL;
    private Email email;
    private String password;

    @Builder
    private EmailCredential(Long userId, Email email, String password) {
        super(userId, AuthProvider.EMAIL, email);

        if (password == null) {
            throw new IllegalArgumentException("Password is required");
        }
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }
}
