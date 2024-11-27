package kr.flab.snapnow.infrastructure.postgresql.entity.userAccount;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import kr.flab.snapnow.core.entity.BaseEntity;
import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;
import kr.flab.snapnow.domain.user.domain.enums.Gender;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    private Long id;
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

    public UserEntity(
        Long id,
        String email,
        String password,
        AuthProvider authProvider,
        String providerId,
        boolean verifiedEmail,
        String name,
        Gender gender,
        Locale locale,
        LocalDate birthDay,
        String phoneNumber,
        String deletedReason,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt
    ) {
        super(createdAt, updatedAt, deletedAt, deletedReason);

        this.id = id;
        this.email = email;
        this.password = password;
        this.authProvider = authProvider;
        this.providerId = providerId;
        this.verifiedEmail = verifiedEmail;
        this.name = name;
        this.gender = gender;
        this.locale = locale;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
    }
}
