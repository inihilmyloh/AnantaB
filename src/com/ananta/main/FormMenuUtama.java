package com.ananta.main;

import com.ananta.form.FormLogin;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FormMenuUtama extends javax.swing.JFrame {
    
    private final FormLogin formLogin;
    private static FormMenuUtama app;
    private final Main mainForm;

    public FormMenuUtama() {
        initComponents();
        setIcon(new ImageIcon(getClass().getResource("/com/ananta/icon/Ananta.png")));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        formLogin = new FormLogin();
        mainForm = new Main();
        setContentPane(formLogin);
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
    
    public static void login(){
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.mainForm);
        app.mainForm.applyComponentOrientation(app.getComponentOrientation());
        setSelectedMenu(0,0);
        app.mainForm.hideMenu();
        SwingUtilities.updateComponentTreeUI(app.mainForm);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }
    
    public static void logout() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.formLogin);
        app.formLogin.applyComponentOrientation(app.getComponentOrientation());
        SwingUtilities.updateComponentTreeUI(app.formLogin);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }
    
    public static void setSelectedMenu(int index, int subMenu){
        app.mainForm.setSelectedMenu(index,subMenu);
    }

    private void setIcon(ImageIcon imageIcon) {
        setIconImage(imageIcon.getImage());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
