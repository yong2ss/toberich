package com.yong2ss.toberich.web;

import com.yong2ss.toberich.domain.posts.PostsRepository;
import com.yong2ss.toberich.dto.post.PostsSaveRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }

    @GetMapping("/")
    public String main(HttpSession session, Model model) {
        session.setAttribute("userId", "yong2ss");
        model.addAttribute("user", "yong2ss");

        return "main";
    }

    @GetMapping("/users/{userId}")
    public String getUserList(@PathVariable String userId, HttpSession session, Model model) {
        session.setAttribute("userId", "yong2ss");
        model.addAttribute("user", "yong2ss");
        return "user";
    }
}
