/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SIG.MODEL;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Osama
 */
public class InvoiceLineTableModel extends AbstractTableModel {

    private ArrayList<InvoiceLine> data;
    private String[] columns = {"Item Name", "Unit Price", "Count"};

    public InvoiceLineTableModel(ArrayList<InvoiceLine> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        InvoiceLine line = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return line.getName();
            case 1:
                return line.getPrice();
            case 2:
                return line.getCount();

        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

}
