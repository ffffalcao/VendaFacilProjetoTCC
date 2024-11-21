
import bancoDeDados.ProvedorConexao;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.table.TableModel;

public class GerenciarUsuario extends javax.swing.JFrame {

    private int appusuarioPk = 0;

    public GerenciarUsuario() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private boolean validarCampos(String formType) {
        if (formType.equals("edit") && !txtNome.getText().equals("") && !txtTelefone.getText().equals("") && !txtEmail.getText().equals("") && !txtEndereco.getText().equals("")) {
            return false;
        } else if (formType.equals("new") && !txtNome.getText().equals("") && !txtTelefone.getText().equals("") && !txtEmail.getText().equals("") && !txtEndereco.getText().equals("") && !txtSenha.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
        txtSenha.setText("");
        comboBoxStatus.setSelectedIndex(0);
        appusuarioPk = 0;
        btnExcluir.setEnabled(false);
        btnSalvar.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboBoxStatus = new javax.swing.JComboBox<>();
        txtSenha = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();

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
        jLabel1.setText("Gerenciar Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 340, -1));

        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "Email", "Endereço", "Status"
            }
        ));
        tabelaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaUsuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 430, 450));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 60, -1));

        txtNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 100, 350, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Telefone");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 80, -1));

        txtTelefone.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 160, 350, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 200, 60, -1));

        txtEmail.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 220, 350, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Endereço");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 80, -1));

        txtEndereco.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 270, 350, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Senha");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 60, -1));

        comboBoxStatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));
        getContentPane().add(comboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 350, -1));

        txtSenha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 330, 350, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Status");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 60, -1));

        btnSalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 80, 21));

        btnExcluir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 430, 80, 21));

        btnReiniciar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, 80, 21));

        btnFechar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, 80, 21));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnAtualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 80, 21));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        DefaultTableModel model = (DefaultTableModel) tabelaUsuario.getModel();
        try (Connection connection = ProvedorConexao.connect()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from appusuario where cargo='Admin'");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("appusuario_pk"), rs.getString("nome"), rs.getString("numeroTelefone"), rs.getString("email"), rs.getString("endereco"), rs.getString("status")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        btnExcluir.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText();
        String numeroTelefone = txtTelefone.getText();
        String email = txtEmail.getText();
        String senha = txtSenha.getText();
        String endereco = txtEndereco.getText();
        String status = (String) comboBoxStatus.getSelectedItem();

        if (validarCampos("new")) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios");
        } else {
            try (Connection connection = ProvedorConexao.connect()) {
                String query = ("insert into appusuario (cargo, nome, numeroTelefone, email, senha, endereco, status) values (?,?,?,?,?,?,?)");
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, "Admin");
                ps.setString(2, nome);
                ps.setString(3, numeroTelefone);
                ps.setString(4, email);
                ps.setString(5, senha);
                ps.setString(6, endereco);
                ps.setString(7, status);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso");
                setVisible(false);
                new GerenciarUsuario().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (appusuarioPk == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum usuário selecionado para exclusão.");
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir o usuário?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection connection = ProvedorConexao.connect()) {
                    String query = "DELETE FROM appusuario WHERE appusuario_pk=?";
                    PreparedStatement ps = connection.prepareStatement(query);
                    ps.setInt(1, appusuarioPk);
                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso.");
                        DefaultTableModel model = (DefaultTableModel) tabelaUsuario.getModel();
                        int selectedRow = tabelaUsuario.getSelectedRow();
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

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        setVisible(false);
        new GerenciarUsuario().setVisible(true);
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void tabelaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUsuarioMouseClicked
        int index = tabelaUsuario.getSelectedRow();
        TableModel model = tabelaUsuario.getModel();

        String id = model.getValueAt(index, 0).toString();
        appusuarioPk = Integer.parseInt(id);

        String nome = model.getValueAt(index, 1).toString();
        txtNome.setText(nome);

        String numeroTelefone = model.getValueAt(index, 2).toString();
        txtTelefone.setText(numeroTelefone);

        String email = model.getValueAt(index, 3).toString();
        txtEmail.setText(email);

        String endereco = model.getValueAt(index, 4).toString();
        txtEndereco.setText(endereco);

        String status = model.getValueAt(index, 5).toString();
        comboBoxStatus.removeAllItems();
        if (status.equals("Ativo")) {
            comboBoxStatus.addItem("Ativo");
            comboBoxStatus.addItem("Inativo");
        } else {
            comboBoxStatus.addItem("Inativo");
            comboBoxStatus.addItem("Ativo");
        }

        txtSenha.setEditable(false);
        txtSenha.setBackground(Color.DARK_GRAY);

        btnSalvar.setEnabled(false);
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_tabelaUsuarioMouseClicked

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        String nome = txtNome.getText();
        String numeroTelefone = txtTelefone.getText();
        String email = txtEmail.getText();
        String endereco = txtEndereco.getText();
        String status = (String) comboBoxStatus.getSelectedItem();

        if (validarCampos("edit")) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios");
        } else {
            try (Connection connection = ProvedorConexao.connect()) {
                String query = ("update appusuario set nome=?, numeroTelefone=?, email=?, endereco=?, status=? where appusuario_pk=?");
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, nome);
                ps.setString(2, numeroTelefone);
                ps.setString(3, email);
                ps.setString(4, endereco);
                ps.setString(5, status);
                ps.setInt(6, appusuarioPk);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuario Atualizado com Sucesso");
                setVisible(false);
                new GerenciarUsuario().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaUsuario;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
