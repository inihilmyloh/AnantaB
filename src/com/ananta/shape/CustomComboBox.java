package com.ananta.shape;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class CustomComboBox extends JComboBox<String> {

    private Color backgroundColor = new Color(242, 242, 242);
    private Color selectionColor = new Color(230, 230, 230);
    private Color textColor = Color.BLACK;
    private int radius = 20;
    private int hoverIndex = -1;

    public CustomComboBox() {
        this(new Color(242, 242, 242), Color.BLACK, 20);
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

        setRenderer(new CustomComboBoxRenderer());

        this.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (getSelectedIndex() != 0) {
                        setBackgroundColor(selectionColor);
                    } else {
                        setBackgroundColor(backgroundColor);
                    }
                }
            }
        });

        addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                SwingUtilities.invokeLater(() -> {
                    JList<?> list = getList();
                    if (list != null) {
                        list.addMouseMotionListener(new MouseMotionAdapter() {
                            @Override
                            public void mouseMoved(MouseEvent e) {
                                int index = list.locationToIndex(e.getPoint());
                                if (index != hoverIndex) {
                                    hoverIndex = index;
                                    list.repaint();
                                }
                            }
                        });

                        list.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseExited(MouseEvent e) {
                                hoverIndex = -1;
                                list.repaint();
                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                int index = list.locationToIndex(e.getPoint());
                                if (index != hoverIndex) {
                                    hoverIndex = index;
                                    list.repaint();
                                }
                            }
                        });

                        // 🆕 Tambahkan ini untuk trigger hover awal
                        Point mousePos = MouseInfo.getPointerInfo().getLocation();
                        SwingUtilities.convertPointFromScreen(mousePos, list);
                        int index = list.locationToIndex(mousePos);
                        if (index != hoverIndex && index >= 0 && index < list.getModel().getSize()) {
                            hoverIndex = index;
                            list.repaint();
                        }
                    }
                });
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });

    }

    private JList<?> getList() {
        Object popup = getUI().getAccessibleChild(this, 0);
        if (popup instanceof javax.swing.plaf.basic.ComboPopup) {
            return ((javax.swing.plaf.basic.ComboPopup) popup).getList();
        }
        return null;
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

                int triangleWidth = 10;
                int triangleHeight = 6;

                int x = (w - triangleWidth) / 2;
                int y = (h - triangleHeight) / 2;

                Polygon triangle = new Polygon();
                triangle.addPoint(x, y);
                triangle.addPoint(x + triangleWidth, y);
                triangle.addPoint(x + triangleWidth / 2, y + triangleHeight);

                g2.setColor(textColor);
                g2.fill(triangle);

                g2.dispose();
            }
        }
    }

    private class CustomComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            label.setOpaque(true);
            label.setForeground(textColor);

            if (isSelected) {
                label.setBackground(selectionColor);
            } else if (index == hoverIndex) {
                label.setBackground(new Color(245, 245, 245)); // Warna hover abu muda
            } else {
                label.setBackground(backgroundColor);
            }

            return label;
        }
    }
}
