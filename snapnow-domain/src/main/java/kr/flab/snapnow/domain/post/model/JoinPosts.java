package kr.flab.snapnow.domain.post.model;

import java.time.LocalDateTime;
import java.util.List;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.post.enums.PostExceptionType;

public class JoinPosts {

    Long joinId;
    LocalDateTime expiredAt;
    List<JoinPost> joinPosts;

    public JoinPosts(Long joinId, LocalDateTime expiredAt, List<JoinPost> joinPosts) {
        this.joinId = joinId;
        this.expiredAt = expiredAt;
        this.joinPosts = joinPosts;
    }

    public void addJoinPost(JoinPost joinPost, boolean isFriend) {
        if (!isFriend) {
            throw new BadRequestException(PostExceptionType.ONLY_FRIEND_CAN_JOIN.getMessage());
        }
        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new BadRequestException(PostExceptionType.JOIN_POST_EXPIRED.getMessage());
        }
        if (joinPosts.stream().anyMatch(post -> post.getUserId().equals(joinPost.getUserId()))) {
            throw new BadRequestException(PostExceptionType.JOIN_POST_ALREADY_JOINED.getMessage());
        }
        this.joinPosts.add(joinPost);
    }
}
