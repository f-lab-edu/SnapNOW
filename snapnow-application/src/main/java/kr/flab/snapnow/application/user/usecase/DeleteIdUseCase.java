package kr.flab.snapnow.application.user.usecase;

public interface DeleteIdUseCase {

    public void deleteOAuthUser(Long userId, String deleteReason);

    public void deleteEmailUser(Long userId, String password, String deleteReason);
}
