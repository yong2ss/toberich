package com.yong2ss.toberich.web;

import com.yong2ss.toberich.config.auth.dto.SessionUser;
import com.yong2ss.toberich.domain.posts.PostsRepository;
import com.yong2ss.toberich.domain.user.User;
import com.yong2ss.toberich.dto.post.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class WebController {

    private final HttpSession httpSession;

    @GetMapping("/main")
    public String main(HttpSession session, Model model) {
       // session.setAttribute("userId", "yong2ss");
       // model.addAttribute("user", "yong2ss");

        return "main";
    }

    // 메인 페이지
    @GetMapping("/")
    public String index(Model model) {
        //model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
           model.addAttribute("userName", user.getName());
        }

        return "index";
    }
}
