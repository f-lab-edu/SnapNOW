package kr.flab.snapnow.domain.user.useCase;

import kr.flab.snapnow.domain.user.domain.model.userProfile.FullProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;

public interface ProfileUseCase {

    public FullProfile getProfile(Long userId);

    public FullProfile getProfile(Long targetId, Long userId);

    public UserProfile updateProfile(UserProfile userProfile);
}
