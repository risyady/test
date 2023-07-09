/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.AnggotaDao;
import dao.BukuDao;
import dao.PeminjamanDao;
import dao.PeminjamanDaoImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Anggota;
import model.Buku;
import model.Peminjaman;
import view.FormPeminjaman;


/**
 *
 * @author Risyad
 */
public class PeminjamanController {
    private FormPeminjaman form;
    private PeminjamanDao dao;
    private Peminjaman pinjam;
    private Buku buku;
    private Anggota anggota;
    private BukuDao bukuDao;
    private AnggotaDao anggotaDao;

    public PeminjamanController(FormPeminjaman form) {
        this.form = form;
        dao = new PeminjamanDaoImpl();
    }
    
    public void isianKodeBuku() {
        form.getCboKodeBuku().removeAllItems();
        List<Buku> list = bukuDao.getAllBuku();
        for(Buku buku : list) {
            form.getCboKodeBuku().addItem(buku.getKodeBuku());
        }
    }
    
    public void isianNoBP() {
        form.getCboNoBP().removeAllItems();
        List<Anggota> list = anggotaDao.getAllAnggota();
        for(Anggota anggota : list) {
            form.getCboNoBP().addItem(anggota.getNobp());
        }
    }
    
    public void clear() {
        form.getTxtKodePinjam().setText("");
        form.getTxtTanggalKembali().setText("");
        form.getTxtTanggalPinjam().setText("");
    }
    
    public void display() {
        DefaultTableModel tableModel = (DefaultTableModel)
                form.getTabelPinjam().getModel();
        tableModel.setRowCount(0);
        List<Peminjaman>ListPinjam = dao.getAllPeminjaman();
        for (Peminjaman pinjam : ListPinjam) {
            Object[]data = {
                pinjam.getKodePinjam(),
                pinjam.getNobp(),
                pinjam.getKodeBuku(),
                pinjam.getTanggalPinjam(),
                pinjam.getTanggalKembali()
            };
            tableModel.addRow(data);
        }
    }
    
    public void insert() {
        pinjam.setKodePinjam(form.getTxtKodePinjam().getText());
        pinjam.setTanggalKembali(form.getTxtTanggalKembali().getText());
        pinjam.setTanggalPinjam(form.getTxtTanggalPinjam().getText());
        pinjam.setKodeBuku(form.getCboKodeBuku().getSelectedItem().toString());
        pinjam.setNobp(form.getCboNoBP().getSelectedItem().toString());
        dao.save(pinjam);
        JOptionPane.showMessageDialog(form, "Entry Data OK!");
    }
    
    public void update() {
        int index = form.getTabelPinjam().getSelectedRow();
        pinjam.setKodePinjam(form.getTxtKodePinjam().getText());
        pinjam.setTanggalKembali(form.getTxtTanggalKembali().getText());
        pinjam.setTanggalPinjam(form.getTxtTanggalPinjam().getText());
        pinjam.setKodeBuku(form.getCboKodeBuku().getSelectedItem().toString());
        pinjam.setNobp(form.getCboNoBP().getSelectedItem().toString());
        dao.update(index, pinjam);
        JOptionPane.showMessageDialog(form,"Update Data OK!");
    }
    
    public void delete() {
        int index = form.getTabelPinjam().getSelectedRow();
        dao.delete(index);
        JOptionPane.showMessageDialog(form, "Delete Data OK!");
    }
    
    public void getPinjam() {
        int index = form.getTabelPinjam().getSelectedRow();
        pinjam = dao.getPinjam(index);
        if(pinjam != null) {
            form.getTxtKodePinjam().setText(pinjam.getKodePinjam());
            form.getTxtTanggalKembali().setText(pinjam.getTanggalKembali());
            form.getTxtTanggalPinjam().setText(pinjam.getTanggalPinjam());
            form.getCboKodeBuku().setSelectedItem(pinjam.getKodeBuku());
            form.getCboNoBP().setSelectedItem(pinjam.getNobp());
        }
    }
}
