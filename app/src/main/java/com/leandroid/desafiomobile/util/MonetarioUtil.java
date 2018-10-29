package com.leandroid.desafiomobile.util;

import java.text.NumberFormat;
import java.util.Locale;

public class MonetarioUtil {

    public static String getValorMonetario(Double valor){
        Locale ptBr = new Locale("pt", "BR");
        String valorString = NumberFormat.getCurrencyInstance(ptBr).format(valor);
        return valorString;
    }
}
