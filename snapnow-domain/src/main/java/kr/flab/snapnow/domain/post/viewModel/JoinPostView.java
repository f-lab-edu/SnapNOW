package kr.flab.snapnow.domain.post.viewModel;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;

import kr.flab.snapnow.domain.post.model.Carousel;
import kr.flab.snapnow.domain.user.model.userProfile.UserProfile;

@Getter
public class JoinPostView extends BasePostView {

    int joinCount;
    List<UserProfile> joinUsersUpToFive;

    LocalDateTime expiredAt;

    public JoinPostView(
        Long postId,
        UserProfile userProfile,
        int likeCount,
        int commentCount,
        String content,
        Carousel carousel,
        LocalDateTime createdAt,
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
            isHideCount,
            isForbiddenComment);
        this.joinUsersUpToFive = joinUsersUpToFive;
        this.joinCount = joinCount;
        this.expiredAt = expiredAt;
    }
}

