package kr.flab.snapnow.user.dto.request.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordUpdateRequest {

    private String currentPassword;
    private String newPassword;
}