package kr.flab.snapnow.application.user.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.flab.snapnow.application.user.output.UserInfoOutputPort;
import kr.flab.snapnow.domain.user.model.userAccount.UserInfo;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoOutputPort userInfoOutputPort;

    @Transactional
    public void insert(Long userId) {
        UserInfo userInfo = UserInfo.builder()
            .userId(userId)
            .build();

        userInfoOutputPort.insert(userInfo);
    }

    public UserInfo get(Long userId) {
        return userInfoOutputPort.get(userId);
    }

    @Transactional
    public void update(UserInfo userInfo) {
        userInfoOutputPort.update(userInfo);
    }

    @Transactional
    public void delete(Long userId) {
        userInfoOutputPort.delete(userId);
    }
}


