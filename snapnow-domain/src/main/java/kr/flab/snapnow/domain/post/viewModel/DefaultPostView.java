package kr.flab.snapnow.domain.post.viewModel;

import java.time.LocalDateTime;

import lombok.Getter;

import kr.flab.snapnow.domain.post.model.Carousel;
import kr.flab.snapnow.domain.user.model.userProfile.UserProfile;

@Getter
public class DefaultPostView extends BasePostView {
    
    public DefaultPostView(
        Long postId,
        UserProfile userProfile,
        int likeCount,
        int commentCount,
        String content,
        Carousel carousel,
        LocalDateTime createdAt,
        boolean isHideCount,
        boolean isForbiddenComment) {
        super(postId,
            userProfile,
            likeCount,
            commentCount,
            content,
            carousel,
            createdAt,
            isHideCount,
            isForbiddenComment);
    }
}
