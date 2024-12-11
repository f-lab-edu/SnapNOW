package kr.flab.snapnow.application.user.output;

import kr.flab.snapnow.domain.user.model.User;

public interface UserOutputPort {

    void insert(User user);

    void delete(Long userId, String deleteReason);
}
