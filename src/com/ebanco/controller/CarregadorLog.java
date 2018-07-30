package com.ebanco.controller;

import com.ebanco.data.Log;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CarregadorLog {

    //  Formato válido [YYYY-mm-dd H:i:s] - Abertura da Porta OK
    public static final String FORMATO = "\\[\\d{4}[-]+\\d{2}[-]\\d{2} \\d{2}\\:\\d{2}\\:\\d{2}\\] - Abertura da Porta OK";
    private int contador = 0;
    private String fileName = "";
    private List<Log> log = new ArrayList<Log>();

    public void carregaLog(FileReader reader){

        try {
            BufferedReader buffReader = new BufferedReader(reader);

            String linha = buffReader.readLine();

            while (null != linha) {
                if (validarFormato(linha)) {
                    conta(linha);
                }

                linha = buffReader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e) {
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

    public List<Log> abrirArquivo(){
        try{
            JFileChooser chooser = new JFileChooser();
            int retorno = chooser.showOpenDialog(null);

            if (JFileChooser.APPROVE_OPTION == retorno){
                zerarContador();
                FileReader reader = new FileReader(chooser.getSelectedFile());
                fileName = chooser.getSelectedFile().getName();
                carregaLog(reader);
            }
            return log;
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void conta(String linha) throws ParseException {
        /*
            Cada item da lista log representa um dia registrado no arquivo de entrada.
            O contador só é incrementado caso o registro tenha sido feito dentro do
            horário de funcionamento do banco.
         */
        String dataLog = linha.substring(1,11);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = formato.parse(dataLog);

        if (0 == log.size()){
            Log temp = new Log(data);
            if (verificaExpediente(linha)) {
                temp.incrementaContador();
            }
            log.add(temp);
        } else if (data.equals(log.get(log.size()-1).getData())){
            if(verificaExpediente(linha)){
                log.get(log.size()-1).incrementaContador();
            }
        } else {
            Log temp = new Log(data);
            if (verificaExpediente(linha)) {
                temp.incrementaContador();
            }
            log.add(temp);
        }
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
