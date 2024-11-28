package kr.flab.snapnow.domain.user.useCase;

import kr.flab.snapnow.domain.user.domain.model.userProfile.FullProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.CompactProfile;

public interface GetProfileUseCase {

    FullProfile getProfile(Long userId);

    CompactProfile getCompactProfile(Long userId);
}
