package kr.flab.snapnow.application.post.usecase;

import kr.flab.snapnow.core.model.Page;
import kr.flab.snapnow.domain.post.viewModel.BasePostView;

public interface FeedUseCase {

    Page<BasePostView> get(Long userId, int page, int size);
}
