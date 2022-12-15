package tripboat.tripboat1.User.Form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
@Getter
@Setter
public class UserCreateForm {
    @NotEmpty(message = "아이디가 입력되지 않았습니다.")
    private String username;

    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password1;

    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password2;

    @NotEmpty(message = "이메일이 입력되지 않았습니다.")
    @Email
    private String email;

    @NotEmpty(message = "닉네임이 입력되지 않았습니다.")
    private String nickname;
}
