package kr.flab.snapnow.user.dto.response.account;

import java.time.LocalDate;
import java.util.Locale;

import lombok.Builder;
import lombok.Getter;

import kr.flab.snapnow.domain.user.enums.AuthProvider;
import kr.flab.snapnow.domain.user.enums.Gender;

@Getter
@Builder
public class AccountResponse {

    private String email;
    private AuthProvider authProvider;

    private String name;
    private LocalDate birthDay;
    private String phoneNumber;
    private Gender gender;
    private Locale locale;
}
