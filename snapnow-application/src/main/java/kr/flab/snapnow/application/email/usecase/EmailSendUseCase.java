package kr.flab.snapnow.application.email.usecase;

public interface EmailSendUseCase {

    public void sendEmail(String email, String subject, String content);
}

