
package dao;

import java.util.List;
import model.Anggota;


public interface AnggotaDao {
    Anggota save (Anggota anggota);
    Anggota update(int index,Anggota anggota);
    Anggota delete(int index);
    Anggota getAnggota(int index);
    List<Anggota>getAllAnggota();
    
}
