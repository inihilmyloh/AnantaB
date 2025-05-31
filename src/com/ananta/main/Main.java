package com.ananta.main;

import com.ananta.form.*;
import com.ananta.main.FormMenuUtama;
import com.ananta.main.FormMenuUtama.Session;
import com.ananta.menu.*;
import com.ananta.menu.MenuAction;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.util.UIScale;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;



public class Main extends JLayeredPane {

    public Menu menu;
    private JPanel panelBody;
    private JButton menuButton;
       
    public Main(){
        init();
 
    }

    private void init(){
        setBorder(new EmptyBorder(5,5,5,5));
        setLayout(new MainFormLayout());
        menu = new Menu();
        panelBody = new JPanel(new BorderLayout());
        initMenuArrowIcon();
        menuButton.putClientProperty(FlatClientProperties.STYLE, ""
        + "background:$Menu.button.background;"
        + "arc:999;"
        + "focusWidth:0;"
        + "borderWidth:0");
        menuButton.addActionListener((ActionEvent e) -> {
            setMenuFull(!menu.isMenuFull());
        });
        initMenuEvent();
        add(menuButton);
        add(menu);
        add(panelBody);
    }
    
    private void initMenuArrowIcon() {
        if (menuButton == null) {
            menuButton = new JButton();
        }
        
        String icon = (getComponentOrientation().isLeftToRight() ? "menu_left.svg" : "menu_right.svg");
        menuButton.setIcon(new FlatSVGIcon("com/ananta/icon/" + icon, 0.8f));
    }
    

private void initMenuEvent() {
   menu.addMenuEvent((int index, int subIndex, MenuAction action) -> {
        String role = Session.role; // Ambil role dari session
        System.out.println("Index dipilih: " + index + ", Role: " + role);
        
        if ("admin".equalsIgnoreCase(role)) {
            // Admin boleh akses semua
            switch (index) {
                case 0 -> FormMenuUtama.showForm(new FormDashboard());
                case 1 -> FormMenuUtama.showForm(new FormJasa());
                case 2 -> FormMenuUtama.showForm(new FormBarang());
                case 3 -> FormMenuUtama.showForm(new FormKaryawan());
                case 4 -> FormMenuUtama.showForm(new FormTransaksi());
                case 5 -> FormMenuUtama.showForm(new FormPengeluaran());
                case 6 -> FormMenuUtama.showForm(new FormAbsensi());
                case 7 -> FormMenuUtama.showForm(new LaporanAlternatif());
                case 8 -> {
                        int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin ingin keluar?",
                        "Konfirmasi Keluar",
                        JOptionPane.YES_NO_OPTION
                    );
                    if (confirm == JOptionPane.YES_OPTION) {
                        Session.username = null;
                        Session.role = null;
                        System.exit(0);
                    } else {
                        action.cancel();
                    }
                    break;
                }
                default -> action.cancel();
            }
            
            
            
        } else if ("kasir".equalsIgnoreCase(role)) {
            // Kasir hanya boleh akses dashboard, absensi, jasa, transaksi, pengeluaran, dan logout
            switch (index) {
                case 0 -> FormMenuUtama.showForm(new FormDashboard());
                case 1 -> FormMenuUtama.showForm(new FormAbsensi());
                case 2 -> FormMenuUtama.showForm(new FormTransaksi());
                case 3 -> FormMenuUtama.showForm(new FormPengeluaran());
                case 4 -> {
                        int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin ingin keluar?",
                        "Konfirmasi Keluar",
                        JOptionPane.YES_NO_OPTION
                    );
                    if (confirm == JOptionPane.YES_OPTION) {
                        Session.username = null;
                        Session.role = null;
                        System.exit(0);
                    } else {
                        action.cancel();
                    }
                    break;
                }
                default -> {
                    action.cancel();
                    showAksesDitolak();
                }
            }

        } else {
            // Role tidak dikenali
            action.cancel();
            showAksesDitolak();
        }
    });



    
