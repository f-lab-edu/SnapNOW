package kr.flab.snapnow.infrastructure.postgresql.entity.userProfile;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileEntity {

    private Long id;
    private String userName;
    private String fullName;
    private String biography;
    private String profileImageUrl;

    private LocalDateTime deletedAt;
}
