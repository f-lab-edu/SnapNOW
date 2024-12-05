package kr.flab.snapnow.domain.user.repository;

import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.FullProfile;

public interface UserProfileRepository {

    UserProfile update(UserProfile userProfile);

    UserProfile find(Long userId);

    UserProfile find(Long userId, Long targetUserId);

    FullProfile getFullProfile(Long targetId, Long userId);
}
