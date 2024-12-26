package kr.flab.snapnow.domain.comment.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Comment {

    Long id;
    Long postId;
    Long userId;
    Long parentCommentId;

    String content;

    private Comment(Long id, Long postId, Long userId, Long parentCommentId, String content) {
        if (postId == null) {
            throw new IllegalArgumentException("Post id is required");
        }
        if (userId == null) {
            throw new IllegalArgumentException("User id is required");
        }
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Content is required");
        }
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.parentCommentId = parentCommentId;
        this.content = content;
    }
}
