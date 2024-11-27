package kr.flab.snapnow.user.model.dto.response.profile;

import java.util.List;

import lombok.Getter;
import lombok.Builder;

@Getter
@Builder
public class ProfilesResponse {

    private List<ProfileElement> profiles;
}