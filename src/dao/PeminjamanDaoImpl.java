/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Peminjaman;

/**
 *
 * @author Risyad
 */
public class PeminjamanDaoImpl implements PeminjamanDao {

    List<Peminjaman> data = new ArrayList<>();

    public PeminjamanDaoImpl() {
        data.add(new Peminjaman("P001", null, null, "29 mei", "29 mei"));
    }
    
    
    
    @Override
    public Peminjaman insert(Peminjaman pinjam) {
        data.add(pinjam);
        return pinjam;
    }

    @Override
    public Peminjaman update(int index, Peminjaman pinjam) {
        data.set(index, pinjam);
        return pinjam;
    }

    @Override
    public Peminjaman delete(int index) {
        return data.remove(index);
    }

    @Override
    public Peminjaman getPinjam(int index) {
        return data.get(index);
    }

    @Override
    public List<Peminjaman> getAllPeminjaman() {
        return data;
    }

    @Override
    public Peminjaman save(Peminjaman pinjam) {
        data.add(pinjam);
        return pinjam;
    }
    
}
