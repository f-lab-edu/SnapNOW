package kr.flab.snapnow.domain.user.domain.model.userAccount;

import java.time.LocalDate;
import java.util.Locale;

import lombok.Getter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;
import kr.flab.snapnow.domain.user.domain.enums.Gender;
import kr.flab.snapnow.domain.user.domain.exception.IdentityRequiredException;
import kr.flab.snapnow.domain.user.domain.exception.InvalidEmailException;
import kr.flab.snapnow.domain.user.domain.exception.InvalidPasswordException;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserAccount {

    private Long id;
    private String email;
    private String password;
    private AuthProvider authProvider;
    private String providerId;

    private String name;
    private LocalDate birthDay;
    private String phoneNumber;
    private Gender gender;
    private Locale locale;
    private boolean verifiedEmail;

    public static class UserAccountBuilder {

        private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        public UserAccount build() {
            if (email == null || providerId == null) {
                throw new IdentityRequiredException();
            }
            if (email != null && !email.matches(EMAIL_REGEX)) {
                throw new InvalidEmailException();
            }
            if (password == null || password.isBlank()) {
                throw new InvalidPasswordException();
            }
            if (locale == null) {
                locale = Locale.KOREA;
            }
            if (gender == null) {
                gender = Gender.UNKNOWN;
            }

            return new UserAccount(id, email, password, authProvider, providerId, name, birthDay,
                    phoneNumber, gender, locale, verifiedEmail);
        }
    }

    public void updatePassword(String password) {
        this.password = password;
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

    public void updateVerifiedEmail() {
        this.verifiedEmail = true;
    }
}
