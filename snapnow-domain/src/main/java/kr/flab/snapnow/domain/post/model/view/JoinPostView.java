package kr.flab.snapnow.domain.post.model.view;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

import kr.flab.snapnow.domain.post.model.Carousel;
import kr.flab.snapnow.domain.user.model.userProfile.UserProfile;

@Getter
public class JoinPostView extends BasePostView {

    private int joinCount;
    private List<UserProfile> joinUsersUpToFive;

    private LocalDateTime expiredAt;

    @Builder
    private JoinPostView(
        Long postId,
        UserProfile userProfile,
        int likeCount,
        int commentCount,
        String content,
        Carousel carousel,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        boolean isHideCount,
        boolean isForbiddenComment,
        List<UserProfile> joinUsersUpToFive,
        int joinCount,
        LocalDateTime expiredAt) {
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
        this.joinUsersUpToFive = joinUsersUpToFive;
        this.joinCount = joinCount;
        this.expiredAt = expiredAt;
    }
}

