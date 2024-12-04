package kr.flab.snapnow.domain.user.repository;

import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.FullProfile;

public interface UserProfileRepository {

    UserProfile insert(UserProfile userProfile);

    UserProfile update(UserProfile userProfile);

    UserProfile find(Long userId);

    FullProfile getFullProfile(Long targetId, Long userId);
}
