package com.ananta.dao;

import com.ananta.database.Database;
import com.ananta.model.ModelKaryawan;
import com.ananta.service.ServiceKaryawan;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class KaryawanDAO implements ServiceKaryawan {

    private Connection con;

    public KaryawanDAO() {
        con = Database.getConnection();
    }

    @Override
    public void tambahData(ModelKaryawan model) {
        String sql = "INSERT INTO karyawan (rfid_tag, nama, posisi, no_hp) VALUES (?, ?, ?, ?)";

        try (PreparedStatement st = con.prepareStatement(sql)) {
            // Debug: tampilkan data yang akan disimpan
            System.out.println("Menambahkan Karyawan: " + model.getRFID() + ", "
                    + model.getNama() + ", " + model.getPosisi() + ", "
                    + model.getNoTelp());

            // Set parameter
            st.setString(1, model.getRFID());
            st.setString(2, model.getNama());
            st.setString(3, model.getPosisi());
            st.setString(4, model.getNoTelp());

            // Eksekusi perintah SQL
            st.executeUpdate();

            System.out.println("Data karyawan berhasil disimpan.");
        } catch (SQLException e) {
            System.err.println("Gagal menyimpan data karyawan:");
            e.printStackTrace();
        }
    }

    @Override
    public void perbaruiData(ModelKaryawan model) {
        PreparedStatement st = null;
        try {
            String sql = "UPDATE karyawan SET rfid_tag=?,"
                    + "nama=?, posisi=?, no_hp=? WHERE id_karyawan=?";
            st = con.prepareStatement(sql);
            st.setString(1, model.getRFID());
            st.setString(2, model.getNama());
            st.setString(3, model.getPosisi());
            st.setString(4, model.getNoTelp());
            st.setInt(5, model.getIdKaryawan());

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusData(ModelKaryawan model) {
        PreparedStatement st = null;
        String sql = "DELETE FROM karyawan WHERE id_karyawan=?";
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, model.getIdKaryawan());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelKaryawan> tampilData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM karyawan";

        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelKaryawan karyawan = new ModelKaryawan();
                karyawan.setIdKaryawan(rs.getInt("id_karyawan"));
                karyawan.setRFID(rs.getString("rfid_tag"));
                karyawan.setNama(rs.getString("nama"));
                karyawan.setPosisi(rs.getString("posisi"));
                karyawan.setNoTelp(rs.getString("no_hp"));

                list.add(karyawan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ModelKaryawan> pencarianData(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM karyawan WHERE rfid_tag LIKE'%" + id + "%'"
                + "OR nama LIKE '%" + id + "%'"
                + "OR posisi LIKE '%" + id + "%'"
                + "OR no_hp LIKE '%" + id + "%'";

        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelKaryawan karyawan = new ModelKaryawan();
                karyawan.setIdKaryawan(rs.getInt("id_karyawan"));
                karyawan.setRFID(rs.getString("rfid_tag"));
                karyawan.setNama(rs.getString("nama"));
                karyawan.setPosisi(rs.getString("posisi"));
                karyawan.setNoTelp(rs.getString("no_hp"));

                list.add(karyawan);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
