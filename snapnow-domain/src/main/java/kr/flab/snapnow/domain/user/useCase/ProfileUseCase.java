package kr.flab.snapnow.domain.user.useCase;

import kr.flab.snapnow.domain.user.domain.model.userProfile.CompactProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.FullProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;

public interface ProfileUseCase {

    public CompactProfile getCompactProfile(Long userId);

    public FullProfile getProfile(Long userId);

    public FullProfile getProfile(Long targetId, Long userId);

    public void updateProfile(UserProfile userProfile);
}
