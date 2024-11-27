package kr.flab.snapnow.domain.user.model.userProfile;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class UserProfile{

    private Long userId;

    @NotBlank(message = "User name cannot be blank")
    private String userName;

    private String fullName;
    private String biography;
    private String profileImageUrl;
}
