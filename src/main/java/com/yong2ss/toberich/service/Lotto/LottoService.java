package com.yong2ss.toberich.service.Lotto;

import com.yong2ss.toberich.domain.lotto.Lotto;
import com.yong2ss.toberich.domain.lotto.LottoRepository;
import com.yong2ss.toberich.domain.user.UserRepository;
import com.yong2ss.toberich.object.ApiConnect;
import com.yong2ss.toberich.object.ExcelFunction;
import com.yong2ss.toberich.object.LottoFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LottoService {

    @Autowired
    private LottoRepository lottoRepository;

    public List<Lotto> findAll() {
        return null;
    }

    public Lotto findOne(int round) {
        return lottoRepository.findByRound(round).orElseThrow();
    }

    public Lotto save(Lotto lotto) {
        return lottoRepository.save(lotto);
    }
}
