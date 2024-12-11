package kr.flab.snapnow.application.email.output;

public interface EmailVerificationOutputPort {

    void insert(String email, String code, String subject);

    boolean isSuccess(String email, String subject);

    String getVerificationCode(String email, String subject);

    void updateSuccess(String email, String subject);

    void updateFailCount(String email, String subject);

    void delete(String email, String subject);
}