package kr.flab.snapnow.domain.user.repository;

import java.util.Optional;

import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.FullProfile;
import kr.flab.snapnow.domain.user.domain.model.userProfile.CompactProfile;

public interface UserProfileRepository {

    UserProfile insert( UserProfile userProfile);

    UserProfile update(UserProfile userProfile);

    Optional<UserProfile> findById(Long userId);

    FullProfile getFullProfileById(Long userId);

    CompactProfile getCompactProfileById(Long userId);
}
