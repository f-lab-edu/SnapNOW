package kr.flab.snapnow.domain.user.domain.model.userAccount;

import lombok.Getter;

import kr.flab.snapnow.domain.user.domain.exception.InvalidEmailException;

@Getter
public class Email {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private String value;
    private boolean verifiedEmail;

    public Email(String email) {
        this(email, false);
    }

    public Email(String email, boolean verifiedEmail) {
        validateEmail(email);
        this.value = email;
        this.verifiedEmail = verifiedEmail;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Email email = (Email) obj;
        return value.equals(email.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public void sendVerificationCode() {
        // TODO: 이메일 인증 코드 발송 로직 구현. email을 key로 캐시에 인증 코드 저장.
    }

    public boolean verifyCode(String code) {
        // TODO: 캐시에서 email에 맞는 code 조회. 일치하면 인증 완료 처리.
        // Todo: 인증 완료 시 캐시에서 해당 코드 삭제 -> 인증 완료는 일회성
        if (!this.verifiedEmail) {
            this.verifiedEmail = true;
        }

        return true;
    }

    public boolean isVerified() {
        // TODO: 캐시에서 인증 완료되었는지 확인
        return true;
    }
    
    public void updateEmail(String email) {
        if (this.value != null) {
            throw new IllegalStateException("Email is already set");
        }
        
        validateEmail(email);
        this.value = email;
    }

    private void validateEmail(String email) {
        if (email != null && !email.matches(EMAIL_REGEX)) {
            throw new InvalidEmailException();
        }
    }
}
