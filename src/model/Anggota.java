/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author USER
 */
public class Anggota {
    private String nobp;
    private String nama;
    private String alamat;
    private String kelamin;
    
    public Anggota(){
    }

    public Anggota(String nobp, String nama, String alamat, String kelamin) {
        this.nobp = nobp;
        this.nama = nama;
        this.alamat = alamat;
        this.kelamin = kelamin;
    }

    public String getNobp() {
        return nobp;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setNobp(String nobp) {
        this.nobp= nobp;
    }

    public void setNama(String nama) {
        this.nama=nama;
    }

    public void setAlamat(String alamat) {
        this.alamat=alamat;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }
    
}
