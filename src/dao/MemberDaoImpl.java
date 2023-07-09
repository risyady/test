/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.MemberKoneksi;
import model.MemberModel;

/**
 *
 * @author Risyad
 */
public class MemberDaoImpl implements MemberDao {
    Connection connection;
    final String insert = "INSERT INTO member (nama, no_telp, alamat, paket) VALUES (?, ?, ?, ?);";
    final String update = "UPDATE member SET nama = ?, no_telp = ?, alamat = ?, paket = ? WHERE id = ? ;";
    final String delete = "DELETE FROM member WHERE id = ? ;";
    final String select = "SELECT * FROM member;";
    final String nameSearch = "SELECT * FROM member WHERE nama like ?;";
    
    public MemberDaoImpl() {
        connection = MemberKoneksi.connection();
    }

    @Override
    public void insert(MemberModel b) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) connection.prepareStatement(insert);
            statement.setString(1, b.getNama());
            statement.setString(2, b.getNoTelp());
            statement.setString(3, b.getAlamat());
            statement.setString(4, b.getPaket());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(MemberModel b) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) connection.prepareStatement(update);
            statement.setString(1, b.getNama());
            statement.setString(2, b.getNoTelp());
            statement.setString(3, b.getAlamat());
            statement.setString(4, b.getPaket());
            statement.setInt(5, b.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<MemberModel> getAll() {
        List<MemberModel> lb = null;
        try {
            lb = new ArrayList<MemberModel>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                MemberModel b = new MemberModel();
                b.setId(rs.getInt("id"));
                b.setNama(rs.getString("nama"));
                b.setNoTelp(rs.getString("no_telp"));
                b.setAlamat(rs.getString("alamat"));
                b.setPaket(rs.getString("paket"));
                lb.add(b);
            }
        } catch (Exception e) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return lb;
    }

    @Override
    public List<MemberModel> getCariNama(String nama) {
        List<MemberModel> lb = null;
        try {
            lb = new ArrayList<MemberModel>();
            PreparedStatement st = (PreparedStatement) connection.prepareStatement(nameSearch);
            st.setString(1, nama);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                MemberModel b = new MemberModel();
                b.setId(rs.getInt("id"));
                b.setNama(rs.getString("nama"));
                b.setNoTelp(rs.getString("no_telp"));
                b.setAlamat(rs.getString("alamat"));
                b.setPaket(rs.getString("paket"));
                lb.add(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
}

