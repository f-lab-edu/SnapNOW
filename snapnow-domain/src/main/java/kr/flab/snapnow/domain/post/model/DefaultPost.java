package kr.flab.snapnow.domain.post.model;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        DefaultPost that = (DefaultPost) obj;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId)
                && Objects.equals(content, that.content)
                && Objects.equals(carousel, that.carousel)
                && Objects.equals(hashTags, that.hashTags)
                && Objects.equals(userTags, that.userTags)
                && isHideCount == that.isHideCount
                && isForbiddenComment == that.isForbiddenComment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id, userId, content, carousel, hashTags, userTags, isHideCount, isForbiddenComment);
    }
}
