package com.yong2ss.toberich.web;

import com.yong2ss.toberich.domain.posts.PostsRepository;
import com.yong2ss.toberich.dto.post.PostsSaveRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class WebController {

    private PostsRepository postsRepository;

    @GetMapping("/main")
    public String main(HttpSession session, Model model) {
       // session.setAttribute("userId", "yong2ss");
       // model.addAttribute("user", "yong2ss");

        return "main";
    }
}
