package com.ananta.menu;

import com.ananta.menu.*;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Menu extends JPanel{
    
    private final String menuItemsAdmin[] [] = {
        {"~MAIN~"},
        {"Dashboard"}, //0
        {"~MASTER~"},
        {"Jasa"}, //1
        {"Barang"}, //2
        {"Karyawan"},//3
        {"~AKTIVITAS~"},
        {"Transaksi"}, //4
        {"Pengeluaran"},//5
        {"Absensi"},//6
        {"~LAPORAN~"},
        {"Laporan"}, //7
        {"~LOG OUT~"}, 
        {"Keluar"} //8
    };

    private final String menuItemsKasir[][] = {
        {"~MAIN~"},
        {"Dashboard"},
        {"~AKTIVITAS~"},
        {"Transaksi"},
        {"Pengeluaran"},
        {"Absensi"},
        {"~LOG OUT~"},
        {"Keluar"}
};

    public boolean isMenuFull () {
        return menuFull;
    }

    public void setMenuFull (boolean menuFull) {
        this.menuFull = menuFull;
        if (menuFull) {
            header.setText(headerName);
            header.setHorizontalAlignment(getComponentOrientation().isLeftToRight()? JLabel.LEFT : JLabel.RIGHT);
        } else {
            header.setText("");
            header.setHorizontalAlignment (JLabel. CENTER);
        }
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                ((MenuItem)com).setFull(menuFull) ;
            }
        }
        lightDarkMode.setMenuFull(menuFull);
        //toolBarAccentColor.setMenuFull (menuFull);
    }

    private final List<MenuEvent> events = new ArrayList<>();
    private boolean menuFull = true;
    private final String headerName = "   Ananta Barbershop";

    protected final boolean hideMenuTitleOnMinimum = true;
    protected final int menuTitleLeftInset = 5;
    protected final int menuTitleVgap = 5;
    protected final int menuMaxWidth = 250;
    protected final int menuMinWidth = 60;
    protected final int headerFullHgap = 5;

    public Menu() {
        init();
    }

    private void init(){
        setLayout(new MenuLayout());
        putClientProperty(FlatClientProperties.STYLE, ""
            + "border:20,2,2,2;"
            + "background:$Menu.background;"
            + "arc:10");
        header = new JLabel(headerName);
        header.setIcon(new ImageIcon(getClass().getResource ("/com/ananta/icon/Ananta.png")));
        header.putClientProperty(FlatClientProperties.STYLE, ""
            + "font:$Menu.header.font;"
            + "foreground:$Menu.foreground");

        // Menu
        scroll = new JScrollPane();
        panelMenu = new JPanel(new MenuItemLayout(this));
        panelMenu.putClientProperty(FlatClientProperties. STYLE, ""
            + "border:5,5,5,5;"
            + "background:$Menu.background");

        scroll.setViewportView(panelMenu);
        scroll.putClientProperty(FlatClientProperties.STYLE, ""
            + "border:null") ;
        JScrollBar vscroll = scroll.getVerticalScrollBar();
        vscroll.setUnitIncrement(10);
        vscroll.putClientProperty(FlatClientProperties.STYLE, ""
            + "width:$Menu.scroll.width;"
            + "trackInsets:$Menu.scroll.trackInsets;"
            + "thumbInsets:$Menu.scroll.thumbInsets;"
            + "background:$Menu.ScrollBar.background;"
            + "thumb:$Menu.ScrollBar.thumb");
        createMenu();
        lightDarkMode = new LightDarkMode();
        add(header);
        add(scroll);
        add(lightDarkMode);
    }

    private void createMenu() {
        int index = 0;
        for (int i = 0; i < menuItemsAdmin.length; i++) {
            String menuName = menuItemsAdmin [i] [0];
            if (menuName.startsWith ("~") && menuName.endsWith("~")) {
                panelMenu.add(createTitle(menuName));
            } else {
                MenuItem menuItem = new MenuItem(this, menuItemsAdmin[i], index++, events);
                panelMenu.add(menuItem);
            }
        }
    }

    private JLabel createTitle(String title) {
        String menuName = title.substring (1, title.length() - 1);
        JLabel lbTitle = new JLabel (menuName);
        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
            + "font:$Menu.label.font;"
            + "foreground:$Menu.title.foreground") ;
        return lbTitle;
    }

    public void setSelectedMenu(int index, int subIndex) {
        runEvent(index, subIndex);
    }

    protected void setSelected(int index, int subIndex) {
        int size = panelMenu.getComponentCount();
        for (int i = 0; i < size; i++) {
            Component com = panelMenu.getComponent (i);
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                if (item.getMenuIndex() == index) {
                    item.setSelectedIndex(subIndex);
                } else {
                    item.setSelectedIndex (-1);
                }
            }
        }
    }
    
    protected void runEvent (int index, int subIndex) {
        MenuAction menuAction = new MenuAction();
        for (MenuEvent event : events) {
            event.menuSelected(index, subIndex, menuAction);
        }
        if (!menuAction.isCancel()) {
            setSelected(index, subIndex) ;
        }
    }

    public void addMenuEvent (MenuEvent event) {
        events.add (event);
    }

    public void hideMenuItem() {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                ((MenuItem) com) .hideMenuItem();
            }
        }
        revalidate();
    }

    public boolean isHideMenuTitleOnMinimum() {
        return hideMenuTitleOnMinimum;
    }

    public int getMenuTitleLeftInset() {
        return menuTitleLeftInset;
    }

    public int getMenuTitleVgap() {
        return menuTitleVgap;
    }

    public int getMenuMaxWidth () {
        return menuMaxWidth;
    }

    public int getMenuMinWidth () {
        return menuMinWidth;
    }

    private JLabel header;
    private JScrollPane scroll;
    private JPanel panelMenu;
    private LightDarkMode lightDarkMode;

    private class MenuLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize (Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(5, 5);
            }
        }

        @Override
        public Dimension minimumLayoutSize (Container parent) {
            synchronized (parent.getTreeLock () ) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer (Container parent) {
            synchronized (parent.getTreeLock()) {
                Insets insets = parent.getInsets();
                int x = insets.left;
                int y = insets.top;
                int gap = UIScale.scale(5);
                int sheaderFulllgap = UIScale.scale(headerFullHgap);
                int width = parent.getWidth () - (insets. left + insets.right);
                int height = parent.getHeight () - (insets.top + insets.bottom);
                int iconWidth = width;
                int iconHeight = header.getPreferredSize () .height;
                int hgap = menuFull ? headerFullHgap : 0;
                header.setBounds (x + hgap, y, iconWidth - (hgap * 2), iconHeight);

                int ldgap = UIScale.scale(10);
                int ldwidth = width - ldgap * 2;
                int ldHeight = lightDarkMode.getPreferredSize() .height;
                int ldx = x + ldgap;

                int ldy = y + height - ldHeight - ldgap - gap;

                int menux = x;
                int menuy = y + iconHeight + gap;
                int menuWidth = width;
                int menuHeight = height - (iconHeight + gap) - (ldHeight + ldgap * 2);
                scroll.setBounds (menux, menuy, menuWidth, menuHeight) ;

                lightDarkMode.setBounds(ldx, ldy, ldwidth, ldHeight);
            }
        }
    }
}