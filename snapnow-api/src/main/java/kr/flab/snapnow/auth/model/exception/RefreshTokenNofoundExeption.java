package kr.flab.snapnow.auth.model.exception;

import kr.flab.snapnow.auth.model.enums.AuthExceptionType;
import kr.flab.snapnow.core.exception.NotFoundException;

public class RefreshTokenNofoundExeption extends NotFoundException {

    public RefreshTokenNofoundExeption() {
        super(AuthExceptionType.REFRESH_TOKEN_NOT_FOUND);
    }

    public RefreshTokenNofoundExeption(AuthExceptionType authExceptionType) {
        super(authExceptionType);
    }

    public RefreshTokenNofoundExeption(String message) {
        super(AuthExceptionType.REFRESH_TOKEN_NOT_FOUND, message);
    }

    public RefreshTokenNofoundExeption(Throwable cause) {
        super(AuthExceptionType.REFRESH_TOKEN_NOT_FOUND, cause);
    }
}
