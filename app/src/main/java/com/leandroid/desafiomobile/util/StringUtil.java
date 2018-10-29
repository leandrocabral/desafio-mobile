package com.leandroid.desafiomobile.util;

public class StringUtil {

    public static String getTituloReduzido(String title){
        String resultadoString  = title;
        if(title!=null && title.length()>=30){
            resultadoString = title.substring(0,15)+"\n"+ title.substring(15,29)+"...";
        }
        return resultadoString;
    }
}
