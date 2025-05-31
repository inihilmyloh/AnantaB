package com.ananta.form;

import com.ananta.dao.JasaDAO;
import com.ananta.model.ModelJasa;
import com.ananta.service.ServiceJasa;
import com.ananta.tablemodel.TableModelJasa;
import java.util.List;
import javax.swing.JOptionPane;

public class FormInputJasa extends javax.swing.JDialog {
    
    private final TableModelJasa tblModel = new TableModelJasa();
    private ServiceJasa servis = new JasaDAO();
    private ModelJasa jasa;
    private int IdJasa;
    private int row;

    public FormInputJasa(java.awt.Frame parent, boolean modal, int row, ModelJasa jasa) {
        super(parent, modal);
        initComponents();
        Tombol_Simpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tombol_Batal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.jasa = jasa;
        this.row = row;
        setLocationRelativeTo(null);

        if (jasa != null) {
            this.IdJasa = jasa.getIdJasa(); // Menyimpan ID Jasa dari objek jasa
            dataTabel();
        }
        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Tombol_Simpan = new com.ananta.shape.CustomButton();
        Tombol_Batal = new com.ananta.shape.CustomButton();
        shapecustom1 = new com.ananta.shape.shapecustom();
        Text_Nama = new javax.swing.JTextField();
        shapecustom2 = new com.ananta.shape.shapecustom();
        Text_Harga = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(1, 121, 6));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tambah Jasa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 1));
        jLabel2.setText("Nama Jasa");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 1));
        jLabel3.setText("Harga");

        Tombol_Simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_simpan.png"))); // NOI18N
        Tombol_Simpan.setText("Simpan");
        Tombol_Simpan.setDefaultColor(new java.awt.Color(51, 204, 0));
        Tombol_Simpan.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Tombol_Simpan.setHoverColor(new java.awt.Color(51, 153, 0));
        Tombol_Simpan.setPressedColor(new java.awt.Color(51, 102, 0));
        Tombol_Simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_SimpanMouseClicked(evt);
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

        shapecustom1.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom1.setRoundBottomLeft(15);
        shapecustom1.setRoundBottomRight(15);
        shapecustom1.setRoundTopLeft(15);
        shapecustom1.setRoundTopRight(15);

        Text_Nama.setBackground(new java.awt.Color(212, 212, 212));
        Text_Nama.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_Nama.setForeground(new java.awt.Color(0, 0, 1));
        Text_Nama.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom1Layout = new javax.swing.GroupLayout(shapecustom1);
        shapecustom1.setLayout(shapecustom1Layout);
        shapecustom1Layout.setHorizontalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Text_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        shapecustom1Layout.setVerticalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_Nama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        shapecustom2.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom2.setRoundBottomLeft(15);
        shapecustom2.setRoundBottomRight(15);
        shapecustom2.setRoundTopLeft(15);
        shapecustom2.setRoundTopRight(15);

        Text_Harga.setBackground(new java.awt.Color(212, 212, 212));
        Text_Harga.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_Harga.setForeground(new java.awt.Color(0, 0, 1));
        Text_Harga.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom2Layout = new javax.swing.GroupLayout(shapecustom2);
        shapecustom2.setLayout(shapecustom2Layout);
        shapecustom2Layout.setHorizontalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Text_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        shapecustom2Layout.setVerticalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_Harga, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Tombol_Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Tombol_Batal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(shapecustom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shapecustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(shapecustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shapecustom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tombol_Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tombol_Batal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
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
        if (Tombol_Simpan.getText().equals("Simpan")) {
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

    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormInputJasa dialog = new FormInputJasa(new javax.swing.JFrame(), true, 1, null);
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
    private javax.swing.JTextField Text_Harga;
    private javax.swing.JTextField Text_Nama;
    private com.ananta.shape.CustomButton Tombol_Batal;
    private com.ananta.shape.CustomButton Tombol_Simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.ananta.shape.shapecustom shapecustom1;
    private com.ananta.shape.shapecustom shapecustom2;
    // End of variables declaration//GEN-END:variables

    private boolean validasiInput() {
        boolean valid = false;
        if (Text_Nama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama Jasa tidak boleh kosong");
        } else if (Text_Harga.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harga Jasa tidak boleh kosong");
        } else {
            valid = true;
        }
        return valid;
    }

    private void simpanData() {
        if (validasiInput() == true) {
            String nama = Text_Nama.getText();
            String harga = Text_Harga.getText();

            try {
                int Harga = Integer.parseInt(harga);

                ModelJasa jasa = new ModelJasa();
                jasa.setNama(nama);
                jasa.setHarga(Harga);

                servis.tambahData(jasa);
                tblModel.insertData(jasa);
                resetForm();
                dispose();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Harga harus berupa angka!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void resetForm() {
        Text_Nama.setText("");
        Text_Harga.setText("");
    }

    private void dataTabel() {
        Tombol_Simpan.setText("Perbarui");
        Text_Nama.setText(jasa.getNama());
        Text_Harga.setText(String.valueOf(jasa.getHarga()));
    }

    private void loadData() {
        List<ModelJasa> list = servis.tampilData();
        tblModel.setData(list);
    }

    private void perbaruiData() {
         if (validasiInput() == true) {
            String nama = Text_Nama.getText();
            String hargaText = Text_Harga.getText();

            try {
                int harga = Integer.parseInt(hargaText);

                ModelJasa jasa = new ModelJasa();
                jasa.setIdJasa(IdJasa);
                jasa.setNama(nama);
                jasa.setHarga(harga);

                servis.perbaruiData(jasa);
                tblModel.updateData(row, jasa);
                resetForm();
                dispose(); // hanya jika berhasil
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Harga harus berupa angka!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}