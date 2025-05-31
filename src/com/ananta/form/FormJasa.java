package com.ananta.form;

import com.ananta.tablemodel.TableModelJasa;
import com.ananta.service.ServiceJasa;
import com.ananta.dao.JasaDAO;
import com.ananta.model.ModelJasa;
import java.util.List;
import javax.swing.JOptionPane;

public class FormJasa extends javax.swing.JPanel {

    private final TableModelJasa tblModel = new TableModelJasa();
    private final ServiceJasa servis = new JasaDAO();
    
    public FormJasa() {
        initComponents();
        Tabel_Data.setModel(tblModel);
        loadData();
        
        Tombol_Tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tombol_Hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tombol_Perbarui.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Tombol_Tambah = new com.ananta.shape.CustomButton();
        Tombol_Perbarui = new com.ananta.shape.CustomButton();
        Tombol_Hapus = new com.ananta.shape.CustomButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel_Data = new com.ananta.shape.JTabeel();
        shapecustom1 = new com.ananta.shape.shapecustom();
        jLabel2 = new javax.swing.JLabel();
        Text_Pencarian = new javax.swing.JTextField();

        setBackground(new java.awt.Color(212, 212, 212));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 1));
        jLabel1.setText("Jasa");

        jSeparator1.setForeground(new java.awt.Color(255, 250, 253));

        Tombol_Tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_tambah.png"))); // NOI18N
        Tombol_Tambah.setText("Tambah");
        Tombol_Tambah.setDefaultColor(new java.awt.Color(51, 204, 0));
        Tombol_Tambah.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Tombol_Tambah.setHoverColor(new java.awt.Color(51, 153, 0));
        Tombol_Tambah.setPressedColor(new java.awt.Color(51, 102, 0));
        Tombol_Tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_TambahMouseClicked(evt);
            }
        });
        Tombol_Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tombol_TambahActionPerformed(evt);
            }
        });

        Tombol_Perbarui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_update.png"))); // NOI18N
        Tombol_Perbarui.setText("Perbarui");
        Tombol_Perbarui.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Tombol_Perbarui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_PerbaruiMouseClicked(evt);
            }
        });
        Tombol_Perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tombol_PerbaruiActionPerformed(evt);
            }
        });

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

        shapecustom1.setBackground(new java.awt.Color(255, 252, 252));
        shapecustom1.setRoundBottomLeft(20);
        shapecustom1.setRoundBottomRight(20);
        shapecustom1.setRoundTopLeft(20);
        shapecustom1.setRoundTopRight(20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_search.png"))); // NOI18N

        Text_Pencarian.setBackground(new java.awt.Color(252, 252, 252));
        Text_Pencarian.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_Pencarian.setForeground(new java.awt.Color(0, 0, 1));
        Text_Pencarian.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Text_Pencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Text_PencarianKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout shapecustom1Layout = new javax.swing.GroupLayout(shapecustom1);
        shapecustom1.setLayout(shapecustom1Layout);
        shapecustom1Layout.setHorizontalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text_Pencarian, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );
        shapecustom1Layout.setVerticalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Text_Pencarian))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Tombol_Tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Tombol_Perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Tombol_Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(768, 768, 768)
                        .addComponent(shapecustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(shapecustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tombol_Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tombol_Perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tombol_Tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Text_PencarianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Text_PencarianKeyTyped
        pencarianData();
    }//GEN-LAST:event_Text_PencarianKeyTyped

    private void Tombol_HapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_HapusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Tombol_HapusMouseClicked

    private void Tombol_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tombol_HapusActionPerformed
        hapusData();
    }//GEN-LAST:event_Tombol_HapusActionPerformed

    private void Tombol_TambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_TambahMouseClicked
        tambahData();
    }//GEN-LAST:event_Tombol_TambahMouseClicked

    private void Tombol_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tombol_TambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tombol_TambahActionPerformed

    private void Tombol_PerbaruiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_PerbaruiMouseClicked
        perbaruiData();
    }//GEN-LAST:event_Tombol_PerbaruiMouseClicked

    private void Tombol_PerbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tombol_PerbaruiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tombol_PerbaruiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ananta.shape.JTabeel Tabel_Data;
    private javax.swing.JTextField Text_Pencarian;
    private com.ananta.shape.CustomButton Tombol_Hapus;
    private com.ananta.shape.CustomButton Tombol_Perbarui;
    private com.ananta.shape.CustomButton Tombol_Tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.ananta.shape.shapecustom shapecustom1;
    // End of variables declaration//GEN-END:variables

    private void loadData() {
        List<ModelJasa> list = servis.tampilData();
        tblModel.setData(list);
    }
    
    private void pencarianData(){
        List<ModelJasa> list = servis.pencarianData(Text_Pencarian.getText());
        tblModel.setData(list);
    }

    private void tambahData() {
        FormInputJasa formInput = new FormInputJasa(null, true, 1, null);
        formInput.setVisible(true);
        loadData();
    }

    private void perbaruiData() {
        int row = Tabel_Data.getSelectedRow();
        if(row != -1) {
            ModelJasa jasa = tblModel.getData(row);
            FormInputJasa formInput = new FormInputJasa(null, true, row, jasa);
            formInput.setVisible(true);
            loadData();
        } else {
            JOptionPane.showMessageDialog(null, "Pilih Data yang Akan Diperbarui");
        }
    }

    private void hapusData() {
        int row = Tabel_Data.getSelectedRow();
        if(row != -1) {
            ModelJasa jasa= tblModel.getData(row);
            if(JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Data Ini?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                servis.hapusData(jasa);
                tblModel.deleteData(row);
                loadData();
            } else {
                JOptionPane.showMessageDialog(null, "Pilih Dahulu Data yang Akan Dihapus!");
            }
        }
    }
}