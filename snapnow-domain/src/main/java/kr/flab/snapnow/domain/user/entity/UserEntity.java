package kr.flab.snapnow.domain.user.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;

import kr.flab.snapnow.core.entity.BaseEntity;
import kr.flab.snapnow.domain.user.enums.AuthProvider;

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

    public UserEntity(
        Long id,
        String email,
        String password,
        AuthProvider authProvider,
        String providerId,
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
        this.verifiedEmail = verifiedEmail;
    }
}
