/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MemberDao;
import dao.MemberDaoImpl;
import java.util.List;
import javax.swing.JOptionPane;
import model.MemberModel;
import model.MemberTable;
import view.FormMember;

/**
 *
 * @author Risyad
 */
public class MemberController {
    private FormMember form;
    private MemberDao dao;
    List<MemberModel> ListMember;

    public MemberController(FormMember form) {
        this.form = form;
        dao = new MemberDaoImpl();
        ListMember = dao.getAll();
    }
    
    public void clear() {
        form.getTxtIdMember().setText("");
        form.getTxtNamaPelanggan().setText("");
        form.getTxtNoTelp().setText("");
        form.getTxtAlamat().setText("");
        form.getCboPaket().setSelectedItem("---Pilih Paket---");
        form.getTxtSearch().setText("");
    }
    
    public void displayTable() {
        ListMember = dao.getAll();
        MemberTable tableModel = new MemberTable(ListMember);
        form.getTableMember().setModel(tableModel);
    }
    
    public void displayField(int row) {
        form.getTxtIdMember().setText(Integer.toString(ListMember.get(row).getId()));
        form.getTxtNamaPelanggan().setText(ListMember.get(row).getNama());
        form.getTxtNoTelp().setText(ListMember.get(row).getNoTelp());
        form.getTxtAlamat().setText(ListMember.get(row).getAlamat());
        form.getCboPaket().setSelectedItem(ListMember.get(row).getPaket());
    }
    
    public void insert() {
        if(!form.getTxtNamaPelanggan().getText().trim().
                isEmpty() & !form.getTxtAlamat().getText().
                        trim().isEmpty()) {
            MemberModel b = new MemberModel();
            b.setNama(form.getTxtNamaPelanggan().getText());
            b.setNoTelp(form.getTxtNoTelp().getText());
            b.setAlamat(form.getTxtAlamat().getText());
            b.setPaket(form.getCboPaket().getSelectedItem().toString());
            b.setId(Integer.parseInt(form.getTxtIdMember().getText()));
            
            dao.update(b);
            JOptionPane.showMessageDialog(form, "Data Berhasil Disimpan!");
        }
        else {
            JOptionPane.showMessageDialog(form, "Data Tidak Boleh Kosong!");
        }
    }
    
    public void update() {
        if(!form.getTxtIdMember().getText().trim().isEmpty()) {
            MemberModel b = new MemberModel();
            b.setNama(form.getTxtNamaPelanggan().getText());
            b.setNoTelp(form.getTxtNoTelp().getText());
            b.setAlamat(form.getTxtAlamat().getText());
            b.setPaket(form.getCboPaket().getSelectedItem().toString());
            b.setId(Integer.parseInt(form.getTxtIdMember().getText()));
            
            dao.update(b);
            JOptionPane.showMessageDialog(form, "Data Berhasil Diupdate!");
        }
        else {
            JOptionPane.showMessageDialog(form, "Silahkan pilih data yang ingin di update");
        }
    }
    
    public void delete() {
        if(!form.getTxtIdMember().getText().trim().isEmpty()) {
            int id = Integer.parseInt(form.getTxtIdMember().getText());
            dao.delete(id);
        }
    }
    
    public void displayTableSearch() {
        ListMember = dao.getCariNama(form.getTxtSearch().getText());
        MemberTable tmb = new MemberTable(ListMember);
        form.getTableMember().setModel(tmb);
    }
    
    public void SearchName() {
        if(!form.getTxtSearch().getText().trim().isEmpty()) {
            dao.getCariNama(form.getTxtSearch().getText());
            displayTableSearch();
        }
        else {
            JOptionPane.showMessageDialog(form, "Silahkan pilih data...");
        }
    }
}
