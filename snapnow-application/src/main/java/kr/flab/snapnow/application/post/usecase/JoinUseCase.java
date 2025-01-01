package kr.flab.snapnow.application.post.usecase;

import kr.flab.snapnow.domain.post.model.JoinPost;

public interface JoinUseCase {

    Long join(Long joinId, JoinPost joinPost);
}
