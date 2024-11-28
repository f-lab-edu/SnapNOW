package kr.flab.snapnow.auth.model.dto.request;

import java.time.LocalDate;
import java.util.Locale;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.Gender;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    private String userName;
    private String fullName;
    private String biography;
    private String profileImageUrl;

    private String email;
    private String password;
    private String securityToken;

    private String name;
    private Gender gender;
    private Locale locale;
    private LocalDate birthDay;
    private String phoneNumber;
}
