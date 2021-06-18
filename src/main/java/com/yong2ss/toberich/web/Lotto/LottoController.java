package com.yong2ss.toberich.web.Lotto;

import com.yong2ss.toberich.domain.lotto.Lotto;
import com.yong2ss.toberich.object.SpreadSheetApi;
import com.yong2ss.toberich.service.Lotto.LottoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
public class LottoController {

    private LottoService lottoService;

    //==* 생성자를 통해 의존성 주입하는 방법
    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @GetMapping("/lottos")
    public List<Lotto> lottos() {
        return lottoService.findAll();
    }

    @GetMapping("/lottos/${id}")
    public Lotto lotto(@PathVariable int id) {
        return lottoService.findOne(id);
    }

    @PostMapping("/lottos")
    public void createLotto(@RequestBody Lotto lotto) {
        Lotto savedLotto = lottoService.save(lotto);
    }

}
