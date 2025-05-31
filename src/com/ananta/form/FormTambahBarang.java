package com.ananta.form;

public class FormTambahBarang extends javax.swing.JPanel {

    public FormTambahBarang() {
        initComponents();
        customButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shapecustom1 = new com.ananta.shape.shapecustom();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        shapecustom2 = new com.ananta.shape.shapecustom();
        jTextField1 = new javax.swing.JTextField();
        shapecustom3 = new com.ananta.shape.shapecustom();
        jTextField2 = new javax.swing.JTextField();
        shapecustom4 = new com.ananta.shape.shapecustom();
        jTextField5 = new javax.swing.JTextField();
        shapecustom5 = new com.ananta.shape.shapecustom();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabeel2 = new com.ananta.shape.JTabeel();
        customButton4 = new com.ananta.shape.CustomButton();
        customButton5 = new com.ananta.shape.CustomButton();
        customButton3 = new com.ananta.shape.CustomButton();
        customButton6 = new com.ananta.shape.CustomButton();

        shapecustom1.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom1.setRoundBottomLeft(60);
        shapecustom1.setRoundBottomRight(60);
        shapecustom1.setRoundTopLeft(60);
        shapecustom1.setRoundTopRight(60);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 0, 0));
        jLabel1.setText("Stock Saat Ini");

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 0, 0));
        jLabel2.setText("Menu Tambah Barang");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 0, 0));
        jLabel3.setText("Nama Barang");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 0, 0));
        jLabel4.setText("Jumlah Barang");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 0, 0));
        jLabel5.setText("Harga");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 0, 0));
        jLabel6.setText("ID Barang");

        shapecustom2.setBackground(new java.awt.Color(255, 252, 253));
        shapecustom2.setRoundBottomLeft(20);
        shapecustom2.setRoundBottomRight(20);
        shapecustom2.setRoundTopLeft(20);
        shapecustom2.setRoundTopRight(20);

        jTextField1.setBackground(new java.awt.Color(255, 253, 253));
        jTextField1.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout shapecustom2Layout = new javax.swing.GroupLayout(shapecustom2);
        shapecustom2.setLayout(shapecustom2Layout);
        shapecustom2Layout.setHorizontalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1)
                .addContainerGap())
        );
        shapecustom2Layout.setVerticalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        shapecustom3.setBackground(new java.awt.Color(255, 252, 252));
        shapecustom3.setRoundBottomLeft(20);
        shapecustom3.setRoundBottomRight(20);
        shapecustom3.setRoundTopLeft(20);
        shapecustom3.setRoundTopRight(20);

        jTextField2.setBackground(new java.awt.Color(255, 253, 252));
        jTextField2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom3Layout = new javax.swing.GroupLayout(shapecustom3);
        shapecustom3.setLayout(shapecustom3Layout);
        shapecustom3Layout.setHorizontalGroup(
            shapecustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2)
                .addContainerGap())
        );
        shapecustom3Layout.setVerticalGroup(
            shapecustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        shapecustom4.setBackground(new java.awt.Color(255, 252, 253));
        shapecustom4.setRoundBottomLeft(20);
        shapecustom4.setRoundBottomRight(20);
        shapecustom4.setRoundTopLeft(20);
        shapecustom4.setRoundTopRight(20);

        jTextField5.setBackground(new java.awt.Color(255, 252, 253));
        jTextField5.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jTextField5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom4Layout = new javax.swing.GroupLayout(shapecustom4);
        shapecustom4.setLayout(shapecustom4Layout);
        shapecustom4Layout.setHorizontalGroup(
            shapecustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        shapecustom4Layout.setVerticalGroup(
            shapecustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        shapecustom5.setBackground(new java.awt.Color(255, 252, 253));
        shapecustom5.setRoundBottomLeft(20);
        shapecustom5.setRoundBottomRight(20);
        shapecustom5.setRoundTopLeft(20);
        shapecustom5.setRoundTopRight(20);

        jTextField4.setBackground(new java.awt.Color(255, 252, 253));
        jTextField4.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom5Layout = new javax.swing.GroupLayout(shapecustom5);
        shapecustom5.setLayout(shapecustom5Layout);
        shapecustom5Layout.setHorizontalGroup(
            shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField4)
                .addContainerGap())
        );
        shapecustom5Layout.setVerticalGroup(
            shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabeel2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTabeel2);

        customButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_batal.png"))); // NOI18N
        customButton4.setText(" Batal");
        customButton4.setToolTipText("");
        customButton4.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        customButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        customButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        customButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_hapus.png"))); // NOI18N
        customButton5.setText("Hapus");
        customButton5.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N

        customButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_update.png"))); // NOI18N
        customButton3.setText("Update");
        customButton3.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N

        customButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_simpan.png"))); // NOI18N
        customButton6.setText("Simpan");
        customButton6.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        customButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout shapecustom1Layout = new javax.swing.GroupLayout(shapecustom1);
        shapecustom1.setLayout(shapecustom1Layout);
        shapecustom1Layout.setHorizontalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom1Layout.createSequentialGroup()
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(shapecustom1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2))
                    .addGroup(shapecustom1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom1Layout.createSequentialGroup()
                                .addComponent(customButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(customButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(shapecustom1Layout.createSequentialGroup()
                                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(shapecustom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(shapecustom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(shapecustom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(shapecustom5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20))
        );
        shapecustom1Layout.setVerticalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(shapecustom1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(shapecustom1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(shapecustom1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(shapecustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapecustom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shapecustom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapecustom5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shapecustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shapecustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void customButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ananta.shape.CustomButton customButton3;
    private com.ananta.shape.CustomButton customButton4;
    private com.ananta.shape.CustomButton customButton5;
    private com.ananta.shape.CustomButton customButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private com.ananta.shape.JTabeel jTabeel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private com.ananta.shape.shapecustom shapecustom1;
    private com.ananta.shape.shapecustom shapecustom2;
    private com.ananta.shape.shapecustom shapecustom3;
    private com.ananta.shape.shapecustom shapecustom4;
    private com.ananta.shape.shapecustom shapecustom5;
    // End of variables declaration//GEN-END:variables
}
