/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Risyad
 */
public class MemberTable extends AbstractTableModel{
    List<MemberModel> ListMember;

    public MemberTable(List<MemberModel> ListMember) {
        this.ListMember = ListMember;
    }

    @Override
    public int getRowCount() {
        return ListMember.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return ListMember.get(rowIndex).getId();
            case 1 : return ListMember.get(rowIndex).getNama();
            case 2 : return ListMember.get(rowIndex).getNoTelp();
            case 3 : return ListMember.get(rowIndex).getAlamat();
            case 4 : return ListMember.get(rowIndex).getPaket();
            default : return null;
        } 
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex) {
            case 0 : return "ID";
            case 1 : return "NAMA";
            case 2 : return "NOMOR TELEPON";
            case 3 : return "ALAMAT";
            case 4 : return "PAKET MEMBER";
            default : return null;
        }
    }
}
