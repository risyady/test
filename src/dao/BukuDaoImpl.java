/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Buku;

/**
 *
 * @author Risyad
 */
public class BukuDaoImpl implements BukuDao{

    List<Buku> data = new ArrayList<>();

    public BukuDaoImpl() {
        data.add(new Buku("J001", "Laskar Pelaut", "Pak Nurdin", "Gramekamu", "2021"));
    }
    
 
    public Buku insert(Buku buku) {
        data.add(buku);
        return buku;
    }

    public Buku update(int index, Buku buku) {
        data.set(index, buku);
        return buku;
    }

    public Buku delete(int index) {
        return data.remove(index);
    }

    public Buku getBuku(int index) {
        return data.get(index);
    }

    public List<Buku> getAllBuku() {
        return data;
    }
    
}
