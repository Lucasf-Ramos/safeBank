package template.client;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Natanael-PC
 */
public class editarConta extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(editarConta.class.getName());

    /**
     * Creates new form editarConta
     */
    public editarConta() {
        initComponents();
        
        String currentName = "usuario 012"; //coloque o getNome e o getSenha aqui
        String currentPass = "012";
        
        txtfld_user.setText(currentName);
        txtfld_senha.setText(currentPass);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        gradient = new javax.swing.JLabel();
        txtfld_user = new javax.swing.JTextField();
        lbl_user = new javax.swing.JLabel();
        lbl_user1 = new javax.swing.JLabel();
        txtfld_senha = new javax.swing.JPasswordField();
        lbl_senhaantiga = new javax.swing.JLabel();
        txtfld_senhaConfirm = new javax.swing.JPasswordField();
        btn_confirmar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        Logotipo = new javax.swing.JLabel();
        _______ = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().setLayout(null);

        header.setBackground(new java.awt.Color(255, 69, 69));
        header.setLayout(null);

        gradient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/red_bg.jpg"))); // NOI18N
        header.add(gradient);
        gradient.setBounds(0, 0, 1080, 60);

        getContentPane().add(header);
        header.setBounds(0, 0, 1080, 60);

        txtfld_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtfld_user);
        txtfld_user.setBounds(310, 270, 420, 22);

        lbl_user.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        lbl_user.setForeground(new java.awt.Color(102, 102, 102));
        lbl_user.setText("Novo nome:");
        lbl_user.setToolTipText("");
        lbl_user.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lbl_user);
        lbl_user.setBounds(310, 240, 300, 23);

        lbl_user1.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        lbl_user1.setForeground(new java.awt.Color(102, 102, 102));
        lbl_user1.setText("Nova Senha:");
        lbl_user1.setToolTipText("");
        lbl_user1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lbl_user1);
        lbl_user1.setBounds(310, 310, 300, 23);

        txtfld_senha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtfld_senha);
        txtfld_senha.setBounds(310, 340, 420, 22);

        lbl_senhaantiga.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        lbl_senhaantiga.setForeground(new java.awt.Color(102, 102, 102));
        lbl_senhaantiga.setText("Antiga senha:");
        lbl_senhaantiga.setToolTipText("");
        lbl_senhaantiga.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lbl_senhaantiga);
        lbl_senhaantiga.setBounds(310, 400, 300, 23);

        txtfld_senhaConfirm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtfld_senhaConfirm);
        txtfld_senhaConfirm.setBounds(310, 430, 420, 22);

        btn_confirmar.setBackground(new java.awt.Color(255, 69, 69));
        btn_confirmar.setForeground(new java.awt.Color(255, 255, 255));
        btn_confirmar.setText("Confirmar");
        btn_confirmar.setToolTipText("Preencha os campos e clique aqui para entrar");
        btn_confirmar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_confirmar);
        btn_confirmar.setBounds(430, 490, 180, 30);

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
        getContentPane().add(btn_cancelar);
        btn_cancelar.setBounds(430, 530, 180, 30);

        Logotipo.setFont(new java.awt.Font("DialogInput", 0, 36)); // NOI18N
        Logotipo.setForeground(new java.awt.Color(102, 102, 102));
        Logotipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Logotipo.setText("Editar Conta");
        Logotipo.setToolTipText("");
        Logotipo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(Logotipo);
        Logotipo.setBounds(380, 90, 300, 78);
        getContentPane().add(_______);
        _______.setBounds(80, 180, 930, 10);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed
        
        //if a senha atual e blabla bla dai continua, se não da telinha de erro
        
        //retorna a tela conta
        clientAccont targetScreen = new clientAccont();
        this.setVisible(false);
        targetScreen.setVisible(true);
        
        
    }//GEN-LAST:event_btn_confirmarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        clientAccont targetScreen = new clientAccont();
        this.setVisible(false);
        targetScreen.setVisible(true);
    }//GEN-LAST:event_btn_cancelarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new editarConta().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logotipo;
    private javax.swing.JSeparator _______;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_confirmar;
    private javax.swing.JLabel gradient;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lbl_senhaantiga;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JLabel lbl_user1;
    private javax.swing.JPasswordField txtfld_senha;
    private javax.swing.JPasswordField txtfld_senhaConfirm;
    private javax.swing.JTextField txtfld_user;
    // End of variables declaration//GEN-END:variables
}
