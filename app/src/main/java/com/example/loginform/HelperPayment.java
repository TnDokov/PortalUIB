package com.example.loginform;

public class HelperPayment {

    String jenisfee,jumlah,tanggal,deskripsi;

    public HelperPayment(String jenisfee,String jumlah, String tanggal ,String deskripsi) {
        this.jenisfee = jenisfee;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
    }

    public String getJenisfee() {
        return jenisfee;
    }
    public String getJumlah() {
        return jumlah;
    }
    public String getTanggal() {
        return tanggal;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
}
