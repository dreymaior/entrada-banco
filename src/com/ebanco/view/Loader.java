package com.ebanco.view;

import com.ebanco.controller.CarregadorLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loader {

    public static final int LABEL_WIDTH = 580;

    private JFrame frameInicial;
    private JPanel painelInicial;
    private JPanel painelSuperior;
    private JPanel painelInferior;
    private CarregadorLog carregadorLog;

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
        painelInicial = new JPanel(new BorderLayout());
        painelSuperior = new JPanel();
        painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        criarLabel();
        botaoLog();
        botaoAjuda();

        painelInicial.add(painelSuperior, BorderLayout.NORTH);
        painelInicial.add(painelInferior, BorderLayout.SOUTH);

        frameInicial.add(painelInicial);
    }

    public void mostraFrame(){
        frameInicial.pack();
        frameInicial.setSize(600,200);
        frameInicial.setLocationRelativeTo(null);
        frameInicial.setVisible(true);
    }

    public void criarLabel(){
        JLabel label = new JLabel();
        if (null != carregadorLog){
            if (!carregadorLog.getFileName().equals("")){
                label.setText("<html><body width='"+ LABEL_WIDTH + "'>" +
                        "<div style='text-align:center;'>" +
                        "<h1>Número de pessoas que entraram no banco: " + carregadorLog.getContador() + "</h1>" +
                        "</div>" +
                        "</body></html>");
            }
        } else {
            label.setText("<html><body width='"+ LABEL_WIDTH + "'>" +
                    "<div style='text-align:center;'>" +
                    "<h2>Você deve carregar o arquivo primeiro.</h2>" +
                    "</div>" +
                    "</body></html>");
        }
        painelSuperior.add(label, BorderLayout.CENTER);
    }

    public void botaoLog(){
        JButton botaoLog = new JButton("Carregar Log");
        botaoLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregadorLog = new CarregadorLog();
                carregadorLog.abrirArquivo();
                painelSuperior.removeAll();
                criarLabel();
                painelSuperior.revalidate();
                painelSuperior.repaint();
            }
        });
        painelInferior.add(botaoLog);
    }

    public void botaoAjuda(){
        JButton botaoAjuda = new JButton("Ajuda");
        botaoAjuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ajuda();
            }
        });
        painelInferior.add(botaoAjuda);
    }

}
