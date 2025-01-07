package kr.flab.snapnow.application.auth.output;

import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;
import kr.flab.snapnow.domain.user.model.userAccount.credential.OAuthCredential;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;

public interface CredentialOutputPort {

    public void insert(UserCredential userCredential);

    public UserCredential get(Long userId);

    public UserCredential get(Email email);

    public OAuthCredential get(String providerId);

    public void updatePassword(Long userId, String password);

    public void delete(Long userId);
}
