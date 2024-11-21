// Classe responsável pelo menu principal do sistema. Oferece as opções para gerenciar usuários, produtos, clientes, etc.

import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {

// Construtor padrão da classe Menu, inicializa os componentes da interface e define a posição da janela
    public Menu() {
        initComponents();
        setLocationRelativeTo(null);

    }

// Construtor sobrecarregado que oculta o botão de usuário se o cargo for "Admin"
    public Menu(String cargo) {
        initComponents();
        setLocationRelativeTo(null);
        if (cargo.equals("Admin")) {
            btnUsuario.setVisible(false);
        }
    }

// Método gerado automaticamente pela IDE, responsável pela inicialização dos componentes da interface gráfica.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUsuario = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnPedido = new javax.swing.JButton();
        btnVerPedidos = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/User-Multiple--Streamline-Carbon.png"))); // NOI18N
        btnUsuario.setText("Usuário");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 140, 50));

        btnCategoria.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Category--Streamline-Carbon.png"))); // NOI18N
        btnCategoria.setText("Categoria");
        btnCategoria.setMaximumSize(new java.awt.Dimension(104, 24));
        btnCategoria.setMinimumSize(new java.awt.Dimension(104, 24));
        btnCategoria.setPreferredSize(new java.awt.Dimension(104, 24));
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 140, 50));

        btnProduto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Product--Streamline-Carbon.png"))); // NOI18N
        btnProduto.setText("Produto");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btnProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 140, 50));

        btnCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Customer--Streamline-Carbon.png"))); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 140, 50));

        btnPedido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Shopping-Cart--Streamline-Carbon.png"))); // NOI18N
        btnPedido.setText("Pedido");
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 140, 50));

        btnVerPedidos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVerPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Order-Details--Streamline-Carbon.png"))); // NOI18N
        btnVerPedidos.setText("Ver Pedidos");
        btnVerPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 140, 50));

        btnLogout.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Exit--Streamline-Carbon.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, 140, 50));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/home_background.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
// Ação executada ao clicar no botão "Usuário".
// Abre a tela de gerenciamento de usuários.
    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        new GerenciarUsuario().setVisible(true);
    }//GEN-LAST:event_btnUsuarioActionPerformed

// Ação executada ao clicar no botão "Cliente".
// Abre a tela de gerenciamento de clientes.
    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        new GerenciarCliente().setVisible(true);
    }//GEN-LAST:event_btnClienteActionPerformed

// Evento de ação do botão "Logout"
// Exibe um diálogo de confirmação antes de fazer o logout e retornar à tela de login
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Você deseja fazer logout da aplicação?", "Selecione", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

// Evento de ação do botão "Categoria"
// Abre o formulário de gerenciamento de categorias
    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        new GerenciarCategoria().setVisible(true);
    }//GEN-LAST:event_btnCategoriaActionPerformed

// Ação executada ao clicar no botão "Produto".
// Abre a tela de gerenciamento de produtos.
    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        new GerenciarProduto().setVisible(true);
    }//GEN-LAST:event_btnProdutoActionPerformed

// Ação executada ao clicar no botão "Pedido".
// Abre a tela de gerenciamento de pedidos.
    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        new GerenciarPedido().setVisible(true);
    }//GEN-LAST:event_btnPedidoActionPerformed

// Ação executada ao clicar no botão "Ver Pedidos".
// Abre a tela para visualizar os pedidos feitos.
    private void btnVerPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosActionPerformed
        new verPedido().setVisible(true);
    }//GEN-LAST:event_btnVerPedidosActionPerformed

// Método principal que cria e exibe a janela do Menu.
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPedido;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVerPedidos;
    private javax.swing.JLabel lblFundo;
    // End of variables declaration//GEN-END:variables
}
