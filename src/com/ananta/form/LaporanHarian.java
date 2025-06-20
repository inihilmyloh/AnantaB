package com.ananta.form;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import com.ananta.database.Database;
import java.text.NumberFormat;
import java.util.Locale;
/**
 *
 * @author M.Khoiril
 */
public class LaporanHarian extends javax.swing.JPanel {

    private Connection conn;
    
    public LaporanHarian() {
        initComponents();
        conn = Database.getConnection();
        loadData();
            setModelTabelTransaksi();
            getDataTransaksi((DefaultTableModel) TabelRiwayatTransaksi.getModel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        whiteBg = new com.ananta.shape.shapecustom();
        kuning_card_RK = new com.ananta.shape.shapecustom();
        label_RK = new javax.swing.JLabel();
        hijau_card_RK = new com.ananta.shape.shapecustom();
        labelPengeluaran = new javax.swing.JLabel();
        labelLaba = new javax.swing.JLabel();
        lb_rp_pemasukan = new javax.swing.JLabel();
        lb_rp_pengeluaran = new javax.swing.JLabel();
        lb_rp_laba = new javax.swing.JLabel();
        labelPemasukan = new javax.swing.JLabel();
        PemasukanDlmAngka = new javax.swing.JLabel();
        PengeluaranDlmAngka = new javax.swing.JLabel();
        LabaDlmAngka = new javax.swing.JLabel();
        kuning_card_RO = new com.ananta.shape.shapecustom();
        label_RO = new javax.swing.JLabel();
        hijau_card_RO = new com.ananta.shape.shapecustom();
        labelProduk = new javax.swing.JLabel();
        labelTerlaris = new javax.swing.JLabel();
        titikddua = new javax.swing.JLabel();
        titikdua = new javax.swing.JLabel();
        titikdddua = new javax.swing.JLabel();
        labelJasa = new javax.swing.JLabel();
        titikdddua1 = new javax.swing.JLabel();
        TransaksiDlmAngka = new javax.swing.JLabel();
        labelTransaksi = new javax.swing.JLabel();
        JasaDlmAngka = new javax.swing.JLabel();
        ProdukDlmAngka = new javax.swing.JLabel();
        txtTerlaris = new javax.swing.JLabel();
        numTerlaris = new javax.swing.JLabel();
        kuning_card_RK1 = new com.ananta.shape.shapecustom();
        labelRiwayatTransaksi = new javax.swing.JLabel();
        pn_PilihHari = new com.ananta.shape.shapecustom();
        comboBoxHari = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelRiwayatTransaksi = new com.ananta.shape.JTabeel();

        setBackground(new java.awt.Color(153, 153, 153));

        whiteBg.setBackground(new java.awt.Color(255, 255, 255));
        whiteBg.setRoundBottomLeft(80);
        whiteBg.setRoundBottomRight(80);
        whiteBg.setRoundTopLeft(80);
        whiteBg.setRoundTopRight(80);

        kuning_card_RK.setBackground(new java.awt.Color(255, 153, 0));
        kuning_card_RK.setRoundTopLeft(60);
        kuning_card_RK.setRoundTopRight(60);

        label_RK.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        label_RK.setText("Ringkasan Keuangan");

        javax.swing.GroupLayout kuning_card_RKLayout = new javax.swing.GroupLayout(kuning_card_RK);
        kuning_card_RK.setLayout(kuning_card_RKLayout);
        kuning_card_RKLayout.setHorizontalGroup(
            kuning_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kuning_card_RKLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(label_RK)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        kuning_card_RKLayout.setVerticalGroup(
            kuning_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kuning_card_RKLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(label_RK)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        hijau_card_RK.setBackground(new java.awt.Color(0, 119, 32));
        hijau_card_RK.setRoundBottomLeft(20);
        hijau_card_RK.setRoundBottomRight(20);

        labelPengeluaran.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelPengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        labelPengeluaran.setText("Pengeluaran");

        labelLaba.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelLaba.setForeground(new java.awt.Color(255, 255, 255));
        labelLaba.setText("Laba");

        lb_rp_pemasukan.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        lb_rp_pemasukan.setForeground(new java.awt.Color(255, 255, 255));
        lb_rp_pemasukan.setText(":");

        lb_rp_pengeluaran.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        lb_rp_pengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        lb_rp_pengeluaran.setText(":");

        lb_rp_laba.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        lb_rp_laba.setForeground(new java.awt.Color(255, 255, 255));
        lb_rp_laba.setText(":");

        labelPemasukan.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelPemasukan.setForeground(new java.awt.Color(255, 255, 255));
        labelPemasukan.setText("Pemasukan");

        PemasukanDlmAngka.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        PemasukanDlmAngka.setForeground(new java.awt.Color(255, 255, 255));
        PemasukanDlmAngka.setText("325.000,00");

        PengeluaranDlmAngka.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        PengeluaranDlmAngka.setForeground(new java.awt.Color(255, 255, 255));
        PengeluaranDlmAngka.setText("180.000,00");

        LabaDlmAngka.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        LabaDlmAngka.setForeground(new java.awt.Color(255, 255, 255));
        LabaDlmAngka.setText("145.000,00");

        javax.swing.GroupLayout hijau_card_RKLayout = new javax.swing.GroupLayout(hijau_card_RK);
        hijau_card_RK.setLayout(hijau_card_RKLayout);
        hijau_card_RKLayout.setHorizontalGroup(
            hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hijau_card_RKLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelLaba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(labelPemasukan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lb_rp_pengeluaran, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_rp_pemasukan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_rp_laba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PemasukanDlmAngka, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(PengeluaranDlmAngka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabaDlmAngka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        hijau_card_RKLayout.setVerticalGroup(
            hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hijau_card_RKLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_rp_pemasukan)
                    .addComponent(labelPemasukan)
                    .addComponent(PemasukanDlmAngka))
                .addGap(11, 11, 11)
                .addGroup(hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPengeluaran)
                    .addComponent(lb_rp_pengeluaran)
                    .addComponent(PengeluaranDlmAngka))
                .addGap(11, 11, 11)
                .addGroup(hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLaba)
                    .addComponent(lb_rp_laba)
                    .addComponent(LabaDlmAngka))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        kuning_card_RO.setBackground(new java.awt.Color(255, 153, 0));
        kuning_card_RO.setRoundTopLeft(60);
        kuning_card_RO.setRoundTopRight(60);

        label_RO.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        label_RO.setText("Ringkasan Operasional");

        javax.swing.GroupLayout kuning_card_ROLayout = new javax.swing.GroupLayout(kuning_card_RO);
        kuning_card_RO.setLayout(kuning_card_ROLayout);
        kuning_card_ROLayout.setHorizontalGroup(
            kuning_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kuning_card_ROLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(label_RO)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        kuning_card_ROLayout.setVerticalGroup(
            kuning_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kuning_card_ROLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(label_RO)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        hijau_card_RO.setBackground(new java.awt.Color(0, 119, 32));
        hijau_card_RO.setRoundBottomLeft(20);
        hijau_card_RO.setRoundBottomRight(20);

        labelProduk.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelProduk.setForeground(new java.awt.Color(255, 255, 255));
        labelProduk.setText("Produk Terjual");

        labelTerlaris.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelTerlaris.setForeground(new java.awt.Color(255, 255, 255));
        labelTerlaris.setText("Jasa/Produk Terlaris");

        titikddua.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        titikddua.setForeground(new java.awt.Color(255, 255, 255));
        titikddua.setText(":");

        titikdua.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        titikdua.setForeground(new java.awt.Color(255, 255, 255));
        titikdua.setText(":");

        titikdddua.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        titikdddua.setForeground(new java.awt.Color(255, 255, 255));
        titikdddua.setText(":");

        labelJasa.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelJasa.setForeground(new java.awt.Color(255, 255, 255));
        labelJasa.setText("Jasa Dikerjakan");

        titikdddua1.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        titikdddua1.setForeground(new java.awt.Color(255, 255, 255));
        titikdddua1.setText(":");

        TransaksiDlmAngka.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        TransaksiDlmAngka.setForeground(new java.awt.Color(255, 255, 255));
        TransaksiDlmAngka.setText("20");

        labelTransaksi.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        labelTransaksi.setText("Transaksi Dilakukan");

        JasaDlmAngka.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        JasaDlmAngka.setForeground(new java.awt.Color(255, 255, 255));
        JasaDlmAngka.setText("20");

        ProdukDlmAngka.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        ProdukDlmAngka.setForeground(new java.awt.Color(255, 255, 255));
        ProdukDlmAngka.setText("14");

        txtTerlaris.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        txtTerlaris.setForeground(new java.awt.Color(255, 255, 255));
        txtTerlaris.setText("Hair Cut");

        numTerlaris.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        numTerlaris.setForeground(new java.awt.Color(255, 255, 255));
        numTerlaris.setText("(14x)");

        javax.swing.GroupLayout hijau_card_ROLayout = new javax.swing.GroupLayout(hijau_card_RO);
        hijau_card_RO.setLayout(hijau_card_ROLayout);
        hijau_card_ROLayout.setHorizontalGroup(
            hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hijau_card_ROLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelTerlaris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelJasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(hijau_card_ROLayout.createSequentialGroup()
                        .addGroup(hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(titikdua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titikddua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titikdddua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(hijau_card_ROLayout.createSequentialGroup()
                                .addComponent(txtTerlaris)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numTerlaris, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JasaDlmAngka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TransaksiDlmAngka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(hijau_card_ROLayout.createSequentialGroup()
                        .addComponent(titikdddua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProdukDlmAngka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        hijau_card_ROLayout.setVerticalGroup(
            hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hijau_card_ROLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titikddua)
                    .addComponent(TransaksiDlmAngka)
                    .addComponent(labelTransaksi))
                .addGap(11, 11, 11)
                .addGroup(hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titikdua)
                    .addComponent(labelJasa)
                    .addComponent(JasaDlmAngka))
                .addGap(11, 11, 11)
                .addGroup(hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titikdddua)
                    .addComponent(labelProduk)
                    .addComponent(ProdukDlmAngka))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titikdddua1)
                    .addComponent(labelTerlaris)
                    .addComponent(txtTerlaris)
                    .addComponent(numTerlaris))
                .addGap(17, 17, 17))
        );

        kuning_card_RK1.setBackground(new java.awt.Color(255, 153, 0));
        kuning_card_RK1.setRoundBottomLeft(40);
        kuning_card_RK1.setRoundBottomRight(40);
        kuning_card_RK1.setRoundTopLeft(40);
        kuning_card_RK1.setRoundTopRight(40);

        labelRiwayatTransaksi.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelRiwayatTransaksi.setText("Riwayat Transaksi");

        javax.swing.GroupLayout kuning_card_RK1Layout = new javax.swing.GroupLayout(kuning_card_RK1);
        kuning_card_RK1.setLayout(kuning_card_RK1Layout);
        kuning_card_RK1Layout.setHorizontalGroup(
            kuning_card_RK1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kuning_card_RK1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelRiwayatTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        kuning_card_RK1Layout.setVerticalGroup(
            kuning_card_RK1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kuning_card_RK1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(labelRiwayatTransaksi)
                .addGap(12, 12, 12))
        );

        pn_PilihHari.setBackground(new java.awt.Color(255, 153, 0));
        pn_PilihHari.setRoundBottomLeft(20);
        pn_PilihHari.setRoundBottomRight(20);
        pn_PilihHari.setRoundTopLeft(20);
        pn_PilihHari.setRoundTopRight(20);

        comboBoxHari.setBackground(new java.awt.Color(255, 153, 0));
        comboBoxHari.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        comboBoxHari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Hari--", "Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu", "Minggu" }));
        comboBoxHari.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        comboBoxHari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxHariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_PilihHariLayout = new javax.swing.GroupLayout(pn_PilihHari);
        pn_PilihHari.setLayout(pn_PilihHariLayout);
        pn_PilihHariLayout.setHorizontalGroup(
            pn_PilihHariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_PilihHariLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(comboBoxHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_PilihHariLayout.setVerticalGroup(
            pn_PilihHariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboBoxHari, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        TabelRiwayatTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID TRANSAKSI", "WAKTU", "JENIS TRANSAKSI", "NOMINAL", "KETERANGAN"
            }
        ));
        jScrollPane1.setViewportView(TabelRiwayatTransaksi);

        javax.swing.GroupLayout whiteBgLayout = new javax.swing.GroupLayout(whiteBg);
        whiteBg.setLayout(whiteBgLayout);
        whiteBgLayout.setHorizontalGroup(
            whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteBgLayout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, whiteBgLayout.createSequentialGroup()
                        .addComponent(kuning_card_RK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pn_PilihHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, whiteBgLayout.createSequentialGroup()
                        .addGroup(whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kuning_card_RK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hijau_card_RK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(81, 81, 81)
                        .addGroup(whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hijau_card_RO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kuning_card_RO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        whiteBgLayout.setVerticalGroup(
            whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteBgLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kuning_card_RO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kuning_card_RK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hijau_card_RK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hijau_card_RO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(kuning_card_RK1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_PilihHari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(whiteBg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(whiteBg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxHariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxHariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxHariActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JasaDlmAngka;
    private javax.swing.JLabel LabaDlmAngka;
    private javax.swing.JLabel PemasukanDlmAngka;
    private javax.swing.JLabel PengeluaranDlmAngka;
    private javax.swing.JLabel ProdukDlmAngka;
    private com.ananta.shape.JTabeel TabelRiwayatTransaksi;
    private javax.swing.JLabel TransaksiDlmAngka;
    private javax.swing.JComboBox<String> comboBoxHari;
    private com.ananta.shape.shapecustom hijau_card_RK;
    private com.ananta.shape.shapecustom hijau_card_RO;
    private javax.swing.JScrollPane jScrollPane1;
    private com.ananta.shape.shapecustom kuning_card_RK;
    private com.ananta.shape.shapecustom kuning_card_RK1;
    private com.ananta.shape.shapecustom kuning_card_RO;
    private javax.swing.JLabel labelJasa;
    private javax.swing.JLabel labelLaba;
    private javax.swing.JLabel labelPemasukan;
    private javax.swing.JLabel labelPengeluaran;
    private javax.swing.JLabel labelProduk;
    private javax.swing.JLabel labelRiwayatTransaksi;
    private javax.swing.JLabel labelTerlaris;
    private javax.swing.JLabel labelTransaksi;
    private javax.swing.JLabel label_RK;
    private javax.swing.JLabel label_RO;
    private javax.swing.JLabel lb_rp_laba;
    private javax.swing.JLabel lb_rp_pemasukan;
    private javax.swing.JLabel lb_rp_pengeluaran;
    private javax.swing.JLabel numTerlaris;
    private com.ananta.shape.shapecustom pn_PilihHari;
    private javax.swing.JLabel titikdddua;
    private javax.swing.JLabel titikdddua1;
    private javax.swing.JLabel titikddua;
    private javax.swing.JLabel titikdua;
    private javax.swing.JLabel txtTerlaris;
    private com.ananta.shape.shapecustom whiteBg;
    // End of variables declaration//GEN-END:variables

    private int totalPemasukan () {
        int totalPemasukan = 0;
        try {
            String sql = """
                         SELECT IFNULL(SUM(total_harga), 0) AS pemasukan
                         FROM transaksi
                         WHERE DATE(created_at) = CURDATE();""";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()){
                totalPemasukan = rs.getInt("pemasukan");
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        return totalPemasukan;
    }
    
    private int totalPengeluaran () {
        int totalPengeluaran = 0;
        try {
            String sql = """
                         SELECT IFNULL(SUM(jumlah), 0) AS pengeluaran
                         FROM pengeluaran
                         WHERE DATE(created_at) = CURDATE();""";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()){
                totalPengeluaran = rs.getInt("pengeluaran");
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        return totalPengeluaran;
    }
    
    private int totalLaba() {
        int totalLaba = 0;
        try {
            String sql = """
                         SELECT
                             IFNULL((
                                 SELECT SUM(total_harga)
                                 FROM transaksi
                                 WHERE DATE(created_at) = CURDATE()
                             ), 0)
                             -
                             IFNULL((
                                 SELECT SUM(jumlah)
                                 FROM pengeluaran
                                 WHERE DATE(created_at) = CURDATE()
                             ), 0) AS laba;
                         """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                totalLaba = rs.getInt("laba");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalLaba;
    }
    
    private int jmlTransaksi() {
        int jmlTransaksi = 0;
        try {
            String sql = """
                        SELECT COUNT(*) AS jumlah_transaksi
                        FROM transaksi
                        WHERE DATE(created_at) = CURDATE();
                        """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                jmlTransaksi = rs.getInt("jumlah_transaksi");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jmlTransaksi;
    }

    
    private int jmlJasaDikerjakan() {
        int jmlJasa = 0;
        try {
            String sql = """
                        SELECT COUNT(*) AS jumlah_jasa_dikerjakan
                        FROM transaksi_jasa tj
                        JOIN transaksi t ON tj.id_transaksi = t.id_transaksi
                        WHERE DATE(t.created_at) = CURDATE();
                        """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                jmlJasa = rs.getInt("jumlah_jasa_dikerjakan");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jmlJasa;
    }
    
    private int jmlProdukTerjual() {
        int jmlProduk = 0;
        try {
            String sql = """
                         SELECT COUNT(*) AS jumlah_produk
                         FROM transaksi_barang tb
                         JOIN transaksi t ON tb.id_transaksi = t.id_transaksi
                         WHERE DATE(t.created_at) = CURDATE();
                         """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                jmlProduk = rs.getInt("jumlah_produk");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jmlProduk;
    }

    private void getTerlaris() {
        String namaTerlaris = "-";
        int jumlahTerlaris = 0;

        try {
            String sqlJasa = """
                             SELECT j.nama_jasa AS nama, COUNT(*) AS jumlah
                             FROM transaksi_jasa tj
                             JOIN transaksi t ON tj.id_transaksi = t.id_transaksi
                             JOIN jasa j ON tj.id_jasa = j.id_jasa
                             WHERE DATE(t.created_at) = CURDATE()
                             GROUP BY j.nama_jasa
                             ORDER BY jumlah DESC
                             LIMIT 1;
                             """;
            
           PreparedStatement stJasa = conn.prepareStatement(sqlJasa);
            ResultSet rsJasa = stJasa.executeQuery();

            String namaJasa = null;
            int jumlahJasa = 0;
        
            if (rsJasa.next()) {
                namaJasa = rsJasa.getString("nama");
                jumlahJasa = rsJasa.getInt("jumlah");
            }

            String sqlProduk = """
                               SELECT b.nama_barang AS nama, COUNT(*) AS jumlah
                               FROM transaksi_barang tb
                               JOIN transaksi t ON tb.id_transaksi = t.id_transaksi
                               JOIN barang b ON tb.id_barang = b.id_barang
                               WHERE DATE(t.created_at) = CURDATE()
                               GROUP BY b.nama_barang
                               ORDER BY jumlah DESC
                               LIMIT 1;
                               """;

            PreparedStatement stProduk = conn.prepareStatement(sqlProduk);
            ResultSet rsProduk = stProduk.executeQuery();

            String namaProduk = null;
            int jumlahProduk = 0;

            if (rsProduk.next()) {
                namaProduk = rsProduk.getString("nama");
                jumlahProduk = rsProduk.getInt("jumlah");
            }

            if (jumlahJasa >= jumlahProduk) {
                namaTerlaris = namaJasa != null ? namaJasa : "-";
                jumlahTerlaris = jumlahJasa;
            } else {
                namaTerlaris = namaProduk != null ? namaProduk : "-";
                jumlahTerlaris = jumlahProduk;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        txtTerlaris.setText(namaTerlaris);
        numTerlaris.setText("("+jumlahTerlaris + "x)");
    }

    
    private void loadData() {
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
        
        PemasukanDlmAngka.setText(formatRupiah.format(totalPemasukan()));
        PengeluaranDlmAngka.setText(formatRupiah.format(totalPengeluaran()));
        LabaDlmAngka.setText(formatRupiah.format(totalLaba()));
        TransaksiDlmAngka.setText(String.valueOf(jmlTransaksi()));
        JasaDlmAngka.setText(String.valueOf(jmlJasaDikerjakan()));
        ProdukDlmAngka.setText(String.valueOf(jmlProdukTerjual()));
        getTerlaris();
    }

    private void setModelTabelTransaksi() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID TRANSAKSI");
        model.addColumn("WAKTU");
        model.addColumn("JENIS TRANSAKSI");
        model.addColumn("NOMINAL");
        model.addColumn("KETERANGAN");
        TabelRiwayatTransaksi.setModel(model);
}
    
    
    private void getDataTransaksi(DefaultTableModel model) {
        model.setRowCount(0);
            
        try {
            String sql = """
                SELECT t.id_transaksi, t.created_at, 'Pemasukan' AS jenis, t.total_harga AS nominal,
                           CONCAT_WS(', ',
                               (SELECT j.nama_jasa
                                FROM transaksi_jasa tj
                                JOIN jasa j ON tj.id_jasa = j.id_jasa
                                WHERE tj.id_transaksi = t.id_transaksi
                                LIMIT 1),
                               (SELECT b.nama_barang
                                FROM transaksi_barang tb
                                JOIN barang b ON tb.id_barang = b.id_barang
                                WHERE tb.id_transaksi = t.id_transaksi
                                LIMIT 1)
                           ) AS keterangan
                    FROM transaksi t
                    WHERE DATE(t.created_at) = CURDATE()
                    
                    UNION ALL
                    
                    SELECT p.id_pengeluaran, p.created_at, 'Pengeluaran' AS jenis, p.jumlah AS nominal, p.kategori AS keterangan
                    FROM pengeluaran p
                    WHERE DATE(p.created_at) = CURDATE()
                    
                    ORDER BY created_at ASC;
                """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
            int no = 1;
            while (rs.next()) {
                Object[] rowData = {
                    no++,
                    rs.getString("created_at"),
                    rs.getString("jenis"),
                    formatRupiah.format(rs.getInt("nominal")),
                    rs.getString("keterangan")
                };
                model.addRow(rowData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
