package kr.flab.snapnow.domain.user.repository;

import java.util.Optional;

import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccount;

public interface UserAccountRepository {

    UserAccount insert(UserAccount userAccount);

    UserAccount update(UserAccount userAccount);

    void updateVerifiedEmail(Long userId);

    void updatePassword(Long userId, String password);

    void delete(Long userId, String deletedReason);

    Optional<UserAccount> findById(Long userId);
}
