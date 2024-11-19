package kr.flab.snapnow.core.dto;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;

import kr.flab.snapnow.core.enums.ResultCode;
import kr.flab.snapnow.core.enums.Success;

@Getter
@ToString
public class ApiResponse<T> {
    private final ResultCode code;
    private final String message;
    private final T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final PageInfo pageInfo;

    private ApiResponse(ResultCode code, String message, T data, PageInfo pageInfo) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.pageInfo = pageInfo;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(
            Success.SUCCESS,
            Success.SUCCESS.getMessage(),
            null,
            null
        );
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(
            Success.SUCCESS,
            Success.SUCCESS.getMessage(),
            data,
            null
        );
    }

    public static <T> ApiResponse<List<T>> success(List<T> data) {
        return new ApiResponse<>(
            Success.SUCCESS,
            Success.SUCCESS.getMessage(),
            data,
            null
        );
    }

    public static <T> ApiResponse<List<T>> success(PageResponse<T> data) {
        return new ApiResponse<>(  
            Success.SUCCESS,
            Success.SUCCESS.getMessage(),
            data.getContent(),
            data.getPageInfo()
        );
    }

    public static <T> ApiResponse<T> failure(ResultCode code) {
        return new ApiResponse<>(
            code,
            code.getMessage(),
            null,
            null
        );
    }

    public static <T> ApiResponse<T> failure(ResultCode code, String message) {
        return new ApiResponse<>(
            code,
            message,
            null,
            null
        );
    }
}