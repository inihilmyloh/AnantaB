/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ananta.login;
import com.ananta.database.Database; // Impor koneksi database
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author choos
 */
public class LoginHalaman extends javax.swing.JFrame {

    /**
     * Creates new form LoginHalaman
     */
    public LoginHalaman() {
        initComponents();
    }

    
     private void login() {
        String username = Username.getText();
        String password = new String(Password.getPassword());

        // Pastikan username dan password tidak kosong
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan Password harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
      Connection conn = Database.getConnection(); // Mengambil koneksi dari class Database
        if (conn != null) {
            String sql = "SELECT * FROM users WHERE username=? AND password=?"; // Sesuaikan dengan nama tabel di database Anda

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Login Berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    // Buka halaman utama atau dashboard setelah login sukses
                    new Dashboard().setVisible(true);
                    this.dispose(); // Tutup halaman login
                } else {
                    JOptionPane.showMessageDialog(this, "Login Gagal! Username atau Password salah.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan koneksi!", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                Database.closeConnection(conn); // Tutup koneksi setelah selesai digunakan
            }
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginButton = new javax.swing.JButton();
        Username = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        LupaPassword = new javax.swing.JButton();
        Register = new javax.swing.JButton();
        ShowBox = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginButton.setBorder(null);
        LoginButton.setVisible(false);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 710, 390, 50));

        Username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Username.setBorder(null);
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        getContentPane().add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 452, 410, 50));

        Password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Password.setBorder(null);
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 590, 410, 50));

        LupaPassword.setVisible(false);
        LupaPassword.setBorder(null);
        getContentPane().add(LupaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 653, 190, 30));

        Register.setVisible(false);
        getContentPane().add(Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 830, 170, 30));

        ShowBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ShowBox.setText("Show Password");
        ShowBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowBoxActionPerformed(evt);
            }
        });
        getContentPane().add(ShowBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 660, 150, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/Image/LOGIN.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
      login();
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void ShowBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowBoxActionPerformed
     if(ShowBox.isSelected()){
            Password.setEchoChar((char)0);
        } else{
            Password.setEchoChar('•');
        }  
    }//GEN-LAST:event_ShowBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginHalaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginHalaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginHalaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginHalaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginHalaman().setVisible(true);
         java.awt.EventQueue.invokeLater(() -> new LoginHalaman().setVisible(true));        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton LupaPassword;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton Register;
    private javax.swing.JRadioButton ShowBox;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
