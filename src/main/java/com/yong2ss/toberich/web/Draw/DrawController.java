package com.yong2ss.toberich.web.Draw;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrawController {

    @GetMapping("/draw_ajax")
    public String hello(Model model) {
        return "HelloWorld";
    }

}
