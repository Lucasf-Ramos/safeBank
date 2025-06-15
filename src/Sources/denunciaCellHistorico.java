package Sources;

import java.util.Date;
import template.client.clientAccont;

public class denunciaCellHistorico extends javax.swing.JPanel {

    clientAccont parent;
    
    public denunciaCellHistorico() {
        initComponents();
    }
    public denunciaCellHistorico(long protocoloTransferencia, Date _data, String _status) {
        initComponents();

        denunciado.setText("Protocolo Transferencia: " + protocoloTransferencia);
        data.setText("Data: " + _data);
        status.setText("Status: " + _status);
        this.parent = clientAccont.clientScreen;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        denunciado = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(900, 50));
        setMinimumSize(new java.awt.Dimension(900, 50));
        setPreferredSize(new java.awt.Dimension(900, 50));

        denunciado.setText("Protocolo de Transferência:");

        data.setText("data: 00/00/0000");

        status.setText("Status:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(denunciado)
                .addGap(217, 217, 217)
                .addComponent(data)
                .addGap(205, 205, 205)
                .addComponent(status)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(denunciado)
                    .addComponent(data)
                    .addComponent(status))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel data;
    private javax.swing.JLabel denunciado;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
