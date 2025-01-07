package kr.flab.snapnow.application.auth.output;

import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;

public interface CredentialOutputPort {

    public void insert(UserCredential userCredential);

    public UserCredential get(Long userId);

    public void updatePassword(Long userId, String password);

    public void delete(Long userId);
}
