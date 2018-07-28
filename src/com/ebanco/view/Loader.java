package com.ebanco.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loader {

    private JFrame frameInicial;
    private JPanel painelInicial;

    public Loader(){
        inicializaFrame();
        carregaFrame();
        mostraFrame();
    }

    public void inicializaFrame(){
        frameInicial = new JFrame();
        frameInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void carregaFrame(){
        painelInicial = new JPanel();
        botaoLog();
        botaoAjuda();
        frameInicial.add(painelInicial);
    }

    public void mostraFrame(){
        frameInicial.pack();
        frameInicial.setSize(600,200);
        frameInicial.setVisible(true);
    }

    public void botaoLog(){
        JButton botaoLog = new JButton("Carregar Log");
        botaoLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ToDo carregar log
            }
        });
        painelInicial.add(botaoLog);
    }

    public void botaoAjuda(){
        JButton botaoAjuda = new JButton("Ajuda");
        botaoAjuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ajuda();
            }
        });
        painelInicial.add(botaoAjuda);
    }

}
