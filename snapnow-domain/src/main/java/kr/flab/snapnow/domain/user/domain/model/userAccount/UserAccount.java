package kr.flab.snapnow.domain.user.domain.model.userAccount;

import lombok.Getter;
import kr.flab.snapnow.domain.user.domain.model.userAccount.credential.UserCredential;
import lombok.Builder;

@Getter
@Builder
public class UserAccount {

    private Long userId;
    private UserCredential credential;
    private UserAccountInfo info;

    @Builder
    protected UserAccount(Long userId, UserCredential credential, UserAccountInfo info) {
        if (credential == null) {
            throw new IllegalArgumentException("UserAccount credential is null");
        }
        if (info == null) {
            throw new IllegalArgumentException("UserAccount info is null");
        }
        this.userId = userId;
        this.credential = credential;
        this.info = info;
    }
}
