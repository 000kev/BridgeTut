/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.lessons;

import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author Ishaan
 */
public class LoginScreen extends javax.swing.JFrame {

    /**
     * Creates new form LoginScreen
     */
    public LoginScreen() {
        initComponents();
        
        pnlLogin.setPreferredSize(new Dimension(500, 500));
        setSize(new Dimension(580, 400));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblPlayerName = new javax.swing.JLabel();
        lblPswrd = new javax.swing.JLabel();
        lblNewPlayer = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnNewUser = new javax.swing.JButton();
        txfUserName = new javax.swing.JTextField();
        pswfPassword = new javax.swing.JPasswordField();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(580, 400));
        getContentPane().setLayout(null);

        pnlLogin.setLayout(null);

        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/title45.png"))); // NOI18N
        pnlLogin.add(lblTitle);
        lblTitle.setBounds(110, 10, 350, 73);

        lblPlayerName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/playerName30.png"))); // NOI18N
        pnlLogin.add(lblPlayerName);
        lblPlayerName.setBounds(50, 100, 180, 30);

        lblPswrd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/Password30.png"))); // NOI18N
        pnlLogin.add(lblPswrd);
        lblPswrd.setBounds(50, 130, 170, 59);

        lblNewPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/newPlayer30.png"))); // NOI18N
        pnlLogin.add(lblNewPlayer);
        lblNewPlayer.setBounds(110, 270, 360, 65);

        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(btnLogin);
        btnLogin.setBounds(240, 200, 90, 30);

        btnNewUser.setText("Make New Account");
        btnNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewUserActionPerformed(evt);
            }
        });
        pnlLogin.add(btnNewUser);
        btnNewUser.setBounds(210, 320, 150, 30);

        txfUserName.setText("Enter Username here");
        pnlLogin.add(txfUserName);
        txfUserName.setBounds(260, 100, 210, 30);

        pswfPassword.setText("12345");
        pswfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswfPasswordActionPerformed(evt);
            }
        });
        pnlLogin.add(pswfPassword);
        pswfPassword.setBounds(260, 150, 210, 30);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/background.jpg"))); // NOI18N
        lblBackground.setText("jLabel5");
        pnlLogin.add(lblBackground);
        lblBackground.setBounds(0, 0, 580, 400);

        getContentPane().add(pnlLogin);
        pnlLogin.setBounds(0, 0, 580, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Variables
    String userName;
    String password;
    boolean userExists=false;
    private void btnNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewUserActionPerformed
      // Takes user to new account screen
        new newUserAccountScreen().setVisible(true);
        
            this.setVisible(false);
            this.dispose(); 
    }//GEN-LAST:event_btnNewUserActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // Login button
        userName=txfUserName.getText();
        password=pswfPassword.getText();
        
        if (userName.equals("")||password.equals("")) {
            JOptionPane.showMessageDialog(null, "Cannot leave username or password field blank"); 
        }
        else{
            User obj=new User(userName, password);
            userExists=obj.authenticateUser();
        //have to read from textfile to look for users info
        //Have to update this
            if (userExists==true) {
               
                
                
               new gameMenu().setVisible(true);

                this.setVisible(false);
                this.dispose(); 
            }
            else{
                JOptionPane.showMessageDialog(null, "User not found!\nEnsure correct username and password entered.\nOR\nNew user must make an account first.");
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void pswfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pswfPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnNewUser;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblNewPlayer;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblPswrd;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPasswordField pswfPassword;
    private javax.swing.JTextField txfUserName;
    // End of variables declaration//GEN-END:variables
}