package kr.flab.snapnow.domain.user.entity;

import java.util.Locale;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import kr.flab.snapnow.core.entity.BaseEntity;
import kr.flab.snapnow.domain.user.enums.account.AuthProvider;
import kr.flab.snapnow.domain.user.enums.account.Gender;

@Getter
@SuperBuilder
public class UserAccountEntity extends BaseEntity {

    private Long id;
    private String email;
    private String password;
    private AuthProvider authProvider;
    private String providerId;

    private String name;
    private Gender gender;
    private Locale locale;
    private LocalDate birthDay;
    private String phoneNumber;
    private boolean verifiedEmail;

    public UserAccountEntity(
        Long id, 
        String email, 
        String password, 
        AuthProvider authProvider, 
        String providerId, 
        String name, 
        Gender gender, 
        Locale locale, 
        LocalDate birthDay, 
        String phoneNumber, 
        boolean verifiedEmail
    ) {
        super();

        this.id = id;
        this.email = email;
        this.password = password;
        this.authProvider = authProvider;
        this.providerId = providerId;
        this.name = name;
        this.gender = gender;
        this.locale = locale;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.verifiedEmail = verifiedEmail;
    }

    public UserAccountEntity(
        Long id, 
        String email, 
        String password, 
        AuthProvider authProvider, 
        String providerId, 
        String name, 
        Gender gender, 
        Locale locale, 
        LocalDate birthDay, 
        String phoneNumber, 
        boolean verifiedEmail, 
        LocalDateTime createdAt, 
        LocalDateTime updatedAt, 
        LocalDateTime deletedAt
    ) {
        super(createdAt, updatedAt, deletedAt);

        this.id = id;
        this.email = email;
        this.password = password;
        this.authProvider = authProvider;
        this.providerId = providerId;
        this.name = name;
        this.gender = gender;
        this.locale = locale;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.verifiedEmail = verifiedEmail;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateGender(Gender gender) {
        this.gender = gender;
    }

    public void updateLocale(Locale locale) {
        this.locale = locale;
    }

    public void updateBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updateVerifiedEmail(boolean verifiedEmail) {
        this.verifiedEmail = verifiedEmail;
    }
}
