package kr.flab.snapnow.application.post.output;

import kr.flab.snapnow.core.model.Page;
import kr.flab.snapnow.domain.post.viewModel.BasePostView;

public interface FeedOutputPort {

    Page<BasePostView> get(Long userId, int page, int size);
}
