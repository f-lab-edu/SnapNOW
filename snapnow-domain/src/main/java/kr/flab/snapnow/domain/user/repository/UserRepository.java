package kr.flab.snapnow.domain.user.repository;

import kr.flab.snapnow.domain.user.domain.model.User;

public interface UserRepository {

    void insert(User user);

    void delete(Long userId, String deleteReason);
}
