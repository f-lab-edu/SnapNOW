package kr.flab.snapnow.domain.user.useCase;

public interface DeleteIdUseCase {

    public void delete(Long userId, String deleteReason);
}
