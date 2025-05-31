package com.ananta.form;

import com.ananta.database.Database;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class FormPerizinan extends javax.swing.JDialog {

    private Connection con;

    public FormPerizinan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        shapecustom1 = new com.ananta.shape.shapecustom();
        Text_RFID = new javax.swing.JTextField();
        shapecustom2 = new com.ananta.shape.shapecustom();
        Text_Nama = new javax.swing.JTextField();
        ComboBox_Status = new com.ananta.shape.CustomComboBox();
        Tombol_Simpan = new com.ananta.shape.CustomButton();
        J_TanggalAbsen = new com.toedter.calendar.JDateChooser();
        Tombol_Batal = new com.ananta.shape.CustomButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(1, 121, 6));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 252, 252));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Perizinan Karyawan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 1));
        jLabel2.setText("RFID");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 1));
        jLabel4.setText("Status");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 1));
        jLabel5.setText("Tanggal");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 1));
        jLabel6.setText("Nama");

        shapecustom1.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom1.setRoundBottomLeft(15);
        shapecustom1.setRoundBottomRight(15);
        shapecustom1.setRoundTopLeft(15);
        shapecustom1.setRoundTopRight(15);

        Text_RFID.setBackground(new java.awt.Color(212, 212, 212));
        Text_RFID.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
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
                .addGap(14, 14, 14)
                .addComponent(Text_RFID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        Text_Nama.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom2Layout = new javax.swing.GroupLayout(shapecustom2);
        shapecustom2.setLayout(shapecustom2Layout);
        shapecustom2Layout.setHorizontalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Text_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        shapecustom2Layout.setVerticalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_Nama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        ComboBox_Status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Status", "Izin", "Sakit" }));
        ComboBox_Status.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N

        Tombol_Simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_simpan.png"))); // NOI18N
        Tombol_Simpan.setText("Simpan");
        Tombol_Simpan.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Tombol_Simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_SimpanMouseClicked(evt);
            }
        });

        J_TanggalAbsen.setBackground(new java.awt.Color(212, 212, 212));
        J_TanggalAbsen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        J_TanggalAbsen.setForeground(new java.awt.Color(0, 0, 1));

        Tombol_Batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_batal.png"))); // NOI18N
        Tombol_Batal.setText(" Batal");
        Tombol_Batal.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Tombol_Batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_BatalMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Tombol_Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Tombol_Batal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(shapecustom2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(J_TanggalAbsen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBox_Status, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shapecustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapecustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapecustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(J_TanggalAbsen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tombol_Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tombol_Batal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tombol_SimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_SimpanMouseClicked
        String rfid = Text_RFID.getText().trim();
        if (!rfid.isEmpty()) {
            try {
                Connection con = Database.getConnection();

                LocalDate localDate = LocalDate.now();
                java.sql.Date currentDate = java.sql.Date.valueOf(localDate);

                String sql = "SELECT id_karyawan, nama FROM karyawan WHERE rfid_tag = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, rfid);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int idKaryawan = rs.getInt("id_karyawan");
                    String nama = rs.getString("nama");
                    Text_Nama.setText(nama);
                    J_TanggalAbsen.setDate(currentDate);

                    Object selectedItem = ComboBox_Status.getSelectedItem();
                    String status = (selectedItem != null) ? selectedItem.toString() : "";

                    // Cek status dipilih atau tidak
                    if (status.equals("-- Pilih Status --") || status.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Silakan pilih status terlebih dahulu!");
                        rs.close();
                        ps.close();
                        return; // Penting agar proses berhenti
                    }

                    // Cek apakah sudah absen hari ini
                    String cekSql = "SELECT * FROM absensi WHERE id_karyawan = ? AND tanggal = ?";
                    PreparedStatement cekPs = con.prepareStatement(cekSql);
                    cekPs.setInt(1, idKaryawan);
                    cekPs.setDate(2, currentDate);
                    ResultSet cekRs = cekPs.executeQuery();

                    if (cekRs.next()) {
                        JOptionPane.showMessageDialog(this, "Anda sudah absen hari ini!");
                    } else {
                        String insertSql = "INSERT INTO absensi (id_karyawan, tanggal, status) VALUES (?, ?, ?)";
                        PreparedStatement insertPs = con.prepareStatement(insertSql);
                        insertPs.setInt(1, idKaryawan);
                        insertPs.setDate(2, currentDate);
                        insertPs.setString(3, status);
                        insertPs.executeUpdate();
                        insertPs.close();

                        JOptionPane.showMessageDialog(this, "Absensi berhasil disimpan!");
                        dispose();
                    }

                    cekRs.close();
                    cekPs.close();
                } else {
                    JOptionPane.showMessageDialog(this, "RFID tidak ditemukan!");
                }

                rs.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_Tombol_SimpanMouseClicked

    private void Tombol_BatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_BatalMouseClicked
        resetForm();
    }//GEN-LAST:event_Tombol_BatalMouseClicked

    private void Text_RFIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Text_RFIDKeyReleased
        String rfid = Text_RFID.getText().trim();
        if (!rfid.isEmpty()) {
            try {
                Connection con = Database.getConnection();
                String sql = "SELECT nama FROM karyawan WHERE rfid_tag = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, rfid);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String nama = rs.getString("nama");
                    Text_Nama.setText(nama);

                    // Ubah LocalDate ke java.util.Date
                    LocalDate tanggalHariIni = LocalDate.now();
                    Date date = java.sql.Date.valueOf(tanggalHariIni);
                    J_TanggalAbsen.setDate(date);
                } else {
                    Text_Nama.setText("");
                    J_TanggalAbsen.setDate(null);
                }

                rs.close();
                ps.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error saat mencari nama: " + e.getMessage());
            }
        } else {
            Text_Nama.setText("");
            J_TanggalAbsen.setDate(null);
        }
    }//GEN-LAST:event_Text_RFIDKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormPerizinan dialog = new FormPerizinan(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField Text_Nama;
    private javax.swing.JTextField Text_RFID;
    private com.ananta.shape.CustomButton Tombol_Batal;
    private com.ananta.shape.CustomButton Tombol_Simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.ananta.shape.shapecustom shapecustom1;
    private com.ananta.shape.shapecustom shapecustom2;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        Text_RFID.setText("");
        Text_Nama.setText("");
        ComboBox_Status.setSelectedItem("");
        J_TanggalAbsen.setDate(null);
    }
}
