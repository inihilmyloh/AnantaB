package com.ananta.menu;

import com.ananta.menu.*;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LightDarkMode extends JPanel {
    
    private JButton buttonLight;
    private JButton buttonDark;
    private JButton buttonLighDark;

    public void setMenuFull (boolean menuFull) {
        this.menuFull = menuFull;
        if (menuFull) {
            buttonLight.setVisible(true);
            buttonDark.setVisible(true);
            buttonLighDark.setVisible(false);
        } else {
            buttonLight.setVisible(false);
            buttonDark.setVisible(false);
            buttonLighDark.setVisible (true);
        }
    }

    private boolean menuFull = true;

    public LightDarkMode() {
        init();
    }

    private void init() {
        setBorder(new EmptyBorder(2,2,2,2));
        setLayout(new LightDarkModeLayout());
        putClientProperty(FlatClientProperties.STYLE, ""
            + "arc:999;"
            + "background: $Menu. lightdark.background");
        buttonLight = new JButton ("Light", new FlatSVGIcon("com/ananta/icon/light.svg"));
        buttonDark = new JButton ("Dark", new FlatSVGIcon ("com/ananta/icon/dark.svg"));
        buttonLighDark = new JButton();
        buttonLighDark.putClientProperty (FlatClientProperties. STYLE, ""
            + "arc:999;"
            + "background:$Menu.lightdark.button.background;"
            + "foreground:$Menu.foreground;"
            + "focusWidth:0;"
            + "borderWidth:0");
        buttonLighDark.addActionListener ((ActionEvent e) -> {
            changeMode(!FlatLaf.isLafDark());
        });
        checkStyle();
        buttonDark. addActionListener((ActionEvent e) -> {
            changeMode(true);
        });
        buttonLight.addActionListener((ActionEvent e) -> {
            changeMode(false);
        });
        add(buttonLight);
        add(buttonDark);
        add(buttonLighDark);
    }
    
    private void changeMode (boolean dark) {
        if (FlatLaf. isLafDark() != dark) {
            if (dark) {
                EventQueue.invokeLater(() -> {
                    FlatAnimatedLafChange.showSnapshot();
                    FlatDarculaLaf.setup();
                    FlatLaf.updateUI();
                    checkStyle();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                });
            } else {
                EventQueue.invokeLater(() -> {
                    FlatAnimatedLafChange.showSnapshot();
                    FlatIntelliJLaf.setup();
                    FlatLaf.updateUI() ;
                    checkStyle();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                });
            }
        }
    }

    private void checkStyle () {
        boolean isDark = FlatLaf. isLafDark () ;
        addStyle(buttonLight, !isDark);
        addStyle(buttonDark, isDark);
        if (isDark) {
            buttonLighDark.setIcon(new FlatSVGIcon("com/ananta/icon/dark.svg"));
        } else {
            buttonLighDark.setIcon(new FlatSVGIcon("com/ananta/icon/light.svg"));
        }
    }
    
    private void addStyle(JButton button, boolean style) {
        if (style) {
            button.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:999;"
                + "background:$Menu.lightdark.button.background;"
                + "foreground:$Menu.foreground;"
                + "focusWidth:0;"
                + "borderWidth:0");
        } else {
            button.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:999;"
                + "background:$Menu.lightdark.button.background;"
                + "foreground:$Menu.foreground; "
                + "focusWidth:0;"
                + "borderWidth:0;"
                + "background:null");
        }
    }

    private class LightDarkModeLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }
        
        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(5, buttonDark.getPreferredSize().height + (menuFull ? 0 : 5));
            }
        }
        
        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension (0, 0);
            }
        }
        
        @Override
        public void layoutContainer (Container parent) {
            synchronized (parent.getTreeLock()) {
                Insets insets = parent.getInsets();
                int x = insets.left;
                int y = insets.top;
                int gap = 5;
                int width = parent.getWidth() - (insets.left + insets.right);
                int height = parent.getHeight() - (insets.top + insets.bottom) ;
                int buttonWidth = (width - gap) / 2;
                if (menuFull) {
                    buttonLight.setBounds(x, y, buttonWidth, height);
                    buttonDark.setBounds(x + buttonWidth + gap, y, buttonWidth, height);
                } else {
                    buttonLighDark.setBounds(x, y, width, height);
                }
            }
        }
    }
}