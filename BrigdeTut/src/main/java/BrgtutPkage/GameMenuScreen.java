/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BrgtutPkage;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author Ishaan
 */
public class GameMenuScreen extends javax.swing.JFrame {

    /**
     * Creates new form GameMenuScreen
     */
    public GameMenuScreen() {
        initComponents();
        pnlGameMenu.setPreferredSize(new Dimension(500, 500));
        setSize(new Dimension(540, 360));
        
        
        
        btnLessons.setBackground(Color.BLACK);
        btnLessons.setOpaque(true);
        
        btnFreePlay.setBackground(Color.BLACK);
        btnFreePlay.setOpaque(true);
        
        btnExit.setBackground(Color.BLACK);
        btnExit.setOpaque(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMenu = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnFreePlay = new javax.swing.JButton();
        btnLessons = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        lblBackGround = new javax.swing.JLabel();
        lblArrowBackGround = new javax.swing.JLabel();
        pnlGameMenu = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\ishaan\\Desktop\\University 2019\\CS3\\Sem2\\Capstone\\Phase3\\TextFont\\gameMenuMed.png")); // NOI18N
        getContentPane().add(lblMenu);
        lblMenu.setBounds(140, 0, 250, 50);

        btnExit.setBackground(new java.awt.Color(0, 0, 0));
        btnExit.setIcon(new javax.swing.ImageIcon("C:\\Users\\ishaan\\Desktop\\University 2019\\CS3\\Sem2\\Capstone\\Phase3\\TextFont\\ExitGame30.png")); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(170, 230, 180, 50);

        btnFreePlay.setIcon(new javax.swing.ImageIcon("C:\\Users\\ishaan\\Desktop\\University 2019\\CS3\\Sem2\\Capstone\\Phase3\\TextFont\\freePlay30.png")); // NOI18N
        getContentPane().add(btnFreePlay);
        btnFreePlay.setBounds(170, 170, 180, 50);

        btnLessons.setIcon(new javax.swing.ImageIcon("C:\\Users\\ishaan\\Desktop\\University 2019\\CS3\\Sem2\\Capstone\\Phase3\\TextFont\\Lessons30.png")); // NOI18N
        btnLessons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLessonsActionPerformed(evt);
            }
        });
        getContentPane().add(btnLessons);
        btnLessons.setBounds(170, 110, 180, 50);

        btnPrevious.setIcon(new javax.swing.ImageIcon("C:\\Users\\ishaan\\Desktop\\University 2019\\CS3\\Sem2\\Capstone\\Phase3\\TextFont\\arrow-112-32.png")); // NOI18N
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrevious);
        btnPrevious.setBounds(0, 0, 60, 50);

        lblBackGround.setIcon(new javax.swing.ImageIcon("C:\\Users\\ishaan\\Desktop\\University 2019\\CS3\\Sem2\\Capstone\\Phase3\\Images\\background.jpg")); // NOI18N
        lblBackGround.setText("jLabel2");
        getContentPane().add(lblBackGround);
        lblBackGround.setBounds(0, 0, 540, 360);

        lblArrowBackGround.setBackground(new java.awt.Color(0, 0, 0));
        lblArrowBackGround.setIcon(new javax.swing.ImageIcon("C:\\Users\\ishaan\\Desktop\\University 2019\\CS3\\Sem2\\Capstone\\Phase3\\Images\\blackBackgrnd.jpg")); // NOI18N
        lblArrowBackGround.setText("jLabel2");
        getContentPane().add(lblArrowBackGround);
        lblArrowBackGround.setBounds(0, 0, 60, 50);

        pnlGameMenu.setLayout(null);
        getContentPane().add(pnlGameMenu);
        pnlGameMenu.setBounds(270, 320, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // Exit screen
        new ExitScreen().setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // Go to previous screen
        new LoginScreen().setVisible(true);
        
        GameMenuScreen objGameMenu1=new GameMenuScreen();
        objGameMenu1.setVisible(false);
        this.dispose();
        
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnLessonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLessonsActionPerformed
        // Go to Lessons screen
        new LessonsScreen().setVisible(true);
        GameMenuScreen objGameMenu2=new GameMenuScreen();
        objGameMenu2.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnLessonsActionPerformed

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
            java.util.logging.Logger.getLogger(GameMenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameMenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameMenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameMenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameMenuScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFreePlay;
    private javax.swing.JButton btnLessons;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel lblArrowBackGround;
    private javax.swing.JLabel lblBackGround;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JPanel pnlGameMenu;
    // End of variables declaration//GEN-END:variables
}