package kr.flab.snapnow.domain.user.domain.model.userAccount;

import java.time.LocalDate;
import java.util.Locale;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.domain.enums.Gender;
import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;
import kr.flab.snapnow.domain.user.domain.exception.UserRequiredArgumentException;

@Getter
@Builder
public class UserAccount {

    private UserCredential credential;

    private String name;
    private LocalDate birthDay;
    private String phoneNumber;
    private Gender gender;
    private Locale locale;

    @Builder
    protected UserAccount(UserCredential credential, String name, LocalDate birthDay,
            String phoneNumber, Gender gender, Locale locale) {
        if (credential == null) {
            throw new UserRequiredArgumentException();
        }
        this.credential = credential;
        this.name = name;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.gender = gender == null ? Gender.UNKNOWN : gender;
        this.locale = locale == null ? Locale.KOREA : locale;
    }

    @Builder
    protected UserAccount(Long userId, String email, String password, AuthProvider authProvider,
            String providerId, boolean verifiedEmail, String name, LocalDate birthDay,
            String phoneNumber, Gender gender, Locale locale) {
        this(UserCredential.builder()
                .userId(userId)
                .email(email)
                .password(password)
                .authProvider(authProvider)
                .providerId(providerId)
                .verifiedEmail(verifiedEmail)
                .build(), name, birthDay, phoneNumber, gender, locale);
    }

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
        this.gender = gender;
    }

    public void updateLocale(Locale locale) {
        this.locale = locale;
    }
}
