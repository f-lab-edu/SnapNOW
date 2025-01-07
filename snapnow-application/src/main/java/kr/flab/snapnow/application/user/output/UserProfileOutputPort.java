package kr.flab.snapnow.application.user.output;

import kr.flab.snapnow.domain.user.model.userProfile.UserProfile;

public interface UserProfileOutputPort {

    public void insert(UserProfile userProfile);

    public UserProfile get(Long userId);

    public UserProfile update(UserProfile userProfile);

    public void delete(Long userId);
}
