package com.ananta.form;

import com.ananta.database.Database;
import java.awt.Component;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.text.*;
import javax.print.PrintService;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.Copies;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.util.HashMap;
import net.sf.jasperreports.engine.util.JRLoader;

public class FormTransaksi extends javax.swing.JPanel {

    public FormTransaksi() {
        initComponents();
        loadComboBoxJasa();
        KasirText.setEditable(false);
        KasirText.setFocusable(false);
        TotalHargaText.setEditable(false);
        TotalHargaText.setFocusable(false);
        KembaliText.setEditable(false);
        KembaliText.setFocusable(false);
        tabelTransaksi();
        loadComboBoxBarber();
        loadComboBoxMetodeBayar();
        EditBT.setVisible(false);
        HapusBT.setVisible(false);
        barcodeText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String barcode = barcodeText.getText().trim();
                    try {
                        Connection conn = Database.getConnection();
                        String sql = "SELECT id_barang, nama_barang, harga, jumlah FROM barang WHERE barcode = ?";
                        PreparedStatement pst = conn.prepareStatement(sql);
                        pst.setString(1, barcode);
                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {
                            int idBarang = rs.getInt("id_barang");
                            String namaBarang = rs.getString("nama_barang");
                            int harga = rs.getInt("harga");
                            int stok = rs.getInt("jumlah");

                            int jumlahDiKeranjang = keranjangBarang.getOrDefault(idBarang, 0);

                            if (stok <= jumlahDiKeranjang) {
                                JOptionPane.showMessageDialog(null,
                                        "Stok untuk \"" + namaBarang + "\" habis atau sudah mencapai batas maksimal (" + stok + ").",
                                        "Stok Habis", JOptionPane.WARNING_MESSAGE);
                            } else {
                                keranjangBarang.put(idBarang, jumlahDiKeranjang + 1);
                                totalHargaBarang += harga;

                                undoStack.push(() -> {
                                    int jumlah = keranjangBarang.get(idBarang);
                                    if (jumlah > 1) {
                                        keranjangBarang.put(idBarang, jumlah - 1);
                                    } else {
                                        keranjangBarang.remove(idBarang);
                                    }
                                    totalHargaBarang -= harga;
                                    updateTampilanDetail();
                                    updateTotalHarga();
                                });

                                updateTampilanDetail();
                                updateTotalHarga();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Barang dengan barcode ini tidak ditemukan.");
                        }

                        barcodeText.setText("");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        BayarText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String input = BayarText.getText().replaceAll("[^\\d]", "");

                if (!input.isEmpty()) {
                    try {
                        int angka = Integer.parseInt(input);
                        BayarText.setText(formatRupiah(angka));
                    } catch (NumberFormatException e) {
                        BayarText.setText("");
                    }
                }
                // Hitung kembali di sini juga
                try {
                    String totalStr = TotalHargaText.getText().replaceAll("[^\\d]", "");
                    String bayarStr = BayarText.getText().replaceAll("[^\\d]", "");

                    int total = Integer.parseInt(totalStr);
                    int bayar = Integer.parseInt(bayarStr);
                    int kembali = bayar - total;

                    KembaliText.setText(formatRupiah(kembali));
                } catch (NumberFormatException e) {
                    KembaliText.setText("Rp0");
                }
            }
        });
        EditBT.addActionListener(e -> editTransaksi());
        PaymentCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String metode = PaymentCB.getSelectedItem().toString();
                if (metode.equalsIgnoreCase("QRIS")) {
                    int total = totalHargaBarang + totalHargaJasa;
                    BayarText.setText(formatRupiah(total));
                    BayarText.setEditable(false);
                    updateKembalian();
                } else {
                    BayarText.setText("");
                    KembaliText.setText("Rp0");
                    BayarText.setEditable(true); // Biar bisa diisi manual untuk Tunai
                }
            }
        });
    }

    private int transaksiYangSedangDiedit = -1;
    private boolean listenerSudahDitambahkan = false;
    private Map<String, Integer> barberMap = new HashMap<>();
    Map<Integer, Integer> keranjangBarang = new HashMap<>();
    Stack<Runnable> undoStack = new Stack<>();
    private Map<String, Integer> namaKeIdKasir = new HashMap<>();
    private List<String> jasaList = new ArrayList<>();
    private int totalHarga = 0;
    private int idKasir;
    private int totalHargaBarang = 0;
    private int totalHargaJasa = 0;

    private void updateTotalHarga() {
        int total = totalHargaBarang + totalHargaJasa;
        TotalHargaText.setText(formatRupiah(total));
    }

    public void setKasir(int id, String nama) {
        this.idKasir = id;
        KasirText.setText(nama); // tampilkan nama di field
    }

    private void loadComboBoxJasa() {
        JasaCB.removeAllItems();
        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT nama_jasa FROM jasa";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                JasaCB.addItem(rs.getString("nama_jasa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String formatRupiah(int angka) {
        DecimalFormatSymbols simbol = new DecimalFormatSymbols();
        simbol.setGroupingSeparator('.');
        simbol.setDecimalSeparator(',');
        DecimalFormat formatRupiah = new DecimalFormat("Rp#,##0", simbol);
        return formatRupiah.format(angka);
    }

    private void resetFormTransaksi() {
        DetailTotalText.setText("");
        TotalHargaText.setText(formatRupiah(0));
        BayarText.setText("");
        KembaliText.setText("");
        JasaCB.setSelectedIndex(0);
        BarberCB.setSelectedIndex(0);
        PaymentCB.setSelectedIndex(0);
        EditBT.setVisible(false);
        HapusBT.setVisible(false);
        transaksiYangSedangDiedit = -1;
        jasaList.clear();
        keranjangBarang.clear();
        totalHargaBarang = 0;
        totalHargaJasa = 0;
        totalHarga = 0;

        tabelTransaksi();
    }

    private void loadComboBoxBarber() {
        BarberCB.removeAllItems();
        barberMap.clear();

        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT id_karyawan, nama FROM karyawan WHERE posisi = 'barber'";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_karyawan");
                String nama = rs.getString("nama");

                BarberCB.addItem(nama);
                barberMap.put(nama, id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getBarberNameById(int idBarber) {
        for (Map.Entry<String, Integer> entry : barberMap.entrySet()) {
            if (entry.getValue() == idBarber) {
                return entry.getKey();
            }
        }
        return null;
    }

    private void tabelTransaksi() {
        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT t.id_transaksi, u.username AS kasir, t.total_harga, t.metode_pembayaran, "
                    + "GROUP_CONCAT(DISTINCT j.nama_jasa SEPARATOR ', ') AS jasa_dipilih, "
                    + "GROUP_CONCAT(DISTINCT b.nama_barang SEPARATOR ', ') AS barang_dipilih "
                    + "FROM transaksi t "
                    + "JOIN users u ON t.id_user = u.id_user "
                    + "LEFT JOIN transaksi_jasa tj ON t.id_transaksi = tj.id_transaksi "
                    + "LEFT JOIN jasa j ON tj.id_jasa = j.id_jasa "
                    + "LEFT JOIN transaksi_barang tb ON t.id_transaksi = tb.id_transaksi "
                    + "LEFT JOIN barang b ON tb.id_barang = b.id_barang "
                    + "GROUP BY t.id_transaksi "
                    + "ORDER BY t.created_at DESC";
            PreparedStatement tb = conn.prepareStatement(sql);
            ResultSet tbs = tb.executeQuery();

            DefaultTableModel model = (DefaultTableModel) RiwayatTB.getModel();
            model.setRowCount(0);

            int no = 1;
            while (tbs.next()) {
                model.addRow(new Object[]{
                    no++,
                    tbs.getInt("id_transaksi"),
                    tbs.getString("kasir"),
                    formatRupiah(tbs.getBigDecimal("total_harga").intValue()),
                    tbs.getString("metode_pembayaran"),
                    tbs.getString("jasa_dipilih"),
                    tbs.getString("barang_dipilih")
                });
            }

            // Sembunyikan kolom id_transaksi (kolom ke-1)
            RiwayatTB.getColumnModel().getColumn(1).setMinWidth(0);
            RiwayatTB.getColumnModel().getColumn(1).setMaxWidth(0);
            RiwayatTB.getColumnModel().getColumn(1).setWidth(0);

            // Tambah listener jika belum ada
            if (!listenerSudahDitambahkan) {
                RiwayatTB.getSelectionModel().addListSelectionListener(e -> {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = RiwayatTB.getSelectedRow();
                        EditBT.setVisible(selectedRow != -1);
                        HapusBT.setVisible(selectedRow != -1);
                    }
                });
                listenerSudahDitambahkan = true;
            }

            EditBT.setVisible(false);
            HapusBT.setVisible(false);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String centerText(String text) {
        int paperWidth = 48; // Lebar karakter maksimal untuk 80mm
        int padding = (paperWidth - text.length()) / 2;
        if (padding < 0) {
            padding = 0;
        }
        return " ".repeat(padding) + text;
    }

    private void cetakStruk(int idTransaksi) {
        try {
            // Path file jasper
            String path = "src/com/ananta/struk/StrukTransaksi.jasper";
            Connection conn = Database.getConnection();

            // Parameter
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id_transaksi", idTransaksi);

            // Load dan cetak laporan
            JasperPrint print = JasperFillManager.fillReport(path, parameters, conn);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mencetak laporan: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void cetakStruk2(JTable table, int rowIndex) {
        try {
            String printerName = "Thermal Printer Generic";

            // Cari printer yang sesuai
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            PrintService selectedService = null;
            for (PrintService service : services) {
                if (service.getName().equalsIgnoreCase(printerName)) {
                    selectedService = service;
                    break;
                }
            }

            if (selectedService == null) {
                System.out.println("Printer tidak ditemukan.");
                return;
            }

            int idTransaksi = Integer.parseInt(table.getValueAt(rowIndex, 1).toString());

            // Format struk
            StringBuilder sb = new StringBuilder();
            sb.append(centerText("=== ANANTA BARBERSHOP ===")).append("\n");
            sb.append("No Transaksi : ").append(table.getValueAt(rowIndex, 0)).append("\n");
            sb.append("ID Transaksi : ").append(idTransaksi).append("\n");
            sb.append("Kasir        : ").append(table.getValueAt(rowIndex, 2)).append("\n");
            sb.append("Metode Bayar : ").append(table.getValueAt(rowIndex, 4)).append("\n");
            sb.append(centerText("---------------------------")).append("\n");
            sb.append("JASA YANG DIPILIH:\n");

            Connection conn = Database.getConnection();

            // Ambil jasa dari database
            String sqlJasa = "SELECT j.nama_jasa, tj.harga "
                    + "FROM transaksi_jasa tj "
                    + "JOIN jasa j ON tj.id_jasa = j.id_jasa "
                    + "WHERE tj.id_transaksi = ?";
            PreparedStatement pstJasa = conn.prepareStatement(sqlJasa);
            pstJasa.setInt(1, idTransaksi);
            ResultSet rsJasa = pstJasa.executeQuery();

            int total = 0;
            while (rsJasa.next()) {
                String namaJasa = rsJasa.getString("nama_jasa");
                int harga = rsJasa.getInt("harga");
                sb.append("- ").append(namaJasa).append(" : ").append(formatRupiah(harga)).append("\n");
                total += harga;
            }

            // Ambil barang dari database
            sb.append(centerText("---------------------------")).append("\n");
            sb.append("BARANG YANG DIBELI:\n");
            String sqlBarang = "SELECT b.nama_barang, tb.harga, tb.jumlah "
                    + "FROM transaksi_barang tb "
                    + "JOIN barang b ON tb.id_barang = b.id_barang "
                    + "WHERE tb.id_transaksi = ?";
            PreparedStatement pstBarang = conn.prepareStatement(sqlBarang);
            pstBarang.setInt(1, idTransaksi);
            ResultSet rsBarang = pstBarang.executeQuery();

            while (rsBarang.next()) {
                String namaBarang = rsBarang.getString("nama_barang");
                int harga = rsBarang.getInt("harga");
                int jumlah = rsBarang.getInt("jumlah");
                int subtotal = harga * jumlah;
                sb.append("- ").append(namaBarang)
                        .append(" (x").append(jumlah).append(") : ")
                        .append(formatRupiah(subtotal)).append("\n");
                total += subtotal;
            }
            String sqlBayar = "SELECT bayar, kembali FROM transaksi WHERE id_transaksi = ?";
            PreparedStatement pstBayar = conn.prepareStatement(sqlBayar);
            pstBayar.setInt(1, idTransaksi);
            ResultSet rsBayar = pstBayar.executeQuery();

            int bayar = 0;
            int kembali = 0;
            if (rsBayar.next()) {
                bayar = rsBayar.getInt("bayar");
                kembali = rsBayar.getInt("kembali");
            }

            // Penutup struk
            sb.append(centerText("---------------------------")).append("\n");
            sb.append("Total Harga  : ").append(formatRupiah(total)).append("\n");
            sb.append("Bayar        : ").append(formatRupiah(bayar)).append("\n");
            sb.append("Kembali      : ").append(formatRupiah(kembali)).append("\n");
            sb.append(centerText("===========================")).append("\n");
            sb.append("Terima kasih telah berkunjung!\n");

            // Feed dan potong kertas
            sb.append("\n\n\n\n");
            sb.append((char) 0x1D).append("V").append((char) 0x00); // ESC/POS Cut

            // Kirim ke printer
            InputStream is = new ByteArrayInputStream(sb.toString().getBytes("CP437"));
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc doc = new SimpleDoc(is, flavor, null);
            DocPrintJob job = selectedService.createPrintJob();

            PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
            aset.add(new Copies(1));

            job.print(doc, aset);
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int ambilHargaDariDatabase(String namaJasa) {
        int harga = 0;
        try {
            Connection conn = Database.getConnection(); // pastikan kamu punya class koneksi Database
            String sql = "SELECT harga FROM jasa WHERE nama_jasa = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, namaJasa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                harga = rs.getInt("harga");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil harga jasa: " + e.getMessage());
        }
        return harga;
    }

    private int ambilHargaBarangDariDatabase(int idBarang) {
        int harga = 0;
        try {
            Connection conn = Database.getConnection(); // Pastikan class Database sudah benar
            String sql = "SELECT harga FROM barang WHERE id_barang = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idBarang);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                harga = rs.getInt("harga");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil harga barang: " + e.getMessage());
        }
        return harga;
    }

    private void updateTampilanDetail() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat rupiah = new DecimalFormat("Rp #,##0");
        int index = 1;
        int total = 0;

        // BARANG
        if (!keranjangBarang.isEmpty()) {
            sb.append("=== BARANG YANG DIBELI ===\n");
            for (Map.Entry<Integer, Integer> entry : keranjangBarang.entrySet()) {
                int idBarang = entry.getKey();
                int qty = entry.getValue();
                String namaBarang = ambilNamaBarangDariDatabase(idBarang);
                int harga = ambilHargaBarangDariDatabase(idBarang);
                int subtotal = harga * qty;

                sb.append(String.format("%2d. %-20s x%-2d - %10s\n",
                        index++, namaBarang, qty, rupiah.format(subtotal)));

                total += subtotal;
            }
            sb.append("\n");
        }

        // JASA
        if (!jasaList.isEmpty()) {
            sb.append("=== JASA YANG DIPILIH ===\n");
            for (String namaJasa : jasaList) {
                int harga = ambilHargaDariDatabase(namaJasa);

                sb.append(String.format("%2d. %-20s - %10s\n",
                        index++, namaJasa, rupiah.format(harga)));

                total += harga;
            }
            sb.append("\n");
        }
        // Set tampilan ke DetailTotalText
        DetailTotalText.setText(sb.toString());
        DetailTotalText.repaint();  // Memastikan GUI di-refresh dengan baik
    }

    private String ambilNamaBarangDariDatabase(int idBarang) {
        String nama = "";
        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT nama_barang FROM barang WHERE id_barang = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idBarang);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nama = rs.getString("nama_barang");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal ambil nama barang: " + e.getMessage());
        }
        return nama;
    }

    private void loadComboBoxMetodeBayar() {
        PaymentCB.removeAllItems();
        PaymentCB.addItem("Tunai");
        PaymentCB.addItem("QRIS");
    }

    private void updateKembalian() {
        try {
            String totalStr = TotalHargaText.getText().replaceAll("[^\\d]", "");
            String bayarStr = BayarText.getText().replaceAll("[^\\d]", "");

            int total = Integer.parseInt(totalStr);
            int bayar = Integer.parseInt(bayarStr);
            int kembali = bayar - total;

            KembaliText.setText(formatRupiah(kembali));
        } catch (NumberFormatException e) {
            KembaliText.setText("Rp0");
        }
    }

    private void simpanTransaksi() {
        String metode = PaymentCB.getSelectedItem().toString().trim();
        int bayar;

        try {
            String bayarStr = BayarText.getText().replace("Rp", "").replace(".", "").replace(",", "").trim();
            bayar = Integer.parseInt(bayarStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Format pembayaran tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = Database.getConnection()) {
            conn.setAutoCommit(false);
            int total = totalHargaBarang + totalHargaJasa;

            if (transaksiYangSedangDiedit != -1) {
                // Mode edit
                updateTransaksi(conn, transaksiYangSedangDiedit, metode, total, bayar);
                JOptionPane.showMessageDialog(this, "Transaksi berhasil diperbarui");
                transaksiYangSedangDiedit = -1;
            } else {
                // Mode simpan baru
                String sqlTransaksi = "INSERT INTO transaksi (id_user, total_harga, metode_pembayaran, bayar, kembali, created_at) VALUES (?, ?, ?, ?, ?, NOW())";
                PreparedStatement pstTrans = conn.prepareStatement(sqlTransaksi, Statement.RETURN_GENERATED_KEYS);
                pstTrans.setInt(1, 2); // Ganti ke id user login jika sudah ada sistem login
                pstTrans.setInt(2, total);
                pstTrans.setString(3, metode);
                pstTrans.setInt(4, bayar);
                pstTrans.setInt(5, bayar - total);
                pstTrans.executeUpdate();

                ResultSet generatedKeys = pstTrans.getGeneratedKeys();
                if (!generatedKeys.next()) {
                    throw new SQLException("Gagal mengambil ID transaksi.");
                }
                int idTransaksi = generatedKeys.getInt(1);

                simpanTransaksiJasa(conn, idTransaksi, jasaList);
                simpanTransaksiBarang(conn, idTransaksi, keranjangBarang);

                JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan");
            }

            conn.commit();
            updateTotalHarga();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal menyimpan transaksi: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTransaksi(Connection conn, int idTransaksi, String metode, int total, int bayar) throws SQLException {
        int kembali = bayar - total;

        // Update tabel transaksi utama
        String updateSql = "UPDATE transaksi SET total_harga = ?, metode_pembayaran = ?, bayar = ?, kembali = ? WHERE id_transaksi = ?";
        PreparedStatement pst = conn.prepareStatement(updateSql);
        pst.setInt(1, total);
        pst.setString(2, metode);
        pst.setInt(3, bayar);
        pst.setInt(4, kembali);
        pst.setInt(5, idTransaksi);
        pst.executeUpdate();

        // Hapus isi lama
        conn.prepareStatement("DELETE FROM transaksi_barang WHERE id_transaksi = " + idTransaksi).executeUpdate();
        conn.prepareStatement("DELETE FROM transaksi_jasa WHERE id_transaksi = " + idTransaksi).executeUpdate();

        // Simpan ulang yang baru
        simpanTransaksiJasa(conn, idTransaksi, jasaList);
        simpanTransaksiBarang(conn, idTransaksi, keranjangBarang);
    }

    private void loadTransaksiKeForm(Connection conn, int idTransaksi) throws SQLException {
        keranjangBarang.clear();
        jasaList.clear();
        totalHargaBarang = 0;
        totalHargaJasa = 0;

        // Load barang
        String sqlBarang = "SELECT tb.id_barang, tb.jumlah, b.harga FROM transaksi_barang tb JOIN barang b ON tb.id_barang = b.id_barang WHERE tb.id_transaksi = ?";
        PreparedStatement pstBarang = conn.prepareStatement(sqlBarang);
        pstBarang.setInt(1, idTransaksi);
        ResultSet rsBarang = pstBarang.executeQuery();

        while (rsBarang.next()) {
            int idBarang = rsBarang.getInt("id_barang");
            int jumlah = rsBarang.getInt("jumlah");
            int harga = rsBarang.getInt("harga");

            keranjangBarang.put(idBarang, jumlah);
            totalHargaBarang += harga * jumlah;
            for (int i = 0; i < jumlah; i++) {
                undoStack.push(() -> {
                    int jumlahSekarang = keranjangBarang.getOrDefault(idBarang, 0);
                    if (jumlahSekarang > 1) {
                        keranjangBarang.put(idBarang, jumlahSekarang - 1);
                    } else {
                        keranjangBarang.remove(idBarang);
                    }
                    totalHargaBarang -= harga;
                    updateTampilanDetail();
                    updateTotalHarga();
                });
            }

        }

        // Load jasa
        String sqlJasa = "SELECT j.nama_jasa, tj.harga, tj.id_barber FROM transaksi_jasa tj JOIN jasa j ON tj.id_jasa = j.id_jasa WHERE tj.id_transaksi = ?";
        PreparedStatement pstJasa = conn.prepareStatement(sqlJasa);
        pstJasa.setInt(1, idTransaksi);
        ResultSet rsJasa = pstJasa.executeQuery();

        while (rsJasa.next()) {
            String namaJasa = rsJasa.getString("nama_jasa");
            int harga = rsJasa.getInt("harga");
            int idBarber = rsJasa.getInt("id_barber");

            jasaList.add(namaJasa);
            totalHargaJasa += harga;
            BarberCB.setSelectedItem(getBarberNameById(idBarber));

            undoStack.push(() -> {
                jasaList.remove(namaJasa);
                totalHargaJasa -= harga;
                updateTampilanDetail();
                updateTotalHarga();
            });
        }
        // Load data bayar dan kembali dari transaksi
        String sqlTrans = "SELECT bayar, kembali FROM transaksi WHERE id_transaksi = ?";
        PreparedStatement pstTrans = conn.prepareStatement(sqlTrans);
        pstTrans.setInt(1, idTransaksi);
        ResultSet rsTrans = pstTrans.executeQuery();

        if (rsTrans.next()) {
            int bayar = rsTrans.getInt("bayar");
            int kembali = rsTrans.getInt("kembali");

            BayarText.setText(formatRupiah(bayar));
            KembaliText.setText(formatRupiah(kembali));
        }

        updateTampilanDetail();
        updateTotalHarga();
    }

    private void editTransaksi() {
        int selectedRow = RiwayatTB.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih salah satu transaksi untuk diedit!");
            return;
        }

        int idTransaksi = (int) RiwayatTB.getValueAt(selectedRow, 1);
        transaksiYangSedangDiedit = idTransaksi;

        try (Connection conn = Database.getConnection()) {
            // Load isi transaksi lengkap ke form, termasuk metode, bayar, kembali
            String sqlTrans = "SELECT metode_pembayaran FROM transaksi WHERE id_transaksi = ?";
            PreparedStatement pstTrans = conn.prepareStatement(sqlTrans);
            pstTrans.setInt(1, idTransaksi);
            ResultSet rsTrans = pstTrans.executeQuery();
            if (rsTrans.next()) {
                PaymentCB.setSelectedItem(rsTrans.getString("metode_pembayaran"));
            }

            loadTransaksiKeForm(conn, idTransaksi);

            JOptionPane.showMessageDialog(this, "Transaksi dimuat. Silakan lakukan perubahan dan tekan tombol Selesai.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal memuat data transaksi.");
        }
    }

    private void simpanTransaksiJasa(Connection conn, int idTransaksi, List<String> namaJasaList) throws SQLException {
        String sqlCariIdJasa = "SELECT id_jasa, harga FROM jasa WHERE nama_jasa = ?";
        PreparedStatement pstCariId = conn.prepareStatement(sqlCariIdJasa);

        String sqlInsertTJ = "INSERT INTO transaksi_jasa (id_transaksi, id_jasa, id_barber, harga) VALUES (?, ?, ?, ?)";
        PreparedStatement pstTJ = conn.prepareStatement(sqlInsertTJ);

        for (String namaJasa : namaJasaList) {
            // Hapus info tambahan kalau ada (e.g. " x1 - Rp12.000")
            if (namaJasa.contains(" x")) {
                namaJasa = namaJasa.split(" x")[0].trim();
            }

            pstCariId.setString(1, namaJasa);
            ResultSet rsJasa = pstCariId.executeQuery();

            if (!rsJasa.next()) {
                throw new SQLException("Jasa tidak ditemukan: " + namaJasa);
            }

            int idJasa = rsJasa.getInt("id_jasa");
            int harga = rsJasa.getInt("harga");
            int idBarber = barberMap.getOrDefault(BarberCB.getSelectedItem().toString(), -1);

            if (idBarber == -1) {
                throw new SQLException("Barber tidak ditemukan");
            }

            pstTJ.setInt(1, idTransaksi);
            pstTJ.setInt(2, idJasa);
            pstTJ.setInt(3, idBarber);
            pstTJ.setBigDecimal(4, new BigDecimal(harga));
            pstTJ.executeUpdate();
        }
    }

    private void simpanTransaksiBarang(Connection conn, int idTransaksi, Map<Integer, Integer> keranjangBarang) throws SQLException {
        if (keranjangBarang.isEmpty()) {
            return;
        }

        // Ambil harga dan jumlah stok dari tabel barang
        String sqlGetHargaJumlah = "SELECT harga, jumlah FROM barang WHERE id_barang = ?";
        PreparedStatement pstGetHargaJumlah = conn.prepareStatement(sqlGetHargaJumlah);

        // Tambahkan kolom subtotal ke query insert
        String sqlInsert = "INSERT INTO transaksi_barang (id_transaksi, id_barang, jumlah, harga, subtotal) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstInsert = conn.prepareStatement(sqlInsert);

        // Untuk mengurangi stok barang
        String sqlUpdateJumlah = "UPDATE barang SET jumlah = jumlah - ? WHERE id_barang = ?";
        PreparedStatement pstUpdateJumlah = conn.prepareStatement(sqlUpdateJumlah);

        for (Map.Entry<Integer, Integer> entry : keranjangBarang.entrySet()) {
            int idBarang = entry.getKey();
            int jumlahDibeli = entry.getValue();

            pstGetHargaJumlah.setInt(1, idBarang);
            ResultSet rs = pstGetHargaJumlah.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Barang tidak ditemukan: ID " + idBarang);
            }

            BigDecimal harga = rs.getBigDecimal("harga");
            int stokTersedia = rs.getInt("jumlah");

            if (stokTersedia < jumlahDibeli) {
                throw new SQLException("Stok barang tidak mencukupi untuk ID " + idBarang + ". Tersisa: " + stokTersedia);
            }

            // Hitung subtotal
            BigDecimal subtotal = harga.multiply(new BigDecimal(jumlahDibeli));

            // Simpan transaksi barang dengan subtotal
            pstInsert.setInt(1, idTransaksi);
            pstInsert.setInt(2, idBarang);
            pstInsert.setInt(3, jumlahDibeli);
            pstInsert.setBigDecimal(4, harga);
            pstInsert.setBigDecimal(5, subtotal);  // ← Tambahan penting
            pstInsert.executeUpdate();

            // Update jumlah stok barang
            pstUpdateJumlah.setInt(1, jumlahDibeli);
            pstUpdateJumlah.setInt(2, idBarang);
            pstUpdateJumlah.executeUpdate();
        }
    }

    private void hapusTransaksiDariDatabase(int idTransaksi) {
        try (Connection conn = Database.getConnection()) {
            conn.setAutoCommit(false);

            // Ambil data jumlah barang yang dibeli di transaksi ini
            String sqlAmbilBarang = "SELECT id_barang, jumlah FROM transaksi_barang WHERE id_transaksi = ?";
            PreparedStatement pstAmbil = conn.prepareStatement(sqlAmbilBarang);
            pstAmbil.setInt(1, idTransaksi);
            ResultSet rs = pstAmbil.executeQuery();

            Map<Integer, Integer> barangYangDibeli = new HashMap<>();
            while (rs.next()) {
                int idBarang = rs.getInt("id_barang");
                int jumlah = rs.getInt("jumlah");
                barangYangDibeli.put(idBarang, jumlah);
            }

            // Kembalikan stok barang
            String sqlUpdateStok = "UPDATE barang SET jumlah = jumlah + ? WHERE id_barang = ?";
            PreparedStatement pstUpdateStok = conn.prepareStatement(sqlUpdateStok);
            for (Map.Entry<Integer, Integer> entry : barangYangDibeli.entrySet()) {
                pstUpdateStok.setInt(1, entry.getValue());
                pstUpdateStok.setInt(2, entry.getKey());
                pstUpdateStok.executeUpdate();
            }

            // Hapus dari transaksi_jasa
            PreparedStatement pstJasa = conn.prepareStatement("DELETE FROM transaksi_jasa WHERE id_transaksi = ?");
            pstJasa.setInt(1, idTransaksi);
            pstJasa.executeUpdate();

            // Hapus dari transaksi_barang
            PreparedStatement pstBarang = conn.prepareStatement("DELETE FROM transaksi_barang WHERE id_transaksi = ?");
            pstBarang.setInt(1, idTransaksi);
            pstBarang.executeUpdate();

            // Hapus dari transaksi
            PreparedStatement pstTrans = conn.prepareStatement("DELETE FROM transaksi WHERE id_transaksi = ?");
            pstTrans.setInt(1, idTransaksi);
            pstTrans.executeUpdate();

            conn.commit();
            JOptionPane.showMessageDialog(this, "Transaksi berhasil dihapus dan stok barang dikembalikan.");
            tabelTransaksi(); // refresh tampilan tabel

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal menghapus transaksi: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shapecustom2 = new com.ananta.shape.shapecustom();
        shapecustom5 = new com.ananta.shape.shapecustom();
        TotalHargaText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        DetailTotalText = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        ResetBT = new com.ananta.shape.CustomButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        RiwayatTB = new com.ananta.shape.JTabeel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        shapecustom12 = new com.ananta.shape.shapecustom();
        BayarText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        BarberCB = new com.ananta.shape.CustomComboBox();
        PaymentCB = new com.ananta.shape.CustomComboBox();
        JasaCB = new com.ananta.shape.CustomComboBox();
        TambahBT = new com.ananta.shape.CustomButton();
        SelesaiBT = new com.ananta.shape.CustomButton();
        shapecustom6 = new com.ananta.shape.shapecustom();
        KasirText = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        UndoBT = new com.ananta.shape.CustomButton();
        CetakBT = new com.ananta.shape.CustomButton();
        EditBT = new com.ananta.shape.CustomButton();
        HapusBT = new com.ananta.shape.CustomButton();
        shapecustom13 = new com.ananta.shape.shapecustom();
        KembaliText = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        shapecustom8 = new com.ananta.shape.shapecustom();
        barcodeText = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        shapecustom2.setBackground(new java.awt.Color(212, 212, 212));
        shapecustom2.setPreferredSize(new java.awt.Dimension(1427, 887));
        shapecustom2.setRoundBottomLeft(10);
        shapecustom2.setRoundBottomRight(10);
        shapecustom2.setRoundTopLeft(10);
        shapecustom2.setRoundTopRight(10);

        shapecustom5.setBackground(new java.awt.Color(255, 255, 255));
        shapecustom5.setRoundBottomLeft(20);
        shapecustom5.setRoundBottomRight(20);
        shapecustom5.setRoundTopLeft(20);
        shapecustom5.setRoundTopRight(20);

        TotalHargaText.setBackground(new java.awt.Color(253, 253, 253));
        TotalHargaText.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        TotalHargaText.setForeground(new java.awt.Color(1, 0, 0));
        TotalHargaText.setText("Total Harga");
        TotalHargaText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TotalHargaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalHargaTextActionPerformed(evt);
            }
        });

        DetailTotalText.setEditable(false);
        DetailTotalText.setBackground(new java.awt.Color(255, 255, 255));
        DetailTotalText.setColumns(20);
        DetailTotalText.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        DetailTotalText.setForeground(new java.awt.Color(1, 1, 1));
        DetailTotalText.setLineWrap(true);
        DetailTotalText.setRows(5);
        DetailTotalText.setWrapStyleWord(true);
        jScrollPane1.setViewportView(DetailTotalText);

        javax.swing.GroupLayout shapecustom5Layout = new javax.swing.GroupLayout(shapecustom5);
        shapecustom5.setLayout(shapecustom5Layout);
        shapecustom5Layout.setHorizontalGroup(
            shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(TotalHargaText, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        shapecustom5Layout.setVerticalGroup(
            shapecustom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(TotalHargaText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 0, 0));
        jLabel4.setText("Kembali");

        ResetBT.setText("Reset");
        ResetBT.setDefaultColor(new java.awt.Color(220, 53, 69));
        ResetBT.setHoverColor(new java.awt.Color(180, 40, 55));
        ResetBT.setPressedColor(new java.awt.Color(180, 40, 55));
        ResetBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBTActionPerformed(evt);
            }
        });

        RiwayatTB.setForeground(new java.awt.Color(1, 0, 0));
        RiwayatTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "ID TRANSAKSI", "KASIR", "TOTAL HARGA", "METODE", "JASA", "BARANG"
            }
        ));
        jScrollPane2.setViewportView(RiwayatTB);

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 0, 0));
        jLabel8.setText("Jasa");

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(1, 0, 0));
        jLabel9.setText("Transaksi");

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(1, 0, 0));
        jLabel10.setText("Barber");

        shapecustom12.setBackground(new java.awt.Color(255, 255, 255));
        shapecustom12.setRoundBottomLeft(20);
        shapecustom12.setRoundBottomRight(20);
        shapecustom12.setRoundTopLeft(20);
        shapecustom12.setRoundTopRight(20);

        BayarText.setBackground(new java.awt.Color(253, 253, 253));
        BayarText.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        BayarText.setForeground(new java.awt.Color(1, 0, 0));
        BayarText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BayarText.setCaretColor(new java.awt.Color(1, 0, 0));
        BayarText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BayarTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout shapecustom12Layout = new javax.swing.GroupLayout(shapecustom12);
        shapecustom12.setLayout(shapecustom12Layout);
        shapecustom12Layout.setHorizontalGroup(
            shapecustom12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BayarText)
                .addContainerGap())
        );
        shapecustom12Layout.setVerticalGroup(
            shapecustom12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BayarText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 0, 0));
        jLabel6.setText("Payment");

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(1, 0, 0));
        jLabel11.setText("Bayar");

        BarberCB.setBackground(new java.awt.Color(253, 253, 253));
        BarberCB.setForeground(new java.awt.Color(1, 0, 0));
        BarberCB.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N

        PaymentCB.setBackground(new java.awt.Color(253, 253, 253));
        PaymentCB.setForeground(new java.awt.Color(1, 0, 0));
        PaymentCB.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        PaymentCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentCBActionPerformed(evt);
            }
        });

        JasaCB.setBackground(new java.awt.Color(253, 253, 253));
        JasaCB.setForeground(new java.awt.Color(1, 1, 1));
        JasaCB.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        JasaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JasaCBActionPerformed(evt);
            }
        });

        TambahBT.setText("Tambah");
        TambahBT.setDefaultColor(new java.awt.Color(0, 123, 255));
        TambahBT.setHoverColor(new java.awt.Color(0, 90, 190));
        TambahBT.setPressedColor(new java.awt.Color(0, 90, 190));
        TambahBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahBTActionPerformed(evt);
            }
        });

        SelesaiBT.setText("Selesai");
        SelesaiBT.setDefaultColor(new java.awt.Color(40, 167, 69));
        SelesaiBT.setHoverColor(new java.awt.Color(30, 120, 50));
        SelesaiBT.setPressedColor(new java.awt.Color(30, 120, 50));
        SelesaiBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelesaiBTActionPerformed(evt);
            }
        });

        shapecustom6.setBackground(new java.awt.Color(255, 255, 255));
        shapecustom6.setRoundBottomLeft(20);
        shapecustom6.setRoundBottomRight(20);
        shapecustom6.setRoundTopLeft(20);
        shapecustom6.setRoundTopRight(20);

        KasirText.setBackground(new java.awt.Color(253, 253, 255));
        KasirText.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        KasirText.setForeground(new java.awt.Color(1, 0, 0));
        KasirText.setText("Kasir");
        KasirText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        KasirText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KasirTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout shapecustom6Layout = new javax.swing.GroupLayout(shapecustom6);
        shapecustom6.setLayout(shapecustom6Layout);
        shapecustom6Layout.setHorizontalGroup(
            shapecustom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(KasirText, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );
        shapecustom6Layout.setVerticalGroup(
            shapecustom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(KasirText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel12.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(1, 0, 0));
        jLabel12.setText("Barang");

        UndoBT.setText("Undo");
        UndoBT.setDefaultColor(new java.awt.Color(255, 140, 0));
        UndoBT.setHoverColor(new java.awt.Color(200, 100, 0));
        UndoBT.setPressedColor(new java.awt.Color(200, 100, 0));
        UndoBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoBTActionPerformed(evt);
            }
        });

        CetakBT.setText("Cetak");
        CetakBT.setDefaultColor(new java.awt.Color(102, 178, 255));
        CetakBT.setHoverColor(new java.awt.Color(70, 140, 210));
        CetakBT.setPressedColor(new java.awt.Color(70, 140, 210));
        CetakBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakBTActionPerformed(evt);
            }
        });

        EditBT.setText("Edit");
        EditBT.setDefaultColor(new java.awt.Color(255, 140, 0));
        EditBT.setHoverColor(new java.awt.Color(200, 100, 0));
        EditBT.setPressedColor(new java.awt.Color(200, 100, 0));
        EditBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBTActionPerformed(evt);
            }
        });

        HapusBT.setText("Hapus");
        HapusBT.setDefaultColor(new java.awt.Color(220, 53, 69));
        HapusBT.setHoverColor(new java.awt.Color(180, 40, 55));
        HapusBT.setPressedColor(new java.awt.Color(180, 40, 55));
        HapusBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusBTActionPerformed(evt);
            }
        });

        shapecustom13.setBackground(new java.awt.Color(255, 255, 255));
        shapecustom13.setRoundBottomLeft(20);
        shapecustom13.setRoundBottomRight(20);
        shapecustom13.setRoundTopLeft(20);
        shapecustom13.setRoundTopRight(20);

        KembaliText.setBackground(new java.awt.Color(253, 253, 253));
        KembaliText.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        KembaliText.setForeground(new java.awt.Color(1, 0, 0));
        KembaliText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        KembaliText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembaliTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout shapecustom13Layout = new javax.swing.GroupLayout(shapecustom13);
        shapecustom13.setLayout(shapecustom13Layout);
        shapecustom13Layout.setHorizontalGroup(
            shapecustom13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(KembaliText)
                .addContainerGap())
        );
        shapecustom13Layout.setVerticalGroup(
            shapecustom13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(KembaliText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel13.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(1, 0, 0));
        jLabel13.setText("Kasir");

        shapecustom8.setBackground(new java.awt.Color(255, 255, 255));
        shapecustom8.setRoundBottomLeft(20);
        shapecustom8.setRoundBottomRight(20);
        shapecustom8.setRoundTopLeft(20);
        shapecustom8.setRoundTopRight(20);

        barcodeText.setBackground(new java.awt.Color(253, 253, 253));
        barcodeText.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        barcodeText.setForeground(new java.awt.Color(1, 0, 0));
        barcodeText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        barcodeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcodeTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout shapecustom8Layout = new javax.swing.GroupLayout(shapecustom8);
        shapecustom8.setLayout(shapecustom8Layout);
        shapecustom8Layout.setHorizontalGroup(
            shapecustom8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barcodeText, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );
        shapecustom8Layout.setVerticalGroup(
            shapecustom8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(barcodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel14.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(1, 0, 0));
        jLabel14.setText("Riwayat Transaksi");

        javax.swing.GroupLayout shapecustom2Layout = new javax.swing.GroupLayout(shapecustom2);
        shapecustom2.setLayout(shapecustom2Layout);
        shapecustom2Layout.setHorizontalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(shapecustom2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(shapecustom2Layout.createSequentialGroup()
                                .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(shapecustom2Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(81, 81, 81)
                                        .addComponent(shapecustom6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(138, 138, 138)
                                .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SelesaiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(shapecustom2Layout.createSequentialGroup()
                                        .addComponent(TambahBT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(ResetBT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(UndoBT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(shapecustom2Layout.createSequentialGroup()
                                        .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(shapecustom12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(shapecustom2Layout.createSequentialGroup()
                                        .addGap(108, 108, 108)
                                        .addComponent(shapecustom13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(shapecustom2Layout.createSequentialGroup()
                                .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(shapecustom2Layout.createSequentialGroup()
                                        .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(41, 41, 41)
                                        .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(shapecustom8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JasaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BarberCB, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PaymentCB, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(shapecustom2Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(CetakBT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(EditBT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(44, 44, 44)
                                .addComponent(HapusBT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(shapecustom5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1561, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        shapecustom2Layout.setVerticalGroup(
            shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shapecustom2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shapecustom12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapecustom6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapecustom13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JasaCB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UndoBT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahBT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelesaiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BarberCB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaymentCB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CetakBT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EditBT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(HapusBT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(shapecustom2Layout.createSequentialGroup()
                .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(shapecustom2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(shapecustom5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(shapecustom2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(shapecustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shapecustom8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(500, 500, 500))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shapecustom2, javax.swing.GroupLayout.DEFAULT_SIZE, 1591, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shapecustom2, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TotalHargaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalHargaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalHargaTextActionPerformed

    private void ResetBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBTActionPerformed
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin mereset transaksi?",
                "Konfirmasi Reset", JOptionPane.YES_NO_OPTION);
        if (konfirmasi == JOptionPane.YES_OPTION) {
            resetFormTransaksi();
        }
    }//GEN-LAST:event_ResetBTActionPerformed

    private void KasirTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KasirTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KasirTextActionPerformed

    private void BayarTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BayarTextActionPerformed
        // TODO add your handling code here:
        BayarText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    int total = Integer.parseInt(TotalHargaText.getText());
                    int bayar = Integer.parseInt(BayarText.getText());
                    int kembali = bayar - total;
                    KembaliText.setText(String.valueOf(kembali));
                } catch (NumberFormatException ex) {
                    KembaliText.setText("0");
                }
            }
        });
    }//GEN-LAST:event_BayarTextActionPerformed

    private void KembaliTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembaliTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KembaliTextActionPerformed

    private void JasaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JasaCBActionPerformed

    }//GEN-LAST:event_JasaCBActionPerformed

    private void TambahBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahBTActionPerformed
        // TODO add your handling code here:
        String jasaDipilih = (String) JasaCB.getSelectedItem();

        if (jasaDipilih != null && !jasaDipilih.equalsIgnoreCase("Pilih Opsi")) {
            try {
                Connection conn = Database.getConnection();
                String query = "SELECT harga FROM jasa WHERE nama_jasa = ?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, jasaDipilih);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    int harga = rs.getInt("harga");

                    jasaList.add(jasaDipilih);
                    totalHargaJasa += harga;

                    undoStack.push(() -> {
                        jasaList.remove(jasaDipilih);
                        totalHargaJasa -= harga;
                        updateTotalHarga();
                        updateTampilanDetail();
                    });

                    updateTotalHarga();
                    updateTampilanDetail();
                } else {
                    JOptionPane.showMessageDialog(this, "Jasa tidak ditemukan di database!", "Error", JOptionPane.ERROR_MESSAGE);
                }

                rs.close();
                pst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gagal mengambil harga dari database", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih jasa terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_TambahBTActionPerformed

    private void SelesaiBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelesaiBTActionPerformed
        try {
            // Ambil jasa yang dipilih dari DetailTotalText
            List<String> jasaDipilih = new ArrayList<>();
            String[] lines = DetailTotalText.getText().split("\n");
            for (String line : lines) {
                String jasa = line.replaceFirst("^\\d+\\.\\s*", "").trim();
                if (!jasa.isEmpty()) {
                    jasaDipilih.add(jasa);
                }
            }

            // Validasi minimal jasa atau barang
            if (jasaDipilih.isEmpty() && keranjangBarang.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Pilih setidaknya satu jasa atau barang!");
                return;
            }

            // Validasi pembayaran
            String bayarStr = BayarText.getText().replace("Rp", "").replace(".", "").replace(",", "").trim();
            if (bayarStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Masukkan jumlah pembayaran terlebih dahulu!");
                return;
            }

            int bayar;
            try {
                bayar = Integer.parseInt(bayarStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Format pembayaran tidak valid!");
                return;
            }

            int total = totalHargaBarang + totalHargaJasa;
            if (bayar < total) {
                JOptionPane.showMessageDialog(null, "Pembayaran kurang dari total harga!");
                return;
            }

            // Info opsional
            if (keranjangBarang.isEmpty()) {
                System.out.println("Info: Transaksi hanya berisi jasa, tanpa barang.");
            }

            // Simpan transaksi
            simpanTransaksi();
            resetFormTransaksi();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
        }
    }//GEN-LAST:event_SelesaiBTActionPerformed

    private void PaymentCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PaymentCBActionPerformed

    private void barcodeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barcodeTextActionPerformed

    private void UndoBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoBTActionPerformed
        // TODO add your handling code here:
        if (!undoStack.isEmpty()) {
            undoStack.pop().run();
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada aksi yang bisa di-undo.");
        }
    }//GEN-LAST:event_UndoBTActionPerformed

    private void CetakBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakBTActionPerformed
        int selectedRow = RiwayatTB.getSelectedRow();
        if (selectedRow != -1) {
            int idTransaksi = (int) RiwayatTB.getValueAt(selectedRow, 1); // kolom ke-1 adalah id_transaksi
            cetakStruk(idTransaksi);
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih baris transaksi yang ingin dicetak.");
        }
    }//GEN-LAST:event_CetakBTActionPerformed

    private void EditBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditBTActionPerformed

    private void HapusBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusBTActionPerformed
        // TODO add your handling code here:
        int selectedRow = RiwayatTB.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih salah satu transaksi yang ingin dihapus!");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus transaksi ini?",
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            int idTransaksi = (int) RiwayatTB.getValueAt(selectedRow, 1); // kolom ke-1 adalah id_transaksi (disembunyikan)
            hapusTransaksiDariDatabase(idTransaksi);
        }
    }//GEN-LAST:event_HapusBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ananta.shape.CustomComboBox BarberCB;
    private javax.swing.JTextField BayarText;
    private com.ananta.shape.CustomButton CetakBT;
    private javax.swing.JTextArea DetailTotalText;
    private com.ananta.shape.CustomButton EditBT;
    private com.ananta.shape.CustomButton HapusBT;
    private com.ananta.shape.CustomComboBox JasaCB;
    private javax.swing.JTextField KasirText;
    private javax.swing.JTextField KembaliText;
    private com.ananta.shape.CustomComboBox PaymentCB;
    private com.ananta.shape.CustomButton ResetBT;
    private com.ananta.shape.JTabeel RiwayatTB;
    private com.ananta.shape.CustomButton SelesaiBT;
    private com.ananta.shape.CustomButton TambahBT;
    private javax.swing.JTextField TotalHargaText;
    private com.ananta.shape.CustomButton UndoBT;
    private javax.swing.JTextField barcodeText;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.ananta.shape.shapecustom shapecustom12;
    private com.ananta.shape.shapecustom shapecustom13;
    private com.ananta.shape.shapecustom shapecustom2;
    private com.ananta.shape.shapecustom shapecustom5;
    private com.ananta.shape.shapecustom shapecustom6;
    private com.ananta.shape.shapecustom shapecustom8;
    // End of variables declaration//GEN-END:variables
}
