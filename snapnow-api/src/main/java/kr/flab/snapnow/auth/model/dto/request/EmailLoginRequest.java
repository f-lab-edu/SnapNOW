package kr.flab.snapnow.auth.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailLoginRequest {

    private String email;
    private String password;
}
