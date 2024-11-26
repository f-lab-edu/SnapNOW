package kr.flab.snapnow.domain.user.entity;

import java.util.Locale;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.enums.Gender;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountEntity {

    private Long id;
    private String name;
    private Gender gender;
    private Locale locale;
    private LocalDate birthDay;
    private String phoneNumber;
}
