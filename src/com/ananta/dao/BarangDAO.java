package com.ananta.dao;

import com.ananta.database.Database;
import com.ananta.model.ModelBarang;
import com.ananta.service.ServiceBarang;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class BarangDAO implements ServiceBarang {
    
    private Connection con;
    
    public BarangDAO() {
        con = Database.getConnection();
    }
    
    @Override
    public void tambahData(ModelBarang model) {
        String sql = "INSERT INTO barang (nama_barang, barcode, jumlah, harga) VALUES (?, ?, ?, ?)";

        try (PreparedStatement st = con.prepareStatement(sql)) {
            // Debug: tampilkan data yang akan disimpan
            System.out.println("Menambahkan Barang: " + model.getNama() + ", "
                    + model.getBarcode() + ", " + model.getJumlah() + ", "
                    + model.getHarga());

            // Set parameter
            st.setString(1, model.getNama());
            st.setString(2, model.getBarcode());
            st.setInt(3, model.getJumlah());
            st.setInt(4, model.getHarga());

            // Eksekusi perintah SQL
            st.executeUpdate();

            System.out.println("Data Barang Berhasil Disimpan.");
        } catch (SQLException e) {
            System.err.println("Gagal Menyimpan Data Barang :");
            e.printStackTrace();
        }
    }

    @Override
    public void perbaruiData(ModelBarang model) {
        PreparedStatement st = null;
        try {
            String sql = "UPDATE barang SET nama_barang=?,"
                    + "barcode=?, jumlah=?, harga=? WHERE id_barang=?";
            st = con.prepareStatement(sql);
            st.setString(1, model.getNama());
            st.setString(2, model.getBarcode());
            st.setInt(3, model.getJumlah());
            st.setInt(4, model.getHarga());
            st.setInt(5, model.getIdBarang());

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusData(ModelBarang model) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang WHERE id_barang=?";
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, model.getIdBarang());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelBarang> tampilData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM barang";

        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelBarang barang = new ModelBarang();
                barang.setIdBarang(rs.getInt("id_barang"));
                barang.setNama(rs.getString("nama_barang"));
                barang.setBarcode(rs.getString("barcode"));
                barang.setJumlah(rs.getInt("jumlah"));
                barang.setHarga(rs.getInt("harga"));

                list.add(barang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ModelBarang> pencarianData(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM barang WHERE nama_barang LIKE'%" + id + "%'"
                + "OR barcode LIKE '%" + id + "%'"
                + "OR jumlah LIKE '%" + id + "%'"
                + "OR harga LIKE '%" + id + "%'";

        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelBarang barang = new ModelBarang();
                barang.setIdBarang(rs.getInt("id_barang"));
                barang.setNama(rs.getString("nama_barang"));
                barang.setBarcode(rs.getString("barcode"));
                barang.setJumlah(rs.getInt("jumlah"));
                barang.setHarga(rs.getInt("harga"));

                list.add(barang);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
