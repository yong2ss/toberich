package com.yong2ss.toberich.object;

import java.time.LocalDate;

public class CmFuntion {
    public static String getToday8() {
        LocalDate localDate = LocalDate.now();
        return localDate.toString().replace("-", "");
    }
}
