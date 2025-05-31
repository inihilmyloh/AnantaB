package com.ananta.form;

import com.ananta.database.Database;
import com.ananta.main.FormMenuUtama;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormAbsensi extends javax.swing.JPanel {

    DefaultTableModel model;
    private Connection con;

    public FormAbsensi() {
        initComponents();
        String[] judul = {"No Absensi", "Nama Karyawan", "Status", "Waktu Masuk", "Waktu Pulang", "Tanggal"};
        model = new DefaultTableModel(judul, 0);
        Tabel_Data.setModel(model);

        Tombol_Absen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tombol_Hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tombol_Perizinan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        DataAbsensi();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Tombol_Absen = new com.ananta.shape.CustomButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel_Data = new com.ananta.shape.JTabeel();
        Tombol_Perizinan = new com.ananta.shape.CustomButton();
        shapecustom2 = new com.ananta.shape.shapecustom();
        jLabel3 = new javax.swing.JLabel();
        Text_Pencarian = new javax.swing.JTextField();
        Tombol_Hapus = new com.ananta.shape.CustomButton();

        setBackground(new java.awt.Color(212, 212, 212));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 1));
        jLabel1.setText("Absensi");

        jSeparator1.setForeground(new java.awt.Color(255, 250, 250));

        Tombol_Absen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_Absen.png"))); // NOI18N
        Tombol_Absen.setText("Absen");
        Tombol_Absen.setDefaultColor(new java.awt.Color(51, 204, 0));
        Tombol_Absen.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Tombol_Absen.setHoverColor(new java.awt.Color(51, 153, 0));
        Tombol_Absen.setPressedColor(new java.awt.Color(51, 102, 0));
        Tombol_Absen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_AbsenMouseClicked(evt);
            }
        });
        Tombol_Absen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tombol_AbsenActionPerformed(evt);
            }
        });

        Tabel_Data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabel_Data);

        Tombol_Perizinan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_Perizinan.png"))); // NOI18N
        Tombol_Perizinan.setText("Perizinan");
        Tombol_Perizinan.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Tombol_Perizinan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_PerizinanMouseClicked(evt);
            }
        });

        shapecustom2.setBackground(new java.awt.Color(255, 252, 252));
        shapecustom2.setRoundBottomLeft(20);
        shapecustom2.setRoundBottomRight(20);
        shapecustom2.setRoundTopLeft(20);
        shapecustom2.setRoundTopRight(20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_search.png"))); // NOI18N

        Text_Pencarian.setBackground(new java.awt.Color(255, 252, 252));
        Text_Pencarian.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_Pencarian.setForeground(new java.awt.Color(0, 0, 1));
        Text_Pencarian.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Text_Pencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Text_PencarianKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Text_PencarianKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout shapecustom2Layout = new javax.swing.GroupLayout(shapecustom2);
        shapecustom2.setLayout(shapecustom2Layout);
        shapecustom2Layout.setHorizontalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text_Pencarian, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );
        shapecustom2Layout.setVerticalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Text_Pencarian))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tombol_Hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_hapus.png"))); // NOI18N
        Tombol_Hapus.setText("Hapus");
        Tombol_Hapus.setDefaultColor(new java.awt.Color(255, 51, 51));
        Tombol_Hapus.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Tombol_Hapus.setHoverColor(new java.awt.Color(255, 0, 0));
        Tombol_Hapus.setPressedColor(new java.awt.Color(153, 0, 0));
        Tombol_Hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_HapusMouseClicked(evt);
            }
        });
        Tombol_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tombol_HapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Tombol_Absen, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Tombol_Perizinan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Tombol_Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(768, 768, 768)
                        .addComponent(shapecustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Tombol_Absen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Tombol_Perizinan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Tombol_Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(shapecustom2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Tombol_AbsenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_AbsenMouseClicked
        FormMenuUtama menu = new FormMenuUtama();
        FormInputAbsensi dialog = new FormInputAbsensi(menu, true);
        dialog.setLocationRelativeTo(menu);
        dialog.setVisible(true);

        DataAbsensi();
    }//GEN-LAST:event_Tombol_AbsenMouseClicked

    private void Tombol_PerizinanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_PerizinanMouseClicked
        FormMenuUtama menu = new FormMenuUtama();
        FormPerizinan dialog = new FormPerizinan(menu, true);
        dialog.setLocationRelativeTo(menu);
        dialog.setVisible(true);

        DataAbsensi();
    }//GEN-LAST:event_Tombol_PerizinanMouseClicked

    private void Tombol_AbsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tombol_AbsenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tombol_AbsenActionPerformed

    private void Text_PencarianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Text_PencarianKeyTyped
        
    }//GEN-LAST:event_Text_PencarianKeyTyped

    private void Text_PencarianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Text_PencarianKeyReleased
        String keyword = Text_Pencarian.getText().trim();
        DefaultTableModel model = (DefaultTableModel) Tabel_Data.getModel();
        model.setRowCount(0); // Kosongkan tabel sebelum isi data baru

        try {
            Connection con = Database.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM absensi INNER JOIN karyawan ON absensi.id_karyawan = karyawan.id_karyawan "
                + "WHERE nama LIKE ? OR status LIKE ? OR tanggal LIKE ?";
                PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1, "%" + keyword + "%");
                stat.setString(2, "%" + keyword + "%");
                stat.setString(3, "%" + keyword + "%");

                ResultSet rs = stat.executeQuery();

                while (rs.next()) {
                    int idabsensi = rs.getInt("id_absensi");
                    String namakaryawan = rs.getString("nama");
                    String status = rs.getString("status");
                    Time waktumasuk = rs.getTime("waktu_masuk");
                    Time waktukeluar = rs.getTime("waktu_keluar");
                    Date tanggal = rs.getDate("tanggal");

                    Object[] rowData = {idabsensi, namakaryawan, status, waktumasuk, waktukeluar, tanggal};
                    model.addRow(rowData);
                }

                rs.close();
                stat.close();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Koneksi Ke Database");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_Text_PencarianKeyReleased

    private void Tombol_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tombol_HapusActionPerformed

    }//GEN-LAST:event_Tombol_HapusActionPerformed

    private void Tombol_HapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_HapusMouseClicked
        int selectedRow = Tabel_Data.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus terlebih dahulu.");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (konfirmasi != JOptionPane.YES_OPTION) {
            return;
        }

        DefaultTableModel model = (DefaultTableModel) Tabel_Data.getModel();
        int idAbsensi = (int) model.getValueAt(selectedRow, 0); // Kolom 0 = id_absensi

        try {
            Connection con = Database.getConnection();
            if (con != null) {
                String sql = "DELETE FROM absensi WHERE id_absensi = ?";
                PreparedStatement stat = con.prepareStatement(sql);
                stat.setInt(1, idAbsensi);

                int rowsDeleted = stat.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
                    DataAbsensi(); // Refresh data di tabel
                } else {
                    JOptionPane.showMessageDialog(null, "Data gagal dihapus.");
                }

                stat.close();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal koneksi ke database.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_Tombol_HapusMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ananta.shape.JTabeel Tabel_Data;
    private javax.swing.JTextField Text_Pencarian;
    private com.ananta.shape.CustomButton Tombol_Absen;
    private com.ananta.shape.CustomButton Tombol_Hapus;
    private com.ananta.shape.CustomButton Tombol_Perizinan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.ananta.shape.shapecustom shapecustom2;
    // End of variables declaration//GEN-END:variables

    private void DataAbsensi() {
        DefaultTableModel model = (DefaultTableModel) Tabel_Data.getModel();
        model.setRowCount(0);

        try {
            Connection con = Database.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM absensi INNER JOIN karyawan ON absensi.id_karyawan = karyawan.id_karyawan";
                PreparedStatement stat = con.prepareStatement(sql);
                ResultSet rs = stat.executeQuery();

                while (rs.next()) {
                    int idabsensi = rs.getInt("id_absensi");
                    String namakaryawan = rs.getString("nama");

                    String status = rs.getString("status");
                    Time waktumasuk = rs.getTime("waktu_masuk");
                    Time waktukeluar = rs.getTime("waktu_keluar");
                    Date tanggal = rs.getDate("tanggal");

                    Object[] rowData = {idabsensi, namakaryawan, status, waktumasuk, waktukeluar, tanggal};
                    model.addRow(rowData);
                }

                rs.close();
                stat.close();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Koneksi Ke Database");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
