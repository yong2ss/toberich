package com.yong2ss.toberich.web.Draw;

import com.yong2ss.toberich.domain.draw.Draw;
import com.yong2ss.toberich.domain.lotto.Lotto;
import com.yong2ss.toberich.object.SpreadSheetApi;
import com.yong2ss.toberich.service.Draw.DrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class DrawController {
    
    //Autowired를 이용한 의존성 주입
    @Autowired
    private DrawService drawService;

    @PostMapping("/draws")
    public Draw createDraw() {
        return drawService.save();
    }

    @GetMapping("/draw_ajax")
    public String hello(Model model) throws GeneralSecurityException, IOException {

        new SpreadSheetApi().lotto_google_data();
        return "HelloWorld";
    }

}
