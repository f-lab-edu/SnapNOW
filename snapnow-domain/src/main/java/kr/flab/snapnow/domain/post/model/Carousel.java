package kr.flab.snapnow.domain.post.model;

import java.util.List;
import java.util.ArrayList;

import lombok.Builder;
import lombok.Getter;

import kr.flab.snapnow.domain.post.enums.CarouselImageType;

@Getter
@Builder
public class Carousel {

    int count;
    List<CarouselImage> carouselImages;

    @Builder
    private Carousel(List<CarouselImage> carouselImages) {
        int count = 0;
        int defaultCount = 0;
        int frontCount = 0;
        int backCount = 0;

        if (carouselImages == null) {
            carouselImages = new ArrayList<>();
            return;
        }
        for (CarouselImage carouselImage : carouselImages) {
            if (carouselImage.getType() == CarouselImageType.FRONT) {
                frontCount++;
            } else if (carouselImage.getType() == CarouselImageType.BACK) {
                backCount++;
            } else if (carouselImage.getType() == CarouselImageType.DEFAULT) {
                defaultCount++;
            }
        }
        if (frontCount != 0 && (frontCount != 1 || backCount != 1)) {
            throw new IllegalArgumentException(
                    "Front and back image url must be provided together");
        }
        count = defaultCount + frontCount;
        if (count > 5) {
            throw new IllegalArgumentException("Default image url must be provided");
        }

        this.count = count;
        this.carouselImages = carouselImages;
    }
}
