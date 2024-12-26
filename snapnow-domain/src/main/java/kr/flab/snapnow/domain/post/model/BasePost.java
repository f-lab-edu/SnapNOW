package kr.flab.snapnow.domain.post.model;

import java.util.List;
import java.util.ArrayList;

import lombok.Getter;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.comment.model.Comment;
import kr.flab.snapnow.domain.post.enums.PostExceptionType;

@Getter
public abstract class BasePost {

    protected Long id;
    protected Long userId;

    protected String content;
    protected Carousel carousel;

    protected List<String> hashTags;    
    protected List<String> userTags;

    protected boolean isHideCount;
    protected boolean isForbiddenComment;

    protected BasePost(
        Long id, 
        Long userId, 
        String content, 
        Carousel carousel, 
        List<String> hashTags, 
        List<String> userTags, 
        boolean isHideCount, 
            boolean isForbiddenComment) {
        if (userId == null) {
            throw new IllegalArgumentException("User id is required");
        }
        if (content == null && carousel == null) {
            throw new IllegalArgumentException("Content or carousel is required");
        }
        if (hashTags == null) {
            hashTags = new ArrayList<>();
        }
        if (userTags == null) {
            userTags = new ArrayList<>();
        }
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.carousel = carousel;
        this.hashTags = hashTags;
        this.userTags = userTags;
        this.isHideCount = isHideCount;
        this.isForbiddenComment = isForbiddenComment;
    }

    public Comment makeComment(Long userId, String content) {
        if (isForbiddenComment) {
            throw new BadRequestException(PostExceptionType.FORBIDDEN_COMMENT.getMessage());
        }

        Comment comment = Comment.builder()
                                .postId(id)
                                .userId(userId)
                                .content(content)
                                .build();
        return comment;
    }

    public void update(
            String content,
            Carousel carousel,
            List<String> hashTags,
            List<String> userTags,
            boolean isHideCount,
            boolean isForbiddenComment) {
        if (content == null && carousel == null) {
            throw new IllegalArgumentException("Content or carousel is required");
        }
        if (hashTags == null) {
            hashTags = new ArrayList<>();
        }
        if (userTags == null) {
            userTags = new ArrayList<>();
        }
        this.content = content;
        this.carousel = carousel;
        this.hashTags = hashTags;
        this.userTags = userTags;
        this.isHideCount = isHideCount;
        this.isForbiddenComment = isForbiddenComment;
    }
}
