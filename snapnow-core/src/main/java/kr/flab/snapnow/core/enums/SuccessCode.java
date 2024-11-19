package kr.flab.snapnow.core.enums;

public enum SuccessCode implements ResultCode {

    SUCCESS("Success");

    private final String message;

    SuccessCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
