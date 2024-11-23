package kr.flab.snapnow.core.model;

import java.util.List;

import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class Page<T> {

    private final List<T> content;

    private int page;
    private int size;
    private long totalCount;
}    