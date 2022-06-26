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
public class InvoiceHeaderTableModel extends AbstractTableModel {

    private ArrayList<InvoiceHeader> data;
    private String[] columns = {"Id", "Customer Name", "Invoice Date"};

    public InvoiceHeaderTableModel(ArrayList<InvoiceHeader> data) {
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
        InvoiceHeader header = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return header.getNum();
            case 1:
                return header.getCustomer();
            case 2:
                return header.getDate();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];

    }

}
