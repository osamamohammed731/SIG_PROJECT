package SIG.MODEL;

import java.util.ArrayList;


public class InvoiceHeader {

    private int num;
    private String customer;
    private String date;
    private ArrayList<InvoiceLine> lines;

    public InvoiceHeader(int num, String customer, String date) {
        this.num = num;
        this.customer = customer;
        this.date = date;
    }

 
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }
    

    public double getInvoiceTotal() {
        double total = 0;
        for (InvoiceLine line : getLines()) {
            total += line.getLineTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" + "num=" + num + ", customer=" + customer + ", date=" + date + '}';
    }

}
