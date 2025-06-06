package template.adm;

import template.adm.transationCell;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import template.client.denunCell;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Natanael-PC
 */
public class verDenuncia extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(verDenuncia.class.getName());

    /**
     * Creates new form historico
     */
    public verDenuncia() {
        initComponents();

    }
    public verDenuncia(int id) {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        denunciaTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        header = new javax.swing.JPanel();
        gradient = new javax.swing.JLabel();
        denunciado = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        denunciaTitle2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        hitorico_denunciante = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        resumo = new javax.swing.JLabel();
        denunciante = new javax.swing.JLabel();
        historico_Denunciado = new javax.swing.JButton();
        Aprovar = new javax.swing.JButton();
        Negar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1080, 720));
        setResizable(false);
        getContentPane().setLayout(null);

        denunciaTitle.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        denunciaTitle.setForeground(new java.awt.Color(102, 102, 102));
        denunciaTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        denunciaTitle.setText("Denuncias 001");
        denunciaTitle.setToolTipText("");
        denunciaTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        denunciaTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(denunciaTitle);
        denunciaTitle.setBounds(10, 70, 1040, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 110, 1040, 10);

        header.setBackground(new java.awt.Color(255, 69, 69));
        header.setLayout(null);

        gradient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/red_bg.jpg"))); // NOI18N
        header.add(gradient);
        gradient.setBounds(0, 0, 1080, 170);

        getContentPane().add(header);
        header.setBounds(0, 0, 1080, 50);

        denunciado.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        denunciado.setForeground(new java.awt.Color(102, 102, 102));
        denunciado.setText("Denunciado: 0000");
        denunciado.setToolTipText("");
        denunciado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        denunciado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(denunciado);
        denunciado.setBounds(10, 140, 880, 30);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(10, 180, 1040, 10);

        denunciaTitle2.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        denunciaTitle2.setForeground(new java.awt.Color(102, 102, 102));
        denunciaTitle2.setText("Resumo:");
        denunciaTitle2.setToolTipText("");
        denunciaTitle2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        denunciaTitle2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(denunciaTitle2);
        denunciaTitle2.setBounds(20, 260, 880, 30);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(10, 240, 1040, 10);

        hitorico_denunciante.setText("ver histórico");
        getContentPane().add(hitorico_denunciante);
        hitorico_denunciante.setBounds(910, 200, 110, 23);

        cancelar.setBackground(new java.awt.Color(204, 204, 204));
        cancelar.setText("Cancelar");
        cancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(cancelar);
        cancelar.setBounds(830, 660, 150, 30);

        resumo.setBackground(new java.awt.Color(255, 255, 255));
        resumo.setText("Resumo do acontecimento e blablabla");
        resumo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(resumo);
        resumo.setBounds(30, 300, 990, 200);

        denunciante.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        denunciante.setForeground(new java.awt.Color(102, 102, 102));
        denunciante.setText("Denunciante: 000");
        denunciante.setToolTipText("");
        denunciante.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        denunciante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(denunciante);
        denunciante.setBounds(10, 200, 880, 30);

        historico_Denunciado.setText("ver histórico");
        getContentPane().add(historico_Denunciado);
        historico_Denunciado.setBounds(910, 140, 110, 23);

        Aprovar.setBackground(new java.awt.Color(153, 255, 204));
        Aprovar.setText("Aprovar");
        Aprovar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Aprovar);
        Aprovar.setBounds(80, 660, 150, 30);

        Negar.setBackground(new java.awt.Color(255, 102, 102));
        Negar.setForeground(new java.awt.Color(255, 255, 255));
        Negar.setText("Negar");
        Negar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Negar);
        Negar.setBounds(250, 660, 150, 30);

        pack();
        setLocationRelativeTo(null);
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new verDenuncia().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aprovar;
    private javax.swing.JButton Negar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel denunciaTitle;
    private javax.swing.JLabel denunciaTitle2;
    private javax.swing.JLabel denunciado;
    private javax.swing.JLabel denunciante;
    private javax.swing.JLabel gradient;
    private javax.swing.JPanel header;
    private javax.swing.JButton historico_Denunciado;
    private javax.swing.JButton hitorico_denunciante;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel resumo;
    // End of variables declaration//GEN-END:variables
}
