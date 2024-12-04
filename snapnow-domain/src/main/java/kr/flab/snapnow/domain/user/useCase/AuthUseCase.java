package kr.flab.snapnow.domain.user.useCase;

import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccount;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserCredential;

public interface AuthUseCase {

    UserProfile signUp(UserAccount userAccount, UserProfile userProfile);

    UserCredential getCredential(Long userId);

    String getRefreshToken(Long userId);

    String updateRefreshToken(Long userId, String refreshToken);

    void signOut(Long userId);

    void delete(Long userId, String verifiedCode);
}
