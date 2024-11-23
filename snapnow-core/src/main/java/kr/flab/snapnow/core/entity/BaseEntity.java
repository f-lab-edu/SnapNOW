package kr.flab.snapnow.core.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
    protected LocalDateTime deletedAt;
    protected String deletedReason;

    public void setDeleted(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public void setDeleted(LocalDateTime deletedAt, String deletedReason) {
        this.deletedAt = deletedAt;
        this.deletedReason = deletedReason;
    }
}
