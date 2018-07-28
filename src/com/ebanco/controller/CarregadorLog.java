package com.ebanco.controller;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CarregadorLog {

    //  Formato válido [YYYY-mm-dd H:i:s] - Abertura da Porta OK
    public static final String FORMATO = "\\[\\d{4}[-]+\\d{2}[-]\\d{2} \\d{2}\\:\\d{2}\\:\\d{2}\\] - Abertura da Porta OK";
    private int contador = 0;
    private String fileName = "";

    public void carregaLog(FileReader reader){

        try {
            BufferedReader buffReader = new BufferedReader(reader);

            String linha = buffReader.readLine();

            while (null != linha) {
                if (validarFormato(linha)) {
                    if (verificaExpediente(linha)){
                        incrementaContador();
                    }
                }

                linha = buffReader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean validarFormato(String s){
        if (s.matches(FORMATO)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificaExpediente(String s){
        String horario = s.split("[-]\\d{2} ")[1];
        horario = horario.split("\\] ")[0];
        String[] horaSeparada = horario.split("\\:");
        if (10 <= Integer.parseInt(horaSeparada[0])) {
            if (16 > Integer.parseInt(horaSeparada[0])) {
                return true;
            } else if (16 == Integer.parseInt(horaSeparada[0]) &&
                        0 == Integer.parseInt(horaSeparada[1]) &&
                        0 == Integer.parseInt(horaSeparada[2])){
                //     16:00:00 é um horário válido!
                return true;
            }
        }
        return false;
    }

    public void abrirArquivo(){
        try{
            JFileChooser chooser = new JFileChooser();
            int retorno = chooser.showOpenDialog(null);

            if (JFileChooser.APPROVE_OPTION == retorno){
                zerarContador();
                FileReader reader = new FileReader(chooser.getSelectedFile());
                fileName = chooser.getSelectedFile().getName();
                System.out.println(fileName);
                carregaLog(reader);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void incrementaContador(){
        contador++;
    }

    public void zerarContador(){
        contador = 0;
    }

    public int getContador(){
        return contador;
    }

    public String getFileName(){
        return fileName;
    }
}
