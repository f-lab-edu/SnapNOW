package kr.flab.snapnow.infrastructure.postgresql.entity.userAccount;

import java.time.LocalDate;
import java.util.Locale;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;
import kr.flab.snapnow.domain.user.domain.enums.Gender;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountEntity {

    private Long userId;
    private String email;
    private String password;
    private AuthProvider authProvider;
    private String providerId;
    private boolean verifiedEmail;

    private String name;
    private Gender gender;
    private Locale locale;
    private LocalDate birthDay;
    private String phoneNumber;
}
