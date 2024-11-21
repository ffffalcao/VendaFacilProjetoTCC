// Classe para gerenciamento de categorias, permitindo adicionar, editar e excluir.

import bancoDeDados.ProvedorConexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.table.TableModel;

public class GerenciarCategoria extends javax.swing.JFrame {

    private int categoriaPk = 0;

// Construtor da classe, inicializa os componentes e define a posição da janela.
    public GerenciarCategoria() {
        initComponents();
        setLocationRelativeTo(null);
    }

// Método para validar se o campo de nome da categoria foi preenchido.
    private boolean validarCampos() {
        if (!txtNome.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

// Método para atualizar a tabela de categorias com os dados do banco de dados.
    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) tabelaCategoria.getModel();

        try (Connection connection = ProvedorConexao.connect()) {
            Statement st = connection.createStatement();
            String query = "SELECT * FROM categoria";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("categoria_pk");
                String nome = rs.getString("nome");
                model.addRow(new Object[]{id, nome});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

// Método para limpar o campo de nome e resetar a variável de controle.
    private void limparCampos() {
        txtNome.setText("");
        categoriaPk = 0;
    }

// Método gerado automaticamente pela IDE, responsável pela inicialização dos componentes da interface gráfica.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCategoria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 600));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitulo.setText("Gerenciar Categorias");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        lblNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNome.setText("Nome");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 190, -1));

        txtNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 350, -1));

        btnSalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 80, 21));

        btnExcluir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 80, 21));

        btnReiniciar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 80, 21));

        btnFechar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 80, 21));

        btnAtualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 80, 21));

        tabelaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ));
        tabelaCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCategoriaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaCategoria);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

// Método executado quando o formulário é exibido, inicializando os dados na tabela de categoria.
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        atualizarTabela();
        btnAtualizar.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

// Evento de clique do botão "Salvar". Realiza a inserção de uma nova categoria no banco de dados.    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText();
        if (validarCampos()) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios");
        } else {
            try (Connection connection = ProvedorConexao.connect()) {
                String query = "INSERT INTO categoria (nome) VALUES (?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, nome);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso");
                limparCampos();
                setVisible(false);
                new GerenciarCategoria().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

// Evento de clique do botão "Excluir". Remove a categoria selecionada do banco de dados.
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (categoriaPk == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma categoria selecionada para exclusão.");
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir a categoria?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection connection = ProvedorConexao.connect()) {
                    String query = "DELETE FROM categoria WHERE categoria_pk=?";
                    PreparedStatement ps = connection.prepareStatement(query);
                    ps.setInt(1, categoriaPk);
                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso.");
                        DefaultTableModel model = (DefaultTableModel) tabelaCategoria.getModel();
                        int selectedRow = tabelaCategoria.getSelectedRow();
                        model.removeRow(selectedRow);
                        limparCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir a categoria.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

// Evento de clique do botão "Reiniciar". Reinicializa a tela para seu estado inicial.
    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        setVisible(false);
        new GerenciarCategoria().setVisible(true);
    }//GEN-LAST:event_btnReiniciarActionPerformed

//Método acionado quando o botão "Fechar" é clicado. Fecha a tela de gerenciamento de categorias.
    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

// Evento de clique do botão "Atualizar". Atualiza o nome da categoria selecionada no banco de dados.
    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        String nome = txtNome.getText();
        if (validarCampos()) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios");
        } else {
            try (Connection connection = ProvedorConexao.connect()) {
                String query = "UPDATE categoria SET nome=? WHERE categoria_pk=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, nome);
                ps.setInt(2, categoriaPk);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Categoria atualizada com sucesso");
                limparCampos();
                setVisible(false);
                new GerenciarCategoria().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

// Método acionado quando uma categoria é clicada na tabela. Preenche os campos com os dados da categoria selecionada.
    private void tabelaCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCategoriaMouseClicked
        int index = tabelaCategoria.getSelectedRow();
        TableModel model = tabelaCategoria.getModel();
        String id = model.getValueAt(index, 0).toString();
        categoriaPk = Integer.parseInt(id);

        String nome = model.getValueAt(index, 1).toString();
        txtNome.setText(nome);
        btnSalvar.setEnabled(false);
        btnAtualizar.setEnabled(true);
    }//GEN-LAST:event_tabelaCategoriaMouseClicked

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
            java.util.logging.Logger.getLogger(GerenciarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tabelaCategoria;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
