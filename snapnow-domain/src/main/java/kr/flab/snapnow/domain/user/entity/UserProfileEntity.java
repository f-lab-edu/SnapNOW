package kr.flab.snapnow.domain.user.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import kr.flab.snapnow.core.entity.BaseEntity;

@Getter
@SuperBuilder
public class UserProfileEntity extends BaseEntity {

    private Long id;
    private String userName;
    private String fullName;
    private String biography;
    private String profileImageUrl;

    public UserProfileEntity(Long id, String userName, String fullName, String biography, String profileImageUrl) {
        super();

        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.biography = biography;
        this.profileImageUrl = profileImageUrl;
    }

    public UserProfileEntity(Long id, String userName, String fullName, String biography, String profileImageUrl, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        super(createdAt, updatedAt, deletedAt);

        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.biography = biography;
        this.profileImageUrl = profileImageUrl;
    }

    public void userNameUpdate(String userName) {
        this.userName = userName;
    }

    public void fullNameUpdate(String fullName) {
        this.fullName = fullName;
    }

    public void biographyUpdate(String biography) {
        this.biography = biography;
    }

    public void profileImageUrlUpdate(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
