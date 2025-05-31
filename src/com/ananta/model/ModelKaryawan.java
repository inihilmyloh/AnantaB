package com.ananta.model;

public class ModelKaryawan {
    private int IdKaryawan;
    private String RFID;
    private String Nama;
    private String Posisi;
    private String NoTelp;

    public int getIdKaryawan() {
        return IdKaryawan;
    }

    public void setIdKaryawan(int idKaryawan) {
        this.IdKaryawan = idKaryawan;
    }

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getPosisi() {
        return Posisi;
    }

    public void setPosisi(String Posisi) {
        this.Posisi = Posisi;
    }

    public String getNoTelp() {
        return NoTelp;
    }

    public void setNoTelp(String NoTelp) {
        this.NoTelp = NoTelp;
    }
}
