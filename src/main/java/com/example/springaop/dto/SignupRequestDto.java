package com.example.springaop.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    private String nickname;


    private String username;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,15}$") // 비밀번호를 해쉬화해놔서
    // 일단 여따적어둠
    private String password;
    private String email;
    private boolean admin = false;
    private String adminToken = "";
    //private String
}