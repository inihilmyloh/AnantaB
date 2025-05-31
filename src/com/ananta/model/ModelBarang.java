package com.ananta.model;

public class ModelBarang {
    private int IdBarang;
    private String Nama;
    private String Barcode;
    private int Jumlah;
    private int Harga;

    public int getIdBarang() {
        return IdBarang;
    }

    public void setIdBarang(int idBarang) {
        this.IdBarang = idBarang;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String Barcode) {
        this.Barcode = Barcode;
    }

    public int getJumlah() {
        return Jumlah;
    }

    public void setJumlah(int Jumlah) {
        this.Jumlah = Jumlah;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }
}
