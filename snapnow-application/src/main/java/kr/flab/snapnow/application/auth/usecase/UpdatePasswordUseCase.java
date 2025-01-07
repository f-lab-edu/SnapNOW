package kr.flab.snapnow.application.auth.usecase;

public interface UpdatePasswordUseCase {

    void updatePassword(Long userId, String originalPassword, String newPassword);
}
