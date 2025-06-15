package template.client;

import DAO.DenunciaDAO;
import DAO.TransacaoDAO;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Denuncia;
import model.Transacao;
import model.enums.StatusDenuncia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Natanael-PC
 */
public class denuncia extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(denuncia.class.getName());

    public denuncia() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        gradient = new javax.swing.JLabel();
        pageName = new javax.swing.JLabel();
        _______ = new javax.swing.JSeparator();
        lbl_resumo = new javax.swing.JLabel();
        txtfld_user = new javax.swing.JTextField();
        lbl_user = new javax.swing.JLabel();
        txtarea_resumo = new javax.swing.JScrollPane();
        txtfld_resumo = new javax.swing.JTextArea();
        btn_cancelar = new javax.swing.JButton();
        btn_enviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(255, 69, 69));
        header.setLayout(null);

        gradient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/red_bg.jpg"))); // NOI18N
        header.add(gradient);
        gradient.setBounds(0, 0, 1080, 60);

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 60));

        pageName.setFont(new java.awt.Font("DialogInput", 0, 36)); // NOI18N
        pageName.setForeground(new java.awt.Color(102, 102, 102));
        pageName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageName.setText("Fazer Denúncia");
        pageName.setToolTipText("");
        pageName.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(pageName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 610, 78));
        getContentPane().add(_______, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 930, 10));

        lbl_resumo.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        lbl_resumo.setForeground(new java.awt.Color(102, 102, 102));
        lbl_resumo.setText("Resumo:");
        lbl_resumo.setToolTipText("");
        lbl_resumo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lbl_resumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 300, -1));

        txtfld_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtfld_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 420, -1));

        lbl_user.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        lbl_user.setForeground(new java.awt.Color(102, 102, 102));
        lbl_user.setText("Numero de Protocolo:");
        lbl_user.setToolTipText("");
        lbl_user.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lbl_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 300, -1));

        txtfld_resumo.setColumns(20);
        txtfld_resumo.setRows(5);
        txtfld_resumo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtarea_resumo.setViewportView(txtfld_resumo);

        getContentPane().add(txtarea_resumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 420, 90));

        btn_cancelar.setBackground(new java.awt.Color(153, 153, 153));
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setToolTipText("Preencha os campos e clique aqui para entrar");
        btn_cancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 590, 180, 30));

        btn_enviar.setBackground(new java.awt.Color(255, 69, 69));
        btn_enviar.setForeground(new java.awt.Color(255, 255, 255));
        btn_enviar.setText("Enviar");
        btn_enviar.setToolTipText("Preencha os campos e clique aqui para entrar");
        btn_enviar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 180, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        
    String protocoloStr = txtfld_user.getText().trim(); 
    String resumo = txtfld_resumo.getText().trim();    


    if (protocoloStr.isEmpty() || resumo.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Todos os campos devem ser preenchidos corretamente.",
            "Erro de preenchimento",
            JOptionPane.ERROR_MESSAGE);
        return;
    }
    try {
        long protocoloId = Long.parseLong(protocoloStr); // Convertendo protocolo para Long

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        Transacao transacao = transacaoDAO.buscarTransacaoPorProtocolo(protocoloId);

        if (transacao == null) {
            JOptionPane.showMessageDialog(this,
                "Transação com o número de protocolo informado não encontrada.",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        Denuncia denuncia = new Denuncia(resumo, StatusDenuncia.pendente, new Date(), transacao);

        DenunciaDAO denunciaDAO = new DenunciaDAO();
        boolean sucesso = denunciaDAO.registrarDenuncia(denuncia);

        if (sucesso) {
            JOptionPane.showMessageDialog(this,
                "Denúncia registrada com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);

            // Voltar pra tela principal do cliente
            clientAccont targetScreen = new clientAccont();
            this.setVisible(false);
            targetScreen.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                "Falha ao registrar a denúncia no banco de dados.",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "O número de protocolo deve ser um número válido.",
                "Erro de formato",
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Erro inesperado: " + ex.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_enviarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
       clientAccont targetScreen = new clientAccont();
        this.setVisible(false);
        targetScreen.setVisible(true);
    }//GEN-LAST:event_btn_cancelarActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new denuncia().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator _______;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_enviar;
    private javax.swing.JLabel gradient;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lbl_resumo;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JLabel pageName;
    private javax.swing.JScrollPane txtarea_resumo;
    private javax.swing.JTextArea txtfld_resumo;
    private javax.swing.JTextField txtfld_user;
    // End of variables declaration//GEN-END:variables
}
