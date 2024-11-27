package kr.flab.snapnow.domain.user.domain.model.userProfile;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CompactProfile {

    private Long userId;
    private String userName;
    private String profileImageUrl;
}
