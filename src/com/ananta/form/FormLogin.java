package com.ananta.form;
import com.ananta.main.FormMenuUtama;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JOptionPane;
import com.ananta.database.Database;
import com.ananta.main.FormMenuUtama.Session;
import java.awt.CardLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.*;
import org.mindrot.jbcrypt.BCrypt;

public class FormLogin extends javax.swing.JPanel {
    
    private CardLayout cardLayout;
    private JPanel parent;
  
    public FormLogin(CardLayout layout, JPanel parentPanel) {   
        initComponents();
        setLayoutForm();
        setVisible(true);
        this.cardLayout = layout;
        this.parent = parentPanel;       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new com.ananta.shape.panelRound();
        jLabel1 = new javax.swing.JLabel();
        PanelLogin = new com.ananta.shape.panelRound();
        UsernamePane = new javax.swing.JTextField();
        PasswordPane = new javax.swing.JPasswordField();
        LabelUsername = new javax.swing.JLabel();
        LabelPassword = new javax.swing.JLabel();
        lupaButton = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        LabelLogin = new javax.swing.JLabel();
        ImageIcon = new javax.swing.JLabel();
        ShowPass = new javax.swing.JRadioButton();

        jLabel1.setText("jLabel1");

        PanelLogin.setGradientDirection(com.ananta.shape.panelRound.Direction.VERTICAL);
        PanelLogin.setRoundBottomLeft(20);
        PanelLogin.setRoundBottomRight(20);
        PanelLogin.setRoundTopLeft(20);
        PanelLogin.setRoundTopRight(20);
        PanelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelLogin.add(UsernamePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 250, 40));

