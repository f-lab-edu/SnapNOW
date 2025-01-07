package kr.flab.snapnow.application.auth.usecase.dto;

import java.util.Objects;

import lombok.Getter;
import lombok.Builder;

@Getter
@Builder
public class IssueRequest {

    private Long userId;
    private String deviceId;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        IssueRequest that = (IssueRequest) obj;
        return Objects.equals(userId, that.userId) && Objects.equals(deviceId, that.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, deviceId);
    }
}
