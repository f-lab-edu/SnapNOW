package kr.flab.snapnow.application.email.output;

public interface EmailSendOutputPort {

    void sendEmail(String email, String content);
}