package com.yong2ss.toberich.domain.draw;

import com.yong2ss.toberich.dto.draw.CustomDrawDto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrawStatisRepository extends JpaRepository<Draw, Long> {
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


    //JPQL 사용
  //  @Query("SELECT M.DRAW1 lotto_num, COUNT(*) CNT FROM lotto as M GROUP BY M.DRAW1")
  //  List<DrawStatis> findStatisNum1();
/*
    @Query("SELECT DRAW2 lotto_num, COUNT(*) CNT FROM lotto as M GROUP BY DRAW2")
    List<DrawStatis> findStatisByNum2();

    @Query("SELECT DRAW3 lotto_num, COUNT(*) CNT FROM lotto as M GROUP BY DRAW3")
    List<DrawStatis> findStatisByNum3();

    @Query("SELECT DRAW4 lotto_num, COUNT(*) CNT FROM lotto as M GROUP BY DRAW4")
    List<DrawStatis> findStatisByNum4();

    @Query("SELECT DRAW5 lotto_num, COUNT(*) CNT FROM lotto as M GROUP BY DRAW5")
    List<DrawStatis> findStatisByNum5();

    @Query("SELECT DRAW6 lotto_num, COUNT(*) CNT FROM lotto as M GROUP BY DRAW6")
    List<DrawStatis> findStatisByNum6();
    */

}
