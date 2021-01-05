package kr.jmd.spring_starter.interfaces.command;

// 로그인 혹은 회원가입 시 전화번호를 보내주는 커맨드
public class LoginCommand {

    private String phone;

    @Override
    public String toString() {
        return String.format("LoginCommand {phone='%s'}", phone);
    }

}
