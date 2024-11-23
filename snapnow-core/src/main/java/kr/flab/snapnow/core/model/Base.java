package kr.flab.snapnow.core.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Base {

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
}
