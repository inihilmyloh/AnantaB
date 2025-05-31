package com.ananta.form;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import jbarcodebean.JBarcodeBean;
import jnafilechooser.api.JnaFileChooser;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.jbarcodebean.model.*;
import javax.swing.JOptionPane;

public class FormBarcode extends javax.swing.JFrame {

    private BufferedImage image = null;

    public FormBarcode() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ComboBox = new com.ananta.shape.CustomComboBox();
        jLabel2 = new javax.swing.JLabel();
        Tombol_export = new com.ananta.shape.CustomButton();
        label_barcode = new javax.swing.JLabel();
        Tombol_Generate = new com.ananta.shape.CustomButton();
        Text_ID = new javax.swing.JTextField();
        Tombol_PrintBarcode = new com.ananta.shape.CustomButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(212, 212, 212));

        jLabel1.setText("Code Barcode");

        ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Code11", "Code39", "Code93", "Code128", "Codabar", "Ean13" }));

        jLabel2.setText("Tipe Barcode");

        Tombol_export.setText("Export");
        Tombol_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tombol_exportActionPerformed(evt);
            }
        });

        Tombol_Generate.setText("Generate");
        Tombol_Generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tombol_GenerateActionPerformed(evt);
            }
        });

        Tombol_PrintBarcode.setText("Print Barcode");
        Tombol_PrintBarcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_PrintBarcodeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_barcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tombol_Generate, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(Text_ID))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(ComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(Tombol_export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Tombol_PrintBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_ID))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tombol_export, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tombol_Generate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tombol_PrintBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(label_barcode, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isBarbecueSupported(String type) {
        return switch (type) {
            case "Codabar", "Code39", "Code128", "Ean13" ->
                true;
            default ->
                false;
        };
    }

    private void generateBarcodeWithFactory(String id, String type) {
        try {
            Barcode barcode = switch (type) {
                case "Codabar" ->
                    BarcodeFactory.createCodabar(id);
                case "Code39" ->
                    BarcodeFactory.createCode39(id, true);
                case "Code128" ->
                    BarcodeFactory.createCode128(id);
                case "Ean13" ->
                    BarcodeFactory.createEAN13(id);
                // Jangan masukkan Ean8 dan Interleaved25 di sini karena Barbecue tidak mendukung
                default ->
                    null;
            };

            if (barcode != null) {
                barcode.setBarWidth(2);
                barcode.setBarHeight(100);
                Image img = BarcodeImageHandler.getImage(barcode);
                label_barcode.setIcon(new ImageIcon(img));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void generateBarcodeWithJBarcode(String id, String type) {
        JBarcodeBean bean = new JBarcodeBean();
        AbstractBarcodeStrategy strategy = getCodeType(type);

        if (strategy == null) {
            System.err.println("Tipe barcode tidak dikenal: " + type);
            return;
        }

        bean.setCodeType(strategy);
        bean.setCode(id);
        image = bean.draw(new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB));
        label_barcode.setIcon(new ImageIcon(image.getScaledInstance(label_barcode.getWidth(), label_barcode.getHeight(), Image.SCALE_SMOOTH)));
    }

    private AbstractBarcodeStrategy getCodeType(String codeType) {
        return switch (codeType) {
            case "Code11" ->
                new Code11();
            case "Code39" ->
                new Code39();
            case "Code93" ->
                new Code93();
            case "Code128" ->
                new Code128();
            case "Codabar" ->
                new Codabar();
            case "Ean13" ->
                new Ean13();
            case "MSI" ->
                new MSI();
            default ->
                null;
        };
    }

    private boolean exportBarcode(BufferedImage imageBarcode) {
        JnaFileChooser fileChooser = new JnaFileChooser();
        Window window = SwingUtilities.windowForComponent(this);
        boolean action = fileChooser.showSaveDialog(window);

        if (action) {
            File fileBarcode = fileChooser.getSelectedFile();
            if (!fileBarcode.toString().toLowerCase().endsWith(".png")) {
                fileBarcode = new File(fileBarcode + ".png");
            }
            try {
                ImageIO.write(imageBarcode, "png", fileBarcode);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private void Tombol_exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tombol_exportActionPerformed
        if (image != null) {
            exportBarcode(image);
        }
    }//GEN-LAST:event_Tombol_exportActionPerformed

    private void Tombol_GenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tombol_GenerateActionPerformed
        String id = Text_ID.getText().trim();
        if (id.isEmpty()) {
            return;
        }

        String type = ComboBox.getSelectedItem().toString();

        // Validasi khusus untuk Ean13
        if ("Ean13".equals(type)) {
            if (!id.matches("\\d{12}")) {
                JOptionPane.showMessageDialog(this,
                        "Input untuk Ean13 harus 12 digit angka.",
                        "Error Input",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (isBarbecueSupported(type)) {
            generateBarcodeWithFactory(id, type);
        } else {
            generateBarcodeWithJBarcode(id, type);
        }
    }//GEN-LAST:event_Tombol_GenerateActionPerformed

    private void Tombol_PrintBarcodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_PrintBarcodeMouseClicked
        if (label_barcode.getIcon() == null) {
            JOptionPane.showMessageDialog(this,
                    "Barcode belum digenerate.",
                    "Tidak Ada Barcode",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Mengambil image dari label_barcode
        ImageIcon icon = (ImageIcon) label_barcode.getIcon();
        Image img = icon.getImage();

        // Setup PrinterJob
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Barcode");

        printerJob.setPrintable((graphics, pageFormat, pageIndex) -> {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            // Gambar barcode di tengah halaman
            int x = (int) ((pageFormat.getImageableWidth() - img.getWidth(null)) / 2);
            int y = (int) ((pageFormat.getImageableHeight() - img.getHeight(null)) / 2);
            g2d.drawImage(img, x, y, null);

            return Printable.PAGE_EXISTS;
        });

        boolean doPrint = printerJob.printDialog();
        if (doPrint) {
            try {
                printerJob.print();
            } catch (PrinterException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Gagal mencetak barcode.",
                        "Error Print",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_Tombol_PrintBarcodeMouseClicked

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new FormBarcode().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ananta.shape.CustomComboBox ComboBox;
    private javax.swing.JTextField Text_ID;
    private com.ananta.shape.CustomButton Tombol_Generate;
    private com.ananta.shape.CustomButton Tombol_PrintBarcode;
    private com.ananta.shape.CustomButton Tombol_export;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_barcode;
    // End of variables declaration//GEN-END:variables
}
