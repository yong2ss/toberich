package com.yong2ss.toberich.web.Lotto;

import com.yong2ss.toberich.domain.lotto.Lotto;
import com.yong2ss.toberich.object.SpreadSheetApi;
import com.yong2ss.toberich.service.Lotto.LottoService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
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

    @GetMapping("/lottos/{round}")
    public Lotto lotto(@PathVariable int round) {
        return lottoService.findOne(round);
    }

    @PostMapping("/lottos")
    public ResponseEntity<Lotto> createLotto(@RequestBody Lotto lotto) {

        Lotto savedLotto = lottoService.save(lotto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")   //현재 생성되어 있는 ID값을 헤더로 저장해서 보냄
                                    .buildAndExpand(savedLotto.getId())    //id매핑
                                    .toUri();

        return ResponseEntity.created(location).build();
    }

}
