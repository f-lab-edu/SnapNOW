package kr.flab.snapnow;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import kr.flab.snapnow.core.entity.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends BaseEntity {

    private Long id;

    public UserEntity(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt,
            String deletedReason) {
        super(createdAt, updatedAt, deletedAt, deletedReason);
        this.id = id;
    }
}
