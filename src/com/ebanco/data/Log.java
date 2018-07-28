package com.ebanco.data;

import java.util.ArrayList;
import java.util.List;

public class Log {
    private List log = new ArrayList();

    public void insere(String s){
        if (formatoValido(s)) {
            log.add(s);
        }
    }

    public int numeroDePessoasNoBanco(){
        //ToDo: retornar numero;
        return 0;
    }

    public boolean formatoValido(String s){
        //ToDo: verificar formato
        return true;
    }

}
