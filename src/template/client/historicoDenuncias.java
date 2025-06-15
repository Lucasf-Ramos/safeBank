package template.client;

import DAO.DenunciaDAO;
import Sources.denunciaCellHistorico;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.util.ArrayList;
import model.Cliente;
import model.Denuncia;
import model.Sessao;

public class historicoDenuncias extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(historicoDenuncias.class.getName());
    
    ArrayList<denunciaCellHistorico> cell = new ArrayList<>();
    
    public historicoDenuncias() {
        initComponents();
        
        DenunciaDAO denunciaDAO = new DenunciaDAO();
        
        Cliente cliente = (Cliente)Sessao.getUsuario();
        
        var denuncias = denunciaDAO.listarDenunciasPorClienteId(cliente.getClienteId());

        for (Denuncia denuncia : denuncias) {
            cell.add(
                new denunciaCellHistorico(
                    denuncia.getTransferencia().getProtocolo(), 
                    denuncia.getData(),
                    denuncia.getStatus().getDescricaoStatus()
                ));
        }
        
        generateGrid();
    }
    
    void generateGrid(){
        int verticalGap = 10;
        
        contentDenuncia.setLayout(new BoxLayout(contentDenuncia, BoxLayout.Y_AXIS));

        int alturaTotal = ((60 + verticalGap))* (cell.size() + 1);
        contentDenuncia.setPreferredSize(new Dimension(400, alturaTotal));
        
        for(denunciaCellHistorico currentCell : cell){
            contentDenuncia.add(Box.createVerticalStrut(verticalGap));
            contentDenuncia.add(currentCell);
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        btn_cancelar = new javax.swing.JButton();
        gradient = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        contentDenuncia = new javax.swing.JPanel();
        historicoTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setResizable(false);
        getContentPane().setLayout(null);

        header.setBackground(new java.awt.Color(255, 69, 69));
        header.setLayout(null);

        btn_cancelar.setBackground(new java.awt.Color(153, 153, 153));
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("Voltar");
        btn_cancelar.setToolTipText("Preencha os campos e clique aqui para entrar");
        btn_cancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        header.add(btn_cancelar);
        btn_cancelar.setBounds(960, 10, 100, 20);

        gradient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/red_bg.jpg"))); // NOI18N
        header.add(gradient);
        gradient.setBounds(0, 0, 1080, 170);

        getContentPane().add(header);
        header.setBounds(0, 0, 1080, 50);

        contentDenuncia.setPreferredSize(new java.awt.Dimension(1080, 720));
        contentDenuncia.setLayout(null);
        scroll.setViewportView(contentDenuncia);

        getContentPane().add(scroll);
        scroll.setBounds(0, 190, 1080, 750);

        historicoTitle.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        historicoTitle.setForeground(new java.awt.Color(102, 102, 102));
        historicoTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        historicoTitle.setText("Histórico Denuncias");
        historicoTitle.setToolTipText("");
        historicoTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        historicoTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(historicoTitle);
        historicoTitle.setBounds(10, 70, 1040, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 120, 1040, 10);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        clientAccont targetScreen = new clientAccont();
        this.setVisible(false);
        targetScreen.setVisible(true);
    }//GEN-LAST:event_btn_cancelarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new historicoDenuncias().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JPanel contentDenuncia;
    private javax.swing.JLabel gradient;
    private javax.swing.JPanel header;
    private javax.swing.JLabel historicoTitle;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
