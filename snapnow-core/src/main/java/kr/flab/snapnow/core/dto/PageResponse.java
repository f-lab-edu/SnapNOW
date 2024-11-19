package kr.flab.snapnow.core.dto;

import java.util.List;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class PageResponse<T> {

    private final PageInfo pageInfo;
    private final List<T> content;

    public PageResponse(int number, int size, int totalCount, boolean hasNext, boolean hasPrevious, List<T> data) {
        this.pageInfo = PageInfo.builder()
            .number(number)
            .size(size)
            .totalCount(totalCount)
            .hasNext(hasNext)
            .hasPrevious(hasPrevious)
            .build();
        this.content = data;
    }

    public PageResponse(PageInfo pageInfo, List<T> data) {
        this.pageInfo = pageInfo;
        this.content = data;
    }
}