        PasswordPane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordPaneActionPerformed(evt);
            }
        });
        PanelLogin.add(PasswordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 250, 40));

        LabelUsername.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        LabelUsername.setText("Username");
        PanelLogin.add(LabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        LabelPassword.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        LabelPassword.setText("Password");
        PanelLogin.add(LabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 70, -1));

        lupaButton.setText("Change Password");
        lupaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lupaButtonActionPerformed(evt);
            }
        });
        PanelLogin.add(lupaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, 20));

        LoginButton.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        LoginButton.setText("Login");
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoginButtonMouseExited(evt);
            }
        });
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        PanelLogin.add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 260, 40));

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        PanelLogin.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 116, -1));

        LabelLogin.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        LabelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLogin.setText("LOGIN");
        PanelLogin.add(LabelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 104, -1));

        ImageIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/icon/Logo_Ananta.png"))); // NOI18N
        PanelLogin.add(ImageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        ShowPass.setText("Show Password");
        ShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPassActionPerformed(evt);
            }
        });
        PanelLogin.add(ShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPassActionPerformed
        if (ShowPass.isSelected()) {
            PasswordPane.setEchoChar((char) 0);
        } else {
            PasswordPane.setEchoChar('*');

        }
    }//GEN-LAST:event_ShowPassActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        cardLayout.show(parent, "register");
    }//GEN-LAST:event_registerButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed

        String username = UsernamePane.getText().trim();
        String password = new String(PasswordPane.getPassword()).trim();
        String requiredRole; // Ganti dengan role yang kamu inginkan
        
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tolong isi username dan password.");
            return;
        }

        Connection conn = Database.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        if (conn != null) {
            try {
                String sql = "SELECT * FROM users WHERE username = ?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, username);
                rs = pst.executeQuery();

                if (rs.next()) {
                    String storedHash = rs.getString("password");

                    // Bandingkan password input (plaintext) dengan hash di database
                    if (BCrypt.checkpw(password, storedHash)) {
                        requiredRole = rs.getString("role");

                        // Simpan ke session
                        Session.username = rs.getString("username");
                        Session.role = requiredRole;

                        JOptionPane.showMessageDialog(this, "Login berhasil sebagai " + requiredRole + "!");

                        // Pindah ke menu utama
                        FormMenuUtama.login();
                        
                    } else {
                        JOptionPane.showMessageDialog(this, "Username atau password salah!");
                        UsernamePane.setText("");
                        PasswordPane.setText("");
                        UsernamePane.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Username atau password salah!");
                    UsernamePane.setText("");
                    PasswordPane.setText("");
                    UsernamePane.requestFocus();
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan pada database.");
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (pst != null) pst.close();
                    if (conn != null) conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Gagal koneksi ke database.");
        }

    }//GEN-LAST:event_LoginButtonActionPerformed

    private void LoginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginButtonMouseExited

    private void LoginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginButtonMouseEntered

    private void LoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseClicked
        FormMenuUtama.login();
    }//GEN-LAST:event_LoginButtonMouseClicked

    private void lupaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lupaButtonActionPerformed
        cardLayout.show(parent, "lupa");
    }//GEN-LAST:event_lupaButtonActionPerformed

    private void PasswordPaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordPaneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordPaneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageIcon;
    private javax.swing.JLabel LabelLogin;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelUsername;
    private javax.swing.JButton LoginButton;
    private com.ananta.shape.panelRound PanelLogin;
    private javax.swing.JPasswordField PasswordPane;
    private javax.swing.JRadioButton ShowPass;
    private javax.swing.JTextField UsernamePane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton lupaButton;
    private com.ananta.shape.panelRound panelRound1;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables

    private void setLayoutForm() {
        setLayout(new FormLoginLayout());
        PanelLogin.setLayout(new LoginLayout());
        PanelLogin.setGradient(new Color(32,103,27), new Color (255, 255, 255, 1));
        
        // Gaya PanelLogin
        PanelLogin.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:lighten(@background,5%);"
                + "arc:30;"
                + "border:20,20,20,20");

        // Gaya untuk TextPassword
        PasswordPane.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true;"
                + "showCapsLock:true;"
                + "arc:10;");

        // Gaya untuk TextUsername
        UsernamePane.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10;");

        // Gaya untuk ButtonLogin
        LoginButton.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10;"
                + "borderWidth:0;"
                + "focusWidth:0;");

        // ✅ Atur tinggi TextUsername dan TextPassword
        Dimension fieldSize = new Dimension(0, 40); // 0 = biar layout tetap pakai full lebar
        UsernamePane.setPreferredSize(fieldSize);
        PasswordPane.setPreferredSize(fieldSize);

        // ✅ Atur tinggi dan lebar ButtonLogin
        LoginButton.setPreferredSize(new Dimension(120, 40));
        

    }

    private class FormLoginLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
                
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                int width = parent.getWidth();
                int height = parent.getHeight();
                int loginWidth = UIScale.scale(300);
                int loginHeight = PanelLogin.getPreferredSize().height;
                int x = (width - loginWidth) / 2;
                int y = (height - loginHeight) / 2;
                PanelLogin.setBounds(x, y, loginWidth, loginHeight);
                PanelLogin.repaint();
            }
        }

    }

    private class LoginLayout implements LayoutManager {

        private final int titleGap = 10;
        private final int textGap = 10;
        private final int labelGap = 10;
        private final int buttonGap = 30;

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                Insets insets = parent.getInsets();
               
                int height = insets.top + insets.bottom;

                height += ImageIcon.getPreferredSize().height;
                height += UIScale.scale(titleGap);
                height += LabelLogin.getPreferredSize().height;
                height += UIScale.scale(titleGap);

                height += LabelUsername.getPreferredSize().height;
                height += UIScale.scale(labelGap);
                height += UsernamePane.getPreferredSize().height;
                height += UIScale.scale(textGap);

                height += LabelPassword.getPreferredSize().height;
                height += UIScale.scale(labelGap);
                height += PasswordPane.getPreferredSize().height;
                height += UIScale.scale(textGap);

                height += lupaButton.getPreferredSize().height;
                height += UIScale.scale(buttonGap);

                height += LoginButton.getPreferredSize().height;
                height += UIScale.scale(textGap);

                height += registerButton.getPreferredSize().height;
                height += UIScale.scale(textGap); // opsional, padding bawah

                return new Dimension(0, height);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                Insets insets = parent.getInsets();
                int x = insets.left;
                int y = insets.top;
                int width = parent.getWidth() - (insets.left + insets.right);

                ImageIcon.setBounds(x, y, width, ImageIcon.getPreferredSize().height);
                y += ImageIcon.getPreferredSize().height + UIScale.scale(titleGap);

                LabelLogin.setBounds(x, y, width, LabelLogin.getPreferredSize().height);
                y += LabelLogin.getPreferredSize().height + UIScale.scale(titleGap);

                LabelUsername.setBounds(x, y, width, LabelUsername.getPreferredSize().height);
                y += LabelUsername.getPreferredSize().height + UIScale.scale(labelGap);
                UsernamePane.setBounds(x, y, width, UsernamePane.getPreferredSize().height);
                y += UsernamePane.getPreferredSize().height + UIScale.scale(textGap);

                LabelPassword.setBounds(x, y, width, LabelPassword.getPreferredSize().height);
                y += LabelPassword.getPreferredSize().height + UIScale.scale(labelGap);
                PasswordPane.setBounds(x, y, width, PasswordPane.getPreferredSize().height);
                y += PasswordPane.getPreferredSize().height + UIScale.scale(buttonGap);

                int buttonWidth = LoginButton.getPreferredSize().width;
                int buttonX = x + (width - buttonWidth) / 2;
                LoginButton.setBounds(buttonX, y, buttonWidth, LoginButton.getPreferredSize().height);

                // Tombol "Lupa Password"
           // Tentukan ukuran dan posisi manual untuk LupaButton
                int lupaButtonWidth = 150;
                int lupaButtonHeight = 30;
                int lupaButtonX = x + 4;  // dari kiri
                int lupaButtonY = y + -20;       // bisa atur manual y
                lupaButton.setBounds(lupaButtonX, lupaButtonY, lupaButtonWidth, lupaButtonHeight);
                y += lupaButtonHeight + UIScale.scale(buttonGap);             
                
                // Login Button (posisi dan ukuran manual)
                int loginButtonWidth = 320;
                int loginButtonHeight = 40;
                int loginButtonX = x + (width - loginButtonWidth) / 2;
                LoginButton.setBounds(loginButtonX, y, loginButtonWidth, loginButtonHeight);
                y += loginButtonHeight + UIScale.scale(textGap);

                // Register Button (manual)
                int RegisterButtonWidth = 150;
                int RegisterButtonHeight = 30;
                int RegisterButtonX = x + 180;  // dari kiri
                int RegisterButtonY = y + -141;       // bisa atur manual y
                registerButton.setBounds(RegisterButtonX, RegisterButtonY, RegisterButtonWidth, RegisterButtonHeight);
                y += RegisterButtonHeight + UIScale.scale(buttonGap); 

            }
        }
    }
}
