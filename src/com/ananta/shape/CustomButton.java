package com.ananta.shape;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomButton extends JButton {

    private Color hoverColor = new Color(41, 128, 185);
    private Color defaultColor = new Color(52, 152, 219);
    private Color pressedColor = new Color(31, 97, 141);
    private int cornerRadius = 20;
    private boolean hovered = false;
    private boolean pressed = false;

    public CustomButton() {
        setText("Custom Button");
        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setIconTextGap(8);

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                repaint();
            }

            public void mouseExited(MouseEvent e) {
                hovered = false;
                pressed = false;
                repaint();
            }

            public void mousePressed(MouseEvent e) {
                pressed = true;
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                pressed = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Anti-aliasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Tentukan warna berdasarkan status
        Color fillColor = defaultColor;
        if (pressed) {
            fillColor = pressedColor;
        } else if (hovered) {
            fillColor = hoverColor;
        }

        // Gambar background
        g2.setColor(fillColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        // Ambil info teks & ikon
        Icon icon = getIcon();
        String text = getText();

        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();

        int iconWidth = (icon != null) ? icon.getIconWidth() : 0;
        int iconHeight = (icon != null) ? icon.getIconHeight() : 0;

        int gap = (icon != null) ? getIconTextGap() : 0;

        int totalWidth = iconWidth + gap + textWidth;
        int centerX = (getWidth() - totalWidth) / 2;
        int centerY = getHeight() / 2;

        int iconY = centerY - iconHeight / 2;
        int textY = centerY + fm.getAscent() / 2 - 2; // tweak biar pas

        // Gambar ikon
        if (icon != null) {
            icon.paintIcon(this, g2, centerX, iconY);
        }

        // Gambar teks
        g2.setColor(getForeground());
        g2.setFont(getFont());
        g2.drawString(text, centerX + iconWidth + gap, textY);

        g2.dispose();
    }
// Getter & Setter agar warna bisa diatur dari GUI Builder

    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
        repaint();
    }

    public Color getHoverColor() {
        return hoverColor;
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
        repaint();
    }

    public Color getPressedColor() {
        return pressedColor;
    }

    public void setPressedColor(Color pressedColor) {
        this.pressedColor = pressedColor;
        repaint();
    }
    
// Radius setter untuk NetBeans
    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint();
    }
}
