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

public class FormLogin extends javax.swing.JPanel {

    public FormLogin() {
        initComponents();
        setLayoutForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelLogin = new javax.swing.JPanel();
        LabelIcon = new javax.swing.JLabel();
        LabelLogin = new javax.swing.JLabel();
        LabelUsername = new javax.swing.JLabel();
        LabelPassword = new javax.swing.JLabel();
        TextPassword = new javax.swing.JPasswordField();
        ButtonLogin = new javax.swing.JButton();
        TextUsername = new javax.swing.JTextField();

        LabelIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ananta/ui/ux/Logo_Ananta.png"))); // NOI18N

        LabelLogin.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        LabelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLogin.setText("LOGIN");

        LabelUsername.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        LabelUsername.setText("Username");

        LabelPassword.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        LabelPassword.setText("Password");

        ButtonLogin.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        ButtonLogin.setText("Login");
        ButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelLoginLayout = new javax.swing.GroupLayout(PanelLogin);
        PanelLogin.setLayout(PanelLoginLayout);
        PanelLoginLayout.setHorizontalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(LabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(ButtonLogin))
                    .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLoginLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelUsername)
                                .addComponent(LabelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(PanelLoginLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LabelPassword)
                                .addComponent(TextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        PanelLoginLayout.setVerticalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addComponent(LabelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(ButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLoginMouseClicked
        FormMenuUtama.login();
    }//GEN-LAST:event_ButtonLoginMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLogin;
    private javax.swing.JLabel LabelIcon;
    private javax.swing.JLabel LabelLogin;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelUsername;
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JPasswordField TextPassword;
    private javax.swing.JTextField TextUsername;
    // End of variables declaration//GEN-END:variables
    
    private void setLayoutForm(){
        setLayout(new FormLoginLayout());
        PanelLogin.setLayout(new LoginLayout());
        
        // Gaya PanelLogin
        PanelLogin.putClientProperty(FlatClientProperties.STYLE, ""
               + "background:$Login.background;"
               + "arc:30;"
               + "border:20,20,40,20");

        // Gaya untuk TextPassword
        TextPassword.putClientProperty(FlatClientProperties.STYLE, ""
               + "showRevealButton:true;"
               + "showCapsLock:true;"
               + "arc:10;");

        // Gaya untuk TextUsername
        TextUsername.putClientProperty(FlatClientProperties.STYLE, ""
               + "arc:10;");

        // Gaya untuk ButtonLogin
        ButtonLogin.putClientProperty(FlatClientProperties.STYLE, ""
               + "arc:10;"
               + "borderWidth:0;"
               + "focusWidth:0;");
        
        // ✅ Atur tinggi TextUsername dan TextPassword
        Dimension fieldSize = new Dimension(0, 40); // 0 = biar layout tetap pakai full lebar
        TextUsername.setPreferredSize(fieldSize);
        TextPassword.setPreferredSize(fieldSize);

    // ✅ Atur tinggi dan lebar ButtonLogin
        ButtonLogin.setPreferredSize(new Dimension(120, 40));
    }
    
    private class FormLoginLayout implements LayoutManager{

        @Override
        public void addLayoutComponent(String name, Component comp) {
            
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized(parent.getTreeLock()) {
            return new Dimension(0,0);
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
            synchronized(parent.getTreeLock()) {
                int width = parent.getWidth();
                int height = parent.getHeight();
                int loginWidth = UIScale.scale(300);
                int loginHeight = PanelLogin.getPreferredSize().height;
                int x = (width - loginWidth) / 2;
                int y = (height - loginHeight) / 2;
                PanelLogin.setBounds(x, y, loginWidth, loginHeight);
            }
        }
        
    }
        private class LoginLayout implements LayoutManager{
            
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
                    
                    height += LabelIcon.getPreferredSize().height;
                    height += UIScale.scale(titleGap);
                    height += LabelLogin.getPreferredSize().height;
                    height += UIScale.scale(titleGap);
                    height += LabelUsername.getPreferredSize().height;
                    height += UIScale.scale(labelGap);
                    height += TextUsername.getPreferredSize().height;
                    height += UIScale.scale(textGap);

                    height += LabelPassword.getPreferredSize().height;
                    height += UIScale.scale(labelGap);
                    height += TextPassword.getPreferredSize().height;
                    height += UIScale.scale(buttonGap);
                    height += ButtonLogin.getPreferredSize().height;
                    return new Dimension(0, height);
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
                    Insets insets = parent.getInsets () ;
                    int x = insets.left;
                    int y = insets.top;
                    int width = parent.getWidth() - (insets.left + insets.right);

                    LabelIcon.setBounds (x, y, width, LabelIcon.getPreferredSize().height);
                    y += LabelIcon.getPreferredSize () .height + UIScale.scale(titleGap) ;

                    LabelLogin.setBounds (x, y, width, LabelLogin.getPreferredSize () .height);
                    y += LabelLogin.getPreferredSize().height + UIScale.scale(titleGap);

                    LabelUsername.setBounds (x, y, width, LabelUsername.getPreferredSize() .height);
                    y += LabelUsername.getPreferredSize () .height + UIScale.scale(labelGap);
                    TextUsername.setBounds (x, y, width, TextUsername.getPreferredSize () .height);
                    y += TextUsername.getPreferredSize().height + UIScale.scale(textGap);

                    LabelPassword.setBounds (x, y, width, LabelPassword.getPreferredSize().height);
                    y += LabelPassword.getPreferredSize().height + UIScale.scale(labelGap);
                    TextPassword.setBounds (x, y, width, TextPassword.getPreferredSize().height);
                    y += TextPassword.getPreferredSize().height + UIScale.scale(buttonGap);

                    int buttonWidth = ButtonLogin.getPreferredSize().width;
                    int buttonX = x + (width - buttonWidth) / 2;
                    ButtonLogin.setBounds(buttonX, y, buttonWidth, ButtonLogin.getPreferredSize().height);
                }
            }    
        }
    }