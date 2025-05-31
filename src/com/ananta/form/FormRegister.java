package com.ananta.form;

import com.ananta.database.Database;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import com.pengaturan.otp.customUID;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author andraliandra
 */
public class FormRegister extends javax.swing.JPanel {

    private CardLayout cardLayout;
    private JPanel parent;
    
public FormRegister(CardLayout layout, JPanel parentPanel) {
        initComponents();
        setLayoutForm();        
        this.cardLayout = layout;
        this.parent = parentPanel;
  
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelRegister = new javax.swing.JPanel();
        UserLabel = new javax.swing.JLabel();
        UsernamePane = new javax.swing.JTextField();
        EmailPane = new javax.swing.JTextField();
        ButtonRegister = new javax.swing.JButton();
        EmailLabel = new javax.swing.JLabel();
        PassLabel = new javax.swing.JLabel();
        ConfirmLabel = new javax.swing.JLabel();
        CekBoks = new javax.swing.JCheckBox();
        LabelIcon = new javax.swing.JLabel();
        RegisterLabel = new javax.swing.JLabel();
        ButtonKembali = new javax.swing.JButton();
        PasswordPane = new javax.swing.JPasswordField();
        ConfirmPane = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        UserLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        UserLabel.setText("Username");

        UsernamePane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernamePaneActionPerformed(evt);
            }
        });

        EmailPane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailPaneActionPerformed(evt);
            }
        });

        ButtonRegister.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        ButtonRegister.setText("REGISTER");
        ButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegisterActionPerformed(evt);
            }
        });

        EmailLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        EmailLabel.setText("Email");

        PassLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        PassLabel.setText("Password");

        ConfirmLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        ConfirmLabel.setText("Confirm Password");

        CekBoks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CekBoks.setText("Show Password");
        CekBoks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CekBoksActionPerformed(evt);
            }
        });

        LabelIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\choos\\Downloads\\AnantaB\\AnantaB\\src\\com\\ananta\\icon\\Logo_Ananta.png")); // NOI18N

        RegisterLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        RegisterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegisterLabel.setText("REGISTER");

        ButtonKembali.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        ButtonKembali.setText("Kembali");
        ButtonKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRegisterLayout = new javax.swing.GroupLayout(PanelRegister);
        PanelRegister.setLayout(PanelRegisterLayout);
        PanelRegisterLayout.setHorizontalGroup(
            PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegisterLayout.createSequentialGroup()
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegisterLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(RegisterLabel))
                    .addGroup(PanelRegisterLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(PanelRegisterLayout.createSequentialGroup()
                                .addComponent(ButtonKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(CekBoks))
                            .addComponent(ConfirmLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PassLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UserLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmailPane, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsernamePane, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmailLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelIcon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PasswordPane, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ConfirmPane))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        PanelRegisterLayout.setVerticalGroup(
            PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegisterLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(LabelIcon)
                .addGap(28, 28, 28)
                .addComponent(RegisterLabel)
                .addGap(40, 40, 40)
                .addComponent(UserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UsernamePane, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(EmailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailPane, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(PassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordPane, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConfirmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConfirmPane, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CekBoks)
                    .addComponent(ButtonKembali))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(ButtonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(PanelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void UsernamePaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernamePaneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernamePaneActionPerformed

    private void EmailPaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailPaneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailPaneActionPerformed

    private void CekBoksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CekBoksActionPerformed
        if (CekBoks.isSelected()) {
            PasswordPane.setEchoChar('\u0000');
            ConfirmPane.setEchoChar('\u0000');
        } else {
            PasswordPane.setEchoChar('*');
            ConfirmPane.setEchoChar('*');
        }
    }//GEN-LAST:event_CekBoksActionPerformed
    public static boolean isValidEmail(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(regex);
    }
    private void ButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegisterActionPerformed
    String usernameField = UsernamePane.getText().trim();
    String emailField = EmailPane.getText().trim();
    String pwField = new String(PasswordPane.getPassword()).trim();
    String nwPwField = new String(ConfirmPane.getPassword()).trim();
    
     if (usernameField.isEmpty() || pwField.isEmpty() || emailField.isEmpty() || nwPwField.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!");
        return;
    }
     
    if (usernameField.contains(" ") || pwField.contains(" ")) {
    JOptionPane.showMessageDialog(this, "Username dan password tidak boleh mengandung spasi!");
    return;
    }
 
    if (!pwField.equals(nwPwField)) {
        JOptionPane.showMessageDialog(this, "Password yang anda masukkan tidak sama!");
        return;
    }   
    if (isValidEmail(emailField)){
       JOptionPane.showMessageDialog(this, "Email Valid");
    } else {
      JOptionPane.showMessageDialog(this, "Email tidak  valid");
      return;
    }
   
     Connection conn = Database.getConnection();
     
    if (conn != null){
       try{
         String checkUserSql = "SELECT COUNT(*) FROM users WHERE email = ? OR username = ?";
            PreparedStatement checkPst = conn.prepareStatement(checkUserSql);
            checkPst.setString(1, emailField);
            checkPst.setString(2, usernameField);
            ResultSet rs = checkPst.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Email atau Username sudah terdaftar!");
                return;
            }
            
            //hash password
            String hashedPassword = BCrypt.hashpw(pwField, BCrypt.gensalt());
            
            String insertSql = "INSERT INTO users (id_user, username, email, password, role) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(insertSql);
            pst.setString(1, customUID.generateUserId());
            pst.setString(2, usernameField);
            pst.setString(3, emailField); 
            pst.setString(4, hashedPassword);
            pst.setString(5, "kasir");

            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Registrasi berhasil!");
                
                cardLayout.show(parent, "login");
                // Bersihkan form
                UsernamePane.setText("");
                EmailPane.setText("");
                PasswordPane.setText("");
                ConfirmPane.setText("");
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat registrasi!");
            UsernamePane.setText("");
            EmailPane.setText("");
            PasswordPane.setText("");
            ConfirmPane.setText("");
            UsernamePane.requestFocus();         
        }
       
      //  FormLogin nw_login = new FormLogin(); 
      //  nw_login.setVisible(true);
        
      }else {
        JOptionPane.showMessageDialog(this, "Gagal terkoneksi ke database!");
      } 
    }//GEN-LAST:event_ButtonRegisterActionPerformed

    
    private void ButtonKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonKembaliActionPerformed
    UsernamePane.setText("");
    EmailPane.setText("");
    PasswordPane.setText("");
    ConfirmPane.setText("");
    cardLayout.show(parent, "login");
    }//GEN-LAST:event_ButtonKembaliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonKembali;
    private javax.swing.JButton ButtonRegister;
    private javax.swing.JCheckBox CekBoks;
    private javax.swing.JLabel ConfirmLabel;
    private javax.swing.JPasswordField ConfirmPane;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField EmailPane;
    private javax.swing.JLabel LabelIcon;
    private javax.swing.JPanel PanelRegister;
    private javax.swing.JLabel PassLabel;
    private javax.swing.JPasswordField PasswordPane;
    private javax.swing.JLabel RegisterLabel;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JTextField UsernamePane;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

  private void setLayoutForm() { //atur tampilan
        setLayout(new FormRegisterLayout());
        PanelRegister.setLayout(new RegisterLayout());
        
        // Gaya PanelLogin
        PanelRegister.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Login.background;"
                + "arc:30;"
                + "border:20,20,0,20");
        
         // Gaya untuk TextUsername
        UsernamePane.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10;");
        
        EmailPane.putClientProperty(FlatClientProperties.STYLE, "" 
                + "arc:10");

        // Gaya untuk TextPassword
        PasswordPane.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true;"
                + "showCapsLock:true;"
                + "arc:10;");
        
        ConfirmPane.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true;"
                + "showCapsLock:true;"
                + "arc:10;");

        // Gaya untuk ButtonLogin
        ButtonRegister.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10;"
                + "borderWidth:0;"
                + "focusWidth:0;");

        // ✅ Atur tinggi TextUsername dan TextPassword
        Dimension fieldSize = new Dimension(0, 40); // 0 = biar layout tetap pakai full lebar
        UsernamePane.setPreferredSize(fieldSize);
        EmailPane.setPreferredSize(fieldSize);
        PasswordPane.setPreferredSize(fieldSize);
        ConfirmPane.setPreferredSize(fieldSize);

        // ✅ Atur tinggi dan lebar ButtonLogin
        ButtonRegister.setPreferredSize(new Dimension(120, 40));
    }
  
    private class FormRegisterLayout implements LayoutManager {

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
                int registerWidth = UIScale.scale(300);
                int registerHeight = PanelRegister.getPreferredSize().height;
                int x = (width - registerWidth) / 2;
                int y = (height - registerHeight) / 2;
                PanelRegister.setBounds(x, y, registerWidth, registerHeight);
            }
        }

    }

    private class RegisterLayout implements LayoutManager {

        private final int titleGap = 20;
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

                height += LabelIcon.getPreferredSize().height; //label ananta
                height += UIScale.scale(titleGap);
                height += RegisterLabel.getPreferredSize().height; //label register
                height += UIScale.scale(titleGap);

                height += UserLabel.getPreferredSize().height; //label username
                height += UIScale.scale(labelGap); 
                height += UsernamePane.getPreferredSize().height; //panel username
                height += UIScale.scale(textGap);
                
                height += EmailLabel.getPreferredSize().height; // label email
                height += UIScale.scale(labelGap);
                height += EmailPane.getPreferredSize().height; // panel email
                height += UIScale.scale(textGap);

                height += PassLabel.getPreferredSize().height; // label password
                height += UIScale.scale(labelGap);
                height += PasswordPane.getPreferredSize().height; // panel password
                height += UIScale.scale(textGap);
                
                height += ConfirmLabel.getPreferredSize().height; //label confirm password
                height += UIScale.scale(labelGap);
                height += ConfirmPane.getPreferredSize().height; // panel confirm
                height += UIScale.scale(textGap);
                
                height += ButtonKembali.getPreferredSize().height;
                height += UIScale.scale(buttonGap);       
                
                height += CekBoks.getPreferredSize().height;
                height += UIScale.scale(buttonGap);

                height += ButtonRegister.getPreferredSize().height; // register button
                height += UIScale.scale(buttonGap);
                height += ButtonRegister.getPreferredSize().height;
                height += UIScale.scale(textGap);

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

                LabelIcon.setBounds(x, y, width, LabelIcon.getPreferredSize().height);
                y += LabelIcon.getPreferredSize().height + UIScale.scale(titleGap);

                RegisterLabel.setBounds(x, y, width, RegisterLabel.getPreferredSize().height);
                y += RegisterLabel.getPreferredSize().height + UIScale.scale(titleGap);

                UserLabel.setBounds(x, y, width, UserLabel.getPreferredSize().height);
                y += UserLabel.getPreferredSize().height + UIScale.scale(labelGap);
                UsernamePane.setBounds(x, y, width, UsernamePane.getPreferredSize().height);
                y += UsernamePane.getPreferredSize().height + UIScale.scale(textGap);
                
                EmailLabel.setBounds(x, y, width, EmailLabel.getPreferredSize().height);
                y += EmailLabel.getPreferredSize().height + UIScale.scale(labelGap);
                EmailPane.setBounds(x, y, width, EmailPane.getPreferredSize().height);
                y += EmailPane.getPreferredSize().height + UIScale.scale(textGap);

                PassLabel.setBounds(x, y, width, PassLabel.getPreferredSize().height);
                y += PassLabel.getPreferredSize().height + UIScale.scale(labelGap);
                PasswordPane.setBounds(x, y, width, PasswordPane.getPreferredSize().height);
                y += PasswordPane.getPreferredSize().height + UIScale.scale(textGap);
                
                ConfirmLabel.setBounds(x, y, width, ConfirmLabel.getPreferredSize().height);
                y += ConfirmLabel.getPreferredSize().height + UIScale.scale(labelGap);
                ConfirmPane.setBounds(x, y, width, ConfirmPane.getPreferredSize().height);
                y += ConfirmPane.getPreferredSize().height + UIScale.scale(buttonGap);

                int buttonWidth = ButtonRegister.getPreferredSize().width;
                int buttonX = x + (width - buttonWidth) / 2;
                ButtonRegister.setBounds(buttonX, y, buttonWidth, ButtonRegister.getPreferredSize().height);

                // Tombol "Lupa Password"
           // Tentukan ukuran dan posisi manual untuk LupaButton
                int ButtonKembaliWidth = 150;
                int ButtonKembaliHeight = 30;
                int ButtonKembaliX = x + -4;  // dari kiri
                int ButtonKembaliY = y + -20;       // bisa atur manual y
                ButtonKembali.setBounds(ButtonKembaliX, ButtonKembaliY, ButtonKembaliWidth, ButtonKembaliHeight);
                y += ButtonKembaliHeight + UIScale.scale(buttonGap);  
                
                int CekBoksWidth = 150;
                int CekBoksHeight = 30;
                int CekBoksX = x + 190;
                int CekBoksY = y + -90;
                CekBoks.setBounds(CekBoksX, CekBoksY, CekBoksWidth, CekBoksHeight);
                y += CekBoksHeight + UIScale.scale(buttonGap);
                
                // Login Button (posisi dan ukuran manual)
                int RegisterButtonWidth = 320;
                int RegisterButtonHeight = 40;
                int RegisterButtonX = x + 10;
                int RegisterButtonY = y + -40;
                ButtonRegister.setBounds(RegisterButtonX, RegisterButtonY, RegisterButtonWidth, RegisterButtonHeight);
                y += RegisterButtonHeight + UIScale.scale(textGap);
                
            }
        }
    }
}