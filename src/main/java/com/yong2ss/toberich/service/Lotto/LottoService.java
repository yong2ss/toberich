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
        return lottoRepository.findAll();
    }

    public Lotto findOne(int round) {
        return lottoRepository.findByRound(round).orElseThrow();
    }

    public Lotto save(Lotto lotto) {
        return lottoRepository.save(lotto);
    }

    //초기 데이터 삽입
    public Lotto migration(int i) throws Exception {

        int [] lottos = ApiConnect.lotto_json(i);

        if(lottos.length == 0) {
            throw new Exception();
        }

        Lotto lotto = Lotto.builder()
                        .round(i)
                        .draw1(lottos[0])
                        .draw2(lottos[1])
                        .draw3(lottos[2])
                        .draw4(lottos[3])
                        .draw5(lottos[4])
                        .draw6(lottos[5])
                        .bonus(lottos[6])
                        .build();

        return lotto;
    }
}
