package kr.flab.snapnow.domain.post.model;

import java.time.LocalDateTime;
import java.util.List;
import kr.flab.snapnow.domain.post.enums.CarouselImageType;
import lombok.Builder;

@Builder
public class JoinPost extends BasePost {

    Long joinId;
    Long hostUserId;

    LocalDateTime expiredAt;

    @Builder
    private JoinPost(
        Long joinId,
        Long hostUserId,
        Long id,
        Long userId,
        String content,
        Carousel carousel,
        List<String> hashTags,
        List<String> userTags,
        boolean isHideCount,
        boolean isForbiddenComment) {
        super(id, userId, content, carousel, hashTags, userTags, isHideCount, isForbiddenComment);

        if (joinId == null) {
            throw new IllegalArgumentException("Join post must have joinId");
        }
        if (carousel.getCarouselImages().stream()
                .anyMatch(image -> image.getType() == CarouselImageType.FRONT)) {
            throw new IllegalArgumentException("Join post must have snap");
        }
        this.expiredAt = LocalDateTime.now().plusHours(4);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
