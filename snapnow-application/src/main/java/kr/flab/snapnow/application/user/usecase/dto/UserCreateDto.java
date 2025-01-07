package kr.flab.snapnow.application.user.usecase.dto;

import lombok.Builder;
import lombok.Getter;

import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;
import kr.flab.snapnow.domain.user.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.model.userDevice.Device;

@Getter
@Builder
public class UserCreateDto {

    private UserCredential credential;
    private UserProfile profile;
    private Device device;

    private UserCreateDto(UserCredential credential, UserProfile profile, Device device) {
        this.credential = credential;
        this.profile = profile;
        this.device = device;
    }
}
