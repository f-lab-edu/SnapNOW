package kr.flab.snapnow.application.post.usecase;

import kr.flab.snapnow.domain.post.model.DefaultPost;
import kr.flab.snapnow.domain.post.viewModel.JoinPostView;

public interface JoinUseCase {

    JoinPostView join(Long joinId, DefaultPost post);
}
