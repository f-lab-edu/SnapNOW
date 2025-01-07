package kr.flab.snapnow.domain.post.model.view;

import java.time.LocalDateTime;

import lombok.Getter;

import kr.flab.snapnow.domain.post.model.Carousel;
import kr.flab.snapnow.domain.user.model.userProfile.UserProfile;

@Getter
public abstract class BasePostView {

    protected Long postId;

    protected UserProfile userProfile;

    protected int likeCount;
    protected int commentCount;
    protected String content;
    protected Carousel carousel;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    protected boolean isHideCount;
    protected boolean isForbiddenComment;

    protected BasePostView(
            Long postId,
            UserProfile userProfile,
            int likeCount,
            int commentCount,
            String content,
            Carousel carousel,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            boolean isHideCount,
            boolean isForbiddenComment) {
        this.postId = postId;
        this.userProfile = userProfile;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.content = content;
        this.carousel = carousel;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isHideCount = isHideCount;
        this.isForbiddenComment = isForbiddenComment;

        if (isHideCount) {
            this.likeCount = 0;
            this.commentCount = 0;
        }
        if (isForbiddenComment) {
            this.commentCount = 0;
        }
    }
}
