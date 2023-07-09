/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 *
 * @author Risyad
 */
public class MemberKoneksi {
    static Connection con;
    
    public static Connection connection() {
        if(con == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("toko_baim");
            data.setUser("root");
            data.setPassword("");
            try {
                con = (Connection) data.getConnection();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return con;
    }
}
