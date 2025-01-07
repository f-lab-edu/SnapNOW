package kr.flab.snapnow.application.user.output;

public interface UserOutputPort {

    Long insert();

    void delete(Long userId, String deleteReason);
}
