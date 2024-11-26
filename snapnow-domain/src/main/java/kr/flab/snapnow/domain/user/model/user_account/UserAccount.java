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

    private Long id;

    @Email
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
}