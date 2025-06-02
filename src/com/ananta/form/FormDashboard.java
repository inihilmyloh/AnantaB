package com.ananta.form;

import com.ananta.database.Database;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Locale;
import javax.swing.SwingUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;

public class FormDashboard extends javax.swing.JPanel {

    private Connection con;

    public FormDashboard() {
        initComponents();
        con = Database.getConnection();
        AmbilData();

        con = Database.getConnection();
        SwingUtilities.invokeLater(() -> {
            showPieChart();
            showLineChart();
        });
    }

    public void showPieChart() {
        try {
            DefaultPieDataset dataset = new DefaultPieDataset();

            // Ambil awal bulan ini
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime startOfMonth = now.withDayOfMonth(1).toLocalDate().atStartOfDay();

            // --- Barang ---
            String sqlBarang = """
            SELECT b.nama_barang, SUM(tb.jumlah) as total
            FROM transaksi_barang tb
            JOIN barang b ON tb.id_barang = b.id_barang
            JOIN transaksi t ON tb.id_transaksi = t.id_transaksi
            WHERE t.created_at >= ?
            GROUP BY tb.id_barang
        """;
            PreparedStatement psBarang = con.prepareStatement(sqlBarang);
            psBarang.setTimestamp(1, Timestamp.valueOf(startOfMonth));
            ResultSet rsBarang = psBarang.executeQuery();
            while (rsBarang.next()) {
                dataset.setValue(rsBarang.getString("nama_barang"), rsBarang.getInt("total"));
            }

            // --- Jasa ---
            String sqlJasa = """
            SELECT j.nama_jasa, COUNT(*) as total
            FROM transaksi_jasa tj
            JOIN jasa j ON tj.id_jasa = j.id_jasa
            JOIN transaksi t ON tj.id_transaksi = t.id_transaksi
            WHERE t.created_at >= ?
            GROUP BY tj.id_jasa
        """;
            PreparedStatement psJasa = con.prepareStatement(sqlJasa);
            psJasa.setTimestamp(1, Timestamp.valueOf(startOfMonth));
            ResultSet rsJasa = psJasa.executeQuery();
            while (rsJasa.next()) {
                dataset.setValue(rsJasa.getString("nama_jasa"), rsJasa.getInt("total"));
            }

            // Buat chart
            JFreeChart pieChart = ChartFactory.createPieChart(
                    "Penjualan Barang & Jasa (Bulan Ini)", dataset, true, true, false);

            // Panel chart
            ChartPanel chartPanel = new ChartPanel(pieChart);

            // Plot
            PiePlot plot = (PiePlot) pieChart.getPlot();
            plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})"));
            plot.setLabelFont(new Font("Montserrat", Font.PLAIN, 12));
            plot.setOutlineVisible(false);
            plot.setShadowPaint(new Color(150, 150, 150, 30));
            plot.setInteriorGap(0.04);

            // Warna custom
            Color[] colors = {
                new Color(93, 173, 226),
                new Color(88, 214, 141),
                new Color(245, 176, 65),
                new Color(231, 76, 60),
                new Color(165, 105, 189),
                new Color(127, 140, 141)
            };
            int i = 0;
            for (Object key : dataset.getKeys()) {
                plot.setSectionPaint((Comparable) key, colors[i % colors.length]);
                i++;
            }

            // Judul font
            pieChart.getTitle().setFont(new Font("Montserrat", Font.BOLD, 18));

