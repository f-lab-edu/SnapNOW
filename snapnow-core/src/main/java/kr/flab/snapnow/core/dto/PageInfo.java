package kr.flab.snapnow.core.dto;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.AllArgsConstructor;

@Getter
@ToString
@SuperBuilder
@AllArgsConstructor
public class PageInfo {

    private final int number;
    private final int size;
    private final int totalCount;
    private final boolean hasNext;
    private final boolean hasPrevious;
}
