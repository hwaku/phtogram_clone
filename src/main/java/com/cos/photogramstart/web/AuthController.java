package com.cos.photogramstart.web;

import com.cos.photogramstart.web.DTO.auth.SignupDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    // 로그인 view
    @GetMapping("/auth/signin")
    public String signinForm(){
        return "auth/signin";
    }

    // 회원가입 view
    @GetMapping("/auth/signup")
    public String signupForm(){
        return "auth/signup";
    }

    // 회원가입 버튼 클릭 -> /auth/signup -> /auth/sigin
    @PostMapping("/auth/signup")
    public String signup(SignupDto signupDto){
        log.info(signupDto.toString());
        return "auth/signin";
    }
}
