package kr.flab.snapnow.domain.post.viewModel;

import kr.flab.snapnow.domain.post.model.CarouselImage;
import lombok.Getter;

@Getter
public class PostElementView {

    Long postId;

    CarouselImage thumbnail;
    int likeCount;
    int commentCount;
    boolean isHideCount;
}
