/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BukuDao;
import dao.BukuDaoImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Buku;
import view.FormBuku;

/**
 *
 * @author Risyad
 */
public class BukuController {
    private FormBuku form;
    private BukuDao dao;
    private Buku buku;

    public BukuController(FormBuku form) {
        this.form = form;
        dao = new BukuDaoImpl();
    }
    
    public void clear() {
        form.getTxtJudulBuku().setText("");
        form.getTxtKodeBuku().setText("");
        form.getTxtPenerbit().setText("");
        form.getTxtPengarang().setText("");
        form.getTxtTahunTerbit().setText("");
    }
    
    public void tampil() {
        DefaultTableModel tableModel = (DefaultTableModel)
                form.getTableBuku().getModel();
        tableModel.setRowCount(0);
        List<Buku>ListBuku = dao.getAllBuku();
        for(Buku buku : ListBuku) {
            Object[]data = {buku.getKodeBuku(),
                            buku.getJudulBuku(),
                            buku.getPengarang(),
                            buku.getPenerbit(),
                            buku.getTahunTerbit()
                            };
            tableModel.addRow(data);
        }
    }
    
    public void getBuku() {
        int index = form.getTableBuku().getSelectedRow();
        buku = dao.getBuku(index);
        if(buku != null) {
            form.getTxtJudulBuku().setText(buku.getJudulBuku());
            form.getTxtKodeBuku().setText(buku.getKodeBuku());
            form.getTxtPenerbit().setText(buku.getPenerbit());
            form.getTxtPengarang().setText(buku.getPengarang());
            form.getTxtTahunTerbit().setText(buku.getTahunTerbit());
        }
    }
    
    public void insert() {
        buku.setJudulBuku(form.getTxtJudulBuku().getText());
        buku.setKodeBuku(form.getTxtKodeBuku().getText());
        buku.setPenerbit(form.getTxtPenerbit().getText());
        buku.setPengarang(form.getTxtPengarang().getText());
        buku.setTahunTerbit(form.getTxtTahunTerbit().getText());
        dao.insert(buku);
        JOptionPane.showMessageDialog(form, "Entry Data OK!");
    }
    
    public void update() {
        int index = form.getTableBuku().getSelectedRow();
        buku.setJudulBuku(form.getTxtJudulBuku().getText());
        buku.setKodeBuku(form.getTxtKodeBuku().getText());
        buku.setPenerbit(form.getTxtPenerbit().getText());
        buku.setPengarang(form.getTxtPengarang().getText());
        buku.setTahunTerbit(form.getTxtTahunTerbit().getText());
        dao.update(index, buku);
        JOptionPane.showMessageDialog(form, "Update Data OK!");
    }
    
    public void delete() {
        int index = form.getTableBuku().getSelectedRow();
        dao.delete(index);
        JOptionPane.showMessageDialog(form, "Delete Data OK!");
    }
}
