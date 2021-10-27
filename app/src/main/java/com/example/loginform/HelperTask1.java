package com.example.loginform;

public class HelperTask1 {

    String tanggaldeadline,kelas,tujuantugas,deskripsitugas;

    public HelperTask1(String tanggaldeadline, String kelas, String tujuantugas, String deskripsitugas) {
        this.tanggaldeadline = tanggaldeadline;
        this.kelas = kelas;
        this.tujuantugas = tujuantugas;
        this.deskripsitugas = deskripsitugas;
    }

    public String getTanggaldeadline() {
        return tanggaldeadline;
    }
    public String getTujuantugas() {
        return tujuantugas;
    }
    public String getDeskripsitugas() {
        return deskripsitugas;
    }
    public String getKelas() {
        return kelas;
    }
}
