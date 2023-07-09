/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Buku;

/**
 *
 * @author Risyad
 */
public interface BukuDao {
    Buku insert(Buku buku);
    Buku update(int index, Buku buku);
    Buku delete(int index);
    Buku getBuku(int index);
    List<Buku>getAllBuku();
}
