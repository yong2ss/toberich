package com.yong2ss.toberich.web;

import com.yong2ss.toberich.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    // 로그인 페이지
    @GetMapping("/login")
    public String dispLogin(HttpServletRequest request, HttpServletResponse response) {
        return "main";
    }

    // 로그인 결과 페이지
    @GetMapping("/login/result")
    public String dispLoginResult(HttpServletRequest request, HttpServletResponse response) {
        return "main";
    }

    // 로그아웃 - spring security가 기본으로 제공
    /*@GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }*/

    // 로그아웃 결과 페이지
    @GetMapping("/logout/result")
    public String dispLogout(HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }

    // 접근 거부 페이지
    @GetMapping("/denied")
    public String dispDenied(HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }
}