package com.ebanco.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ajuda {

    public static final int LABEL_WIDTH = 300;

    private JFrame frameAjuda;
    private JPanel painelAjuda;

    public Ajuda(){
        inicializaFrame();
        carregaFrame();
        mostraFrame();
    }

    public void inicializaFrame(){
        frameAjuda = new JFrame();
        frameAjuda.setTitle("Ajuda");
        frameAjuda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void carregaFrame(){
        painelAjuda = new JPanel();
        mensagemAjuda();
        botaoSair();
        frameAjuda.add(painelAjuda);
    }

    public void mostraFrame(){
        frameAjuda.setSize(400,150);
        frameAjuda.setVisible(true);
    }

    public void botaoSair(){
        JButton botaoSair = new JButton("Sair");
        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameAjuda.setVisible(false);
            }
        });
        painelAjuda.add(botaoSair);
    }

    public void mensagemAjuda(){
        JLabel label = new JLabel();
        label.setText("<html><body width='" + LABEL_WIDTH + "'>" +
                "<p>Este programa verifica os registros do log de entrada e conta as entradas válidas" +
                " e que ocorreram no horário de funcionamento do banco.</p><br />" +
                "<p>Primeiro você deve carregar o arquivo de log desejado em [Carregar Log].</p>" +
                "</body></html>");
        painelAjuda.add(label);
    }


}
