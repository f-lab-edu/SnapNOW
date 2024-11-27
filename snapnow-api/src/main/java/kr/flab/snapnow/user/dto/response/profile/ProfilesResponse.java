package kr.flab.snapnow.user.dto.response.profile;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfilesResponse {

    private List<ProfileElement> profiles;
}
