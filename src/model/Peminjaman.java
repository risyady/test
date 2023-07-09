/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Risyad
 */
public class Peminjaman {
    private String kodePinjam;
    private String tanggalPinjam;
    private String tanggalKembali;
    private String kodeBuku;
    private String nobp;

    public Peminjaman(String kodePinjam, String tanggalPinjam, String tanggalKembali, String kodeBuku, String nobp) {
        this.kodePinjam = kodePinjam;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.kodeBuku = kodeBuku;
        this.nobp = nobp;
    }
    
    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getNobp() {
        return nobp;
    }

    public void setNobp(String nobp) {
        this.nobp = nobp;
    }

    public String getKodePinjam() {
        return kodePinjam;
    }

    public void setKodePinjam(String kodePinjam) {
        this.kodePinjam = kodePinjam;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }
    
}
