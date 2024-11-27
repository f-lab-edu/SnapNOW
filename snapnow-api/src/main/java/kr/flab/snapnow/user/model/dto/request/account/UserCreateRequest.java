package kr.flab.snapnow.user.model.dto.request.account;

import java.time.LocalDate;
import java.util.Locale;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.springframework.web.multipart.MultipartFile;

import kr.flab.snapnow.domain.user.domain.enums.Gender;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    private String userName;
    private String fullName;
    private String biography;
    private MultipartFile profileImage;

    private String email;
    private String password;
    private String oAuthToken;

    private String name;
    private Gender gender;
    private Locale locale;
    private LocalDate birthDay;
    private String phoneNumber;
}
