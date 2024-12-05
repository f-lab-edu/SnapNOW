package kr.flab.snapnow.domain.user.domain.model.userAccount;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.domain.exception.UserRequiredArgumentException;

@Getter
@Builder
public class UserAccount {

    private Long userId;
    private UserCredential credential;
    private UserAccountInfo info;

    @Builder
    protected UserAccount(Long userId, UserCredential credential, UserAccountInfo info) {
        if (credential == null || info == null) {
            throw new UserRequiredArgumentException();
        }
        this.userId = userId;
        this.credential = credential;
        this.info = info;
    }
}