//    private void initMenuEvent() {
//        menu.addMenuEvent((int index, int subIndex, MenuAction action) -> {
//            if(index == 0) {
//                FormMenuUtama.showForm(new FormDashboard());
//            } else if (index == 1) {
//                FormMenuUtama.showForm(new FormKaryawan());
//            } else if (index == 2) {
//                FormMenuUtama.showForm(new FormPricelist());
//            } else if (index == 3) {
//                FormMenuUtama.showForm(new FormTransaksi());
//            } else if (index == 4) {
//                FormMenuUtama.showForm(new FormPengeluaran());
//            }else if (index == 5) {
//                FormMenuUtama.showForm(new LaporanHarian());
//            }else if (index == 6) {
//                FormMenuUtama.showForm(new LaporanMingguan());
//            }else if (index == 7) {
//                FormMenuUtama.showForm(new LaporanAlternatif());
//            }//else if (index == 8) {
//               // FormMenuUtama.showForm(new LaporanAlternatif());
//            //}
//            else if (index == 8){
//                FormMenuUtama.logout();
//            }else{
//                action.cancel();
//            }
//        });
    }
    private void showAksesDitolak() {
    JOptionPane.showMessageDialog(this, "Akses ditolak. Anda tidak memiliki izin untuk membuka fitur ini.", 
                                  "Akses Ditolak", JOptionPane.WARNING_MESSAGE);
}

    
    
    private void setMenuFull(boolean full){
        String icon;
        if(getComponentOrientation().isLeftToRight()){
            icon = (full) ? "menu_left.svg" : "menu_right.svg";
        } else {
            icon = (full) ? "menu_right.svg" : "menu_left.svg";
        }
        menuButton.setIcon(new FlatSVGIcon("com/ananta/icon/" + icon, 0.8f));

        menu.setMenuFull(full);
        revalidate();
    }
    
    public void hideMenu() {
        menu.hideMenuItem();
    }
    
    public void showForm(Component component) {
        panelBody.removeAll();
        panelBody.add(component);
        panelBody.repaint();
        panelBody.revalidate();
    }
    
    public void setSelectedMenu(int index, int subIndex) {
        menu.setSelectedMenu(index, subIndex);
    } 
    
    private class MainFormLayout implements LayoutManager{

        @Override
        public void addLayoutComponent(String name, Component comp) {
        
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized(parent.getTreeLock()) {
                return new Dimension(5,5);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized(parent.getTreeLock()) {
                return new Dimension(0,0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                boolean ltr = parent.getComponentOrientation().isLeftToRight();
                Insets insets = UIScale. scale(parent.getInsets());
                int x = insets.left;
                int y = insets.top;
                int width = parent.getWidth() - (insets.left + insets.right);
                int height = parent.getHeight() - (insets.top + insets.bottom);
                int menuWidth = UIScale.scale(menu. isMenuFull () ? menu.getMenuMaxWidth() : menu.getMenuMinWidth());
                int menuX = ltr ? x : x + width - menuWidth;
                menu.setBounds(menuX, y, menuWidth, height) ;
                int menuButtonWidth = menuButton.getPreferredSize() .width;
                int menuButtonHeight = menuButton.getPreferredSize().height;
                int menubX;
                if (ltr) {
                    menubX = (int) (x + menuWidth - (menuButtonWidth * (menu.isMenuFull() ? 0.5f: 0.3f)));
                } else {
                    menubX = (int) (menuX - (menuButtonWidth * (menu.isMenuFull() ? 0.5f:0.7f)));
                }
                menuButton.setBounds (menubX, UIScale. scale(30), menuButtonWidth, menuButtonHeight);
                int gap = UIScale.scale(5);
                int bodyWidth = width - menuWidth - gap;
                int bodyHeight = height;
                int bodyx = ltr ? (x + menuWidth + gap) : x;
                int bodyy = y;
                panelBody.setBounds (bodyx, bodyy, bodyWidth, bodyHeight);
            }
        }
        
    }
}