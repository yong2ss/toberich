package com.yong2ss.toberich.object;

import com.yong2ss.toberich.domain.draw.DrawStatis;

import java.time.LocalDate;

public class CmFuntion {
    public static String getToday8() {
        LocalDate localDate = LocalDate.now();
        return localDate.toString().replace("-", "");
    }

    public static int drawStatisNVL(DrawStatis vo) {
        try {
            if(vo == null) {
                return 0;
            }
            return vo.getCnt();
        } catch (Exception e) {
            return 0;
        }
    }
}
