package com.universidad.utils;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Formato {
    private Formato(){
        
    }

    public static String formatoFecha(LocalDate localDate){
        DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(formato);
    }


    public static String formatoMonedaPesos(double monto){
        Locale colombiaLocal= new Locale("es", "CO");
        NumberFormat formatoMoneda= NumberFormat.getCurrencyInstance(colombiaLocal);
        return formatoMoneda.format(monto);
    }
}
