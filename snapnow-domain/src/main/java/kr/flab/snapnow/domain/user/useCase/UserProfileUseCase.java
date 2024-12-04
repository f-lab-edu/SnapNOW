package kr.flab.snapnow.domain.user.useCase;

import kr.flab.snapnow.domain.user.domain.model.userProfile.CompactProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.FullProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;

public interface UserProfileUseCase {

    CompactProfile getCompactProfile(Long userId);

    FullProfile getProfile(Long userId);

    FullProfile getProfile(Long targetId, Long userId);

    void updateProfile(UserProfile userProfile);
}
