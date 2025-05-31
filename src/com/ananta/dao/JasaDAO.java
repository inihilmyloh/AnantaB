package com.ananta.dao;

import com.ananta.database.Database;
import com.ananta.model.ModelJasa;
import com.ananta.service.ServiceJasa;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class JasaDAO implements ServiceJasa {
    
    private Connection con;
    
    public JasaDAO() {
        con = Database.getConnection();
    }
    
    @Override
    public void tambahData(ModelJasa model) {
        String sql = "INSERT INTO jasa (nama_jasa, harga) VALUES (?, ?)";

        try (PreparedStatement st = con.prepareStatement(sql)) {
            // Debug: tampilkan data yang akan disimpan
            System.out.println("Menambahkan Jasa: " + model.getNama() + ", "
                    + model.getHarga());

            // Set parameter
            st.setString(1, model.getNama());
            st.setInt(2, model.getHarga());

            // Eksekusi perintah SQL
            st.executeUpdate();

            System.out.println("Data Jasa Berhasil Disimpan.");
        } catch (SQLException e) {
            System.err.println("Gagal Menyimpan Data Jasa :");
            e.printStackTrace();
        }
    }

    @Override
    public void perbaruiData(ModelJasa model) {
        PreparedStatement st = null;
        try {
            String sql = "UPDATE jasa SET nama_jasa=?,"
                    + "harga=? WHERE id_jasa=?";
            st = con.prepareStatement(sql);
            st.setString(1, model.getNama());
            st.setInt(2, model.getHarga());
            st.setInt(3, model.getIdJasa());

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusData(ModelJasa model) {
        PreparedStatement st = null;
        String sql = "DELETE FROM jasa WHERE id_jasa=?";
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, model.getIdJasa());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelJasa> tampilData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM jasa";

        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelJasa jasa = new ModelJasa();
                jasa.setIdJasa(rs.getInt("id_jasa"));
                jasa.setNama(rs.getString("nama_jasa"));
                jasa.setHarga(rs.getInt("harga"));

                list.add(jasa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ModelJasa> pencarianData(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM jasa WHERE nama_jasa LIKE'%" + id + "%'"
                + "OR harga LIKE '%" + id + "%'";

        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelJasa jasa = new ModelJasa();
                jasa.setIdJasa(rs.getInt("id_jasa"));
                jasa.setNama(rs.getString("nama_jasa"));
                jasa.setHarga(rs.getInt("harga"));

                list.add(jasa);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
