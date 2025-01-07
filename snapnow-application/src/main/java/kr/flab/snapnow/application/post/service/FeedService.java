package kr.flab.snapnow.application.post.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.core.model.Page;
import kr.flab.snapnow.domain.post.viewModel.BasePostView;
import kr.flab.snapnow.application.post.usecase.FeedUseCase;
import kr.flab.snapnow.application.post.output.FeedOutputPort;

@Service
@RequiredArgsConstructor
public class FeedService implements FeedUseCase {

    private final FeedOutputPort feedOutputPort;

    // Todo: 현재는 DB에서 모두 join하여 결과 반환 -> 후에는 캐시에서 post id list만 가져와 조회하는 방식으로 변경
    public Page<BasePostView> get(Long userId, int page, int size) {
        return feedOutputPort.get(userId, page, size);
    }
}