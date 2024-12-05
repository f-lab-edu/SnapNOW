package kr.flab.snapnow.domain.user.useCase;

import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccount;

public interface AuthUseCase {

    public void signUp(UserAccount userAccount, UserProfile userProfile);

    public boolean signIn(String email, String password);

    public String getRefreshToken(Long userId);

    public void updateRefreshToken(Long userId, String refreshToken);

    public void signOut(Long userId);

    public void delete(Long userId, String verifiedCode);
}
