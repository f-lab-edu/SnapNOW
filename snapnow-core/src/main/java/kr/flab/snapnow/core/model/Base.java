package kr.flab.snapnow.core.model;

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
public class Base {

    @Builder.Default
    protected LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    protected LocalDateTime updatedAt = LocalDateTime.now();

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
