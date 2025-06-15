package template.adm;

import DAO.DenunciaDAO;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import Sources.denunCell;
import java.util.ArrayList;
import model.Denuncia;
import model.Funcionario;
import model.Sessao;
import template.Index;

public class funcAccont extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(funcAccont.class.getName());

    public static funcAccont funcScreen;
    ArrayList<denunCell> cell = new ArrayList<>();
    
    public funcAccont() {
        initComponents();
        
        Funcionario funcionario = (Funcionario)Sessao.getUsuario();
        
        DenunciaDAO denunciaDAO = new DenunciaDAO();
        
        var denuncias = denunciaDAO.listarTodas();
        
        funcScreen = this;
        
        hello.setText("Olá, " + funcionario.getNome());
        
        int verticalGap = 10;
        
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
            for (Denuncia denuncia : denuncias) {
            cell.add(
                new denunCell(
                        denuncia.getTransferencia().getContaDestino().getCliente().getNome(),
                        denuncia.getTransferencia().getData_transferencia(),
                        denuncia.getId(),
                        denuncia.getStatus().getDescricaoStatus()
                ));
        }
        
        int alturaTotal = ((60 + verticalGap))* (cell.size() + 1);
        content.setPreferredSize(new Dimension(400, alturaTotal));
        for(denunCell currentCell : cell){
            content.add(Box.createVerticalStrut(verticalGap));
            content.add(currentCell);
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        content = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        header = new javax.swing.JPanel();
        hello = new javax.swing.JLabel();
        btn_deslogar = new javax.swing.JButton();
        gradient = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1080, 720));
        setResizable(false);
        getContentPane().setLayout(null);

        title.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(102, 102, 102));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Denuncias");
        title.setToolTipText("");
        title.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        title.setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().add(title);
        title.setBounds(10, 190, 1040, 30);

        content.setLayout(null);
        scroll.setViewportView(content);

        getContentPane().add(scroll);
        scroll.setBounds(0, 270, 1070, 620);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 230, 1040, 10);

        header.setBackground(new java.awt.Color(255, 69, 69));
        header.setLayout(null);

        hello.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        hello.setForeground(new java.awt.Color(255, 255, 255));
        hello.setText("Olá, {user}");
        hello.setToolTipText("");
        hello.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        header.add(hello);
        hello.setBounds(20, 30, 250, 78);

        btn_deslogar.setBackground(new java.awt.Color(204, 204, 204));
        btn_deslogar.setForeground(new java.awt.Color(51, 51, 51));
        btn_deslogar.setText("<html><h2>Deslogar");
        btn_deslogar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_deslogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deslogarActionPerformed(evt);
            }
        });
        header.add(btn_deslogar);
        btn_deslogar.setBounds(950, 30, 90, 50);

        gradient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/red_bg.jpg"))); // NOI18N
        header.add(gradient);
        gradient.setBounds(0, 0, 1080, 170);

        getContentPane().add(header);
        header.setBounds(0, 0, 1080, 170);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_deslogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deslogarActionPerformed
        Sessao.encerrar();
        Index targetScreen = new Index();
        this.setVisible(false);
        targetScreen.setVisible(true);
    }//GEN-LAST:event_btn_deslogarActionPerformed

    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(() -> new funcAccont().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_deslogar;
    private javax.swing.JPanel content;
    private javax.swing.JLabel gradient;
    private javax.swing.JPanel header;
    private javax.swing.JLabel hello;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
