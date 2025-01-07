package kr.flab.snapnow.domain.post.model;

import lombok.Builder;
import lombok.Getter;

import kr.flab.snapnow.domain.post.enums.CarouselImageType;

@Builder
@Getter
public class CarouselImage {

    private String imageUrl;
    private CarouselImageType type;

    public CarouselImage(String imageUrl, CarouselImageType type) {
        this.imageUrl = imageUrl;
        this.type = type;
    }
}
