/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Peminjaman;

/**
 *
 * @author Risyad
 */
public interface PeminjamanDao {
    Peminjaman insert(Peminjaman pinjam);
    Peminjaman update(int index, Peminjaman pinjam);
    Peminjaman delete(int index);
    Peminjaman save(Peminjaman pinjam);
    Peminjaman getPinjam(int index);
    List<Peminjaman>getAllPeminjaman();
}
