package Ficha1;

import java.lang.Math;
import java.sql.Date;
import java.time.LocalDate;

public class diaSemana {
    private static String Semana (int dia){
        switch(dia){
            case 0: return "Domingo";
            case 1: return "Segunda";
            case 2: return "Terça";
            case 3: return "Quarta";
            case 4: return "Quinta";
            case 5: return "Sexta";
            case 6: return "Sabado";
        }
        return "None";
    }

    public static String ex1 (int dia, int mes, int ano){
        int diaSemana = ((ano - 1900) * 365) + ((ano - 1900)/4);

        if(ano % 4 == 0 && mes < 3){
            diaSemana--;
        }

        for(int i = 1; i < mes; i++){
            diaSemana += 30;
            if (i==1 || i==3 || i==5 || i == 7 || i == 8 || i == 10 || i == 12){
                diaSemana ++;
            }
            if (i==2) diaSemana -= 2;
        }
        diaSemana += dia;
        return Semana(diaSemana % 7);
    }


    public static void main(String args[]){
        System.out.println(ex1(30,3,2019));
    }
}
