package com.ebanco.data;

import java.util.Date;

public class Log {

    private Date data;
    private int contador;

    public Log(Date data){
        this.data = data;
        contador = 0;
    }

    public Date getData(){
        return data;
    }

    public int getContador(){
        return contador;
    }

    public void incrementaContador(){
        contador++;
    }
}
