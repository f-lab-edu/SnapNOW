package kr.flab.snapnow.domain.user.model.user_account;

import java.time.LocalDate;
import java.util.Locale;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Builder;

import kr.flab.snapnow.domain.user.enums.AuthProvider;
import kr.flab.snapnow.domain.user.enums.Gender;

@Getter
@Builder
public class UserAccount {

    // Todo: annotation을 사용하는 경우 예외처리를 어떻게 해야 일관성을 유지할지 생각해보자

    private Long id;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotNull(message = "Auth provider cannot be null")
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

    public static class UserAccountBuilder {

        public UserAccountBuilder build() {
            if (this.email == null && this.providerId == null) {
                throw new IllegalArgumentException("Email or providerId must be provided");
            }
            return this;
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
