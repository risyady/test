/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.MemberModel;

/**
 *
 * @author Risyad
 */
public interface MemberDao {
    public void insert (MemberModel b);
    public void update(MemberModel b);
    public void delete(int id);
    
    public List<MemberModel> getAll();
    public List<MemberModel> getCariNama (String nama);
}
