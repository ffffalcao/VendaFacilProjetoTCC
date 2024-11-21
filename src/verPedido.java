// Classe para visualizar os pedidos realizados e seus detalhes.

import common.abrirPDF;
import bancoDeDados.ProvedorConexao;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class verPedido extends javax.swing.JFrame {

// Construtor da classe, inicializa os componentes e define a posição da janela.
    public verPedido() {
        initComponents();
        setLocationRelativeTo(null);
    }

// Método gerado automaticamente pela IDE, responsável pela inicialização dos componentes da interface gráfica.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaListaClientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaListaPedidos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(850, 600));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Visualizar Pedido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 21, -1, -1));

        tabelaListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "Email"
            }
        ));
        tabelaListaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaListaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaListaClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 109, 398, -1));

        tabelaListaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID do Pedido", "Data", "Total Pago"
            }
        ));
        tabelaListaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaListaPedidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaListaPedidos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 109, 434, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Lista de Clientes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 81, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Lista de Pedidos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 81, -1, -1));

        btnFechar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 550, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Método acionado quando o botão "Fechar" é clicado. Fecha a tela de visualização de pedidos.
    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

// Método que é chamado quando o formulário é exibido. Atualiza a lista de clientes e pedidos.
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        DefaultTableModel model = (DefaultTableModel) tabelaListaClientes.getModel();
        try (Connection connection = ProvedorConexao.connect()) {
            Statement st = connection.createStatement();
            String query = ("SELECT * FROM cliente");
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("cliente_pk"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email")});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_formComponentShown

// Evento de clique na tabela de clientes. Exibe os pedidos do cliente selecionado.
    private void tabelaListaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaListaClientesMouseClicked
        int index = tabelaListaClientes.getSelectedRow();
        TableModel model = tabelaListaClientes.getModel();
        String id = model.getValueAt(index, 0).toString();

        DefaultTableModel modelPedido = (DefaultTableModel) tabelaListaPedidos.getModel();
        modelPedido.setRowCount(0);
        try (Connection connection = ProvedorConexao.connect()) {
            Statement st = connection.createStatement();
            String query = ("SELECT * FROM detalhePedido WHERE cliente_fk=" + id + "");
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                modelPedido.addRow(new Object[]{rs.getString("idPedido"), rs.getString("dataPedido"), rs.getString("totalPago")});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tabelaListaClientesMouseClicked

// Evento de clique na tabela de pedidos. Exibe detalhes do pedido selecionado.
    private void tabelaListaPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaListaPedidosMouseClicked
        int index = tabelaListaPedidos.getSelectedRow();
        TableModel model = tabelaListaPedidos.getModel();
        String idPedido = model.getValueAt(index, 0).toString();
        abrirPDF.abrirPorId(idPedido);

    }//GEN-LAST:event_tabelaListaPedidosMouseClicked

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
            java.util.logging.Logger.getLogger(verPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaListaClientes;
    private javax.swing.JTable tabelaListaPedidos;
    // End of variables declaration//GEN-END:variables
}
