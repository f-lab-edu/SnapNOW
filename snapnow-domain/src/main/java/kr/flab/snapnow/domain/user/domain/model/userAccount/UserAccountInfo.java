package kr.flab.snapnow.domain.user.domain.model.userAccount;

import java.time.LocalDate;
import java.util.Locale;

import lombok.Builder;
import lombok.Getter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.Gender;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserAccountInfo {

    private String name;
    private LocalDate birthDay;
    private String phoneNumber;

    @Builder.Default
    private Gender gender = Gender.UNKNOWN;

    @Builder.Default
    private Locale locale = Locale.KOREA;

    public void updateName(String name) {
        this.name = name;
    }

    public void updateBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updateGender(Gender gender) {
        if (gender == null) {
            this.gender = Gender.UNKNOWN;
            return;
        }
        this.gender = gender;
    }

    public void updateLocale(Locale locale) {
        if (locale == null) {
            this.locale = Locale.KOREA;
            return;
        }
        this.locale = locale;
    }
}