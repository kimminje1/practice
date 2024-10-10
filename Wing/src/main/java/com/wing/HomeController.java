package com.wing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // 루트 URL 요청 처리 시작시 바로 로그인으로 가게하는 역할
    public String login() {
        return "jsp/auth/index"; // login.jsp로 이동
    }
}