package kr.flab.snapnow.domain.user.model.userAccount.credential;

import lombok.Getter;

@Getter
public class Email {

    private String value;

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public Email(String email) {
        validateEmail(email);
        this.value = email;
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
            throw new IllegalArgumentException("Invalid email format");
        }
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
}
