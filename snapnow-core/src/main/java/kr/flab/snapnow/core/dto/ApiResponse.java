package kr.flab.snapnow.core.dto;

import java.util.List;

import lombok.Getter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

import kr.flab.snapnow.core.model.Page;
import kr.flab.snapnow.core.enums.ResultCode;
import kr.flab.snapnow.core.enums.SuccessCode;

@Getter
@ToString
@RequiredArgsConstructor
public class ApiResponse<T> {

    private final ResultCode code;
    private final String message;
    private final T data;

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(
            SuccessCode.SUCCESS,
            SuccessCode.SUCCESS.getMessage(),
            null
        );
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(
            SuccessCode.SUCCESS,
            SuccessCode.SUCCESS.getMessage(),
            data
        );
    }

    public static <T> ApiResponse<List<T>> success(List<T> data) {
        return new ApiResponse<>(
            SuccessCode.SUCCESS,
            SuccessCode.SUCCESS.getMessage(),
            data
        );
    }

    public static <T> ApiResponse<Page<T>> success(Page<T> data) {
        return new ApiResponse<>(  
            SuccessCode.SUCCESS,
            SuccessCode.SUCCESS.getMessage(),
            data
        );
    }

    public static <T> ApiResponse<T> failure(ResultCode code) {
        return new ApiResponse<>(
            code,
            code.getMessage(),
            null
        );
    }

    public static <T> ApiResponse<T> failure(ResultCode code, String message) {
        return new ApiResponse<>(
            code,
            message,
            null
        );
    }
}