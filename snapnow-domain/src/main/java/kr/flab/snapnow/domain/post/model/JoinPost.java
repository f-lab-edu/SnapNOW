package kr.flab.snapnow.domain.post.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

import kr.flab.snapnow.domain.post.enums.CarouselImageType;

@Builder
@Getter
public class JoinPost extends BasePost {

    private Long joinId;
    private Long hostUserId;

    private LocalDateTime expiredAt;

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
        if (carousel.getCarouselImages().stream()
                .anyMatch(image -> image.getType() == CarouselImageType.FRONT)) {
            throw new IllegalArgumentException("Join post must have snap");
        }
        this.expiredAt = LocalDateTime.now().plusHours(4);
    }
}
