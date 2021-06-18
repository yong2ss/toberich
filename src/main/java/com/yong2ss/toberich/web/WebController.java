package com.yong2ss.toberich.web;

import com.yong2ss.toberich.config.auth.LoginUser;
import com.yong2ss.toberich.config.auth.dto.SessionUser;
import com.yong2ss.toberich.domain.posts.PostsRepository;
import com.yong2ss.toberich.domain.user.User;
import com.yong2ss.toberich.dto.post.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

//  로그인 세션 저장소 3가지 방법
//1. 톰캣 세션을 사용 -> 세션이 내장 톰캣의 메모리에 저장되므로(WAS의 메모리), 애플리케이션 재실행시 초기화되고 2대 이상의 WAS 세션 공유 추가 설정 필요
//2. 데이터베이스를 세션 저장소로 사용 -> 로그인 요청마다 DB IO가 발생하여 이슈
//3. Redis같은 메모리 DB를 세션 저장소로 사용 -> 실제 서비스에선 외부 메모리 서버가 필요

//보통 1번으로 여러 WAS의 세션 공유 추가 설정을 하거나, 2번을 사용
//서비스가 굉장히 커진다면 3번 같은 AWS 레디스나 엘리스틱 캐시에 등에 금액을 지불하고 사용

@RequiredArgsConstructor
@Controller
public class WebController {

    private final HttpSession httpSession;

    @GetMapping("/main")
    public String main(HttpSession session, Model model, @LoginUser SessionUser user) {
       // session.setAttribute("userId", "yong2ss");
       // model.addAttribute("user", "yong2ss");
        model.addAttribute("userName", user.getName());

        return "main";
    }

    //메인 페이지(로그인) TO-BE
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        if(user != null) {
            model.addAttribute("userName", user.getName());
            return "redirect:/main";
        }

        return "index";
    }

    /*
    //==* 메인 페이지(로그인) AS-IS (@LoginUser 사용 전에는, 직접 세션에서 user정보 받아온다.)
    @GetMapping("/")
    public String index(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
           model.addAttribute("userName", user.getName());
        }

        return "index";
    }
    */
}
