/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Anggota;

/**
 *
 * @author USER
 */
public class AnggotaDaoImpl implements AnggotaDao{
    List<Anggota> data = new ArrayList<>();
    
    public AnggotaDaoImpl(){
        data.add(new Anggota("09876444","Budi","Padang", "L"));
    }
    
    
    
    
    @Override
    public Anggota save(Anggota anggota) {
       data.add(anggota);
       return anggota;
    }
    @Override
    public Anggota update(int index, Anggota anggota) {
       data.set(index,anggota);
       return anggota;
    }

    @Override
    public Anggota delete(int index) {
       return data.remove(index);
    }

    @Override
    public Anggota getAnggota(int index) {
        return data.get(index);
    }

    @Override
    public List<Anggota> getAllAnggota() {
        return data;
    }
    
}
