package com.ebanco.view;

import com.ebanco.data.Log;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class LogTableModel extends AbstractTableModel {

    private List<Log> lista;

    public LogTableModel(List lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Log linha = lista.get(rowIndex);

        switch(columnIndex){
            case 0:
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                return formato.format(linha.getData());
            case 1:
                return linha.getContador();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "Data";
            case 1:
                return "Número de clientes no dia";
        }
        return "";
    }
}
