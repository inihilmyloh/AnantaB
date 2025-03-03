package com.ananta.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // URL koneksi database
    private static final String URL = "jdbc:mysql://localhost:3306/anantabarbershop"; // Ganti dengan nama database Anda
    private static final String USER = "root"; // Username MySQL
    private static final String PASSWORD = ""; // Password MySQL

    // Method untuk mendapatkan koneksi ke database
    public static Connection getConnection() {
        Connection Koneksi = null;
        try {
            // Mendapatkan koneksi ke database
            Koneksi = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi ke database berhasil!");
        } catch (SQLException e) {
            // Menangani jika koneksi gagal
            System.out.println("Koneksi ke database gagal!");
            e.printStackTrace();
        }
        return Koneksi; // Mengembalikan koneksi atau null jika gagal
    }

    // Opsional: Method untuk menutup koneksi
    public static void closeConnection(Connection Koneksi) {
        if (Koneksi != null) {
            try {
                Koneksi.close();
                System.out.println("Koneksi database ditutup.");
            } catch (SQLException e) {
                System.out.println("Gagal menutup koneksi database.");
                e.printStackTrace();
            }
        }
    }
}
