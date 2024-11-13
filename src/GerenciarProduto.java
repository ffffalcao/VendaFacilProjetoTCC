
import db.ProvedorConexao;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author cnoel
 */
public class GerenciarProduto extends javax.swing.JFrame {

    private int produtoPk = 0;
    private int quantidadeTotal = 0;

    public GerenciarProduto() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void getTodasCategorias() {
        try (Connection connection = ProvedorConexao.connect()) {
            Statement st = connection.createStatement();
            String query = ("SELECT * FROM categoria");
            ResultSet rs = st.executeQuery(query);
            comboBoxCategoria.removeAllItems();
            while (rs.next()) {
                comboBoxCategoria.addItem(rs.getString("categoria_pk") + "-" + rs.getString("nome"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private boolean validarCampos(String formType) {
        if (formType.equals("edit") && !txtNome.getText().equals("") && !txtPreco.getText().equals("") && !txtDescricao.getText().equals("")) {
            return false;
        } else if (formType.equals("new") && !txtNome.getText().equals("") && !txtPreco.getText().equals("") && !txtDescricao.getText().equals("") && !txtQuantidade.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private void limparCampos() {
        txtNome.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 600));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Gerenciamento de Produto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Quantidade", "Preço", "Descrição", "ID da categoria", "Categoria"
            }
        ));
        tabelaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProduto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 430, 430));

        lblNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNome.setText("Nome");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 350, -1));

        txtNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 355, -1));

        lblQuantidade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblQuantidade.setText("Quantidade");
        getContentPane().add(lblQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 350, -1));

        txtQuantidade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 355, -1));

        lblPreco.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblPreco.setText("Preço");
        getContentPane().add(lblPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 350, -1));

        txtPreco.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 355, -1));

        lblDescricao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDescricao.setText("Descrição");
        getContentPane().add(lblDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 350, -1));

        txtDescricao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 355, -1));

        lblCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCategoria.setText("Categoria");
        getContentPane().add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 350, -1));

        comboBoxCategoria.setEditable(true);
        comboBoxCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCategoria.setPreferredSize(new java.awt.Dimension(64, 20));
        getContentPane().add(comboBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 355, -1));

        btnSalvar.setText("Salvar");
        btnSalvar.setPreferredSize(new java.awt.Dimension(80, 21));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, -1, -1));

        btnAtualizar.setText("Atualizar");
        btnAtualizar.setPreferredSize(new java.awt.Dimension(80, 21));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, -1, -1));

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.setPreferredSize(new java.awt.Dimension(80, 21));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, -1, -1));

        btnExcluir.setText("Excluir");
        btnExcluir.setPreferredSize(new java.awt.Dimension(80, 21));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 80, 21));

        btnFechar.setText("Fechar");
        btnFechar.setPreferredSize(new java.awt.Dimension(80, 21));
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        getTodasCategorias();
        DefaultTableModel model = (DefaultTableModel) tabelaProduto.getModel();
        try (Connection connection = ProvedorConexao.connect()) {
            Statement st = connection.createStatement();
            String query = ("SELECT * FROM produto inner join categoria on produto.categoria_fk = categoria.categoria_pk");
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("produto_pk"), rs.getString("nome"), rs.getString("quantidade"), rs.getString("preco"), rs.getString("descricao"), rs.getString("categoria_fk"), rs.getString(8)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        btnAtualizar.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText();
        String quantidade = txtQuantidade.getText();
        String preco = txtPreco.getText();
        String descricao = txtDescricao.getText();
        String categoria = (String) comboBoxCategoria.getSelectedItem();
        String categoriaId[] = categoria.split("-", 0);
        if (validarCampos("new")) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios");
        } else {
            try (Connection connection = ProvedorConexao.connect()) {
                String query = ("INSERT INTO produto (nome, quantidade, preco, descricao, categoria_fk) VALUES (?,?,?,?,?)");
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, nome);
                ps.setString(2, quantidade);
                ps.setString(3, preco);
                ps.setString(4, descricao);
                ps.setString(5, categoriaId[0]);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
                setVisible(false);
                new GerenciarProduto().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        setVisible(false);
        new GerenciarProduto().setVisible(true);
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void tabelaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutoMouseClicked
        int index = tabelaProduto.getSelectedRow();
        TableModel model = tabelaProduto.getModel();
        String id = model.getValueAt(index, 0).toString();
        produtoPk = Integer.parseInt(id);

        String nome = model.getValueAt(index, 1).toString();
        txtNome.setText(nome);

        String quantidade = model.getValueAt(index, 2).toString();
        quantidadeTotal = 0;
        lblQuantidade.setText("Adicione à quantidade");
        quantidadeTotal = Integer.parseInt(quantidade);

        String preco = model.getValueAt(index, 3).toString();
        txtPreco.setText(preco);

        String descricao = model.getValueAt(index, 4).toString();
        txtDescricao.setText(descricao);

        comboBoxCategoria.removeAllItems();
        String idCategoria = model.getValueAt(index, 5).toString();
        String nomeCategoria = model.getValueAt(index, 6).toString();
        comboBoxCategoria.addItem(idCategoria + "-" + nomeCategoria);

        try (Connection connection = ProvedorConexao.connect()) {
            Statement st = connection.createStatement();
            String query = ("SELECT * FROM categoria");
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                if (Integer.parseInt(idCategoria) != rs.getInt(1)) {
                    comboBoxCategoria.addItem(rs.getString("categoria_pk") + "-" + rs.getString("nome"));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        btnSalvar.setEnabled(false);
        btnAtualizar.setEnabled(true);
    }//GEN-LAST:event_tabelaProdutoMouseClicked

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        String nome = txtNome.getText();
        String quantidade = txtQuantidade.getText();
        String preco = txtPreco.getText();
        String descricao = txtDescricao.getText();
        String categoria = (String) comboBoxCategoria.getSelectedItem();
        String categoriaId[] = categoria.split("-", 0);
        if (validarCampos("edit")) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios");
        } else {
            try (Connection connection = ProvedorConexao.connect()) {
                if (!quantidade.equals("")) {
                    quantidadeTotal = quantidadeTotal + Integer.parseInt(quantidade);
                };
                String query = ("UPDATE produto SET nome=?, quantidade=?, preco=?, descricao=?, categoria_fk=? WHERE produto_pk=?");
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, nome);
                ps.setInt(2, quantidadeTotal);
                ps.setString(3, preco);
                ps.setString(4, descricao);
                ps.setString(5, categoriaId[0]);
                ps.setInt(6, produtoPk);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
                setVisible(false);
                new GerenciarProduto().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (produtoPk == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum produto selecionado para exclusão.");
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir o usuário?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection connection = ProvedorConexao.connect()) {
                    String query = "DELETE FROM produto WHERE produto_pk=?";
                    PreparedStatement ps = connection.prepareStatement(query);
                    ps.setInt(1, produtoPk);
                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso.");
                        DefaultTableModel model = (DefaultTableModel) tabelaProduto.getModel();
                        int selectedRow = tabelaProduto.getSelectedRow();
                        model.removeRow(selectedRow);  // Remove a linha da tabela
                        limparCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir o usuário.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
