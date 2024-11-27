package kr.flab.snapnow.user.model.dto.request.account;

import java.util.Locale;
import kr.flab.snapnow.domain.user.domain.enums.Gender;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateRequeest {

    private String name;
    private Gender gender;
    private Locale locale;
    private LocalDate birthDay;
    private String phoneNumber;
}
