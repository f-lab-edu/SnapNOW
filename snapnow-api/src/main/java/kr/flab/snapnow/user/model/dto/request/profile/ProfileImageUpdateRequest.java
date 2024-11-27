package kr.flab.snapnow.user.model.dto.request.profile;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileImageUpdateRequest {

    private MultipartFile profileImage;
}
