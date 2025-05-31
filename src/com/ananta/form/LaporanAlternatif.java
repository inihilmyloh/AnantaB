package com.ananta.form;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import com.ananta.database.Database;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author M.Khoiril
 */
public class LaporanAlternatif extends javax.swing.JPanel {

    private Connection conn;
    private DateChooser tgl_trs = new DateChooser();
    private DateChooser tgl_png = new DateChooser();
    
    public LaporanAlternatif() {
        initComponents();
        conn = Database.getConnection();
        
        FieldKalenderPengeluaran.setText("");
        FieldKalenderTransaksi.setText("");
        loadDataHarian();
        loadData();
        setModelTabelTransaksi();
        lebarKolomTransaksi();
        getDataTransaksi((DefaultTableModel) tbl_transaksi.getModel());
        setModelTabelPengeluaran();
        lebarKolomPengeluaran();
        getDataPengeluaran((DefaultTableModel) tbl_pengeluaran.getModel());
        
        tgl_trs.setTextField(FieldKalenderTransaksi);
        tgl_trs.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        tgl_trs.setLabelCurrentDayVisible(false);
        tgl_trs.setDateFormat(new SimpleDateFormat("dd-MMMM-yyyy"));
        tgl_trs.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateBetweenChanged(DateBetween date, DateChooserAction action) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateFrom = df.format(date.getFromDate());
                String dateTo = df.format(date.getToDate());
                DefaultTableModel transaksiModel = (DefaultTableModel) tbl_transaksi.getModel();
                transaksiModel.setRowCount(0); 
                try {
                    String sql = """
                        SELECT t.id_transaksi, t.created_at, u.username AS kasir, 
                               CONCAT_WS(', ', 
                                   (SELECT GROUP_CONCAT(j.nama_jasa) 
                                    FROM transaksi_jasa tj 
                                    JOIN jasa j ON tj.id_jasa = j.id_jasa 
                                    WHERE tj.id_transaksi = t.id_transaksi), 
                                   (SELECT GROUP_CONCAT(b.nama_barang) 
                                    FROM transaksi_barang tb 
                                    JOIN barang b ON tb.id_barang = b.id_barang 
                                    WHERE tb.id_transaksi = t.id_transaksi)
                               ) AS detail_transaksi, 
                               t.total_harga
                        FROM transaksi t
                        JOIN users u ON t.id_user = u.id_user
                        WHERE DATE(t.created_at) BETWEEN ? AND ?
                        ORDER BY t.created_at DESC;
                    """;
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, dateFrom);
                    st.setString(2, dateTo);
                    ResultSet rs = st.executeQuery();
                    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
                    while (rs.next()) {
                        transaksiModel.addRow(new Object[]{
                            rs.getInt("id_transaksi"),
                            rs.getString("created_at"),
                            rs.getString("kasir"),
                            rs.getString("detail_transaksi"),
                            formatRupiah.format(rs.getDouble("total_harga"))
                        });
                    }
                    rs.close();
                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        tgl_png.setTextField(FieldKalenderPengeluaran);
        tgl_png.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        tgl_png.setLabelCurrentDayVisible(false);
        tgl_png.setDateFormat(new SimpleDateFormat("dd-MMMM-yyyy"));
        tgl_png.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateBetweenChanged(DateBetween date, DateChooserAction action) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateFrom = df.format(date.getFromDate());
                String dateTo = df.format(date.getToDate());
                DefaultTableModel pengeluaranModel = (DefaultTableModel) tbl_pengeluaran.getModel();
                pengeluaranModel.setRowCount(0);
                try {
                    String sql = """
                        SELECT p.id_pengeluaran, p.created_at, p.kategori, u.username AS kasir, p.nominal
                        FROM pengeluaran p
                        JOIN users u ON p.id_user = u.id_user
                        WHERE DATE(p.created_at) BETWEEN ? AND ?
                        ORDER BY p.created_at DESC;
                    """;
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, dateFrom);
                    st.setString(2, dateTo);
                    ResultSet rs = st.executeQuery();
                    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
                    while (rs.next()) {
                        pengeluaranModel.addRow(new Object[]{
                            rs.getInt("id_pengeluaran"),
                            rs.getString("created_at"),
                            rs.getString("kategori"),
                            rs.getString("kasir"),
                            formatRupiah.format(rs.getDouble("nominal"))
                        });
                    }
                    rs.close();
                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BlackBgTransaksi = new com.ananta.shape.shapecustom();
        GrayBgTranskasi = new com.ananta.shape.shapecustom();
        labelRiwayatTransaksi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_transaksi = new com.ananta.shape.JTabeel();
        btn_cetak_trs = new com.ananta.shape.CustomButton();
        btn_batal = new com.ananta.shape.CustomButton();
        shapecustom8 = new com.ananta.shape.shapecustom();
        FieldKalenderTransaksi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BlackBgPengeluaran = new com.ananta.shape.shapecustom();
        GrayBgpengeluaran = new com.ananta.shape.shapecustom();
        btn_cetak_png = new com.ananta.shape.CustomButton();
        btn_batalPengeluaran = new com.ananta.shape.CustomButton();
        shapecustom9 = new com.ananta.shape.shapecustom();
        FieldKalenderPengeluaran = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_pengeluaran = new com.ananta.shape.JTabeel();
        labelRiwayatTransaksi3 = new javax.swing.JLabel();
        BulanHitam = new com.ananta.shape.shapecustom();
        BulanAbu = new com.ananta.shape.shapecustom();
        RingkasanKeuangan = new javax.swing.JLabel();
        Pendapatan = new javax.swing.JLabel();
        iconRingkasanKeuangan = new javax.swing.JLabel();
        iconPendapatan = new javax.swing.JLabel();
        RpPendapatan = new javax.swing.JLabel();
        RpPengeluaran = new javax.swing.JLabel();
        Pengeluaran = new javax.swing.JLabel();
        iconPengeluaran = new javax.swing.JLabel();
        iconLaba = new javax.swing.JLabel();
        Laba = new javax.swing.JLabel();
        RpLaba = new javax.swing.JLabel();
        titikdua = new javax.swing.JLabel();
        titikdua1 = new javax.swing.JLabel();
        titikdua3 = new javax.swing.JLabel();
        RingkasanOperasional = new javax.swing.JLabel();
        iconRingkasanOperasional = new javax.swing.JLabel();
        iconJmlTransaksi = new javax.swing.JLabel();
        JmlTransaksi = new javax.swing.JLabel();
        iconJasaDiekerjakan = new javax.swing.JLabel();
        iconJasaTerlaris = new javax.swing.JLabel();
        JasaTerlaris = new javax.swing.JLabel();
        JasaDikerjakan = new javax.swing.JLabel();
        ProdukTerlaris = new javax.swing.JLabel();
        ProdukTerjual = new javax.swing.JLabel();
        iconProdukTerjual = new javax.swing.JLabel();
        iconProdukTerlaris = new javax.swing.JLabel();
        titikdua4 = new javax.swing.JLabel();
        titikdua5 = new javax.swing.JLabel();
        titikdua6 = new javax.swing.JLabel();
        titikdua7 = new javax.swing.JLabel();
        titkdua8 = new javax.swing.JLabel();
        numJmlTransaksi = new javax.swing.JLabel();
        numJasaDikerjakan = new javax.swing.JLabel();
        txtJasaTerlaris = new javax.swing.JLabel();
        numJasaTerlaris = new javax.swing.JLabel();
        numProdukTerjual = new javax.swing.JLabel();
        txtProdukterlaris = new javax.swing.JLabel();
        numProdukTerlaris = new javax.swing.JLabel();
        InfoBulanan = new javax.swing.JLabel();
        HariHitam = new com.ananta.shape.shapecustom();
        HariAbu = new com.ananta.shape.shapecustom();
        RingkasanKeuangan1 = new javax.swing.JLabel();
        Pendapatan1 = new javax.swing.JLabel();
        iconRingkasanKeuangan1 = new javax.swing.JLabel();
        iconPendapatan1 = new javax.swing.JLabel();
        RpPendapatan1 = new javax.swing.JLabel();
        RpPengeluaran1 = new javax.swing.JLabel();
        Pengeluaran1 = new javax.swing.JLabel();
        iconPengeluaran1 = new javax.swing.JLabel();
        iconLaba1 = new javax.swing.JLabel();
        Laba1 = new javax.swing.JLabel();
        RpLaba1 = new javax.swing.JLabel();
        titikdua35 = new javax.swing.JLabel();
        titikdua36 = new javax.swing.JLabel();
        titikdua37 = new javax.swing.JLabel();
        RingkasanOperasional1 = new javax.swing.JLabel();
        iconRingkasanOperasional1 = new javax.swing.JLabel();
        iconJmlTransaksi1 = new javax.swing.JLabel();
        JmlTransaksi1 = new javax.swing.JLabel();
        iconJasaDiekerjakan1 = new javax.swing.JLabel();
        iconJasaTerlaris1 = new javax.swing.JLabel();
        JasaTerlaris1 = new javax.swing.JLabel();
        JasaDikerjakan1 = new javax.swing.JLabel();
        ProdukTerlaris1 = new javax.swing.JLabel();
        ProdukTerjual1 = new javax.swing.JLabel();
        iconProdukTerjual1 = new javax.swing.JLabel();
        iconProdukTerlaris1 = new javax.swing.JLabel();
        titikdua38 = new javax.swing.JLabel();
        titikdua39 = new javax.swing.JLabel();
        titikdua40 = new javax.swing.JLabel();
        titikdua41 = new javax.swing.JLabel();
        titkdua13 = new javax.swing.JLabel();
        numJmlTransaksi1 = new javax.swing.JLabel();
        numJasaDikerjakan1 = new javax.swing.JLabel();
        txtJasaTerlaris1 = new javax.swing.JLabel();
        numJasaTerlaris1 = new javax.swing.JLabel();
        numProdukTerjual1 = new javax.swing.JLabel();
        txtProdukterlaris1 = new javax.swing.JLabel();
        numProdukTerlaris1 = new javax.swing.JLabel();
        InfoHarian = new javax.swing.JLabel();

        BlackBgTransaksi.setBackground(new java.awt.Color(6, 0, 0));
        BlackBgTransaksi.setPreferredSize(new java.awt.Dimension(630, 10));
        BlackBgTransaksi.setRoundBottomLeft(60);
        BlackBgTransaksi.setRoundBottomRight(60);
        BlackBgTransaksi.setRoundTopLeft(60);
        BlackBgTransaksi.setRoundTopRight(60);

        GrayBgTranskasi.setBackground(new java.awt.Color(204, 204, 204));
        GrayBgTranskasi.setRoundBottomLeft(60);
        GrayBgTranskasi.setRoundBottomRight(60);
        GrayBgTranskasi.setRoundTopLeft(60);
        GrayBgTranskasi.setRoundTopRight(60);

        labelRiwayatTransaksi.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        labelRiwayatTransaksi.setForeground(new java.awt.Color(1, 0, 0));
        labelRiwayatTransaksi.setText("Riwayat Transaksi");

        tbl_transaksi.setBackground(new java.awt.Color(255, 253, 253));
        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID TRANSAKSI", "TANGGAL/WAKTU", "NAMA KASIR", "DETAIL TRANSAKSI", "TOTAL PEMBAYARAN"
            }
        ));
        jScrollPane1.setViewportView(tbl_transaksi);
        if (tbl_transaksi.getColumnModel().getColumnCount() > 0) {
            tbl_transaksi.getColumnModel().getColumn(3).setMinWidth(200);
        }

        btn_cetak_trs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/exportToExcel.png"))); // NOI18N
        btn_cetak_trs.setText("Ekspor");
        btn_cetak_trs.setDefaultColor(new java.awt.Color(0, 128, 0));
        btn_cetak_trs.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        btn_cetak_trs.setHoverColor(new java.awt.Color(0, 113, 0));
        btn_cetak_trs.setPressedColor(new java.awt.Color(0, 98, 0));
        btn_cetak_trs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cetak_trsMouseClicked(evt);
            }
        });
        btn_cetak_trs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetak_trsActionPerformed(evt);
            }
        });

        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_batal.png"))); // NOI18N
        btn_batal.setText("Batal");
        btn_batal.setDefaultColor(new java.awt.Color(255, 153, 0));
        btn_batal.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        btn_batal.setHoverColor(new java.awt.Color(255, 138, 0));
        btn_batal.setPressedColor(new java.awt.Color(255, 123, 0));
        btn_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_batalMouseClicked(evt);
            }
        });
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        shapecustom8.setBackground(new java.awt.Color(255, 255, 255));
        shapecustom8.setRoundBottomLeft(20);
        shapecustom8.setRoundBottomRight(20);
        shapecustom8.setRoundTopLeft(20);
        shapecustom8.setRoundTopRight(20);

        FieldKalenderTransaksi.setBackground(new java.awt.Color(255, 253, 253));
        FieldKalenderTransaksi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        FieldKalenderTransaksi.setForeground(new java.awt.Color(1, 0, 0));
        FieldKalenderTransaksi.setText("2025-05-22 to 2026-07-22");
        FieldKalenderTransaksi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        FieldKalenderTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldKalenderTransaksiActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icons8-calendar-20.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icons8-search-20.png"))); // NOI18N

        javax.swing.GroupLayout shapecustom8Layout = new javax.swing.GroupLayout(shapecustom8);
        shapecustom8.setLayout(shapecustom8Layout);
        shapecustom8Layout.setHorizontalGroup(
            shapecustom8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addComponent(FieldKalenderTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(8, 8, 8))
        );
        shapecustom8Layout.setVerticalGroup(
            shapecustom8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FieldKalenderTransaksi)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom8Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout GrayBgTranskasiLayout = new javax.swing.GroupLayout(GrayBgTranskasi);
        GrayBgTranskasi.setLayout(GrayBgTranskasiLayout);
        GrayBgTranskasiLayout.setHorizontalGroup(
            GrayBgTranskasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GrayBgTranskasiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cetak_trs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(GrayBgTranskasiLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(GrayBgTranskasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GrayBgTranskasiLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(GrayBgTranskasiLayout.createSequentialGroup()
                        .addComponent(labelRiwayatTransaksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(shapecustom8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        GrayBgTranskasiLayout.setVerticalGroup(
            GrayBgTranskasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GrayBgTranskasiLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(GrayBgTranskasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRiwayatTransaksi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GrayBgTranskasiLayout.createSequentialGroup()
                        .addComponent(shapecustom8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GrayBgTranskasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cetak_trs, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout BlackBgTransaksiLayout = new javax.swing.GroupLayout(BlackBgTransaksi);
        BlackBgTransaksi.setLayout(BlackBgTransaksiLayout);
        BlackBgTransaksiLayout.setHorizontalGroup(
            BlackBgTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlackBgTransaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GrayBgTranskasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BlackBgTransaksiLayout.setVerticalGroup(
            BlackBgTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlackBgTransaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GrayBgTranskasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BlackBgPengeluaran.setBackground(new java.awt.Color(6, 0, 0));
        BlackBgPengeluaran.setPreferredSize(new java.awt.Dimension(630, 10));
        BlackBgPengeluaran.setRoundBottomLeft(60);
        BlackBgPengeluaran.setRoundBottomRight(60);
        BlackBgPengeluaran.setRoundTopLeft(60);
        BlackBgPengeluaran.setRoundTopRight(60);

        GrayBgpengeluaran.setBackground(new java.awt.Color(204, 204, 204));
        GrayBgpengeluaran.setRoundBottomLeft(60);
        GrayBgpengeluaran.setRoundBottomRight(60);
        GrayBgpengeluaran.setRoundTopLeft(60);
        GrayBgpengeluaran.setRoundTopRight(60);

        btn_cetak_png.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/exportToExcel.png"))); // NOI18N
        btn_cetak_png.setText("Ekspor");
        btn_cetak_png.setDefaultColor(new java.awt.Color(0, 128, 0));
        btn_cetak_png.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        btn_cetak_png.setHoverColor(new java.awt.Color(0, 113, 0));
        btn_cetak_png.setPressedColor(new java.awt.Color(0, 98, 0));
        btn_cetak_png.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cetak_pngMouseClicked(evt);
            }
        });
        btn_cetak_png.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetak_pngActionPerformed(evt);
            }
        });

        btn_batalPengeluaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/icon_batal.png"))); // NOI18N
        btn_batalPengeluaran.setText("Batal");
        btn_batalPengeluaran.setDefaultColor(new java.awt.Color(255, 153, 0));
        btn_batalPengeluaran.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        btn_batalPengeluaran.setHoverColor(new java.awt.Color(255, 138, 0));
        btn_batalPengeluaran.setPressedColor(new java.awt.Color(255, 123, 0));
        btn_batalPengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_batalPengeluaranMouseClicked(evt);
            }
        });
        btn_batalPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalPengeluaranActionPerformed(evt);
            }
        });

        shapecustom9.setBackground(new java.awt.Color(255, 255, 255));
        shapecustom9.setRoundBottomLeft(20);
        shapecustom9.setRoundBottomRight(20);
        shapecustom9.setRoundTopLeft(20);
        shapecustom9.setRoundTopRight(20);

        FieldKalenderPengeluaran.setBackground(new java.awt.Color(255, 253, 253));
        FieldKalenderPengeluaran.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        FieldKalenderPengeluaran.setForeground(new java.awt.Color(1, 0, 0));
        FieldKalenderPengeluaran.setText("2025-05-22 to 2026-07-22");
        FieldKalenderPengeluaran.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        FieldKalenderPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldKalenderPengeluaranActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icons8-calendar-20.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icons8-search-20.png"))); // NOI18N

        javax.swing.GroupLayout shapecustom9Layout = new javax.swing.GroupLayout(shapecustom9);
        shapecustom9.setLayout(shapecustom9Layout);
        shapecustom9Layout.setHorizontalGroup(
            shapecustom9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FieldKalenderPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(8, 8, 8))
        );
        shapecustom9Layout.setVerticalGroup(
            shapecustom9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FieldKalenderPengeluaran)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom9Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(shapecustom9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tbl_pengeluaran.setBackground(new java.awt.Color(255, 253, 253));
        tbl_pengeluaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID PENGELUARAN", "TANGGAL/WAKTU", "NAMA KASIR", "KATEGORI", "TOTAL HARGA"
            }
        ));
        jScrollPane2.setViewportView(tbl_pengeluaran);
        if (tbl_pengeluaran.getColumnModel().getColumnCount() > 0) {
            tbl_pengeluaran.getColumnModel().getColumn(3).setMinWidth(200);
        }

        labelRiwayatTransaksi3.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        labelRiwayatTransaksi3.setForeground(new java.awt.Color(1, 0, 0));
        labelRiwayatTransaksi3.setText("Riwayat Pengeluaran");

        javax.swing.GroupLayout GrayBgpengeluaranLayout = new javax.swing.GroupLayout(GrayBgpengeluaran);
        GrayBgpengeluaran.setLayout(GrayBgpengeluaranLayout);
        GrayBgpengeluaranLayout.setHorizontalGroup(
            GrayBgpengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GrayBgpengeluaranLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cetak_png, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_batalPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(GrayBgpengeluaranLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(GrayBgpengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GrayBgpengeluaranLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(GrayBgpengeluaranLayout.createSequentialGroup()
                        .addComponent(labelRiwayatTransaksi3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(shapecustom9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        GrayBgpengeluaranLayout.setVerticalGroup(
            GrayBgpengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GrayBgpengeluaranLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(GrayBgpengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRiwayatTransaksi3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(shapecustom9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GrayBgpengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_batalPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cetak_png, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout BlackBgPengeluaranLayout = new javax.swing.GroupLayout(BlackBgPengeluaran);
        BlackBgPengeluaran.setLayout(BlackBgPengeluaranLayout);
        BlackBgPengeluaranLayout.setHorizontalGroup(
            BlackBgPengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlackBgPengeluaranLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GrayBgpengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BlackBgPengeluaranLayout.setVerticalGroup(
            BlackBgPengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlackBgPengeluaranLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GrayBgpengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BulanHitam.setBackground(new java.awt.Color(6, 0, 0));
        BulanHitam.setRoundBottomLeft(60);
        BulanHitam.setRoundBottomRight(60);
        BulanHitam.setRoundTopLeft(60);
        BulanHitam.setRoundTopRight(60);

        BulanAbu.setBackground(new java.awt.Color(204, 204, 204));
        BulanAbu.setRoundBottomLeft(60);
        BulanAbu.setRoundBottomRight(60);
        BulanAbu.setRoundTopLeft(60);
        BulanAbu.setRoundTopRight(60);

        RingkasanKeuangan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        RingkasanKeuangan.setForeground(new java.awt.Color(1, 0, 0));
        RingkasanKeuangan.setText("Ringkasan Keuangan");

        Pendapatan.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        Pendapatan.setForeground(new java.awt.Color(1, 0, 0));
        Pendapatan.setText("Pendapatan");

        iconRingkasanKeuangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/iconRKeuangan.png"))); // NOI18N

        iconPendapatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_Pemasukan.png"))); // NOI18N

        RpPendapatan.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        RpPendapatan.setForeground(new java.awt.Color(1, 0, 0));
        RpPendapatan.setText("Rp15.000.000,00");

        RpPengeluaran.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        RpPengeluaran.setForeground(new java.awt.Color(1, 0, 0));
        RpPengeluaran.setText("Rp15.000.000,00");

        Pengeluaran.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        Pengeluaran.setForeground(new java.awt.Color(1, 0, 0));
        Pengeluaran.setText("Pengeluaran");

        iconPengeluaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_PengeluaranKcl.png"))); // NOI18N

        iconLaba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_laba.png"))); // NOI18N

        Laba.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        Laba.setForeground(new java.awt.Color(1, 0, 0));
        Laba.setText("Laba");

        RpLaba.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        RpLaba.setForeground(new java.awt.Color(1, 0, 0));
        RpLaba.setText("Rp15.000.000,00");

        titikdua.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua.setForeground(new java.awt.Color(1, 0, 0));
        titikdua.setText(":");

        titikdua1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua1.setForeground(new java.awt.Color(1, 0, 0));
        titikdua1.setText(":");

        titikdua3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua3.setForeground(new java.awt.Color(1, 0, 0));
        titikdua3.setText(":");

        RingkasanOperasional.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        RingkasanOperasional.setForeground(new java.awt.Color(1, 0, 0));
        RingkasanOperasional.setText("Ringkasan Operasional");

        iconRingkasanOperasional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_operasional.png"))); // NOI18N

        iconJmlTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_transaksiKcl.png"))); // NOI18N

        JmlTransaksi.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        JmlTransaksi.setForeground(new java.awt.Color(1, 0, 0));
        JmlTransaksi.setText("Jumlah Transaksi");

        iconJasaDiekerjakan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_JasaKcl.png"))); // NOI18N

        iconJasaTerlaris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_jasaTerlaris.png"))); // NOI18N

        JasaTerlaris.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        JasaTerlaris.setForeground(new java.awt.Color(1, 0, 0));
        JasaTerlaris.setText("Jasa Terlaris");

        JasaDikerjakan.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        JasaDikerjakan.setForeground(new java.awt.Color(1, 0, 0));
        JasaDikerjakan.setText("Jasa Dikerjakan");

        ProdukTerlaris.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        ProdukTerlaris.setForeground(new java.awt.Color(1, 0, 0));
        ProdukTerlaris.setText("Produk Terlaris");

        ProdukTerjual.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        ProdukTerjual.setForeground(new java.awt.Color(1, 0, 0));
        ProdukTerjual.setText("Produk Terjual");

        iconProdukTerjual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_produkTerjual.png"))); // NOI18N

        iconProdukTerlaris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_produkterlaris.png"))); // NOI18N

        titikdua4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua4.setForeground(new java.awt.Color(1, 0, 0));
        titikdua4.setText(":");

        titikdua5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua5.setForeground(new java.awt.Color(1, 0, 0));
        titikdua5.setText(":");

        titikdua6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua6.setForeground(new java.awt.Color(1, 0, 0));
        titikdua6.setText(":");

        titikdua7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua7.setForeground(new java.awt.Color(1, 0, 0));
        titikdua7.setText(":");

        titkdua8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titkdua8.setForeground(new java.awt.Color(1, 0, 0));
        titkdua8.setText(":");

        numJmlTransaksi.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        numJmlTransaksi.setForeground(new java.awt.Color(1, 0, 0));
        numJmlTransaksi.setText("198");

        numJasaDikerjakan.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        numJasaDikerjakan.setForeground(new java.awt.Color(1, 0, 0));
        numJasaDikerjakan.setText("190");

        txtJasaTerlaris.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        txtJasaTerlaris.setForeground(new java.awt.Color(1, 0, 0));
        txtJasaTerlaris.setText("Hair Cut");

        numJasaTerlaris.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        numJasaTerlaris.setForeground(new java.awt.Color(1, 0, 0));
        numJasaTerlaris.setText("177x");

        numProdukTerjual.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        numProdukTerjual.setForeground(new java.awt.Color(1, 0, 0));
        numProdukTerjual.setText("23");

        txtProdukterlaris.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        txtProdukterlaris.setForeground(new java.awt.Color(1, 0, 0));
        txtProdukterlaris.setText("Pomade");

        numProdukTerlaris.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        numProdukTerlaris.setForeground(new java.awt.Color(1, 0, 0));
        numProdukTerlaris.setText("12x");

        InfoBulanan.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        InfoBulanan.setForeground(new java.awt.Color(255, 0, 0));
        InfoBulanan.setText("Informasi Bulan Ini");

        javax.swing.GroupLayout BulanAbuLayout = new javax.swing.GroupLayout(BulanAbu);
        BulanAbu.setLayout(BulanAbuLayout);
        BulanAbuLayout.setHorizontalGroup(
            BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BulanAbuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BulanAbuLayout.createSequentialGroup()
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BulanAbuLayout.createSequentialGroup()
                                .addComponent(iconJmlTransaksi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JmlTransaksi))
                            .addGroup(BulanAbuLayout.createSequentialGroup()
                                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iconJasaDiekerjakan, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iconJasaTerlaris)
                                    .addComponent(iconProdukTerjual, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iconProdukTerlaris))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JasaDikerjakan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JasaTerlaris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ProdukTerlaris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ProdukTerjual, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(7, 7, 7)
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BulanAbuLayout.createSequentialGroup()
                                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(titkdua8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(titikdua7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BulanAbuLayout.createSequentialGroup()
                                        .addComponent(txtProdukterlaris)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numProdukTerlaris))
                                    .addComponent(numProdukTerjual, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(BulanAbuLayout.createSequentialGroup()
                                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(titikdua6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(titikdua5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(titikdua4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numJmlTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numJasaDikerjakan)
                                    .addGroup(BulanAbuLayout.createSequentialGroup()
                                        .addComponent(txtJasaTerlaris)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numJasaTerlaris))))))
                    .addGroup(BulanAbuLayout.createSequentialGroup()
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BulanAbuLayout.createSequentialGroup()
                                .addComponent(iconPendapatan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Pendapatan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(BulanAbuLayout.createSequentialGroup()
                                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iconPengeluaran, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iconLaba))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Laba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Pengeluaran))))
                        .addGap(16, 16, 16)
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titikdua, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titikdua1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titikdua3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RpPengeluaran)
                            .addComponent(RpPendapatan)
                            .addComponent(RpLaba)))
                    .addGroup(BulanAbuLayout.createSequentialGroup()
                        .addComponent(iconRingkasanOperasional)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RingkasanOperasional))
                    .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(InfoBulanan)
                        .addGroup(BulanAbuLayout.createSequentialGroup()
                            .addComponent(iconRingkasanKeuangan)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(RingkasanKeuangan))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        BulanAbuLayout.setVerticalGroup(
            BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BulanAbuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(InfoBulanan)
                .addGap(18, 18, 18)
                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconRingkasanKeuangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RingkasanKeuangan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Pendapatan)
                        .addComponent(RpPendapatan)
                        .addComponent(titikdua))
                    .addComponent(iconPendapatan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Pengeluaran)
                        .addComponent(RpPengeluaran)
                        .addComponent(titikdua1))
                    .addComponent(iconPengeluaran))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Laba)
                        .addComponent(RpLaba)
                        .addComponent(titikdua3))
                    .addComponent(iconLaba))
                .addGap(26, 26, 26)
                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconRingkasanOperasional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RingkasanOperasional, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BulanAbuLayout.createSequentialGroup()
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JmlTransaksi)
                            .addComponent(iconJmlTransaksi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iconJasaDiekerjakan)
                            .addComponent(JasaDikerjakan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JasaTerlaris)
                            .addComponent(iconJasaTerlaris))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iconProdukTerjual)
                            .addComponent(ProdukTerjual))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ProdukTerlaris)
                            .addComponent(iconProdukTerlaris)))
                    .addGroup(BulanAbuLayout.createSequentialGroup()
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titikdua4)
                            .addComponent(numJmlTransaksi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titikdua5)
                            .addComponent(numJasaDikerjakan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titikdua6)
                            .addComponent(txtJasaTerlaris)
                            .addComponent(numJasaTerlaris))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BulanAbuLayout.createSequentialGroup()
                                .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(titikdua7)
                                    .addComponent(numProdukTerjual))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titkdua8))
                            .addGroup(BulanAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtProdukterlaris)
                                .addComponent(numProdukTerlaris)))))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout BulanHitamLayout = new javax.swing.GroupLayout(BulanHitam);
        BulanHitam.setLayout(BulanHitamLayout);
        BulanHitamLayout.setHorizontalGroup(
            BulanHitamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BulanHitamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BulanAbu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        BulanHitamLayout.setVerticalGroup(
            BulanHitamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BulanHitamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BulanAbu, javax.swing.GroupLayout.PREFERRED_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );

        HariHitam.setBackground(new java.awt.Color(6, 0, 0));
        HariHitam.setRoundBottomLeft(60);
        HariHitam.setRoundBottomRight(60);
        HariHitam.setRoundTopLeft(60);
        HariHitam.setRoundTopRight(60);

        HariAbu.setBackground(new java.awt.Color(204, 204, 204));
        HariAbu.setRoundBottomLeft(60);
        HariAbu.setRoundBottomRight(60);
        HariAbu.setRoundTopLeft(60);
        HariAbu.setRoundTopRight(60);

        RingkasanKeuangan1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        RingkasanKeuangan1.setForeground(new java.awt.Color(1, 0, 0));
        RingkasanKeuangan1.setText("Ringkasan Keuangan");

        Pendapatan1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        Pendapatan1.setForeground(new java.awt.Color(1, 0, 0));
        Pendapatan1.setText("Pendapatan");

        iconRingkasanKeuangan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/iconRKeuangan.png"))); // NOI18N

        iconPendapatan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_Pemasukan.png"))); // NOI18N

        RpPendapatan1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        RpPendapatan1.setForeground(new java.awt.Color(1, 0, 0));
        RpPendapatan1.setText("Rp15.000.000,00");

        RpPengeluaran1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        RpPengeluaran1.setForeground(new java.awt.Color(1, 0, 0));
        RpPengeluaran1.setText("Rp15.000.000,00");

        Pengeluaran1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        Pengeluaran1.setForeground(new java.awt.Color(1, 0, 0));
        Pengeluaran1.setText("Pengeluaran");

        iconPengeluaran1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_PengeluaranKcl.png"))); // NOI18N

        iconLaba1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_laba.png"))); // NOI18N

        Laba1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        Laba1.setForeground(new java.awt.Color(1, 0, 0));
        Laba1.setText("Laba");

        RpLaba1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        RpLaba1.setForeground(new java.awt.Color(1, 0, 0));
        RpLaba1.setText("Rp15.000.000,00");

        titikdua35.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua35.setForeground(new java.awt.Color(1, 0, 0));
        titikdua35.setText(":");

        titikdua36.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua36.setForeground(new java.awt.Color(1, 0, 0));
        titikdua36.setText(":");

        titikdua37.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua37.setForeground(new java.awt.Color(1, 0, 0));
        titikdua37.setText(":");

        RingkasanOperasional1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        RingkasanOperasional1.setForeground(new java.awt.Color(1, 0, 0));
        RingkasanOperasional1.setText("Ringkasan Operasional");

        iconRingkasanOperasional1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_operasional.png"))); // NOI18N

        iconJmlTransaksi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_transaksiKcl.png"))); // NOI18N

        JmlTransaksi1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        JmlTransaksi1.setForeground(new java.awt.Color(1, 0, 0));
        JmlTransaksi1.setText("Jumlah Transaksi");

        iconJasaDiekerjakan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_JasaKcl.png"))); // NOI18N

        iconJasaTerlaris1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_jasaTerlaris.png"))); // NOI18N

        JasaTerlaris1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        JasaTerlaris1.setForeground(new java.awt.Color(1, 0, 0));
        JasaTerlaris1.setText("Jasa Terlaris");

        JasaDikerjakan1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        JasaDikerjakan1.setForeground(new java.awt.Color(1, 0, 0));
        JasaDikerjakan1.setText("Jasa Dikerjakan");

        ProdukTerlaris1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        ProdukTerlaris1.setForeground(new java.awt.Color(1, 0, 0));
        ProdukTerlaris1.setText("Produk Terlaris");

        ProdukTerjual1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        ProdukTerjual1.setForeground(new java.awt.Color(1, 0, 0));
        ProdukTerjual1.setText("Produk Terjual");

        iconProdukTerjual1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_produkTerjual.png"))); // NOI18N

        iconProdukTerlaris1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/icon_produkterlaris.png"))); // NOI18N

        titikdua38.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua38.setForeground(new java.awt.Color(1, 0, 0));
        titikdua38.setText(":");

        titikdua39.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua39.setForeground(new java.awt.Color(1, 0, 0));
        titikdua39.setText(":");

        titikdua40.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua40.setForeground(new java.awt.Color(1, 0, 0));
        titikdua40.setText(":");

        titikdua41.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titikdua41.setForeground(new java.awt.Color(1, 0, 0));
        titikdua41.setText(":");

        titkdua13.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        titkdua13.setForeground(new java.awt.Color(1, 0, 0));
        titkdua13.setText(":");

        numJmlTransaksi1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        numJmlTransaksi1.setForeground(new java.awt.Color(1, 0, 0));
        numJmlTransaksi1.setText("198");

        numJasaDikerjakan1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        numJasaDikerjakan1.setForeground(new java.awt.Color(1, 0, 0));
        numJasaDikerjakan1.setText("190");

        txtJasaTerlaris1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        txtJasaTerlaris1.setForeground(new java.awt.Color(1, 0, 0));
        txtJasaTerlaris1.setText("Hair Cut");

        numJasaTerlaris1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        numJasaTerlaris1.setForeground(new java.awt.Color(1, 0, 0));
        numJasaTerlaris1.setText("177x");

        numProdukTerjual1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        numProdukTerjual1.setForeground(new java.awt.Color(1, 0, 0));
        numProdukTerjual1.setText("23");

        txtProdukterlaris1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        txtProdukterlaris1.setForeground(new java.awt.Color(1, 0, 0));
        txtProdukterlaris1.setText("Pomade");

        numProdukTerlaris1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        numProdukTerlaris1.setForeground(new java.awt.Color(1, 0, 0));
        numProdukTerlaris1.setText("12x");

        InfoHarian.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        InfoHarian.setForeground(new java.awt.Color(255, 0, 0));
        InfoHarian.setText("Informasi Hari Ini");

        javax.swing.GroupLayout HariAbuLayout = new javax.swing.GroupLayout(HariAbu);
        HariAbu.setLayout(HariAbuLayout);
        HariAbuLayout.setHorizontalGroup(
            HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HariAbuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HariAbuLayout.createSequentialGroup()
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HariAbuLayout.createSequentialGroup()
                                .addComponent(iconJmlTransaksi1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JmlTransaksi1))
                            .addGroup(HariAbuLayout.createSequentialGroup()
                                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iconJasaDiekerjakan1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iconJasaTerlaris1)
                                    .addComponent(iconProdukTerjual1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iconProdukTerlaris1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JasaDikerjakan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JasaTerlaris1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ProdukTerlaris1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ProdukTerjual1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(7, 7, 7)
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HariAbuLayout.createSequentialGroup()
                                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(titkdua13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(titikdua41))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(HariAbuLayout.createSequentialGroup()
                                        .addComponent(txtProdukterlaris1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numProdukTerlaris1))
                                    .addComponent(numProdukTerjual1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(HariAbuLayout.createSequentialGroup()
                                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(titikdua40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(titikdua39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(titikdua38))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numJmlTransaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numJasaDikerjakan1)
                                    .addGroup(HariAbuLayout.createSequentialGroup()
                                        .addComponent(txtJasaTerlaris1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numJasaTerlaris1))))))
                    .addGroup(HariAbuLayout.createSequentialGroup()
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HariAbuLayout.createSequentialGroup()
                                .addComponent(iconPendapatan1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Pendapatan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(HariAbuLayout.createSequentialGroup()
                                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iconPengeluaran1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iconLaba1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Laba1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Pengeluaran1))))
                        .addGap(16, 16, 16)
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titikdua35, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titikdua36, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titikdua37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RpPengeluaran1)
                            .addComponent(RpPendapatan1)
                            .addComponent(RpLaba1)))
                    .addGroup(HariAbuLayout.createSequentialGroup()
                        .addComponent(iconRingkasanOperasional1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RingkasanOperasional1))
                    .addGroup(HariAbuLayout.createSequentialGroup()
                        .addComponent(iconRingkasanKeuangan1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RingkasanKeuangan1))
                    .addGroup(HariAbuLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(InfoHarian)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        HariAbuLayout.setVerticalGroup(
            HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HariAbuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InfoHarian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconRingkasanKeuangan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RingkasanKeuangan1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Pendapatan1)
                        .addComponent(RpPendapatan1)
                        .addComponent(titikdua35))
                    .addComponent(iconPendapatan1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Pengeluaran1)
                        .addComponent(RpPengeluaran1)
                        .addComponent(titikdua36))
                    .addComponent(iconPengeluaran1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Laba1)
                        .addComponent(RpLaba1)
                        .addComponent(titikdua37))
                    .addComponent(iconLaba1))
                .addGap(26, 26, 26)
                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconRingkasanOperasional1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RingkasanOperasional1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HariAbuLayout.createSequentialGroup()
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JmlTransaksi1)
                            .addComponent(iconJmlTransaksi1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iconJasaDiekerjakan1)
                            .addComponent(JasaDikerjakan1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JasaTerlaris1)
                            .addComponent(iconJasaTerlaris1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iconProdukTerjual1)
                            .addComponent(ProdukTerjual1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ProdukTerlaris1)
                            .addComponent(iconProdukTerlaris1)))
                    .addGroup(HariAbuLayout.createSequentialGroup()
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titikdua38)
                            .addComponent(numJmlTransaksi1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titikdua39)
                            .addComponent(numJasaDikerjakan1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titikdua40)
                            .addComponent(txtJasaTerlaris1)
                            .addComponent(numJasaTerlaris1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(HariAbuLayout.createSequentialGroup()
                                .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(titikdua41)
                                    .addComponent(numProdukTerjual1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titkdua13))
                            .addGroup(HariAbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtProdukterlaris1)
                                .addComponent(numProdukTerlaris1)))))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout HariHitamLayout = new javax.swing.GroupLayout(HariHitam);
        HariHitam.setLayout(HariHitamLayout);
        HariHitamLayout.setHorizontalGroup(
            HariHitamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HariHitamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HariAbu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        HariHitamLayout.setVerticalGroup(
            HariHitamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HariHitamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HariAbu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BlackBgPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE)
                    .addComponent(BlackBgTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BulanHitam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HariHitam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BlackBgTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HariHitam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BlackBgPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BulanHitam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cetak_pngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cetak_pngMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cetak_pngMouseClicked

    private void btn_cetak_pngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetak_pngActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Simpan sebagai");
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet("Data Transaksi");
                Row header = sheet.createRow(0);
                for (int i = 0; i < tbl_pengeluaran.getColumnCount(); i++) {
                    Cell cell = header.createCell(i);
                    cell.setCellValue(tbl_pengeluaran.getColumnName(i));
                }
                for (int i = 0; i < tbl_pengeluaran.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < tbl_pengeluaran.getColumnCount(); j++) {
                        Object value = tbl_pengeluaran.getValueAt(i, j);
                        row.createCell(j).setCellValue(value == null ? "" : value.toString());
                    }
                }
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                if (!filePath.endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }
                try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                    workbook.write(fileOut);
                    JOptionPane.showMessageDialog(this, "Data berhasil diekspor ke Excel!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }                        
    }//GEN-LAST:event_btn_cetak_pngActionPerformed

    private void btn_batalPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batalPengeluaranMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_batalPengeluaranMouseClicked

    private void btn_batalPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalPengeluaranActionPerformed
        FieldKalenderPengeluaran.setText("");
        DefaultTableModel pengeluaranModel = (DefaultTableModel) tbl_pengeluaran.getModel();
        pengeluaranModel.setRowCount(0);
        getDataPengeluaran(pengeluaranModel);
    }//GEN-LAST:event_btn_batalPengeluaranActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        FieldKalenderTransaksi.setText("");
        DefaultTableModel transaksiModel = (DefaultTableModel) tbl_transaksi.getModel();
        transaksiModel.setRowCount(0);
        getDataTransaksi(transaksiModel);
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_batalMouseClicked

    private void btn_cetak_trsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetak_trsActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Simpan sebagai");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet("Data Transaksi");
                Row header = sheet.createRow(0);
                for (int i = 0; i < tbl_transaksi.getColumnCount(); i++) {
                    Cell cell = header.createCell(i);
                    cell.setCellValue(tbl_transaksi.getColumnName(i));
                }
                for (int i = 0; i < tbl_transaksi.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < tbl_transaksi.getColumnCount(); j++) {
                        Object value = tbl_transaksi.getValueAt(i, j);
                        row.createCell(j).setCellValue(value == null ? "" : value.toString());
                    }
                }
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                if (!filePath.endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }
                try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                    workbook.write(fileOut);
                    JOptionPane.showMessageDialog(this, "Data berhasil diekspor ke Excel!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_cetak_trsActionPerformed

    private void btn_cetak_trsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cetak_trsMouseClicked

    }//GEN-LAST:event_btn_cetak_trsMouseClicked

    private void FieldKalenderTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldKalenderTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldKalenderTransaksiActionPerformed

    private void FieldKalenderPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldKalenderPengeluaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldKalenderPengeluaranActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ananta.shape.shapecustom BlackBgPengeluaran;
    private com.ananta.shape.shapecustom BlackBgTransaksi;
    private com.ananta.shape.shapecustom BulanAbu;
    private com.ananta.shape.shapecustom BulanHitam;
    private javax.swing.JTextField FieldKalenderPengeluaran;
    private javax.swing.JTextField FieldKalenderTransaksi;
    private com.ananta.shape.shapecustom GrayBgTranskasi;
    private com.ananta.shape.shapecustom GrayBgpengeluaran;
    private com.ananta.shape.shapecustom HariAbu;
    private com.ananta.shape.shapecustom HariHitam;
    private javax.swing.JLabel InfoBulanan;
    private javax.swing.JLabel InfoHarian;
    private javax.swing.JLabel JasaDikerjakan;
    private javax.swing.JLabel JasaDikerjakan1;
    private javax.swing.JLabel JasaTerlaris;
    private javax.swing.JLabel JasaTerlaris1;
    private javax.swing.JLabel JmlTransaksi;
    private javax.swing.JLabel JmlTransaksi1;
    private javax.swing.JLabel Laba;
    private javax.swing.JLabel Laba1;
    private javax.swing.JLabel Pendapatan;
    private javax.swing.JLabel Pendapatan1;
    private javax.swing.JLabel Pengeluaran;
    private javax.swing.JLabel Pengeluaran1;
    private javax.swing.JLabel ProdukTerjual;
    private javax.swing.JLabel ProdukTerjual1;
    private javax.swing.JLabel ProdukTerlaris;
    private javax.swing.JLabel ProdukTerlaris1;
    private javax.swing.JLabel RingkasanKeuangan;
    private javax.swing.JLabel RingkasanKeuangan1;
    private javax.swing.JLabel RingkasanOperasional;
    private javax.swing.JLabel RingkasanOperasional1;
    private javax.swing.JLabel RpLaba;
    private javax.swing.JLabel RpLaba1;
    private javax.swing.JLabel RpPendapatan;
    private javax.swing.JLabel RpPendapatan1;
    private javax.swing.JLabel RpPengeluaran;
    private javax.swing.JLabel RpPengeluaran1;
    private com.ananta.shape.CustomButton btn_batal;
    private com.ananta.shape.CustomButton btn_batalPengeluaran;
    private com.ananta.shape.CustomButton btn_cetak_png;
    private com.ananta.shape.CustomButton btn_cetak_trs;
    private javax.swing.JLabel iconJasaDiekerjakan;
    private javax.swing.JLabel iconJasaDiekerjakan1;
    private javax.swing.JLabel iconJasaTerlaris;
    private javax.swing.JLabel iconJasaTerlaris1;
    private javax.swing.JLabel iconJmlTransaksi;
    private javax.swing.JLabel iconJmlTransaksi1;
    private javax.swing.JLabel iconLaba;
    private javax.swing.JLabel iconLaba1;
    private javax.swing.JLabel iconPendapatan;
    private javax.swing.JLabel iconPendapatan1;
    private javax.swing.JLabel iconPengeluaran;
    private javax.swing.JLabel iconPengeluaran1;
    private javax.swing.JLabel iconProdukTerjual;
    private javax.swing.JLabel iconProdukTerjual1;
    private javax.swing.JLabel iconProdukTerlaris;
    private javax.swing.JLabel iconProdukTerlaris1;
    private javax.swing.JLabel iconRingkasanKeuangan;
    private javax.swing.JLabel iconRingkasanKeuangan1;
    private javax.swing.JLabel iconRingkasanOperasional;
    private javax.swing.JLabel iconRingkasanOperasional1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelRiwayatTransaksi;
    private javax.swing.JLabel labelRiwayatTransaksi3;
    private javax.swing.JLabel numJasaDikerjakan;
    private javax.swing.JLabel numJasaDikerjakan1;
    private javax.swing.JLabel numJasaTerlaris;
    private javax.swing.JLabel numJasaTerlaris1;
    private javax.swing.JLabel numJmlTransaksi;
    private javax.swing.JLabel numJmlTransaksi1;
    private javax.swing.JLabel numProdukTerjual;
    private javax.swing.JLabel numProdukTerjual1;
    private javax.swing.JLabel numProdukTerlaris;
    private javax.swing.JLabel numProdukTerlaris1;
    private com.ananta.shape.shapecustom shapecustom8;
    private com.ananta.shape.shapecustom shapecustom9;
    private com.ananta.shape.JTabeel tbl_pengeluaran;
    private com.ananta.shape.JTabeel tbl_transaksi;
    private javax.swing.JLabel titikdua;
    private javax.swing.JLabel titikdua1;
    private javax.swing.JLabel titikdua3;
    private javax.swing.JLabel titikdua35;
    private javax.swing.JLabel titikdua36;
    private javax.swing.JLabel titikdua37;
    private javax.swing.JLabel titikdua38;
    private javax.swing.JLabel titikdua39;
    private javax.swing.JLabel titikdua4;
    private javax.swing.JLabel titikdua40;
    private javax.swing.JLabel titikdua41;
    private javax.swing.JLabel titikdua5;
    private javax.swing.JLabel titikdua6;
    private javax.swing.JLabel titikdua7;
    private javax.swing.JLabel titkdua13;
    private javax.swing.JLabel titkdua8;
    private javax.swing.JLabel txtJasaTerlaris;
    private javax.swing.JLabel txtJasaTerlaris1;
    private javax.swing.JLabel txtProdukterlaris;
    private javax.swing.JLabel txtProdukterlaris1;
    // End of variables declaration//GEN-END:variables

    //LABEL-LABEL
    private int pendapatanHarian() {
        int pendapatanHarian = 0;
        try {
            String sql = """
                         SELECT IFNULL(SUM(total_harga), 0) AS pemasukan
                         FROM transaksi
                         WHERE DATE(created_at) = CURDATE();
                         """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                pendapatanHarian = rs.getInt("pemasukan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pendapatanHarian;
    }

    private int pengeluaranHarian() {
        int pengeluaranHarian = 0;
        try {
            String sql = """
                         SELECT IFNULL(SUM(nominal), 0) AS pengeluaran
                         FROM pengeluaran
                         WHERE DATE(created_at) = CURDATE();
                         """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                pengeluaranHarian = rs.getInt("pengeluaran");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pengeluaranHarian;
    }

    private int labaHarian() {
        int labaHarian = 0;
        try {
            String sql = """
                         SELECT
                            IFNULL((
                                SELECT SUM(total_harga)
                                FROM transaksi
                                WHERE DATE(created_at) = CURDATE()
                            ), 0)
                             -
                            IFNULL((
                                SELECT SUM(nominal)
                                FROM pengeluaran
                                WHERE DATE(created_at) = CURDATE()
                            ), 0) AS laba;
                         """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                labaHarian = rs.getInt("laba");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return labaHarian;
    }

    private int transaksiHarian() {
        int transaksiHarian = 0;
        try {
            String sql = """
                        SELECT COUNT(*) AS jumlah_transaksi
                        FROM transaksi
                        WHERE DATE(created_at) = CURDATE();
                        """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                transaksiHarian = rs.getInt("jumlah_transaksi");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transaksiHarian;
    }

    private int jasaHarian() {
        int jasaHarian = 0;
        try {
            String sql = """
                        SELECT COUNT(*) AS jumlah_jasa_dikerjakan
                        FROM transaksi_jasa tj
                        JOIN transaksi t ON tj.id_transaksi = t.id_transaksi
                        WHERE DATE(t.created_at) = CURDATE();
                        """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                jasaHarian = rs.getInt("jumlah_jasa_dikerjakan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jasaHarian;
    }

    private int produkHarian() {
        int produkHarian = 0;
        try {
            String sql = """
                         SELECT COUNT(*) AS jumlah_produk
                         FROM transaksi_barang tb
                         JOIN transaksi t ON tb.id_transaksi = t.id_transaksi
                         WHERE DATE(t.created_at) = CURDATE();
                         """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                produkHarian = rs.getInt("jumlah_produk");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produkHarian;
    }

    private void jTerlarisHarian() {
        String namaJasaharian = "-";
        int jumlahJasaharian = 0;
        try {
            String sqlJasa = """
                            SELECT j.nama_jasa AS nama, COUNT(*) AS jumlah
                            FROM transaksi_jasa tj
                            JOIN transaksi t ON tj.id_transaksi = t.id_transaksi
                            JOIN jasa j ON tj.id_jasa = j.id_jasa
                            WHERE DATE(t.created_at) = CURDATE()
                            GROUP BY j.nama_jasa
                            ORDER BY jumlah DESC
                            LIMIT 1;
                            """;

            PreparedStatement st = conn.prepareStatement(sqlJasa);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                namaJasaharian = rs.getString("nama");
                jumlahJasaharian = rs.getInt("jumlah");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtJasaTerlaris1.setText(namaJasaharian);
        numJasaTerlaris1.setText("(" + jumlahJasaharian + "x)");
    }

    private void pTerlarisHarian() {
        String namaProdukharian = "-";
        int jumlahProdukharian = 0;
        try {
            String sql = """
                         SELECT b.nama_barang AS nama, COUNT(*) AS jumlah
                         FROM transaksi_barang tb
                         JOIN transaksi t ON tb.id_transaksi = t.id_transaksi
                         JOIN barang b ON tb.id_barang = b.id_barang
                         WHERE DATE(t.created_at) = CURDATE()
                         GROUP BY b.nama_barang
                         ORDER BY jumlah DESC
                         LIMIT 1;
                         """;

            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                namaProdukharian = rs.getString("nama");
                jumlahProdukharian = rs.getInt("jumlah");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtProdukterlaris1.setText(namaProdukharian);
        numProdukTerlaris1.setText("(" + jumlahProdukharian + "x)");
    }

    private void loadDataHarian() {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
        int pendapatan = pendapatanHarian();
        int pengeluaran = pengeluaranHarian();
        int laba = labaHarian();
        RpPendapatan1.setText(formatRupiah.format(pendapatan));
        RpPengeluaran1.setText(formatRupiah.format(pengeluaran));
        RpLaba1.setText(formatRupiah.format(laba));
        int jmlTransaksi = transaksiHarian();
        int jmlJasa = jasaHarian();
        int jmlProduk = produkHarian();
        numJmlTransaksi1.setText(String.valueOf(jmlTransaksi));
        numJasaDikerjakan1.setText(String.valueOf(jmlJasa));
        numProdukTerjual1.setText(String.valueOf(jmlProduk));
        jTerlarisHarian();
        pTerlarisHarian();
    }

    
    
    private int pendapatanBulanan () {
        int pendapatanBulanan = 0;
        try {
            String sql = """
                         SELECT IFNULL(SUM(total_harga), 0) AS pemasukan
                         FROM transaksi
                         WHERE MONTH(created_at) = MONTH(CURDATE()) 
                         AND YEAR(created_at) = YEAR(CURDATE());
                         """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                pendapatanBulanan = rs.getInt("pemasukan");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return pendapatanBulanan;
    }
    
    private int pengeluaranBulanan () {
        int pengeluaranBulanan = 0;
        try {
            String sql = """
                         SELECT IFNULL(SUM(nominal), 0) AS pengeluaran
                         FROM pengeluaran
                         WHERE MONTH(created_at) = MONTH(CURDATE()) 
                         AND YEAR(created_at) = YEAR(CURDATE());
                         """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                pengeluaranBulanan = rs.getInt("pengeluaran");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return pengeluaranBulanan;
    }
    
    private int labaBulanan() {
        int labaBulanan = 0;
        try {
            String sql = """
                         SELECT
                            IFNULL((
                                SELECT SUM(total_harga)
                                FROM transaksi
                                WHERE MONTH(created_at) = MONTH(CURDATE()) 
                                AND YEAR(created_at) = YEAR(CURDATE())
                            ), 0)
                             -
                            IFNULL((
                                SELECT SUM(nominal)
                                FROM pengeluaran
                                WHERE MONTH(created_at) = MONTH(CURDATE()) 
                                AND YEAR(created_at) = YEAR(CURDATE())
                            ), 0) AS laba;                          
                         """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                labaBulanan = rs.getInt("laba");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return labaBulanan;
    }
    
    private int transaksiBulanan() {
        int jmlTransaksi = 0;
        try {
            String sql = """
                        SELECT COUNT(*) AS jumlah_transaksi
                        FROM transaksi
                        WHERE MONTH(created_at) = MONTH(CURDATE()) 
                        AND YEAR(created_at) = YEAR(CURDATE());
                        """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                jmlTransaksi = rs.getInt("jumlah_transaksi");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jmlTransaksi;
    }

    
    private int jasaBulanan() {
        int jmlJasa = 0;
        try {
            String sql = """
                        SELECT COUNT(*) AS jumlah_jasa_dikerjakan
                        FROM transaksi_jasa tj
                        JOIN transaksi t ON tj.id_transaksi = t.id_transaksi
                        WHERE MONTH(t.created_at) = MONTH(CURDATE())
                        AND YEAR(t.created_at) = YEAR(CURDATE());
                        """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                jmlJasa = rs.getInt("jumlah_jasa_dikerjakan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jmlJasa;
    }
    
    private int produkBulanan() {
        int jmlProduk = 0;
        try {
            String sql = """
                         SELECT COUNT(*) AS jumlah_produk
                         FROM transaksi_barang tb
                         JOIN transaksi t ON tb.id_transaksi = t.id_transaksi
                         WHERE MONTH(t.created_at) = MONTH(CURDATE()) 
                         AND YEAR(t.created_at) = YEAR(CURDATE());
                         """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                jmlProduk = rs.getInt("jumlah_produk");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jmlProduk;
    }

    private void jTerlarisBulanan() {
        String namaJasa = "-";
        int jumlahJasa = 0;
        try {
            String sqlJasa = """
                            SELECT j.nama_jasa AS nama, COUNT(*) AS jumlah
                            FROM transaksi_jasa tj
                            JOIN transaksi t ON tj.id_transaksi = t.id_transaksi
                            JOIN jasa j ON tj.id_jasa = j.id_jasa
                            WHERE MONTH(t.created_at) = MONTH(CURDATE()) 
                            AND YEAR(t.created_at) = YEAR(CURDATE())
                            GROUP BY j.nama_jasa
                            ORDER BY jumlah DESC
                            LIMIT 1;
                            """;
            PreparedStatement st = conn.prepareStatement(sqlJasa);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                namaJasa = rs.getString("nama");
                jumlahJasa = rs.getInt("jumlah");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtJasaTerlaris.setText(namaJasa);
        numJasaTerlaris.setText("(" + jumlahJasa + "x)");
    }
    
    private void pTerlarisBulanan() {
        String namaProduk = "-";
        int jumlahProduk = 0;
        try {
            String sql = """
                         SELECT b.nama_barang AS nama, COUNT(*) AS jumlah
                         FROM transaksi_barang tb
                         JOIN transaksi t ON tb.id_transaksi = t.id_transaksi
                         JOIN barang b ON tb.id_barang = b.id_barang
                         WHERE MONTH(t.created_at) = MONTH(CURDATE()) 
                         AND YEAR(t.created_at) = YEAR(CURDATE())
                         GROUP BY b.nama_barang
                         ORDER BY jumlah DESC
                         LIMIT 1;
                         """;

            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                namaProduk = rs.getString("nama");
                jumlahProduk = rs.getInt("jumlah");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtProdukterlaris.setText(namaProduk);
        numProdukTerlaris.setText("(" + jumlahProduk + "x)");
    }

    
    private void loadData() {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
        int pendapatan = pendapatanBulanan();
        int pengeluaran = pengeluaranBulanan();
        int laba = labaBulanan();
        RpPendapatan.setText(formatRupiah.format(pendapatan));
        RpPengeluaran.setText(formatRupiah.format(pengeluaran));
        RpLaba.setText(formatRupiah.format(laba));
        int jmlTransaksi = transaksiBulanan();
        int jmlJasa = jasaBulanan();
        int jmlProduk = produkBulanan();
        numJmlTransaksi.setText(String.valueOf(jmlTransaksi));
        numJasaDikerjakan.setText(String.valueOf(jmlJasa));
        numProdukTerjual.setText(String.valueOf(jmlProduk));
        jTerlarisBulanan();
        pTerlarisBulanan();
    }

    
    //TABEL TABEL
    private void setModelTabelTransaksi() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID TRANSAKSI");
        model.addColumn("WAKTU/TANGGAL");
        model.addColumn("NAMA KASIR");
        model.addColumn("DETAIL TRANSAKSI");
        model.addColumn("TOTAL PEMBAYARAN");
        tbl_transaksi.setModel(model);
    }
    
    private void lebarKolomTransaksi() {
        TableColumnModel modelKolomTrs = tbl_transaksi.getColumnModel();
        modelKolomTrs.getColumn(0).setPreferredWidth(50); // ID Transaksi
        modelKolomTrs.getColumn(1).setPreferredWidth(120); // Tanggal
        modelKolomTrs.getColumn(2).setPreferredWidth(30); // Kasir
//        modelKolomTrs.getColumn(3).setMinWidth(350);       // Detail Transaksi
        modelKolomTrs.getColumn(3).setPreferredWidth(400);
        modelKolomTrs.getColumn(4).setPreferredWidth(150); // Total
    }
    
    private void getDataTransaksi(DefaultTableModel model) {
        try {
            String sql = """
                SELECT t.id_transaksi, t.created_at, u.username AS kasir, 
                       CONCAT_WS(', ', 
                           (SELECT GROUP_CONCAT(j.nama_jasa) 
                            FROM transaksi_jasa tj 
                            JOIN jasa j ON tj.id_jasa = j.id_jasa 
                            WHERE tj.id_transaksi = t.id_transaksi), 
                           (SELECT GROUP_CONCAT(b.nama_barang) 
                            FROM transaksi_barang tb 
                            JOIN barang b ON tb.id_barang = b.id_barang 
                            WHERE tb.id_transaksi = t.id_transaksi)
                       ) AS detail_transaksi, 
                       t.total_harga
                FROM transaksi t
                JOIN users u ON t.id_user = u.id_user
                ORDER BY t.id_transaksi DESC;
            """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_transaksi"),
                    rs.getString("created_at"),
                    rs.getString("kasir"),
                    rs.getString("detail_transaksi"),
                    formatRupiah.format(rs.getDouble("total_harga"))
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data transaksi.");
        }
    }

    private void lebarKolomPengeluaran() {
        TableColumnModel modelKolomTrs = tbl_pengeluaran.getColumnModel();
        modelKolomTrs.getColumn(0).setPreferredWidth(70); 
        modelKolomTrs.getColumn(1).setPreferredWidth(150);  
        modelKolomTrs.getColumn(2).setPreferredWidth(50);  
        modelKolomTrs.getColumn(3).setMinWidth(280);        
        modelKolomTrs.getColumn(3).setPreferredWidth(330);
        modelKolomTrs.getColumn(4).setPreferredWidth(150);  
    }

    private void setModelTabelPengeluaran() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PENGELUARAN");
        model.addColumn("WAKTU/TANGGAL");
        model.addColumn("NAMA KASIR");
        model.addColumn("KATEGORI");
        model.addColumn("TOTAL HARGA");
        tbl_pengeluaran.setModel(model);
    }

    private void getDataPengeluaran(DefaultTableModel model) {
        try {
            String sql = """
                SELECT 
                        p.id_pengeluaran,
                        p.created_at,
                        u.username AS kasir,
                        CASE 
                            WHEN p.kategori = 'Restock Barang' THEN 
                                CONCAT(p.kategori, ' (', b.nama_barang, ')')
                            ELSE p.kategori
                        END AS kategori,
                        p.nominal
                    FROM pengeluaran p
                    JOIN users u ON p.id_user = u.id_user
                    LEFT JOIN barang b ON p.id_barang = b.id_barang
                    ORDER BY p.id_pengeluaran DESC;
                """;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_pengeluaran"),
                    rs.getString("created_at"),
                    rs.getString("kasir"),
                    rs.getString("kategori"),
                    formatRupiah.format(rs.getDouble("nominal"))
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data pengeluaran.");
        }
    } 
}


