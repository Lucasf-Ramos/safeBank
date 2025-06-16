package template.client;

import DAO.ContaDAO;
import DAO.TransacaoDAO;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import Sources.transationCell;
import java.util.ArrayList;
import model.Cliente;
import model.Conta;
import model.Sessao;
import model.Transacao;
import template.adm.funcAccont;

public class historico extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(historico.class.getName());

    boolean isFuncAccont = false; 
    
    ArrayList<transationCell> cell = new ArrayList<>();
    public historico() {
        initComponents();
        
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        
        Cliente cliente = (Cliente)Sessao.getUsuario();
        
        ContaDAO contaDao = new ContaDAO();
        Conta conta = contaDao.buscarContaPorClienteId(cliente.getClienteId());
        
        var transacoes = transacaoDAO.listarTransferenciasPorContaId(conta);

        for (Transacao transacao : transacoes) {
            cell.add(
                new transationCell(
                    transacao.getContaDestino().getNumeroConta(), 
                    transacao.getContaOrigem().getNumeroConta(),
                    transacao.getData_transferencia(),
                    transacao.getId(),
                    transacao.getValor(),
                    transacao.getProtocolo()
                ));
        }
       
        generateGrid();
    }
    
    
    
    
    void generateGrid(){
        int verticalGap = 10;
        
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        int alturaTotal = ((60 + verticalGap))* (cell.size() + 1);
        content.setPreferredSize(new Dimension(400, alturaTotal));
        for(transationCell currentCell : cell){
            content.add(Box.createVerticalStrut(verticalGap));
            content.add(currentCell);
            
        }
    }
    
    
    public historico(long clienteId) {
        initComponents();

        isFuncAccont = true;

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        ContaDAO contaDao = new ContaDAO();
        Conta conta = contaDao.buscarContaPorClienteId(clienteId);
        var transacoes = transacaoDAO.listarTransferenciasPorContaId(conta);

        for (Transacao transacao : transacoes) {
            cell.add(
                new transationCell(
                    transacao.getContaDestino().getNumeroConta(),
                    transacao.getContaOrigem().getNumeroConta(),
                    transacao.getData_transferencia(),
                    transacao.getId(),
                    transacao.getValor(),
                    transacao.getProtocolo()
                )
            );
        }

        generateGrid();
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        btn_cancelar = new javax.swing.JButton();
        gradient = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        content = new javax.swing.JPanel();
        historicoTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        content.setPreferredSize(new java.awt.Dimension(1080, 720));
        content.setLayout(null);
        scroll.setViewportView(content);

        getContentPane().add(scroll);
        scroll.setBounds(0, 190, 1080, 750);

        historicoTitle.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        historicoTitle.setForeground(new java.awt.Color(102, 102, 102));
        historicoTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        historicoTitle.setText("Histórico");
        historicoTitle.setToolTipText("");
        historicoTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        historicoTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(historicoTitle);
        historicoTitle.setBounds(10, 70, 1040, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 120, 1040, 10);

        jLabel1.setText("Conta Destino");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 170, 80, 16);

        jLabel2.setText("Conta Origem");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 170, 80, 16);

        jLabel3.setText("Data");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(460, 170, 30, 16);

        jLabel5.setText("ID");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(810, 170, 20, 16);

        jLabel6.setText("Protocolo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(920, 170, 60, 16);

        jLabel4.setText("Valor");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(650, 170, 37, 16);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

        if(!isFuncAccont){
            clientAccont targetScreen = new clientAccont();
            this.setVisible(false);
            targetScreen.setVisible(true);
        }
        else{
            funcAccont targetScreen = new funcAccont();
            this.setVisible(false);
            targetScreen.setVisible(true);
        }
       
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
        
        java.awt.EventQueue.invokeLater(() -> new historico().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JPanel content;
    private javax.swing.JLabel gradient;
    private javax.swing.JPanel header;
    private javax.swing.JLabel historicoTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
