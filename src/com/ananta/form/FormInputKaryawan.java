package com.ananta.form;

import com.ananta.dao.KaryawanDAO;
import com.ananta.model.ModelKaryawan;
import com.ananta.service.ServiceKaryawan;
import com.ananta.tablemodel.TableModelKaryawan;
import java.util.List;
import javax.swing.JOptionPane;

public class FormInputKaryawan extends javax.swing.JDialog {

    private final TableModelKaryawan tblModel = new TableModelKaryawan();
    private ServiceKaryawan servis = new KaryawanDAO();
    private ModelKaryawan karyawan;
    private int IdKaryawan;
    private int row;

    public FormInputKaryawan(java.awt.Frame parent, boolean modal, int row, ModelKaryawan karyawan) {
        super(parent, modal);
        this.karyawan = karyawan;
        this.row = row;
        initComponents();
        setLocationRelativeTo(null);

        if (karyawan != null) {
            this.IdKaryawan = karyawan.getIdKaryawan();
            dataTabel();
        }
        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shapecustom1 = new com.ananta.shape.shapecustom();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        shapecustom2 = new com.ananta.shape.shapecustom();
        Text_RFID = new javax.swing.JTextField();
        shapecustom3 = new com.ananta.shape.shapecustom();
        Text_Nama = new javax.swing.JTextField();
        shapecustom5 = new com.ananta.shape.shapecustom();
        Text_NoTelp = new javax.swing.JTextField();
        ComboBox_Posisi = new com.ananta.shape.CustomComboBox();
        Tombol_Simpan = new com.ananta.shape.CustomButton();
        Tombol_Batal = new com.ananta.shape.CustomButton();
        shapecustom4 = new com.ananta.shape.shapecustom();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        shapecustom1.setBackground(new java.awt.Color(255, 252, 252));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 1));
        jLabel2.setText("Nama");

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 1));
        jLabel1.setText("RFID");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 1));
        jLabel3.setText("Posisi");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 1));
        jLabel4.setText("No Telp");

        shapecustom2.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom2.setRoundBottomLeft(15);
        shapecustom2.setRoundBottomRight(15);
        shapecustom2.setRoundTopLeft(15);
        shapecustom2.setRoundTopRight(15);

        Text_RFID.setBackground(new java.awt.Color(212, 212, 212));
        Text_RFID.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_RFID.setForeground(new java.awt.Color(0, 0, 1));
        Text_RFID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom2Layout = new javax.swing.GroupLayout(shapecustom2);
        shapecustom2.setLayout(shapecustom2Layout);
        shapecustom2Layout.setHorizontalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(Text_RFID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        shapecustom2Layout.setVerticalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_RFID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        shapecustom3.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom3.setRoundBottomLeft(15);
        shapecustom3.setRoundBottomRight(15);
        shapecustom3.setRoundTopLeft(15);
        shapecustom3.setRoundTopRight(15);

        Text_Nama.setBackground(new java.awt.Color(212, 212, 212));
        Text_Nama.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_Nama.setForeground(new java.awt.Color(0, 0, 1));
        Text_Nama.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom3Layout = new javax.swing.GroupLayout(shapecustom3);
        shapecustom3.setLayout(shapecustom3Layout);
        shapecustom3Layout.setHorizontalGroup(
            shapecustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Text_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        shapecustom3Layout.setVerticalGroup(
            shapecustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_Nama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        shapecustom5.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom5.setRoundBottomLeft(15);
        shapecustom5.setRoundBottomRight(15);
        shapecustom5.setRoundTopLeft(15);
        shapecustom5.setRoundTopRight(15);

        Text_NoTelp.setBackground(new java.awt.Color(212, 212, 212));
        Text_NoTelp.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_NoTelp.setForeground(new java.awt.Color(0, 0, 1));
        Text_NoTelp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom5Layout = new javax.swing.GroupLayout(shapecustom5);
        shapecustom5.setLayout(shapecustom5Layout);
        shapecustom5Layout.setHorizontalGroup(
            shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Text_NoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        shapecustom5Layout.setVerticalGroup(
            shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_NoTelp)
        );

        ComboBox_Posisi.setForeground(new java.awt.Color(0, 0, 1));
        ComboBox_Posisi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Opsi", "Kasir", "Barber" }));
        ComboBox_Posisi.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N

        Tombol_Simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_simpan.png"))); // NOI18N
        Tombol_Simpan.setText("Simpan");
        Tombol_Simpan.setDefaultColor(new java.awt.Color(51, 204, 0));
        Tombol_Simpan.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Tombol_Simpan.setHoverColor(new java.awt.Color(51, 153, 0));
        Tombol_Simpan.setMaximumSize(new java.awt.Dimension(128, 30));
        Tombol_Simpan.setMinimumSize(new java.awt.Dimension(128, 30));
        Tombol_Simpan.setPressedColor(new java.awt.Color(51, 102, 0));
        Tombol_Simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_SimpanMouseClicked(evt);
            }
        });
        Tombol_Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tombol_SimpanActionPerformed(evt);
            }
        });

        Tombol_Batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_batal.png"))); // NOI18N
        Tombol_Batal.setText("Batal");
        Tombol_Batal.setDefaultColor(new java.awt.Color(255, 153, 0));
        Tombol_Batal.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Tombol_Batal.setHoverColor(new java.awt.Color(255, 102, 0));
        Tombol_Batal.setPressedColor(new java.awt.Color(204, 102, 0));
        Tombol_Batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_BatalMouseClicked(evt);
            }
        });

        shapecustom4.setBackground(new java.awt.Color(1, 121, 6));

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 252, 252));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tambah Karyawan");

        javax.swing.GroupLayout shapecustom4Layout = new javax.swing.GroupLayout(shapecustom4);
        shapecustom4.setLayout(shapecustom4Layout);
        shapecustom4Layout.setHorizontalGroup(
            shapecustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        shapecustom4Layout.setVerticalGroup(
            shapecustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout shapecustom1Layout = new javax.swing.GroupLayout(shapecustom1);
        shapecustom1.setLayout(shapecustom1Layout);
        shapecustom1Layout.setHorizontalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(shapecustom1Layout.createSequentialGroup()
                        .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(55, 55, 55)
                        .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboBox_Posisi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shapecustom3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shapecustom2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shapecustom5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(shapecustom1Layout.createSequentialGroup()
                        .addComponent(Tombol_Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Tombol_Batal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(shapecustom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        shapecustom1Layout.setVerticalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom1Layout.createSequentialGroup()
                .addComponent(shapecustom4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shapecustom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapecustom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(ComboBox_Posisi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(shapecustom5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tombol_Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tombol_Batal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shapecustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shapecustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tombol_SimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_SimpanMouseClicked
        if(Tombol_Simpan.getText().equals("Simpan")) {
            simpanData();
        } else if (Tombol_Simpan.getText().equals("Perbarui")) {
            perbaruiData();
        }       
    }//GEN-LAST:event_Tombol_SimpanMouseClicked

    private void Tombol_BatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_BatalMouseClicked
        if (Tombol_Simpan.getText().equals("Simpan")) {
            resetForm();
        } else if (Tombol_Simpan.getText().equals("Perbarui")) {
            dispose();
        }
    }//GEN-LAST:event_Tombol_BatalMouseClicked

    private void Tombol_SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tombol_SimpanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tombol_SimpanActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormInputKaryawan dialog = new FormInputKaryawan(new javax.swing.JFrame(), true, 1, null);
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
    private com.ananta.shape.CustomComboBox ComboBox_Posisi;
    private javax.swing.JTextField Text_Nama;
    private javax.swing.JTextField Text_NoTelp;
    private javax.swing.JTextField Text_RFID;
    private com.ananta.shape.CustomButton Tombol_Batal;
    private com.ananta.shape.CustomButton Tombol_Simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.ananta.shape.shapecustom shapecustom1;
    private com.ananta.shape.shapecustom shapecustom2;
    private com.ananta.shape.shapecustom shapecustom3;
    private com.ananta.shape.shapecustom shapecustom4;
    private com.ananta.shape.shapecustom shapecustom5;
    // End of variables declaration//GEN-END:variables

    private boolean validasiInput() {
        boolean valid = false;
        if (Text_RFID.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "RFID Karyawan tidak boleh kosong");
        } else if (Text_Nama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama Karyawan tidak boleh kosong");
        } else if (ComboBox_Posisi.getSelectedItem().equals("Pilih Posisi")) {
            JOptionPane.showMessageDialog(null, "Harap pilih Posisi Karyawan");
        } else if (Text_NoTelp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Telp Karyawan tidak boleh kosong");
        } else {
            valid = true;
        }
        return valid;
    }

    private void simpanData() {
        if (validasiInput() == true) {
            String rfid = Text_RFID.getText();
            String nama = Text_Nama.getText();
            String posisi = ComboBox_Posisi.getSelectedItem().toString();
            String notelp = Text_NoTelp.getText();

            ModelKaryawan karyawan = new ModelKaryawan();
            karyawan.setRFID(rfid);
            karyawan.setNama(nama);
            karyawan.setPosisi(posisi);
            karyawan.setNoTelp(notelp);

            servis.tambahData(karyawan);
            tblModel.insertData(karyawan);
            resetForm();
            dispose();
        }
    }

    private void resetForm() {
        Text_RFID.setText("");
        Text_Nama.setText("");
        ComboBox_Posisi.setSelectedIndex(0);
        Text_NoTelp.setText("");
    }

    private void dataTabel() {
        Tombol_Simpan.setText("Perbarui");
        Text_RFID.setText(karyawan.getRFID());
        Text_Nama.setText(karyawan.getNama());
        ComboBox_Posisi.setSelectedItem(karyawan.getPosisi());
        Text_NoTelp.setText(karyawan.getNoTelp());
    }

    private void loadData() {
        List<ModelKaryawan> list = servis.tampilData();
        tblModel.setData(list);
    }

    private void perbaruiData() {
        if (validasiInput() == true) {
            String rfid = Text_RFID.getText();
            String nama = Text_Nama.getText();
            String posisi = ComboBox_Posisi.getSelectedItem().toString();
            String notelp = Text_NoTelp.getText();

            ModelKaryawan karyawan = new ModelKaryawan();
            karyawan.setIdKaryawan(IdKaryawan);
            karyawan.setRFID(rfid);
            karyawan.setNama(nama);
            karyawan.setPosisi(posisi);
            karyawan.setNoTelp(notelp);

            servis.perbaruiData(karyawan);
            tblModel.updateData(row, karyawan);
            resetForm();
            dispose();
        }
    }
}
