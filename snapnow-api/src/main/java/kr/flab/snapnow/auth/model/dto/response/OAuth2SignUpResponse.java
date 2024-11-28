package kr.flab.snapnow.auth.model.dto.response;

import java.time.LocalDate;
import java.util.Locale;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.Gender;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OAuth2SignUpResponse {

    private String securityToken;

    private String email;
    private String name;
    private String profileImageUrl;
    private LocalDate birthDay;
    private String phoneNumber;
    private Gender gender;
    private Locale locale;
}
