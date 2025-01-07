package kr.flab.snapnow.application.email.output;

import kr.flab.snapnow.application.email.VerificationType;

public interface EmailVerificationOutputPort {

    void insert(String email, String code, String subject);

    boolean isSuccess(String email, VerificationType type);

    String getVerificationCode(String email, VerificationType type);

    void updateSuccess(String email, String subject);

    void updateFailCount(String email, String subject);

    void delete(String email, String subject);
}