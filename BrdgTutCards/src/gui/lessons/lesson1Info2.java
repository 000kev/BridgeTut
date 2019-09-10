/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.lessons;

import java.awt.Dimension;

/**
 *
 * @author Ishaan
 */
public class lesson1Info2 extends javax.swing.JFrame {

    /**
     * Creates new form lesson1Info2
     */
    public lesson1Info2() {
        initComponents();
        
        pnlInfo.setPreferredSize(new Dimension(500, 500));
        setSize(new Dimension(520, 500));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLesson1MoreInfo = new javax.swing.JPanel();
        pnlInfo = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblHeading = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pnlLesson1MoreInfo.setLayout(null);

        pnlInfo.setLayout(null);

        lblInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/lesson1Info2.png"))); // NOI18N
        pnlInfo.add(lblInfo);
        lblInfo.setBounds(0, 10, 370, 120);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/blackBackgrnd.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        pnlInfo.add(jLabel2);
        jLabel2.setBounds(0, 0, 380, 250);

        pnlLesson1MoreInfo.add(pnlInfo);
        pnlInfo.setBounds(70, 110, 380, 250);

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        pnlLesson1MoreInfo.add(btnNext);
        btnNext.setBounds(450, 210, 40, 23);

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        pnlLesson1MoreInfo.add(btnPrev);
        btnPrev.setBounds(30, 210, 41, 23);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/arrow-112-32.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        pnlLesson1MoreInfo.add(btnBack);
        btnBack.setBounds(0, 0, 60, 50);

        lblHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/lesson1_40_quiz.png"))); // NOI18N
        pnlLesson1MoreInfo.add(lblHeading);
        lblHeading.setBounds(130, 0, 280, 67);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/greenBackground.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        pnlLesson1MoreInfo.add(jLabel1);
        jLabel1.setBounds(0, 0, 520, 500);

        getContentPane().add(pnlLesson1MoreInfo);
        pnlLesson1MoreInfo.setBounds(0, 0, 520, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new lessonsScreen().setVisible(true);

                this.setVisible(false);
                this.dispose(); 
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        new lesson1Info().setVisible(true);

                this.setVisible(false);
                this.dispose(); 
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        new lesson1Info3().setVisible(true);

                this.setVisible(false);
                this.dispose(); 
    }//GEN-LAST:event_btnNextActionPerformed

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
            java.util.logging.Logger.getLogger(lesson1Info2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lesson1Info2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lesson1Info2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lesson1Info2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lesson1Info2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlLesson1MoreInfo;
    // End of variables declaration//GEN-END:variables
}