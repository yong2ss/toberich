package com.yong2ss.toberich.web.Draw;

import com.yong2ss.toberich.object.SpreadSheetApi;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class DrawController {

    @GetMapping("/draw_ajax")
    public String hello(Model model) throws GeneralSecurityException, IOException {

        new SpreadSheetApi().lotto_google_data();
        return "HelloWorld";
    }

}
