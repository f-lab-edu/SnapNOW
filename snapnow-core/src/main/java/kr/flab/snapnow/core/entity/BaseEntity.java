package kr.flab.snapnow.core.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Builder;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    @Builder.Default
    protected LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    protected LocalDateTime updatedAt = LocalDateTime.now();

    @Builder.Default
    protected LocalDateTime deletedAt = null;

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
