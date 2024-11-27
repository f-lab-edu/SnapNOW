package kr.flab.snapnow.user.dto.request.profile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateRequest {

    private String userName;
    private String fullName;
    private String biography;
}
