package com.ananta.form;

import com.ananta.main.FormMenuUtama;

public class FormPricelist extends javax.swing.JPanel {

    public FormPricelist() {
        initComponents();
        customButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));   
        customButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));   
        customButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shapecustom1 = new com.ananta.shape.shapecustom();
        shapecustom3 = new com.ananta.shape.shapecustom();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabeel1 = new com.ananta.shape.JTabeel();
        customButton1 = new com.ananta.shape.CustomButton();
        shapecustom2 = new com.ananta.shape.shapecustom();
        shapecustom4 = new com.ananta.shape.shapecustom();
        jLabel2 = new javax.swing.JLabel();
        customButton2 = new com.ananta.shape.CustomButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabeel3 = new com.ananta.shape.JTabeel();
        shapecustom5 = new com.ananta.shape.shapecustom();
        shapecustom6 = new com.ananta.shape.shapecustom();
        jLabel3 = new javax.swing.JLabel();
        customButton3 = new com.ananta.shape.CustomButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabeel2 = new com.ananta.shape.JTabeel();

        setPreferredSize(new java.awt.Dimension(1278, 680));

        shapecustom1.setBackground(new java.awt.Color(6, 0, 0));
        shapecustom1.setRoundBottomLeft(60);
        shapecustom1.setRoundBottomRight(60);
        shapecustom1.setRoundTopLeft(60);
        shapecustom1.setRoundTopRight(60);

        shapecustom3.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom3.setRoundBottomLeft(60);
        shapecustom3.setRoundBottomRight(60);
        shapecustom3.setRoundTopLeft(60);
        shapecustom3.setRoundTopRight(60);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 0, 0));
        jLabel1.setText("Available Hair Service");

        jTabeel1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTabeel1);

        customButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_tambah.png"))); // NOI18N
        customButton1.setText("Tambah");
        customButton1.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        customButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout shapecustom3Layout = new javax.swing.GroupLayout(shapecustom3);
        shapecustom3.setLayout(shapecustom3Layout);
        shapecustom3Layout.setHorizontalGroup(
            shapecustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(shapecustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(shapecustom3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        shapecustom3Layout.setVerticalGroup(
            shapecustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(shapecustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(customButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout shapecustom1Layout = new javax.swing.GroupLayout(shapecustom1);
        shapecustom1.setLayout(shapecustom1Layout);
        shapecustom1Layout.setHorizontalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shapecustom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        shapecustom1Layout.setVerticalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shapecustom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        shapecustom2.setBackground(new java.awt.Color(6, 0, 0));
        shapecustom2.setPreferredSize(new java.awt.Dimension(630, 10));
        shapecustom2.setRoundBottomLeft(60);
        shapecustom2.setRoundBottomRight(60);
        shapecustom2.setRoundTopLeft(60);
        shapecustom2.setRoundTopRight(60);

        shapecustom4.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom4.setRoundBottomLeft(60);
        shapecustom4.setRoundBottomRight(60);
        shapecustom4.setRoundTopLeft(60);
        shapecustom4.setRoundTopRight(60);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 0, 0));
        jLabel2.setText("Available Product");

        customButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_tambah.png"))); // NOI18N
        customButton2.setText("Tambah");
        customButton2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        customButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customButton2MouseClicked(evt);
            }
        });

        jTabeel3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTabeel3);

        javax.swing.GroupLayout shapecustom4Layout = new javax.swing.GroupLayout(shapecustom4);
        shapecustom4.setLayout(shapecustom4Layout);
        shapecustom4Layout.setHorizontalGroup(
            shapecustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(shapecustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        shapecustom4Layout.setVerticalGroup(
            shapecustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(customButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout shapecustom2Layout = new javax.swing.GroupLayout(shapecustom2);
        shapecustom2.setLayout(shapecustom2Layout);
        shapecustom2Layout.setHorizontalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shapecustom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        shapecustom2Layout.setVerticalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shapecustom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        shapecustom5.setBackground(new java.awt.Color(1, 0, 0));
        shapecustom5.setRoundBottomLeft(40);
        shapecustom5.setRoundBottomRight(40);
        shapecustom5.setRoundTopLeft(40);
        shapecustom5.setRoundTopRight(40);

        shapecustom6.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom6.setRoundBottomLeft(40);
        shapecustom6.setRoundBottomRight(40);
        shapecustom6.setRoundTopLeft(40);
        shapecustom6.setRoundTopRight(40);

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 0, 0));
        jLabel3.setText("Hair Service Package");

        customButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_tambah.png"))); // NOI18N
        customButton3.setText("Tambah");
        customButton3.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        customButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customButton3MouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout shapecustom6Layout = new javax.swing.GroupLayout(shapecustom6);
        shapecustom6.setLayout(shapecustom6Layout);
        shapecustom6Layout.setHorizontalGroup(
            shapecustom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(shapecustom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(shapecustom6Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        shapecustom6Layout.setVerticalGroup(
            shapecustom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(shapecustom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(customButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout shapecustom5Layout = new javax.swing.GroupLayout(shapecustom5);
        shapecustom5.setLayout(shapecustom5Layout);
        shapecustom5Layout.setHorizontalGroup(
            shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shapecustom6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        shapecustom5Layout.setVerticalGroup(
            shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shapecustom6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shapecustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shapecustom5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shapecustom2, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shapecustom2, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(shapecustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(shapecustom5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void customButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customButton1MouseClicked
        FormMenuUtama.showForm(new FormTambahJasa());
    }//GEN-LAST:event_customButton1MouseClicked

    private void customButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customButton2MouseClicked
        FormMenuUtama.showForm(new FormTambahBarang());
    }//GEN-LAST:event_customButton2MouseClicked

    private void customButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customButton3MouseClicked
        FormMenuUtama.showForm(new FormTambahPaket());
    }//GEN-LAST:event_customButton3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ananta.shape.CustomButton customButton1;
    private com.ananta.shape.CustomButton customButton2;
    private com.ananta.shape.CustomButton customButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.ananta.shape.JTabeel jTabeel1;
    private com.ananta.shape.JTabeel jTabeel2;
    private com.ananta.shape.JTabeel jTabeel3;
    private com.ananta.shape.shapecustom shapecustom1;
    private com.ananta.shape.shapecustom shapecustom2;
    private com.ananta.shape.shapecustom shapecustom3;
    private com.ananta.shape.shapecustom shapecustom4;
    private com.ananta.shape.shapecustom shapecustom5;
    private com.ananta.shape.shapecustom shapecustom6;
    // End of variables declaration//GEN-END:variables
}
