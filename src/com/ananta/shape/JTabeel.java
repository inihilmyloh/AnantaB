package com.ananta.shape;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import static javax.swing.SwingConstants.LEFT;
import javax.swing.border.*;
import javax.swing.table.*;

public class JTabeel extends JTable {

    private int selectedRow = -1;

    public JTabeel() {
        setRowHeight(40); // tinggi baris isi data
        setGridColor(Color.BLACK);
        setShowHorizontalLines(true);
        setShowVerticalLines(true);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setBorder(new LineBorder(Color.BLACK, 2)); // border luar tabel

        // Header kustom
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setPreferredSize(new Dimension(0, 50)); // atur tinggi header
        getTableHeader().setDefaultRenderer(new HeaderRenderer());

        // Renderer isi sel
        setDefaultRenderer(Object.class, new CellRenderer());
        
        setFocusable(false);
        setDefaultEditor(Object.class, null);

        // Klik baris
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = getSelectedRow();
                selectedRow = (row == selectedRow) ? -1 : row;
                if (selectedRow == -1) clearSelection();
            }
        });
    }

    // Tambah baris manual
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    // Renderer untuk header kolom
    private class HeaderRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel label = new JLabel(value.toString(), LEFT);
            label.setOpaque(true);
            label.setBackground(new Color(0, 102, 0)); // hijau gelap
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Segoe UI", Font.BOLD, 14));
            label.setBorder(BorderFactory.createCompoundBorder(
                new MatteBorder(1, 1, 1, 1, Color.BLACK),
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // padding header
            ));

            return label;
        }
    }

    // Renderer untuk isi data
    private class CellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel label = new JLabel(value != null ? value.toString() : "", LEFT); // Semua rata kiri
            label.setOpaque(true);

            // Warna background dan foreground berdasarkan status seleksi
            label.setBackground(isSelected ? new Color(220, 235, 245) : Color.WHITE);
            label.setForeground(isSelected ? new Color(0, 70, 120) : new Color(30, 30, 30));

            // Font lebih besar & readable
            label.setFont(new Font("Segoe UI", Font.PLAIN, 14));

            // Padding isi sel
            label.setBorder(BorderFactory.createCompoundBorder(
                new MatteBorder(1, 1, 1, 1, Color.BLACK),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
            ));

            return label;
        }
    }
}
