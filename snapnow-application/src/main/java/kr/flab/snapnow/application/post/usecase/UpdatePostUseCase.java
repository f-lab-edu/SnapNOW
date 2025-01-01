package kr.flab.snapnow.application.post.usecase;

import kr.flab.snapnow.domain.post.model.BasePost;
import kr.flab.snapnow.domain.post.viewModel.BasePostView;

public interface UpdatePostUseCase {

    BasePostView updatePost(BasePost post);
}
