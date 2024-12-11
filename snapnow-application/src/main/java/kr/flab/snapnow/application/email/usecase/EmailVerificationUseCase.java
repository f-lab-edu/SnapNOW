package kr.flab.snapnow.application.email.usecase;

public interface EmailVerificationUseCase {
    
    public void sendVerificationCode(String email);

    public boolean verifyVerificationCode(String email, String code);
}
