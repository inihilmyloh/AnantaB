package com.ananta.shape;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.RoundRectangle2D;

public class CustomComboBox extends JComboBox<String> {

    private Color backgroundColor = Color.WHITE;
    private Color textColor = Color.BLACK;
    private int radius = 20;
    private Color selectionColor = new Color(200, 255, 200); // Warna saat opsi dipilih

    public CustomComboBox() {
        this(Color.WHITE, Color.BLACK, 20);
    }

    public CustomComboBox(Color backgroundColor, Color textColor, int radius) {
        super();
        setOpaque(false);
        setFocusable(false);
        setFont(new Font("Segoe UI", Font.PLAIN, 14));

        addItem("Pilih Opsi");
        addItem("Opsi 1");
        addItem("Opsi 2");
        addItem("Opsi 3");

        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.radius = radius;

        setUI(new RoundedComboBoxUI());
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        setForeground(textColor);

        // Set renderer custom
        setRenderer(new CustomComboBoxRenderer());

// Menambahkan listener untuk mendeteksi pemilihan item
        this.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Cek jika item dipilih dan bukan item default
                    if (getSelectedIndex() != 0) {  // Opsi pertama adalah "Pilih Opsi"
                        setBackgroundColor(selectionColor);  // Ubah background saat opsi dipilih
                    } else {
                        setBackgroundColor(backgroundColor);  // Kembali ke background default jika opsi "Pilih Opsi"
                    }
                }
            }
        });

    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        repaint();
    }

    public void setTextColor(Color color) {
        this.textColor = color;
        setForeground(color);
        repaint();
    }

    public void setCornerRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape round = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(backgroundColor);
        g2.fill(round);

        g2.dispose();
        super.paintComponent(g);
    }

    private class RoundedComboBoxUI extends BasicComboBoxUI {

        @Override
        protected JButton createArrowButton() {
            return new ArrowButton();
        }

        @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(backgroundColor);
            g2.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            g2.dispose();
        }

        private class ArrowButton extends JButton {

            public ArrowButton() {
                setOpaque(false);
                setContentAreaFilled(false);
                setBorderPainted(false);
                setFocusPainted(false);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int w = getWidth();
                int h = getHeight();
                int size = Math.min(w, h) / 3;
                int x = (w - size) / 2;
                int y = (h - size) / 2;

                g2.setColor(textColor);
                g2.setStroke(new BasicStroke(2f));
                g2.drawLine(x, y, x + size / 2, y + size);
                g2.drawLine(x + size / 2, y + size, x + size, y);

                g2.dispose();
            }
        }
    }

    // Renderer custom
    private class CustomComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            label.setOpaque(true);
            label.setBackground(backgroundColor); // Background sama kayak combobox
            label.setForeground(textColor); // Warna text sama juga
            return label;
        }
    }
}
