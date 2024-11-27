package kr.flab.snapnow.infrastructure.postgresql.entity.userProfile;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class CompactProfileModel {

    private Long userId;
    private String userName;
    private String profileImageUrl;
}
