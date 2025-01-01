package kr.flab.snapnow.application.post.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.core.model.Page;
import kr.flab.snapnow.domain.post.model.BasePost;
import kr.flab.snapnow.domain.post.model.DefaultPost;
import kr.flab.snapnow.domain.post.viewModel.BasePostView;
import kr.flab.snapnow.domain.post.viewModel.PostElementView;
import kr.flab.snapnow.domain.post.viewModel.JoinPostView;
import kr.flab.snapnow.domain.user.model.userProfile.UserProfile;
import kr.flab.snapnow.application.post.output.PostOutputPort;
import kr.flab.snapnow.application.post.usecase.GetPostUseCase;
import kr.flab.snapnow.application.post.usecase.JoinUseCase;
import kr.flab.snapnow.application.post.usecase.GetJoinUseCase;
import kr.flab.snapnow.application.post.usecase.UploadPostUseCase;
import kr.flab.snapnow.application.post.usecase.UpdatePostUseCase;
import kr.flab.snapnow.application.post.usecase.DeletePostUseCase;

@Service
@RequiredArgsConstructor
public class PostService implements
    UploadPostUseCase,
    GetPostUseCase,
    UpdatePostUseCase,
    DeletePostUseCase,
    GetJoinUseCase,
    JoinUseCase {

    private final PostOutputPort postOutputPort;

    public BasePostView uploadPost(BasePost post) {
        // Todo: upload 이벤트 발행 -> feed 업데이트 및 알림
        return postOutputPort.insert(post);
    }

    public JoinPostView join(Long postId, DefaultPost post) {
        return postOutputPort.join(postId, post);
    }

    public BasePostView get(Long postId) {
        return postOutputPort.get(postId);
    }

    public Page<PostElementView> getJoinPosts(Long joinId, int page, int size) {
        return postOutputPort.getJoinPosts(joinId, page, size);
    }

    public Page<UserProfile> getJoinUsers(Long joinId, int page, int size) {
        return postOutputPort.getJoinUsers(joinId, page, size);
    }

    public BasePostView update(BasePost post) {
        return postOutputPort.update(post);
    }

    public void delete(Long postId) {
        postOutputPort.delete(postId);
    }
}
