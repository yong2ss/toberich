package com.yong2ss.toberich.domain.draw;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrawStatisRepository extends JpaRepository<DrawStatis, Long> {
 /*   @Query("SELECT M.lotto_num, SUM(M.CNT) AS cnt" +
            "   FROM ( SELECT draw1 lotto_num, COUNT(*) CNT" +
            "            FROM lotto" +
            "           GROUP BY draw1" +
            "           UNION ALL" +
            "          SELECT draw2 lotto_num, COUNT(*) CNT" +
            "            FROM lotto" +
            "           GROUP BY draw2" +
            "           UNION ALL" +
            "           SELECT draw3 lotto_num, COUNT(*) CNT" +
            "            FROM lotto" +
            "           GROUP BY draw3" +
            "           UNION ALL" +
            "           SELECT draw4 lotto_num, COUNT(*) CNT" +
            "            FROM lotto" +
            "           GROUP BY draw4" +
            "           UNION ALL" +
            "           SELECT draw5 lotto_num, COUNT(*) CNT" +
            "            FROM lotto" +
            "           GROUP BY draw5" +
            "           UNION ALL" +
            "           SELECT draw6 lotto_num, COUNT(*) CNT" +
            "            FROM lotto" +
            "           GROUP BY draw6 ) AS M" +
            "  GROUP BY M.lotto_num")
    List<DrawStatis> findStatisByNum();*/

    @Query("SELECT draw1 lotto_num, COUNT(*) CNT FROM lotto GROUP BY draw1")
    List<DrawStatis> findStatisByNum1();

    @Query("SELECT draw2 lotto_num, COUNT(*) CNT FROM lotto GROUP BY draw2")
    List<DrawStatis> findStatisByNum2();

    @Query("SELECT draw3 lotto_num, COUNT(*) CNT FROM lotto GROUP BY draw3")
    List<DrawStatis> findStatisByNum3();

    @Query("SELECT draw4 lotto_num, COUNT(*) CNT FROM lotto GROUP BY draw4")
    List<DrawStatis> findStatisByNum4();

    @Query("SELECT draw5 lotto_num, COUNT(*) CNT FROM lotto GROUP BY draw5")
    List<DrawStatis> findStatisByNum5();

    @Query("SELECT draw6 lotto_num, COUNT(*) CNT FROM lotto GROUP BY draw6")
    List<DrawStatis> findStatisByNum6();

}
