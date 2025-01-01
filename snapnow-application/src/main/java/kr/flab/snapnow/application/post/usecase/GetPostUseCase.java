package kr.flab.snapnow.application.post.usecase;

import kr.flab.snapnow.domain.post.viewModel.BasePostView;

public interface GetPostUseCase {

    BasePostView get(Long postId);
}
