/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.FormAnggota;
import dao.AnggotaDao;
import model.Anggota;
import dao.AnggotaDaoImpl;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class AnggotaController {
    private FormAnggota form;
    private AnggotaDao dao;
    private Anggota anggota;
    
    public AnggotaController(FormAnggota form){
        this.form=form;
        dao = new AnggotaDaoImpl();
    }
    
    public void isianKelamin() {
        form.getCboKelamin().removeAllItems();
        form.getCboKelamin().addItem("L");
        form.getCboKelamin().addItem("P");
    }
    
    public void clear(){
        form.getTxtnobp().setText("");
        form.getTxtnama().setText("");
        form.getTxtalamat().setText("");
    }
    public void tampil(){
        DefaultTableModel tableModel =(DefaultTableModel)
                form.getjTable1().getModel();
        tableModel.setRowCount(0);
        List<Anggota>ListAnggota = dao.getAllAnggota();
        for(Anggota anggota : ListAnggota){
            Object[]data = {anggota.getNobp(),
                            anggota.getNama(),
                            anggota.getKelamin(),
                            anggota.getAlamat()
            };
            tableModel.addRow(data);
        }
    }
    
    public void getAnggota(){
            int index = form.getjTable1().getSelectedRow();
            anggota = dao.getAnggota(index);
            if (anggota !=null){
                form.getTxtnobp().setText(anggota.getNobp());
                form.getTxtnama().setText(anggota.getNama());
                form.getCboKelamin().setSelectedItem(anggota.getKelamin());
                form.getTxtalamat().setText(anggota.getAlamat());
            }
    }
    public void simpan(){
        anggota.setNobp(form.getTxtnobp().getText());
        anggota.setNama(form.getTxtnama().getText());
        anggota.setAlamat(form.getTxtalamat().getText());
        anggota.setKelamin(form.getCboKelamin().getSelectedItem().toString());
        dao.save(anggota);
        JOptionPane.showMessageDialog(form,"Entri Data OK!");
    }
    
    public void hapus(){
        int index = form.getjTable1().getSelectedRow();
        dao.delete(index);
        JOptionPane.showMessageDialog(form,"Delete Data OK!");
    }
    
    public void update(){
        int index = form.getjTable1().getSelectedRow();
        anggota.setNobp(form.getTxtnobp().getText());
        anggota.setNama(form.getTxtnama().getText());
        anggota.setAlamat(form.getTxtalamat().getText());
        anggota.setKelamin(form.getCboKelamin().getSelectedItem().toString());
        dao.update(index,anggota);
        JOptionPane.showMessageDialog(form,"Update Data OK!");
    }
}

