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
public class lesson1Info3 extends javax.swing.JFrame {

    /**
     * Creates new form lesson1Info3
     */
    public lesson1Info3() {
        initComponents();
         pnlLessonInfo3.setPreferredSize(new Dimension(500, 500));
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

        pnlLessonInfo3 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        lblHeading = new javax.swing.JLabel();
        pnlInfo3 = new javax.swing.JPanel();
        lblInfo3 = new javax.swing.JLabel();
        lblInfoBackGrnd = new javax.swing.JLabel();
        btnProceedToQuiz = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        lblMainBackGrnd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pnlLessonInfo3.setLayout(null);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/arrow-112-32.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        pnlLessonInfo3.add(btnBack);
        btnBack.setBounds(0, 0, 60, 50);

        lblHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/lesson1_40_quiz.png"))); // NOI18N
        pnlLessonInfo3.add(lblHeading);
        lblHeading.setBounds(130, 0, 280, 67);

        pnlInfo3.setLayout(null);

        lblInfo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/lesson1Info3.png"))); // NOI18N
        pnlInfo3.add(lblInfo3);
        lblInfo3.setBounds(10, 10, 330, 120);

        lblInfoBackGrnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/blackBackgrnd.jpg"))); // NOI18N
        lblInfoBackGrnd.setText("jLabel1");
        pnlInfo3.add(lblInfoBackGrnd);
        lblInfoBackGrnd.setBounds(0, 0, 380, 250);

        pnlLessonInfo3.add(pnlInfo3);
        pnlInfo3.setBounds(70, 110, 380, 250);

        btnProceedToQuiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/proceed24.png"))); // NOI18N
        btnProceedToQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedToQuizActionPerformed(evt);
            }
        });
        pnlLessonInfo3.add(btnProceedToQuiz);
        btnProceedToQuiz.setBounds(160, 400, 190, 40);

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        pnlLessonInfo3.add(btnPrev);
        btnPrev.setBounds(30, 210, 40, 30);

        lblMainBackGrnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/greenBackground.jpg"))); // NOI18N
        lblMainBackGrnd.setText("jLabel1");
        pnlLessonInfo3.add(lblMainBackGrnd);
        lblMainBackGrnd.setBounds(0, 0, 520, 500);

        getContentPane().add(pnlLessonInfo3);
        pnlLessonInfo3.setBounds(0, 0, 520, 500);

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
        new lesson1Info2().setVisible(true);

                this.setVisible(false);
                this.dispose(); 
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnProceedToQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedToQuizActionPerformed
        // TODO add your handling code here:
        new Lesson1_Quiz().setVisible(true);

                this.setVisible(false);
                this.dispose(); 
    }//GEN-LAST:event_btnProceedToQuizActionPerformed

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
            java.util.logging.Logger.getLogger(lesson1Info3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lesson1Info3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lesson1Info3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lesson1Info3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lesson1Info3().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnProceedToQuiz;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblInfo3;
    private javax.swing.JLabel lblInfoBackGrnd;
    private javax.swing.JLabel lblMainBackGrnd;
    private javax.swing.JPanel pnlInfo3;
    private javax.swing.JPanel pnlLessonInfo3;
    // End of variables declaration//GEN-END:variables
}
