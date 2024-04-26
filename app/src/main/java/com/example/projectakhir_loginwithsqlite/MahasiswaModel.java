package com.example.projectakhir_loginwithsqlite;

import java.util.ArrayList;

public class MahasiswaModel {

    public static ArrayList<MahasiswaModel> mahasiswaArrayList = new ArrayList<>();
    private int nim;
    private String nama;

    private int tanggal_lahir;
    private String jenis_kelamin;
    private String alamat;

    public MahasiswaModel(int nim, int tanggal_lahir, String nama, String jenis_kelamin, String alamat){
        this.nim = nim;
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.jenis_kelamin = jenis_kelamin;
        this.alamat = alamat;
    }

    public int getNim(){
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getTanggal_lahir(){
        return tanggal_lahir;
    }

    public void setTanggal_lahir(int tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getJenis_kelamin(){
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
