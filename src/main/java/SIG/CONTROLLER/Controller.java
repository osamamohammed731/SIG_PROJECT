package SIG.CONTROLLER;

import SIG.MODEL.InvoiceHeader;
import SIG.MODEL.InvoiceLine;
import SIG.MODEL.InvoiceLineTableModel;
import SIG.VIEW.InvoiceFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller implements ActionListener, ListSelectionListener {

    private InvoiceFrame frame;

    public Controller(InvoiceFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action Handler Called!!");
        switch (e.getActionCommand()) {
            case "New Invoice":
                System.out.println("New Invoice");
                newInvoice();
                break;
            case "Delete Invoice":
                System.out.println("Delete Invoice");
                deleteInvoice();
                break;
            case "New Item":
                System.out.println("New Item");
                newItem();
                break;
            case "Delete Item":
                System.out.println("Delete Item");
                deleteItem();
                break;
            case "Load File":
                System.out.println("Load File");
                loadFile();
                break;
            case "Save File":
                System.out.println("Save File");
                saveFile();
                break;
        }

    }

    private void deleteInvoice() {

    }

    private void newItem() {

    }

    private void deleteItem() {

    }

    private void loadFile() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                String headerStrPath = fileChooser.getSelectedFile().getAbsolutePath();
                Path headerPath = Paths.get(headerStrPath);
                List<String> headerLines = Files.lines(headerPath).collect(Collectors.toList());
                ArrayList<InvoiceHeader> invoiceHeadersList = new ArrayList<>();
                for (String headerLine : headerLines) {
                    String[] parts = headerLine.split(",");
                    int id = Integer.parseInt(parts[0]);
                    InvoiceHeader invHeader = new InvoiceHeader(id, parts[2], parts[1]);
                    invoiceHeadersList.add(invHeader);
                }
                result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String LineStrPath = fileChooser.getSelectedFile().getAbsolutePath();
                    Path linePath = Paths.get(LineStrPath);
                    List<String> lineLines = Files.lines(linePath).collect(Collectors.toList());
                    for (String lineLine : lineLines) {
                        String[] parts = lineLine.split(",");
                        int invId = Integer.parseInt(parts[0]);
                        double price = Double.parseDouble(parts[2]);
                        int count = Integer.parseInt(parts[3]);
                        InvoiceHeader header = getInvoiceHeaderById(invoiceHeadersList, invId);
                        InvoiceLine invLine = new InvoiceLine(header, parts[1], price, count);
                        header.getLines().add(invLine);

                    }
                    frame.setInvoiceHeaderList(invoiceHeadersList);

                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private InvoiceHeader getInvoiceHeaderById(ArrayList<InvoiceHeader> invoices, int id) {
        for (InvoiceHeader invoice : invoices) {
            if (invoice.getNum() == id) {
                return invoice;
            }
        }
        return null;
    }

    private void saveFile() {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Row Selected");
        int selectedRow = frame.getHeadTable().getSelectedRow();
        System.out.println(selectedRow);
        ArrayList<InvoiceLine> lines = frame.getInvoiceHeaderList().get(selectedRow).getLines();
        frame.getInvoiceTable().setModel(new InvoiceLineTableModel(lines));

    }

    private void newInvoice() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
