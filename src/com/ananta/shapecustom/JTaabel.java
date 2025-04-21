package com.ananta.shapecustom;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class JTaabel extends JTable {

    private int selectedRow = -1;

    public JTaabel() {
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

            JLabel label = new JLabel(value.toString(), CENTER);
            label.setOpaque(true);
            label.setBackground(new Color(0, 102, 0)); // hijau gelap
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
            label.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK)); // semua sisi hitam

            return label;
        }
    }

    // Renderer untuk isi data
    private class CellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel label = new JLabel(value != null ? value.toString() : "", column == 0 || column == 3 ? CENTER : LEFT);
            label.setOpaque(true);
            label.setBackground(isSelected ? new Color(204, 204, 204) : Color.WHITE);
            label.setForeground(isSelected ? new Color(15, 89, 140) : new Color(60, 60, 60));
            label.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
            label.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK)); // semua sisi hitam

            return label;
        }
    }
}
