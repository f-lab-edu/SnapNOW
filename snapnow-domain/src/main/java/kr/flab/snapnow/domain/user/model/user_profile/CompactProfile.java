package kr.flab.snapnow.domain.user.model.user_profile;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CompactProfile {

    private Long userId;
    private String userName;
    private String profileImageUrl;
}
