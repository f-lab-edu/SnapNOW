package kr.flab.snapnow.application.post.usecase;

import kr.flab.snapnow.core.model.Page;
import kr.flab.snapnow.domain.post.viewModel.JoinPostView;
import kr.flab.snapnow.domain.user.model.userProfile.UserProfile;

public interface GetJoinUseCase {

    Page<JoinPostView> getJoinPosts(Long joinId, int page, int size);

    Page<UserProfile> getJoinUsers(Long joinId, int page, int size);
}
