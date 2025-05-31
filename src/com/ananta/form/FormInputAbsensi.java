package com.ananta.form;

import com.ananta.database.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class FormInputAbsensi extends javax.swing.JDialog {

    private Connection con;

    public FormInputAbsensi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ComboBox_Status = new com.ananta.shape.CustomComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        shapecustom1 = new com.ananta.shape.shapecustom();
        Text_RFID = new javax.swing.JTextField();
        shapecustom2 = new com.ananta.shape.shapecustom();
        Text_Nama = new javax.swing.JTextField();
        shapecustom3 = new com.ananta.shape.shapecustom();
        Text_JamMasuk = new javax.swing.JTextField();
        shapecustom4 = new com.ananta.shape.shapecustom();
        Text_JamPulang = new javax.swing.JTextField();
        J_TanggalAbsen = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 252, 252));

        jPanel2.setBackground(new java.awt.Color(255, 252, 252));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 1));
        jLabel2.setText("RFID");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 1));
        jLabel3.setText("Status");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 1));
        jLabel4.setText("Jam Masuk");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 1));
        jLabel5.setText("Jam Pulang");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 1));
        jLabel6.setText("Tanggal");

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 1));
        jLabel7.setText("Nama");

        ComboBox_Status.setForeground(new java.awt.Color(0, 0, 1));
        ComboBox_Status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Status", "Masuk" }));
        ComboBox_Status.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(1, 121, 6));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 252, 252));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Absensi Karyawan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        shapecustom1.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom1.setRoundBottomLeft(15);
        shapecustom1.setRoundBottomRight(15);
        shapecustom1.setRoundTopLeft(15);
        shapecustom1.setRoundTopRight(15);

        Text_RFID.setBackground(new java.awt.Color(212, 212, 212));
        Text_RFID.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_RFID.setForeground(new java.awt.Color(0, 0, 1));
        Text_RFID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Text_RFID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Text_RFIDKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout shapecustom1Layout = new javax.swing.GroupLayout(shapecustom1);
        shapecustom1.setLayout(shapecustom1Layout);
        shapecustom1Layout.setHorizontalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Text_RFID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        shapecustom1Layout.setVerticalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_RFID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        shapecustom2.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom2.setRoundBottomLeft(15);
        shapecustom2.setRoundBottomRight(15);
        shapecustom2.setRoundTopLeft(15);
        shapecustom2.setRoundTopRight(15);

        Text_Nama.setBackground(new java.awt.Color(212, 212, 212));
        Text_Nama.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_Nama.setForeground(new java.awt.Color(0, 0, 1));
        Text_Nama.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom2Layout = new javax.swing.GroupLayout(shapecustom2);
        shapecustom2.setLayout(shapecustom2Layout);
        shapecustom2Layout.setHorizontalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Text_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        shapecustom2Layout.setVerticalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_Nama, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        shapecustom3.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom3.setRoundBottomLeft(15);
        shapecustom3.setRoundBottomRight(15);
        shapecustom3.setRoundTopLeft(15);
        shapecustom3.setRoundTopRight(15);

        Text_JamMasuk.setBackground(new java.awt.Color(212, 212, 212));
        Text_JamMasuk.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_JamMasuk.setForeground(new java.awt.Color(0, 0, 1));
        Text_JamMasuk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom3Layout = new javax.swing.GroupLayout(shapecustom3);
        shapecustom3.setLayout(shapecustom3Layout);
        shapecustom3Layout.setHorizontalGroup(
            shapecustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Text_JamMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        shapecustom3Layout.setVerticalGroup(
            shapecustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_JamMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        shapecustom4.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom4.setRoundBottomLeft(15);
        shapecustom4.setRoundBottomRight(15);
        shapecustom4.setRoundTopLeft(15);
        shapecustom4.setRoundTopRight(15);

        Text_JamPulang.setBackground(new java.awt.Color(212, 212, 212));
        Text_JamPulang.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_JamPulang.setForeground(new java.awt.Color(0, 0, 1));
        Text_JamPulang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom4Layout = new javax.swing.GroupLayout(shapecustom4);
        shapecustom4.setLayout(shapecustom4Layout);
        shapecustom4Layout.setHorizontalGroup(
            shapecustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Text_JamPulang, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        shapecustom4Layout.setVerticalGroup(
            shapecustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_JamPulang, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        J_TanggalAbsen.setBackground(new java.awt.Color(212, 212, 212));
        J_TanggalAbsen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        J_TanggalAbsen.setForeground(new java.awt.Color(0, 0, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboBox_Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shapecustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shapecustom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shapecustom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shapecustom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(J_TanggalAbsen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapecustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapecustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shapecustom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapecustom4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(J_TanggalAbsen, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isProcessing = false;

    private void Text_RFIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Text_RFIDKeyReleased
        String rfid = Text_RFID.getText().trim();

        // Misalnya panjang tag RFID yang valid adalah 10 karakter
        if (rfid.length() == 10 && !isProcessing) {
            prosesAbsen(rfid);
        }
    }

    private void prosesAbsen(String rfid) {
        isProcessing = true; // Set flag agar tidak dieksekusi berulang

        try {
            Connection con = Database.getConnection();
            String sql = "SELECT id_karyawan, nama FROM karyawan WHERE rfid_tag = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, rfid);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int idKaryawan = rs.getInt("id_karyawan");
                String nama = rs.getString("nama");
                Text_Nama.setText(nama);

                Time currentTime = new Time(System.currentTimeMillis());
                Date currentDate = new Date(System.currentTimeMillis());
                J_TanggalAbsen.setDate(currentDate);

                // Cek apakah sudah absen hari ini
                String cekSql = "SELECT waktu_masuk, waktu_keluar FROM absensi WHERE id_karyawan = ? AND tanggal = ?";
                PreparedStatement cekPs = con.prepareStatement(cekSql);
                cekPs.setInt(1, idKaryawan);
                cekPs.setDate(2, currentDate);
                ResultSet cekRs = cekPs.executeQuery();

                if (cekRs.next()) {
                    Time waktuMasuk = cekRs.getTime("waktu_masuk");
                    Time waktuPulang = cekRs.getTime("waktu_keluar");

                    if (waktuPulang == null) {
                        // Update jam pulang
                        String updateSql = "UPDATE absensi SET waktu_keluar = ? WHERE id_karyawan = ? AND tanggal = ?";
                        PreparedStatement updatePs = con.prepareStatement(updateSql);
                        updatePs.setTime(1, currentTime);
                        updatePs.setInt(2, idKaryawan);
                        updatePs.setDate(3, currentDate);
                        updatePs.executeUpdate();
                        updatePs.close();

                        ComboBox_Status.setSelectedItem("Pulang");
                        Text_JamMasuk.setText(waktuMasuk.toString());
                        JOptionPane.showMessageDialog(this, "Jam pulang berhasil diupdate!");
                        dispose(); // Tutup dialog setelah absen pulang
                    } else {
                        JOptionPane.showMessageDialog(this, "Anda sudah absen masuk dan pulang hari ini!");
                    }
                } else {
                    // Belum absen, simpan jam masuk
                    String insertSql = "INSERT INTO absensi (id_karyawan, status, waktu_masuk, tanggal) VALUES (?, ?, ?, ?)";
                    PreparedStatement insertPs = con.prepareStatement(insertSql);
                    insertPs.setInt(1, idKaryawan);
                    insertPs.setString(2, "Masuk");
                    insertPs.setTime(3, currentTime);
                    insertPs.setDate(4, currentDate);
                    insertPs.executeUpdate();
                    insertPs.close();

                    ComboBox_Status.setSelectedItem("Masuk");
                    Text_JamMasuk.setText(currentTime.toString());
                    JOptionPane.showMessageDialog(this, "Absen masuk berhasil disimpan!");
                    dispose(); // Tutup dialog setelah absen masuk
                }

                cekRs.close();
                cekPs.close();
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {
            isProcessing = false; // Reset flag agar bisa diproses lagi
        }
    }//GEN-LAST:event_Text_RFIDKeyReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormInputAbsensi dialog = new FormInputAbsensi(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ananta.shape.CustomComboBox ComboBox_Status;
    private com.toedter.calendar.JDateChooser J_TanggalAbsen;
    private javax.swing.JTextField Text_JamMasuk;
    private javax.swing.JTextField Text_JamPulang;
    private javax.swing.JTextField Text_Nama;
    private javax.swing.JTextField Text_RFID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.ananta.shape.shapecustom shapecustom1;
    private com.ananta.shape.shapecustom shapecustom2;
    private com.ananta.shape.shapecustom shapecustom3;
    private com.ananta.shape.shapecustom shapecustom4;
    // End of variables declaration//GEN-END:variables

}