            // Update panel
            panelPieChart.removeAll();
            panelPieChart.add(chartPanel, java.awt.BorderLayout.CENTER);
            panelPieChart.revalidate();
            panelPieChart.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showLineChart() {
        try {
            // Dataset untuk line chart
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            // Ambil tanggal hari ini dan tanggal awal bulan ini
            LocalDate today = LocalDate.now();
            LocalDate startOfMonth = today.withDayOfMonth(1);

            // Query SQL untuk hitung nominal transaksi per tanggal sejak awal bulan
            String sql = """
            SELECT DATE_FORMAT(created_at, '%Y-%m-%d') AS tanggal, COUNT(*) AS nominal
            FROM transaksi
            WHERE created_at >= ?
            GROUP BY tanggal
            ORDER BY tanggal
        """;

            // Prepare statement dan set parameter tanggal awal bulan
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(startOfMonth.atStartOfDay()));

            ResultSet rs = ps.executeQuery();

            // Isi dataset dengan data dari ResultSet
            while (rs.next()) {
                String tanggal = rs.getString("tanggal");
                int nominal = rs.getInt("nominal");
                dataset.addValue(nominal, "Transaksi", tanggal);
            }

            // Buat LineChart dengan dataset
            JFreeChart lineChart = ChartFactory.createLineChart(
                    "Nominal Transaksi Harian (Bulan Ini)",
                    "Tanggal", "nominal Transaksi",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true, true, false
            );

            // Atur axis Y supaya angka hanya bilangan bulat
            CategoryPlot plot = (CategoryPlot) lineChart.getPlot();
            NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
            yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

            // Buat ChartPanel dan set ukuran
            ChartPanel chartPanel = new ChartPanel(lineChart);
            chartPanel.setPreferredSize(new java.awt.Dimension(800, 400));

            // Nonaktifkan zoom dan menu klik kanan agar chart tidak bisa diubah-ubah user
            chartPanel.setMouseZoomable(false);
            chartPanel.setDomainZoomable(false);
            chartPanel.setRangeZoomable(false);
            chartPanel.setPopupMenu(null);

            // Tampilkan chart di panelLineChart
            panelLineChart.removeAll();
            panelLineChart.add(chartPanel, java.awt.BorderLayout.CENTER);
            panelLineChart.revalidate();
            panelLineChart.repaint();

            // Tutup resource
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panelLineChart = new com.ananta.shape.shapecustom();
        shapecustom1 = new com.ananta.shape.shapecustom();
        shapecustom4 = new com.ananta.shape.shapecustom();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Label_Pelanggan = new javax.swing.JLabel();
        shapecustom2 = new com.ananta.shape.shapecustom();
        shapecustom6 = new com.ananta.shape.shapecustom();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Label_Pemasukan = new javax.swing.JLabel();
        shapecustom3 = new com.ananta.shape.shapecustom();
        shapecustom7 = new com.ananta.shape.shapecustom();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Label_Pengeluaran = new javax.swing.JLabel();
        shapecustom5 = new com.ananta.shape.shapecustom();
        shapecustom8 = new com.ananta.shape.shapecustom();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Label_Laba = new javax.swing.JLabel();
        panelPieChart = new com.ananta.shape.shapecustom();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setBackground(new java.awt.Color(212, 212, 212));

        jPanel1.setBackground(new java.awt.Color(212, 212, 212));

        panelLineChart.setBackground(new java.awt.Color(255, 252, 252));
        panelLineChart.setRoundBottomLeft(30);
        panelLineChart.setRoundBottomRight(30);
        panelLineChart.setRoundTopLeft(30);
        panelLineChart.setRoundTopRight(30);
        panelLineChart.setLayout(new java.awt.BorderLayout());

        shapecustom1.setRoundBottomLeft(30);
        shapecustom1.setRoundBottomRight(30);
        shapecustom1.setRoundTopLeft(30);
        shapecustom1.setRoundTopRight(30);

        shapecustom4.setBackground(new java.awt.Color(1, 121, 6));
        shapecustom4.setPreferredSize(new java.awt.Dimension(150, 138));
        shapecustom4.setRoundBottomLeft(30);
        shapecustom4.setRoundTopLeft(30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/customer.png"))); // NOI18N

        javax.swing.GroupLayout shapecustom4Layout = new javax.swing.GroupLayout(shapecustom4);
        shapecustom4.setLayout(shapecustom4Layout);
        shapecustom4Layout.setHorizontalGroup(
            shapecustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        shapecustom4Layout.setVerticalGroup(
            shapecustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 30)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Pelanggan ");

        Label_Pelanggan.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        Label_Pelanggan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Pelanggan.setText("99");

        javax.swing.GroupLayout shapecustom1Layout = new javax.swing.GroupLayout(shapecustom1);
        shapecustom1.setLayout(shapecustom1Layout);
        shapecustom1Layout.setHorizontalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom1Layout.createSequentialGroup()
                .addComponent(shapecustom4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(Label_Pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        shapecustom1Layout.setVerticalGroup(
            shapecustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(shapecustom4, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );

        shapecustom2.setRoundBottomLeft(30);
        shapecustom2.setRoundBottomRight(30);
        shapecustom2.setRoundTopLeft(30);
        shapecustom2.setRoundTopRight(30);

        shapecustom6.setBackground(new java.awt.Color(239, 167, 0));
        shapecustom6.setPreferredSize(new java.awt.Dimension(150, 138));
        shapecustom6.setRoundBottomLeft(30);
        shapecustom6.setRoundTopLeft(30);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/income.png"))); // NOI18N

        javax.swing.GroupLayout shapecustom6Layout = new javax.swing.GroupLayout(shapecustom6);
        shapecustom6.setLayout(shapecustom6Layout);
        shapecustom6Layout.setHorizontalGroup(
            shapecustom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel11)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        shapecustom6Layout.setVerticalGroup(
            shapecustom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(42, 42, 42))
        );

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 30)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Pemasukan");

        Label_Pemasukan.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        Label_Pemasukan.setText("00000");

        javax.swing.GroupLayout shapecustom2Layout = new javax.swing.GroupLayout(shapecustom2);
        shapecustom2.setLayout(shapecustom2Layout);
        shapecustom2Layout.setHorizontalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom2Layout.createSequentialGroup()
                .addComponent(shapecustom6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(Label_Pemasukan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        shapecustom2Layout.setVerticalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shapecustom6, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
            .addGroup(shapecustom2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Pemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        shapecustom3.setRoundBottomLeft(30);
        shapecustom3.setRoundBottomRight(30);
        shapecustom3.setRoundTopLeft(30);
        shapecustom3.setRoundTopRight(30);

        shapecustom7.setBackground(new java.awt.Color(1, 121, 6));
        shapecustom7.setRoundBottomLeft(30);
        shapecustom7.setRoundTopLeft(30);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/expenditure.png"))); // NOI18N

        javax.swing.GroupLayout shapecustom7Layout = new javax.swing.GroupLayout(shapecustom7);
        shapecustom7.setLayout(shapecustom7Layout);
        shapecustom7Layout.setHorizontalGroup(
            shapecustom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel12)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        shapecustom7Layout.setVerticalGroup(
            shapecustom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(42, 42, 42))
        );

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 30)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Pengeluaran");

        Label_Pengeluaran.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        Label_Pengeluaran.setText("00000");

        javax.swing.GroupLayout shapecustom3Layout = new javax.swing.GroupLayout(shapecustom3);
        shapecustom3.setLayout(shapecustom3Layout);
        shapecustom3Layout.setHorizontalGroup(
            shapecustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom3Layout.createSequentialGroup()
                .addComponent(shapecustom7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(shapecustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(Label_Pengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        shapecustom3Layout.setVerticalGroup(
            shapecustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shapecustom7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(shapecustom3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Pengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        shapecustom5.setRoundBottomLeft(30);
        shapecustom5.setRoundBottomRight(30);
        shapecustom5.setRoundTopLeft(30);
        shapecustom5.setRoundTopRight(30);

        shapecustom8.setBackground(new java.awt.Color(239, 167, 0));
        shapecustom8.setRoundBottomLeft(30);
        shapecustom8.setRoundTopLeft(30);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/laba.png"))); // NOI18N

        javax.swing.GroupLayout shapecustom8Layout = new javax.swing.GroupLayout(shapecustom8);
        shapecustom8.setLayout(shapecustom8Layout);
        shapecustom8Layout.setHorizontalGroup(
            shapecustom8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel13)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        shapecustom8Layout.setVerticalGroup(
            shapecustom8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(42, 42, 42))
        );

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 30)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Laba");

        Label_Laba.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        Label_Laba.setText("00000");

        javax.swing.GroupLayout shapecustom5Layout = new javax.swing.GroupLayout(shapecustom5);
        shapecustom5.setLayout(shapecustom5Layout);
        shapecustom5Layout.setHorizontalGroup(
            shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom5Layout.createSequentialGroup()
                .addComponent(shapecustom8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(Label_Laba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        shapecustom5Layout.setVerticalGroup(
            shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shapecustom8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(shapecustom5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Laba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPieChart.setBackground(new java.awt.Color(255, 252, 252));
        panelPieChart.setRoundBottomLeft(30);
        panelPieChart.setRoundBottomRight(30);
        panelPieChart.setRoundTopLeft(30);
        panelPieChart.setRoundTopRight(30);
        panelPieChart.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 1));
        jLabel1.setText("Dashboard");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(shapecustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(shapecustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(shapecustom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(shapecustom5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(panelLineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelPieChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shapecustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shapecustom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shapecustom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shapecustom5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(panelLineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1625, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_Laba;
    private javax.swing.JLabel Label_Pelanggan;
    private javax.swing.JLabel Label_Pemasukan;
    private javax.swing.JLabel Label_Pengeluaran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.ananta.shape.shapecustom panelLineChart;
    private com.ananta.shape.shapecustom panelPieChart;
    private com.ananta.shape.shapecustom shapecustom1;
    private com.ananta.shape.shapecustom shapecustom2;
    private com.ananta.shape.shapecustom shapecustom3;
    private com.ananta.shape.shapecustom shapecustom4;
    private com.ananta.shape.shapecustom shapecustom5;
    private com.ananta.shape.shapecustom shapecustom6;
    private com.ananta.shape.shapecustom shapecustom7;
    private com.ananta.shape.shapecustom shapecustom8;
    // End of variables declaration//GEN-END:variables

    private String formatRupiah(int angka) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(new Locale("id", "ID"));
        return "Rp " + formatter.format(angka);
    }

    private String jumlahTransaksiHariIni() {
        int totalTransaksi = 0;

        try {
            String sql = "SELECT COUNT(*) AS total FROM transaksi WHERE DATE(created_at) = CURDATE()";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                totalTransaksi = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(totalTransaksi);
    }

    private String jumlahPemasukanHariIni() {
        int totalPemasukan = 0;

        try {
            String sql = "SELECT SUM(total_harga) AS total FROM transaksi WHERE DATE(created_at) = CURDATE()";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                totalPemasukan = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return formatRupiah(totalPemasukan);
    }

    private String jumlahPengeluaranHariIni() {
        int totalPengeluaran = 0;

        try {
            String sql = "SELECT SUM(nominal) AS total FROM pengeluaran WHERE DATE(created_at) = CURDATE()";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                totalPengeluaran = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return formatRupiah(totalPengeluaran);
    }

    private String jumlahLabaHariIni() {
        int totalPemasukan = 0;
        int totalPengeluaran = 0;

        try {
            // Ambil total pemasukan dari transaksi hari ini
            String sqlPemasukan = "SELECT SUM(total_harga) AS total FROM transaksi WHERE DATE(created_at) = CURDATE()";
            PreparedStatement stPemasukan = con.prepareStatement(sqlPemasukan);
            ResultSet rsPemasukan = stPemasukan.executeQuery();
            if (rsPemasukan.next()) {
                totalPemasukan = rsPemasukan.getInt("total");
            }

            // Ambil total pengeluaran dari pengeluaran hari ini
            String sqlPengeluaran = "SELECT SUM(nominal) AS total FROM pengeluaran WHERE DATE(created_at) = CURDATE()";
            PreparedStatement stPengeluaran = con.prepareStatement(sqlPengeluaran);
            ResultSet rsPengeluaran = stPengeluaran.executeQuery();
            if (rsPengeluaran.next()) {
                totalPengeluaran = rsPengeluaran.getInt("total");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        int laba = totalPemasukan - totalPengeluaran;
        return formatRupiah(laba);
    }

    private void AmbilData() {
        Label_Pelanggan.setText(String.valueOf(jumlahTransaksiHariIni()));
        Label_Pemasukan.setText(String.valueOf(jumlahPemasukanHariIni()));
        Label_Pengeluaran.setText(String.valueOf(jumlahPengeluaranHariIni()));
        Label_Laba.setText(String.valueOf(jumlahLabaHariIni()));
    }
}
