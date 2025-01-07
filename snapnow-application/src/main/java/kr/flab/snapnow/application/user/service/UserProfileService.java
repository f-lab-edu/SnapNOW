package kr.flab.snapnow.application.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import kr.flab.snapnow.application.user.output.UserProfileOutputPort;
import kr.flab.snapnow.domain.user.model.userProfile.UserProfile;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserProfileService {

    private final UserProfileOutputPort userProfileOutputPort;

    @Transactional
    public void insert(UserProfile userProfile) {
        userProfileOutputPort.insert(userProfile);
    }

    public UserProfile get(Long userId) {
        return userProfileOutputPort.get(userId);
    }

    @Transactional
    public void update(UserProfile userProfile) {
        userProfileOutputPort.update(userProfile);
    }

    @Transactional
    public void delete(Long userId) {
        userProfileOutputPort.delete(userId);
    }
}
