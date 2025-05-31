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

import com.ananta.dao.BarangDAO;
import com.ananta.model.ModelBarang;
import com.ananta.service.ServiceBarang;
import com.ananta.tablemodel.TableModelBarang;
import java.util.List;
import javax.swing.JOptionPane;

public class FormInputBarang extends javax.swing.JDialog {
    
    private BufferedImage image = null;

    private final TableModelBarang tblModel = new TableModelBarang();
    private ServiceBarang servis = new BarangDAO();
    private ModelBarang barang;
    private int IdBarang;
    private int row;

    public FormInputBarang(java.awt.Frame parent, boolean modal, int row, ModelBarang barang) {
        super(parent, modal);
        initComponents();
        this.barang = barang;
        this.row = row;
        setLocationRelativeTo(null);

        if (barang != null) {
            this.IdBarang = barang.getIdBarang();
            dataTabel();
        }
        loadData();
        
        Tombol_Generate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tombol_Export.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tombol_Simpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tombol_Batal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tombol_Print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shapecustom1 = new com.ananta.shape.shapecustom();
        shapecustom2 = new com.ananta.shape.shapecustom();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        shapecustom3 = new com.ananta.shape.shapecustom();
        Text_Nama = new javax.swing.JTextField();
        shapecustom4 = new com.ananta.shape.shapecustom();
        Text_Barcode = new javax.swing.JTextField();
        shapecustom5 = new com.ananta.shape.shapecustom();
        Text_Jumlah = new javax.swing.JTextField();
        shapecustom6 = new com.ananta.shape.shapecustom();
        Text_Harga = new javax.swing.JTextField();
        Tombol_Simpan = new com.ananta.shape.CustomButton();
        Tombol_Batal = new com.ananta.shape.CustomButton();
        jLabel6 = new javax.swing.JLabel();
        ComboBox = new com.ananta.shape.CustomComboBox();
        Tombol_Generate = new com.ananta.shape.CustomButton();
        Tombol_Export = new com.ananta.shape.CustomButton();
        jPanel1 = new javax.swing.JPanel();
        label_barcode = new javax.swing.JLabel();
        Tombol_Print = new com.ananta.shape.CustomButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        shapecustom1.setBackground(new java.awt.Color(255, 252, 252));

        shapecustom2.setBackground(new java.awt.Color(1, 121, 6));

        jLabel1.setBackground(new java.awt.Color(255, 252, 252));
        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 252, 252));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tambah Barang");

        javax.swing.GroupLayout shapecustom2Layout = new javax.swing.GroupLayout(shapecustom2);
        shapecustom2.setLayout(shapecustom2Layout);
        shapecustom2Layout.setHorizontalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        shapecustom2Layout.setVerticalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 1));
        jLabel2.setText("Nama Barang");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 1));
        jLabel3.setText("Barcode");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 1));
        jLabel4.setText("Jumlah");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 1));
        jLabel5.setText("Harga");

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
            .addComponent(Text_Nama, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        shapecustom4.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom4.setRoundBottomLeft(15);
        shapecustom4.setRoundBottomRight(15);
        shapecustom4.setRoundTopLeft(15);
        shapecustom4.setRoundTopRight(15);

        Text_Barcode.setBackground(new java.awt.Color(212, 212, 212));
        Text_Barcode.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_Barcode.setForeground(new java.awt.Color(0, 0, 1));
        Text_Barcode.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom4Layout = new javax.swing.GroupLayout(shapecustom4);
        shapecustom4.setLayout(shapecustom4Layout);
        shapecustom4Layout.setHorizontalGroup(
            shapecustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Text_Barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        shapecustom4Layout.setVerticalGroup(
            shapecustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_Barcode, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        shapecustom5.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom5.setRoundBottomLeft(15);
        shapecustom5.setRoundBottomRight(15);
        shapecustom5.setRoundTopLeft(15);
        shapecustom5.setRoundTopRight(15);

        Text_Jumlah.setBackground(new java.awt.Color(212, 212, 212));
        Text_Jumlah.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_Jumlah.setForeground(new java.awt.Color(0, 0, 1));
        Text_Jumlah.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom5Layout = new javax.swing.GroupLayout(shapecustom5);
        shapecustom5.setLayout(shapecustom5Layout);
        shapecustom5Layout.setHorizontalGroup(
            shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Text_Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        shapecustom5Layout.setVerticalGroup(
            shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_Jumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        shapecustom6.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom6.setRoundBottomLeft(15);
        shapecustom6.setRoundBottomRight(15);
        shapecustom6.setRoundTopLeft(15);
        shapecustom6.setRoundTopRight(15);

        Text_Harga.setBackground(new java.awt.Color(212, 212, 212));
        Text_Harga.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Text_Harga.setForeground(new java.awt.Color(0, 0, 1));
        Text_Harga.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout shapecustom6Layout = new javax.swing.GroupLayout(shapecustom6);
        shapecustom6.setLayout(shapecustom6Layout);
        shapecustom6Layout.setHorizontalGroup(
            shapecustom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Text_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        shapecustom6Layout.setVerticalGroup(
            shapecustom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_Harga, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

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

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 1));
        jLabel6.setText("Tipe Barcode");

        ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Code11", "Code39", "Code93", "Code128", "Codabar", "Ean13" }));
        ComboBox.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N

        Tombol_Generate.setText("Generate");
        Tombol_Generate.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Tombol_Generate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_GenerateMouseClicked(evt);
            }
        });

        Tombol_Export.setText("Export");
        Tombol_Export.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Tombol_Export.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_ExportMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(212, 212, 212));

        label_barcode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_barcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_barcode, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        Tombol_Print.setText("Print");
        Tombol_Print.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        Tombol_Print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tombol_PrintMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout shapecustom1Layout = new javax.swing.GroupLayout(shapecustom1);
        shapecustom1.setLayout(shapecustom1Layout);
        shapecustom1Layout.setHorizontalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shapecustom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(shapecustom1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(shapecustom1Layout.createSequentialGroup()
                        .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(shapecustom1Layout.createSequentialGroup()
                                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom1Layout.createSequentialGroup()
                                .addComponent(Tombol_Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Tombol_Batal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shapecustom5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shapecustom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shapecustom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shapecustom6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tombol_Generate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tombol_Export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tombol_Print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        shapecustom1Layout.setVerticalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom1Layout.createSequentialGroup()
                .addComponent(shapecustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapecustom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(shapecustom1Layout.createSequentialGroup()
                        .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(shapecustom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Tombol_Generate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(Tombol_Export, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Tombol_Print, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(shapecustom5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapecustom6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tombol_Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tombol_Batal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
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

    private void Tombol_GenerateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_GenerateMouseClicked
        String id = Text_Barcode.getText().trim();
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
    }//GEN-LAST:event_Tombol_GenerateMouseClicked

    private void Tombol_ExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_ExportMouseClicked
        if (image != null) {
            exportBarcode(image);
        }
    }//GEN-LAST:event_Tombol_ExportMouseClicked

    private void Tombol_PrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tombol_PrintMouseClicked
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
    }//GEN-LAST:event_Tombol_PrintMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormInputBarang dialog = new FormInputBarang(new javax.swing.JFrame(), true, 1, null);
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
    private com.ananta.shape.CustomComboBox ComboBox;
    private javax.swing.JTextField Text_Barcode;
    private javax.swing.JTextField Text_Harga;
    private javax.swing.JTextField Text_Jumlah;
    private javax.swing.JTextField Text_Nama;
    private com.ananta.shape.CustomButton Tombol_Batal;
    private com.ananta.shape.CustomButton Tombol_Export;
    private com.ananta.shape.CustomButton Tombol_Generate;
    private com.ananta.shape.CustomButton Tombol_Print;
    private com.ananta.shape.CustomButton Tombol_Simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_barcode;
    private com.ananta.shape.shapecustom shapecustom1;
    private com.ananta.shape.shapecustom shapecustom2;
    private com.ananta.shape.shapecustom shapecustom3;
    private com.ananta.shape.shapecustom shapecustom4;
    private com.ananta.shape.shapecustom shapecustom5;
    private com.ananta.shape.shapecustom shapecustom6;
    // End of variables declaration//GEN-END:variables

    private boolean validasiInput() {
        boolean valid = false;
        if (Text_Nama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong");
        } else if (Text_Barcode.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Barcode Barang tidak boleh kosong");
        } else if (Text_Jumlah.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Jumlah Barang tidak boleh kosong");
        } else if (Text_Harga.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harga Barang tidak boleh kosong");
        } else {
            valid = true;
        }
        return valid;
    }

    private void simpanData() {
        if (validasiInput() == true) {
            String nama = Text_Nama.getText();
            String barcode = Text_Barcode.getText();
            String jumlah = Text_Jumlah.getText();
            String harga = Text_Harga.getText();

            try {
                int Jumlah = Integer.parseInt(jumlah);
                int Harga = Integer.parseInt(harga);

                ModelBarang barang = new ModelBarang();
                barang.setNama(nama);
                barang.setBarcode(barcode);
                barang.setJumlah(Jumlah);
                barang.setHarga(Harga);

                servis.tambahData(barang);
                tblModel.insertData(barang);
                resetForm();
                dispose();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Jumlah dan Harga harus berupa angka!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void resetForm() {
        Text_Nama.setText("");
        Text_Barcode.setText("");
        Text_Jumlah.setText("");
        Text_Harga.setText("");
    }

    private void dataTabel() {
        Tombol_Simpan.setText("Perbarui");
        Text_Nama.setText(barang.getNama());
        Text_Barcode.setText(barang.getBarcode());
        Text_Jumlah.setText(String.valueOf(barang.getJumlah()));
        Text_Harga.setText(String.valueOf(barang.getHarga()));
    }

    private void loadData() {
        List<ModelBarang> list = servis.tampilData();
        tblModel.setData(list);
    }

    private void perbaruiData() {
        if (validasiInput()) {
            String nama = Text_Nama.getText();
            String barcode = Text_Barcode.getText();
            String jumlahText = Text_Jumlah.getText();
            String hargaText = Text_Harga.getText();

            try {
                int jumlah = Integer.parseInt(jumlahText);
                int harga = Integer.parseInt(hargaText);

                ModelBarang barang = new ModelBarang();
                barang.setIdBarang(IdBarang);
                barang.setNama(nama);
                barang.setBarcode(barcode);
                barang.setJumlah(jumlah);
                barang.setHarga(harga);

                servis.perbaruiData(barang);
                tblModel.updateData(row, barang);
                resetForm();
                dispose(); // hanya jika berhasil
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Jumlah dan Harga harus berupa angka!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
