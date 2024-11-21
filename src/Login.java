
import bancoDeDados.ProvedorConexao;
import javax.swing.*;
import java.sql.*;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }
    private void autenticar(){
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();
        boolean loginSucesso = false;

        try (Connection connection = ProvedorConexao.connect();){
            String sql = "SELECT * FROM appusuario WHERE nome = ? AND senha = ? AND status = 'Ativo'";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                loginSucesso = true;
                setVisible(false);
                new Menu(rs.getString("cargo")).setVisible(true);
            }

            if (!loginSucesso) {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos ou inativo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTítulo1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        botaoLogin = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        lblTítulo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTítulo1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTítulo1.setText("Venda Facil");
        getContentPane().add(lblTítulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 200, 40));

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 300, 29));

        lblSenha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSenha.setText("Senha");
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, -1, -1));

        botaoLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botaoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Port-Input--Streamline-Carbon.png"))); // NOI18N
        botaoLogin.setText("Login");
        botaoLogin.setMaximumSize(new java.awt.Dimension(97, 31));
        botaoLogin.setPreferredSize(new java.awt.Dimension(97, 31));
        botaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginActionPerformed(evt);
            }
        });
        getContentPane().add(botaoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 300, -1));

        botaoFechar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botaoFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Close-Outline--Streamline-Carbon.png"))); // NOI18N
        botaoFechar.setText("Fechar");
        botaoFechar.setMaximumSize(new java.awt.Dimension(97, 31));
        botaoFechar.setPreferredSize(new java.awt.Dimension(97, 31));
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharActionPerformed(evt);
            }
        });
        getContentPane().add(botaoFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 300, -1));

        txtSenha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 300, 29));

        lblTítulo2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTítulo2.setText("Bem vindo");
        getContentPane().add(lblTítulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 200, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Você quer fechar a aplicação?", "Selecione", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void botaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLoginActionPerformed
        autenticar();
    }//GEN-LAST:event_botaoLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton botaoLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTítulo1;
    private javax.swing.JLabel lblTítulo2;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
