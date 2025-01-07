package kr.flab.snapnow.domain.post.model.view;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

import kr.flab.snapnow.domain.post.model.Carousel;
import kr.flab.snapnow.domain.user.model.userProfile.UserProfile;

@Getter
@Builder
public class DefaultPostView extends BasePostView {

    @Builder
    private DefaultPostView(
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
        super(postId,
            userProfile,
            likeCount,
            commentCount,
            content,
            carousel,
            createdAt,
            updatedAt,
            isHideCount,
            isForbiddenComment);
    }
}
