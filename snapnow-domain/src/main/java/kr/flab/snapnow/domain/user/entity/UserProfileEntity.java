package kr.flab.snapnow.domain.user.entity;

import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileEntity {

    private Long id;
    private String userName;
    private String fullName;
    private String biography;
    private String profileImageUrl;
}
