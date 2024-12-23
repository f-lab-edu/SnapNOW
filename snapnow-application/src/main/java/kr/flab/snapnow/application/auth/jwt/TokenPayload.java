package kr.flab.snapnow.application.auth.jwt;

import java.util.Date;
import java.util.Objects;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenPayload {

    private Long userId;
    private String deviceId;
    private Date issuedAt;

    private TokenPayload(Long userId, String deviceId, Date issuedAt) {
        if (userId == null) {
            throw new IllegalArgumentException("Token requires userId");
        }
        if (deviceId == null) {
            throw new IllegalArgumentException("Token requires deviceId");
        }
        if (issuedAt == null) {
            issuedAt = new Date();
        }
        this.userId = userId;
        this.deviceId = deviceId;
        this.issuedAt = issuedAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        TokenPayload that = (TokenPayload) obj;
        return userId.equals(that.userId) && deviceId.equals(that.deviceId)
                && issuedAt.equals(that.issuedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, deviceId, issuedAt);
    }
}