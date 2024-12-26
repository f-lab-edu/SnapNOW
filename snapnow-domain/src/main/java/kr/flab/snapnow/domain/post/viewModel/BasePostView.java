package kr.flab.snapnow.domain.post.viewModel;

import java.time.LocalDateTime;

import lombok.Getter;

import kr.flab.snapnow.domain.post.model.Carousel;
import kr.flab.snapnow.domain.user.model.userProfile.UserProfile;

@Getter
public abstract class BasePostView {

    Long postId;

    UserProfile userProfile;

    int likeCount;
    int commentCount;
    String content;
    Carousel carousel;
    LocalDateTime createdAt;

    boolean isHideCount;
    boolean isForbiddenComment;

    protected BasePostView(
            Long postId,
            UserProfile userProfile,
            int likeCount,
            int commentCount,
            String content,
            Carousel carousel,
            LocalDateTime createdAt,
            boolean isHideCount,
            boolean isForbiddenComment) {
        this.postId = postId;
        this.userProfile = userProfile;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.content = content;
        this.carousel = carousel;
        this.createdAt = createdAt;
        this.isHideCount = isHideCount;
        this.isForbiddenComment = isForbiddenComment;

        if (isHideCount) {
            this.likeCount = 0;
            this.commentCount = 0;
        }
    }
}
