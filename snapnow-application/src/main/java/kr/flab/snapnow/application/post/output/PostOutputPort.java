package kr.flab.snapnow.application.post.output;

import kr.flab.snapnow.core.model.Page;
import kr.flab.snapnow.domain.post.model.BasePost;
import kr.flab.snapnow.domain.post.model.DefaultPost;
import kr.flab.snapnow.domain.post.viewModel.BasePostView;
import kr.flab.snapnow.domain.post.viewModel.JoinPostView;
import kr.flab.snapnow.domain.post.viewModel.PostElementView;
import kr.flab.snapnow.domain.user.model.userProfile.UserProfile;

public interface PostOutputPort {

    BasePostView insert(BasePost post);

    BasePostView get(Long postId);

    JoinPostView join(Long joinId, DefaultPost post);

    Page<PostElementView> getJoinPosts(Long joinId, int page, int size);

    Page<UserProfile> getJoinUsers(Long joinId, int page, int size);

    BasePostView update(BasePost post);

    void delete(Long postId);
}
