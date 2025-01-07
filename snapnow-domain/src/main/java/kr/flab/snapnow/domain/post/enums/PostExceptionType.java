package kr.flab.snapnow.domain.post.enums;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PostExceptionType {

    POST_NOT_FOUND("Post not found"),
    DELETED_POST("Deleted post"),
    FORBIDDEN_COMMENT("Forbidden comment"),

    // join post
    JOIN_POST_EXPIRED("Join post expired"),
    JOIN_POST_ALREADY_JOINED("Join post already joined"),
    ONLY_FRIEND_CAN_JOIN("Only friend can join"),
    ;

    private final String message;

    public static PostExceptionType of(String message) {
        return Arrays.stream(PostExceptionType.values())
            .filter(type -> type.getMessage().equals(message))
            .findFirst()
            .orElse(null);
    }
}
