/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ananta.apk;

/**
 *
 * @author M.Khoiril
 */
public class LaporanBulanan extends javax.swing.JPanel {

    /**
     * Creates new form LaporanHarian
     */
    public LaporanBulanan() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        whiteBg = new com.ananta.shapecustom.shapecustom();
        kuning_card_RK = new com.ananta.shapecustom.shapecustom();
        label_RK = new javax.swing.JLabel();
        hijau_card_RK = new com.ananta.shapecustom.shapecustom();
        labelPengeluaran = new javax.swing.JLabel();
        labelLabaBersih = new javax.swing.JLabel();
        pemasukanDlmRupiah = new javax.swing.JLabel();
        pengeluaranDlmRupiah = new javax.swing.JLabel();
        labaDlmRupiah = new javax.swing.JLabel();
        labelPemasukan = new javax.swing.JLabel();
        kuning_card_RO = new com.ananta.shapecustom.shapecustom();
        label_RO = new javax.swing.JLabel();
        hijau_card_RO = new com.ananta.shapecustom.shapecustom();
        labelJmlTransaksi = new javax.swing.JLabel();
        labelJmlPelanggan = new javax.swing.JLabel();
        labelTerlaris = new javax.swing.JLabel();
        JmlTransaksiDlmAngka = new javax.swing.JLabel();
        JmlPelangganDlmAngka = new javax.swing.JLabel();
        produkTerlaris = new javax.swing.JLabel();
        kuning_card_RK1 = new com.ananta.shapecustom.shapecustom();
        labelRiwayatTransaksi = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelKeuanganMingguan = new com.ananta.shapecustom.JTaabel();
        shapecustom2 = new com.ananta.shapecustom.shapecustom();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(153, 153, 153));

        whiteBg.setBackground(new java.awt.Color(255, 255, 255));
        whiteBg.setRoundBottomLeft(80);
        whiteBg.setRoundBottomRight(80);
        whiteBg.setRoundTopLeft(80);
        whiteBg.setRoundTopRight(80);

        kuning_card_RK.setBackground(new java.awt.Color(239, 167, 0));
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

        labelLabaBersih.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelLabaBersih.setForeground(new java.awt.Color(255, 255, 255));
        labelLabaBersih.setText("Laba");

        pemasukanDlmRupiah.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        pemasukanDlmRupiah.setForeground(new java.awt.Color(255, 255, 255));
        pemasukanDlmRupiah.setText(": Rp 7.125.000,00");

        pengeluaranDlmRupiah.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        pengeluaranDlmRupiah.setForeground(new java.awt.Color(255, 255, 255));
        pengeluaranDlmRupiah.setText(": Rp 1.560.000,00");

        labaDlmRupiah.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labaDlmRupiah.setForeground(new java.awt.Color(255, 255, 255));
        labaDlmRupiah.setText(": Rp 1.565.000,00");

        labelPemasukan.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelPemasukan.setForeground(new java.awt.Color(255, 255, 255));
        labelPemasukan.setText("Pemasukan");

        javax.swing.GroupLayout hijau_card_RKLayout = new javax.swing.GroupLayout(hijau_card_RK);
        hijau_card_RK.setLayout(hijau_card_RKLayout);
        hijau_card_RKLayout.setHorizontalGroup(
            hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hijau_card_RKLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelLabaBersih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(labelPemasukan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pengeluaranDlmRupiah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pemasukanDlmRupiah, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(labaDlmRupiah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        hijau_card_RKLayout.setVerticalGroup(
            hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hijau_card_RKLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pemasukanDlmRupiah)
                    .addComponent(labelPemasukan))
                .addGap(11, 11, 11)
                .addGroup(hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPengeluaran)
                    .addComponent(pengeluaranDlmRupiah))
                .addGap(11, 11, 11)
                .addGroup(hijau_card_RKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLabaBersih)
                    .addComponent(labaDlmRupiah))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        kuning_card_RO.setBackground(new java.awt.Color(239, 167, 0));
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

        labelJmlTransaksi.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelJmlTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        labelJmlTransaksi.setText("Jml. Transaksi");

        labelJmlPelanggan.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelJmlPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        labelJmlPelanggan.setText("Jml. Jasa Laku");

        labelTerlaris.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelTerlaris.setForeground(new java.awt.Color(255, 255, 255));
        labelTerlaris.setText("Jasa Terlaris");

        JmlTransaksiDlmAngka.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        JmlTransaksiDlmAngka.setForeground(new java.awt.Color(255, 255, 255));
        JmlTransaksiDlmAngka.setText(": 244");

        JmlPelangganDlmAngka.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        JmlPelangganDlmAngka.setForeground(new java.awt.Color(255, 255, 255));
        JmlPelangganDlmAngka.setText(": 197");

        produkTerlaris.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        produkTerlaris.setForeground(new java.awt.Color(255, 255, 255));
        produkTerlaris.setText(": Hair Cut (226x)");

        javax.swing.GroupLayout hijau_card_ROLayout = new javax.swing.GroupLayout(hijau_card_RO);
        hijau_card_RO.setLayout(hijau_card_ROLayout);
        hijau_card_ROLayout.setHorizontalGroup(
            hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hijau_card_ROLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelTerlaris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelJmlPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(labelJmlTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JmlTransaksiDlmAngka, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JmlPelangganDlmAngka, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(produkTerlaris, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        hijau_card_ROLayout.setVerticalGroup(
            hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hijau_card_ROLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJmlTransaksi)
                    .addComponent(JmlTransaksiDlmAngka))
                .addGap(11, 11, 11)
                .addGroup(hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJmlPelanggan)
                    .addComponent(JmlPelangganDlmAngka))
                .addGap(11, 11, 11)
                .addGroup(hijau_card_ROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTerlaris)
                    .addComponent(produkTerlaris))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        kuning_card_RK1.setBackground(new java.awt.Color(239, 167, 0));
        kuning_card_RK1.setRoundBottomLeft(40);
        kuning_card_RK1.setRoundBottomRight(40);
        kuning_card_RK1.setRoundTopLeft(40);
        kuning_card_RK1.setRoundTopRight(40);

        labelRiwayatTransaksi.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        labelRiwayatTransaksi.setText("Keuangan Mingguan");

        javax.swing.GroupLayout kuning_card_RK1Layout = new javax.swing.GroupLayout(kuning_card_RK1);
        kuning_card_RK1.setLayout(kuning_card_RK1Layout);
        kuning_card_RK1Layout.setHorizontalGroup(
            kuning_card_RK1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kuning_card_RK1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelRiwayatTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        kuning_card_RK1Layout.setVerticalGroup(
            kuning_card_RK1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kuning_card_RK1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(labelRiwayatTransaksi)
                .addGap(12, 12, 12))
        );

        TabelKeuanganMingguan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null},
                {"", null, null, null, null},
                {"", null, null, null, null},
                {"", null, null, null, null}
            },
            new String [] {
                "Minggu", "Pemasukan", "Pengeluaran", "Laba", "Aksi"
            }
        ));
        jScrollPane2.setViewportView(TabelKeuanganMingguan);

        shapecustom2.setBackground(new java.awt.Color(239, 167, 0));
        shapecustom2.setRoundBottomLeft(20);
        shapecustom2.setRoundBottomRight(20);
        shapecustom2.setRoundTopLeft(20);
        shapecustom2.setRoundTopRight(20);

        jComboBox1.setBackground(new java.awt.Color(239, 167, 0));
        jComboBox1.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Bulan--", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout shapecustom2Layout = new javax.swing.GroupLayout(shapecustom2);
        shapecustom2.setLayout(shapecustom2Layout);
        shapecustom2Layout.setHorizontalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        shapecustom2Layout.setVerticalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout whiteBgLayout = new javax.swing.GroupLayout(whiteBg);
        whiteBg.setLayout(whiteBgLayout);
        whiteBgLayout.setHorizontalGroup(
            whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteBgLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(whiteBgLayout.createSequentialGroup()
                        .addComponent(kuning_card_RK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(shapecustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, whiteBgLayout.createSequentialGroup()
                        .addGroup(whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kuning_card_RK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hijau_card_RK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hijau_card_RO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kuning_card_RO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        whiteBgLayout.setVerticalGroup(
            whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteBgLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kuning_card_RO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kuning_card_RK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hijau_card_RO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hijau_card_RK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(whiteBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kuning_card_RK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapecustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(whiteBg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(whiteBg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JmlPelangganDlmAngka;
    private javax.swing.JLabel JmlTransaksiDlmAngka;
    private com.ananta.shapecustom.JTaabel TabelKeuanganMingguan;
    private com.ananta.shapecustom.shapecustom hijau_card_RK;
    private com.ananta.shapecustom.shapecustom hijau_card_RO;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.ananta.shapecustom.shapecustom kuning_card_RK;
    private com.ananta.shapecustom.shapecustom kuning_card_RK1;
    private com.ananta.shapecustom.shapecustom kuning_card_RO;
    private javax.swing.JLabel labaDlmRupiah;
    private javax.swing.JLabel labelJmlPelanggan;
    private javax.swing.JLabel labelJmlTransaksi;
    private javax.swing.JLabel labelLabaBersih;
    private javax.swing.JLabel labelPemasukan;
    private javax.swing.JLabel labelPengeluaran;
    private javax.swing.JLabel labelRiwayatTransaksi;
    private javax.swing.JLabel labelTerlaris;
    private javax.swing.JLabel label_RK;
    private javax.swing.JLabel label_RO;
    private javax.swing.JLabel pemasukanDlmRupiah;
    private javax.swing.JLabel pengeluaranDlmRupiah;
    private javax.swing.JLabel produkTerlaris;
    private com.ananta.shapecustom.shapecustom shapecustom2;
    private com.ananta.shapecustom.shapecustom whiteBg;
    // End of variables declaration//GEN-END:variables
}
