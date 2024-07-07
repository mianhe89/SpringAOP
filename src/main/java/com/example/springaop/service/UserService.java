package com.example.springaop.service;

import com.example.springaop.dto.LoginReqDto;
import com.example.springaop.dto.SignupRequestDto;
import com.example.springaop.entity.User;
import com.example.springaop.entity.UserRoleEnum;
import com.example.springaop.jwt.JwtUtil;
import com.example.springaop.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // ADMIN_TOKEN
    private final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    public void signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = passwordEncoder.encode(requestDto.getPassword());

        // 회원 중복 확인
        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        // email 중복확인
        String email = requestDto.getEmail();
        Optional<User> checkEmail = userRepository.findByEmail(email);
        if (checkEmail.isPresent()) {
            throw new IllegalArgumentException("중복된 Email 입니다.");
        }

        // 사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if (requestDto.isAdmin()) {
            if (!ADMIN_TOKEN.equals(requestDto.getAdminToken())) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        // 사용자 등록
        User user = new User(username, password, email, role, requestDto.getNickname());
        userRepository.save(user);
    }

//    public void login(LoginReqDto reqDto, HttpServletResponse res) {
//        String username = reqDto.getUsername();
//        String password = reqDto.getPassword();
//
//        User user = userRepository.findByUsername(username).orElseThrow(
//                () -> new IllegalArgumentException("해당하는 유저가 없습니다.")
//        );
//
//        if (!passwordEncoder.matches(password, user.getPassword())) {
//            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
//        }
//        String token = jwtUtil.createToken(user.getUsername(), user.getRole());
//        jwtUtil.addJwtToCookie(token, res);
//    }
}