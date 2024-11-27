package kr.flab.snapnow.domain.user.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;

import kr.flab.snapnow.core.entity.BaseEntity;
import kr.flab.snapnow.domain.user.enums.AuthProvider;
import kr.flab.snapnow.domain.user.enums.Gender;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
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

    private String deletedReason;

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
        super(createdAt, updatedAt, deletedAt);

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
        this.deletedReason = deletedReason;
    }
}
