/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BrgtutPkage;

import java.awt.Dimension;

/**
 *
 * @author Ishaan
 */
public class ScoreCheatSheet extends javax.swing.JFrame {

    /**
     * Creates new form ScoreCheatSheet
     */
    public ScoreCheatSheet() {
        initComponents();
        
        pnlCheatSheet.setPreferredSize(new Dimension(500, 500));
        setSize(new Dimension(680, 701));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCheatSheet = new javax.swing.JPanel();
        lblCheatSheet = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pnlCheatSheet.setLayout(null);

        lblCheatSheet.setIcon(new javax.swing.ImageIcon("C:\\Users\\ishaan\\Desktop\\University 2019\\CS3\\Sem2\\Capstone\\Phase3\\Images\\Bridge Score Guide.jpeg")); // NOI18N
        pnlCheatSheet.add(lblCheatSheet);
        lblCheatSheet.setBounds(0, 0, 670, 660);

        getContentPane().add(pnlCheatSheet);
        pnlCheatSheet.setBounds(0, 0, 680, 670);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ScoreCheatSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreCheatSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreCheatSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreCheatSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreCheatSheet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCheatSheet;
    private javax.swing.JPanel pnlCheatSheet;
    // End of variables declaration//GEN-END:variables
}