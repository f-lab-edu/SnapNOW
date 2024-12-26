package kr.flab.snapnow.domain.post.model;

import java.util.List;

import lombok.Builder;

@Builder
public class DefaultPost extends BasePost {

    @Builder
    private DefaultPost(
        Long id, 
        Long userId, 
        String content, 
        Carousel carousel, 
        List<String> hashTags, 
        List<String> userTags, 
        boolean isHideCount, 
        boolean isForbiddenComment) {
        super(id, userId, content, carousel, hashTags, userTags, isHideCount, isForbiddenComment);
    }
}
