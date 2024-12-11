package kr.flab.snapnow.application.auth.output;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;

public interface TokenOutputPort {

    String get(Email email, String deviceId);

    Token update(String token, String deviceId);

    void delete(String token, String deviceId);
}