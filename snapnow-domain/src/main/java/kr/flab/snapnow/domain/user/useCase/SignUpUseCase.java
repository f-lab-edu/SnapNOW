package kr.flab.snapnow.domain.user.useCase;

import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccount;

public interface SignUpUseCase {

    UserProfile signUp(UserAccount userAccount, UserProfile userProfile);
}
