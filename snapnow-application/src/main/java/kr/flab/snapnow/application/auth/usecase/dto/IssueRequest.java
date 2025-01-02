package kr.flab.snapnow.application.auth.usecase.dto;

import lombok.Getter;
import lombok.Builder;

@Getter
@Builder
public class IssueRequest {

    private Long userId;
    private String deviceId;
}