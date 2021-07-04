package com.yong2ss.toberich.domain.lotto;

import com.yong2ss.toberich.domain.user.User;
import com.yong2ss.toberich.dto.draw.CustomDrawDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LottoRepository extends JpaRepository<Lotto, Long> {
    Optional<Lotto> findByRound(int round);   //회차 검색

    @Query(value = "SELECT M.draw1 AS lottoNum, COUNT(M.draw1) AS cnt FROM lotto AS M GROUP BY M.draw1", nativeQuery = true)
    List<Object[]> selectAllLotto1();

    @Query(value = "SELECT M.draw2 AS lottoNum, COUNT(M.draw2) AS cnt FROM lotto AS M GROUP BY M.draw2", nativeQuery = true)
    List<Object[]> selectAllLotto2();

    @Query(value = "SELECT M.draw3 AS lottoNum, COUNT(M.draw3) AS cnt FROM lotto AS M GROUP BY M.draw3", nativeQuery = true)
    List<Object[]> selectAllLotto3();

    @Query(value = "SELECT M.draw4 AS lottoNum, COUNT(M.draw4) AS cnt FROM lotto AS M GROUP BY M.draw4", nativeQuery = true)
    List<Object[]> selectAllLotto4();

    @Query(value = "SELECT M.draw5 AS lottoNum, COUNT(M.draw5) AS cnt FROM lotto AS M GROUP BY M.draw5", nativeQuery = true)
    List<Object[]> selectAllLotto5();

    @Query(value = "SELECT M.draw6 AS lottoNum, COUNT(M.draw6) AS cnt FROM lotto AS M GROUP BY M.draw6", nativeQuery = true)
    List<Object[]> selectAllLotto6();
}
