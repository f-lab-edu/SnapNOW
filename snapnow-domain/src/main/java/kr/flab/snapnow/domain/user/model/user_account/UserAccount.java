package kr.flab.snapnow.domain.user.model.user_account;

import java.time.LocalDate;
import java.util.Locale;

import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.enums.AuthProvider;
import kr.flab.snapnow.domain.user.enums.Gender;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {

    private Long id;
    private String email;
    private String password;
    private AuthProvider authProvider;
    private String providerId;

    private String name;
    private LocalDate birthDay;
    private String phoneNumber;

    @Builder.Default
    private Gender gender = Gender.UNKNOWN;

    @Builder.Default
    private Locale locale = Locale.KOREA;

    @Builder.Default
    private boolean verifiedEmail = false;
}
