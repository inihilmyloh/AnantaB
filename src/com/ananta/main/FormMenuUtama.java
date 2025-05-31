package com.ananta.main;

import com.ananta.form.*;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//import com.ananta.form.FormLogin;
//import com.formdev.flatlaf.FlatDarculaLaf;
//import com.formdev.flatlaf.FlatLaf;
//import com.formdev.flatlaf.FlatLightLaf;
//import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
//import java.awt.Component;
//import java.awt.ComponentOrientation;
//import javax.swing.JFrame;
//import javax.swing.SwingUtilities;

public class FormMenuUtama extends javax.swing.JFrame {
      
//    private final FormLogin formLogin;
//    private final FormLupaPassword formLupaPassword;
//    private final FormRegister formRegister;
//    private final FormOtpVal formOtpVal;
//    private final FormUbahPassword formUbahPassword;
//    private static FormMenuUtama app;
//    private final Main mainForm;
//    JPanel mainPanel;
//    CardLayout cardLayout;
//
//    public FormMenuUtama() {
//        initComponents();
//        setIcon(new ImageIcon(getClass().getResource("/com/ananta/icon/Ananta.png")));
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        formLogin = new FormLogin();
//        mainForm = new Main();
//        setContentPane(formLogin);
//    }
//    
        
        private final FormLogin formLogin;
        private final FormLupaPassword formLupaPassword;
        private final FormRegister formRegister;
        private final FormOtpVal formOtpVal;
        private final FormUbahPassword formUbahPassword;
        private static FormMenuUtama app;
        private final Main mainForm;
        JPanel mainPanel;
        CardLayout cardLayout; 
        
        public FormMenuUtama() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //formLogin = new FormLogin();
        //mainForm = new Main();
        getContentPane().setBackground(new java.awt.Color(230, 230, 230)); // abu terang

        //inisialisasi cardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        //inisialisasi halaman halaman
        this.formLogin = new FormLogin (cardLayout, mainPanel);
        this.formLupaPassword = new FormLupaPassword (cardLayout, mainPanel);
        this.formRegister = new FormRegister (cardLayout, mainPanel);
        this.formOtpVal = new FormOtpVal (cardLayout, mainPanel);
        this.formUbahPassword = new FormUbahPassword (cardLayout, mainPanel);
        
        mainForm = new Main();
        // menambahkan panel utama dengan nama unik
        mainPanel.add(this.formLogin, "login");
        mainPanel.add(this.formLupaPassword, "lupa");
        mainPanel.add(this.formRegister, "register");
        mainPanel.add(this.formOtpVal, "otp");
        mainPanel.add(this.formUbahPassword, "ubah");
        
        setContentPane(mainPanel);
        cardLayout.show(mainPanel, "login"); //tamp8ilkan login sebagai awal     

        setTitle("Ananta Barbershop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        FlatLaf.registerCustomDefaultsSource("com.ananta.theme");
        FlatLightLaf.setup();
        //FlatDarculaLaf.setup();
        
        java.awt.EventQueue.invokeLater(() -> {
            app = new FormMenuUtama();
            app.setVisible(true);
        });
    }
    
    public static void showForm(Component component){
        component.applyComponentOrientation(app.getComponentOrientation());
        app.mainForm.showForm(component);
    }
    
    public static void loginSuccess() {
       app.cardLayout.show(app.mainPanel, "main");
       app.mainForm.showForm(new FormDashboard());
       app.mainForm.setSelectedMenu(0, 0);
    }
    
    public class Session{
       public static String username;
       public static String role;
    }
    
    public static void login(){
//        FlatAnimatedLafChange.showSnapshot();
//        app.setContentPane(app.mainForm);
//        app.mainForm.applyComponentOrientation(app.getComponentOrientation());
//        setSelectedMenu(0,0);
//        app.mainForm.hideMenu();
//        SwingUtilities.updateComponentTreeUI(app.mainForm);
//        FlatAnimatedLafChange.hideSnapshotWithAnimation();
        FlatAnimatedLafChange.showSnapshot();
            app.setContentPane(app.mainForm);
            app.mainForm.applyComponentOrientation(app.getComponentOrientation());
            app.mainForm.menu.setRole(Session.role);
            
             //Pilih menu dan form berdasarkan role
            if (Session.role.equalsIgnoreCase("admin")) {
                setSelectedMenu(0, 0);             // Menu dashboard admin
                showForm(new FormDashboard());
            } else if (Session.role.equalsIgnoreCase("kasir")) {
                setSelectedMenu(3, 0);             // Menu transaksi untuk kasir
                showForm(new FormTransaksi());
            } else {
                // Role lain / default
                setSelectedMenu(0, 0);
                showForm(new FormDashboard());
                JOptionPane.showMessageDialog(app, "Role tidak dikenali, tampilkan dashboard default.");
            }
            
            app.mainForm.hideMenu();
            SwingUtilities.updateComponentTreeUI(app.mainForm);
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
        
    }
    
    public static void logout() {
        Session.username = null;
        Session.role = null;
        FlatAnimatedLafChange.showSnapshot(); // Refresh tampilan
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }
    
    public static void setSelectedMenu(int index, int subMenu){
        app.mainForm.setSelectedMenu(index,subMenu);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
