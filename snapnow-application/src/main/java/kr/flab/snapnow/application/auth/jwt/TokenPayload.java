package kr.flab.snapnow.application.auth.jwt;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenPayload {

    private Long userId;
    private String deviceId;
    private Date issuedAt;
    private Date expiredAt;

    private TokenPayload(Long userId, String deviceId, Date issuedAt, Date expiredAt) {
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
        this.expiredAt = expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        if (this.expiredAt != null) {
            throw new IllegalArgumentException("Token's expiredAt only can be set once");
        }
        this.expiredAt = expiredAt;
    }
}
