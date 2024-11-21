// Classe para gerenciamento de pedidos, incluindo criação, edição e salvamento.

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.abrirPDF;
import bancoDeDados.ProvedorConexao;
import bancoDeDados.UtilidadeInventario;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GerenciarPedido extends javax.swing.JFrame {

    private int clientePk = 0;
    private int produtoPk = 0;
    private int precoFinalTotal = 0;
    private String idPedido = "";

// Construtor da classe, inicializa os componentes e define a posição da janela.
    public GerenciarPedido() {
        initComponents();
        setLocationRelativeTo(null);
    }

// Método para limpar os campos do formulário relacionados ao produto
    private void limparCamposProduto() {
        produtoPk = 0;
        txtNomeProduto.setText("");
        txtPrecoProduto.setText("");
        txtQuantidadeProduto.setText("");
        txtDescricaoProduto.setText("");
    }

// Método para gerar um ID único com base em um prefixo e o tempo atual
    public String getUniqueId(String prefix) {
        return prefix + System.nanoTime();
    }

// Método gerado automaticamente pela IDE, responsável pela inicialização dos componentes da interface gráfica.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        lblListaClientes = new javax.swing.JLabel();
        lblListaProdutos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        lblCarrinho = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaCarrinho = new javax.swing.JTable();
        lblClienteSelecionado = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefoneCliente = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmailCliente = new javax.swing.JTextField();
        lblProdutoSelecionado = new javax.swing.JLabel();
        lblNomeProduto = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        lblPrecoProduto = new javax.swing.JLabel();
        txtPrecoProduto = new javax.swing.JTextField();
        lblDescricaoProduto = new javax.swing.JLabel();
        txtDescricaoProduto = new javax.swing.JTextField();
        lblQuantidadeProduto = new javax.swing.JLabel();
        txtQuantidadeProduto = new javax.swing.JTextField();
        btnAdicionarAoCarrinho = new javax.swing.JButton();
        lblValorTotal = new javax.swing.JLabel();
        lblPrecoFinalTotal = new javax.swing.JLabel();
        btnSalvarDetalhesPedido = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitulo.setText("Gerenciar Pedido");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 16, -1, -1));

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "Email"
            }
        ));
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 375, 295));

        lblListaClientes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblListaClientes.setText("Lista de Clientes");
        getContentPane().add(lblListaClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 76, -1, -1));

        lblListaProdutos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblListaProdutos.setText("Lista de Produtos");
        getContentPane().add(lblListaProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 76, -1, -1));

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Preço", "Quantidade", "Descrição", "ID da categoria", "Categoria"
            }
        ));
        tabelaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaProduto);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 102, 560, 295));

        lblCarrinho.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCarrinho.setText("Carrinho");
        getContentPane().add(lblCarrinho, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 80, -1, -1));

        tabelaCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID do Produto", "Nome", "Quantidade", "Preço", "Descrição", "Sub Total"
            }
        ));
        tabelaCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCarrinhoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaCarrinho);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 100, 375, 295));

        lblClienteSelecionado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblClienteSelecionado.setText("Cliente Selecionado:");
        getContentPane().add(lblClienteSelecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        lblNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNome.setText("Nome");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        txtNomeCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtNomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 375, -1));

        lblTelefone.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTelefone.setText("Telefone");
        getContentPane().add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        txtTelefoneCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtTelefoneCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 375, -1));

        lblEmail.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblEmail.setText("Email");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, -1, -1));

        txtEmailCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtEmailCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 375, -1));

        lblProdutoSelecionado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblProdutoSelecionado.setText("Produto Selecionado:");
        getContentPane().add(lblProdutoSelecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, -1, -1));

        lblNomeProduto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNomeProduto.setText("Nome do produto");
        getContentPane().add(lblNomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, -1, -1));

        txtNomeProduto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtNomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 560, -1));

        lblPrecoProduto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblPrecoProduto.setText("Preço do produto");
        getContentPane().add(lblPrecoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, -1, -1));

        txtPrecoProduto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtPrecoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 530, 560, -1));

        lblDescricaoProduto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDescricaoProduto.setText("Descrição do produto");
        getContentPane().add(lblDescricaoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 570, -1, -1));

        txtDescricaoProduto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtDescricaoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 590, 560, -1));

        lblQuantidadeProduto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblQuantidadeProduto.setText("Quantidade");
        getContentPane().add(lblQuantidadeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 620, -1, -1));

        txtQuantidadeProduto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(txtQuantidadeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 640, 560, -1));

        btnAdicionarAoCarrinho.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAdicionarAoCarrinho.setText("Adicionar ao carrinho");
        btnAdicionarAoCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAoCarrinhoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarAoCarrinho, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 680, 560, -1));

        lblValorTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblValorTotal.setText("Valor total R$:");
        getContentPane().add(lblValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 410, -1, -1));

        lblPrecoFinalTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblPrecoFinalTotal.setText("00000");
        getContentPane().add(lblPrecoFinalTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 410, 190, -1));

        btnSalvarDetalhesPedido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalvarDetalhesPedido.setText("Salvar detalhes do Pedido");
        btnSalvarDetalhesPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDetalhesPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvarDetalhesPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 470, 380, -1));

        btnReiniciar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 530, 380, -1));

        btnFechar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 591, 380, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

// Método executado quando o formulário é exibido, inicializando os dados nas tabelas de clientes e produtos
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        txtNomeCliente.setEditable(false);
        txtTelefoneCliente.setEditable(false);
        txtEmailCliente.setEditable(false);

        txtNomeProduto.setEditable(false);
        txtPrecoProduto.setEditable(false);
        txtDescricaoProduto.setEditable(false);

        DefaultTableModel model = (DefaultTableModel) tabelaCliente.getModel();
        DefaultTableModel produtomodel = (DefaultTableModel) tabelaProduto.getModel();

        try (Connection connection = ProvedorConexao.connect()) {
            Statement st = connection.createStatement();
            String query = ("SELECT * FROM cliente");
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("cliente_pk"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email")});
            }
            String query2 = ("SELECT * FROM produto INNER JOIN categoria ON produto.categoria_fk = categoria.categoria_pk");
            rs = st.executeQuery(query2);
            while (rs.next()) {
                produtomodel.addRow(new Object[]{rs.getString("produto_pk"), rs.getString("nome"), rs.getString("preco"), rs.getString("quantidade"), rs.getString("descricao"), rs.getString("categoria_fk"), rs.getString(8)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_formComponentShown

//Método acionado quando o botão "Fechar" é clicado. Fecha a tela de gerenciamento de produto.
    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

// Evento de clique do botão "Reiniciar". Reinicializa a tela para seu estado inicial.
    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        setVisible(false);
        new GerenciarPedido().setVisible(true);
    }//GEN-LAST:event_btnReiniciarActionPerformed

// Método acionado quando um cliente é clicado na tabela. Preenche os campos com os dados do cliente selecionado.
    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked
        int index = tabelaCliente.getSelectedRow();
        TableModel model = tabelaCliente.getModel();
        String id = model.getValueAt(index, 0).toString();
        clientePk = Integer.parseInt(id);

        String nome = model.getValueAt(index, 1).toString();
        txtNomeCliente.setText(nome);

        String telefone = model.getValueAt(index, 2).toString();
        txtTelefoneCliente.setText(telefone);

        String email = model.getValueAt(index, 3).toString();
        txtEmailCliente.setText(email);
    }//GEN-LAST:event_tabelaClienteMouseClicked

// Método acionado quando um produto é clicado na tabela. Preenche os campos com os dados do produto selecionado.
    private void tabelaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutoMouseClicked
        int index = tabelaProduto.getSelectedRow();
        TableModel model = tabelaProduto.getModel();
        String id = model.getValueAt(index, 0).toString();
        produtoPk = Integer.parseInt(id);

        String nomeProduto = model.getValueAt(index, 1).toString();
        txtNomeProduto.setText(nomeProduto);

        String precoProduto = model.getValueAt(index, 2).toString();
        txtPrecoProduto.setText(precoProduto);

        String descricaoProduto = model.getValueAt(index, 4).toString();
        txtDescricaoProduto.setText(descricaoProduto);
    }//GEN-LAST:event_tabelaProdutoMouseClicked

// Evento de ação do botão "Adicionar ao Carrinho"
// Verifica a quantidade, o estoque e adiciona o produto ao carrinho se as condições forem atendidas
    private void btnAdicionarAoCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAoCarrinhoActionPerformed
        // Validação de produto selecionado e quantidade
        if (produtoPk == 0 || txtQuantidadeProduto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Número de quantidade e produtos é obrigatório");
            return;
        }

        try {
            // Obtém a quantidade e verifica se é um número válido
            int quantidade = Integer.parseInt(txtQuantidadeProduto.getText());
            double precoProduto = Double.parseDouble(txtPrecoProduto.getText().replace(",", "."));

            // Calcula o subtotal
            double subtotal = quantidade * precoProduto;

            // Atualiza a tabela do carrinho com o produto selecionado
            DefaultTableModel model = (DefaultTableModel) tabelaCarrinho.getModel();
            model.addRow(new Object[]{
                produtoPk,
                txtNomeProduto.getText(),
                quantidade,
                precoProduto,
                txtDescricaoProduto.getText(),
                subtotal
            });

            // Atualiza o valor total
            precoFinalTotal += subtotal;
            lblPrecoFinalTotal.setText(String.valueOf(precoFinalTotal));

            // Limpa os campos do produto
            limparCamposProduto();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Quantidade ou preço inválidos.");
        }
    }//GEN-LAST:event_btnAdicionarAoCarrinhoActionPerformed

    private void tabelaCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCarrinhoMouseClicked
        int index = tabelaCarrinho.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Você quer remover esse produto", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = tabelaCarrinho.getModel();
            String subTotal = model.getValueAt(index, 5).toString();
            precoFinalTotal = precoFinalTotal - Integer.parseInt(subTotal);
            lblPrecoFinalTotal.setText(String.valueOf(precoFinalTotal));
            ((DefaultTableModel) tabelaCarrinho.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_tabelaCarrinhoMouseClicked

    private void btnSalvarDetalhesPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDetalhesPedidoActionPerformed
        if (precoFinalTotal != 0 && !txtNomeCliente.getText().equals("")) {
            idPedido = getUniqueId("Nota-");

            DefaultTableModel dtm = (DefaultTableModel) tabelaCarrinho.getModel();
            if (tabelaCarrinho.getRowCount() != 0) {
                for (int i = 0; i < tabelaCarrinho.getRowCount(); i++) {
                    try (Connection connection = ProvedorConexao.connect()) {
                        Statement st = connection.createStatement();
                        String query = ("UPDATE produto SET quantidade=quantidade-" + Integer.parseInt(dtm.getValueAt(i, 2).toString()) + " WHERE produto_pk=" + Integer.parseInt(dtm.getValueAt(i, 0).toString()));
                        st.executeUpdate(query);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }

            try (Connection connection = ProvedorConexao.connect()) {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                String query = ("INSERT INTO detalhePedido(idPedido,cliente_fk,dataPedido,totalPago) VALUES(?,?,?,?)");
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, idPedido);
                ps.setInt(2, clientePk);
                ps.setString(3, myFormat.format(cal.getTime()));
                ps.setInt(4, precoFinalTotal);
                ps.executeUpdate();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            //Criando documento
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                PdfWriter.getInstance(doc, new FileOutputStream(UtilidadeInventario.caminhoNota + "" + idPedido + ".pdf"));

                doc.open();
                Paragraph nomeProjeto = new Paragraph("                                                                         Venda Fácil\n");
                doc.add(nomeProjeto);
                Paragraph linhaEstrela = new Paragraph("****************************************************************************************************************");
                doc.add(linhaEstrela);
                Paragraph detalhes = new Paragraph("\tID do Pedido: " + idPedido + "\nData: " + myFormat.format(cal.getTime()) + "\nTotal Pago: " + precoFinalTotal);
                doc.add(detalhes);
                doc.add(linhaEstrela);
                PdfPTable tb1 = new PdfPTable(5);
                PdfPCell nomeCelula = new PdfPCell(new Phrase("Nome"));
                PdfPCell descricaoCelula = new PdfPCell(new Phrase("Descrição"));
                PdfPCell precoCelula = new PdfPCell(new Phrase("Preço por unidade"));
                PdfPCell quantidadeCelula = new PdfPCell(new Phrase("Quantidade"));
                PdfPCell precoSubTotalCelula = new PdfPCell(new Phrase("Valor Sub Total"));

                BaseColor backgroundColor = new BaseColor(255, 204, 51);
                nomeCelula.setBackgroundColor(backgroundColor);
                descricaoCelula.setBackgroundColor(backgroundColor);
                precoCelula.setBackgroundColor(backgroundColor);
                quantidadeCelula.setBackgroundColor(backgroundColor);
                precoSubTotalCelula.setBackgroundColor(backgroundColor);

                tb1.addCell(nomeCelula);
                tb1.addCell(descricaoCelula);
                tb1.addCell(precoCelula);
                tb1.addCell(quantidadeCelula);
                tb1.addCell(precoSubTotalCelula);

                for (int i = 0; i < tabelaCarrinho.getRowCount(); i++) {
                    tb1.addCell(tabelaCarrinho.getValueAt(i, 1).toString());
                    tb1.addCell(tabelaCarrinho.getValueAt(i, 4).toString());
                    tb1.addCell(tabelaCarrinho.getValueAt(i, 3).toString());
                    tb1.addCell(tabelaCarrinho.getValueAt(i, 2).toString());
                    tb1.addCell(tabelaCarrinho.getValueAt(i, 5).toString());
                }

                doc.add(tb1);
                doc.add(linhaEstrela);
                Paragraph mensagemObrigado = new Paragraph("                                                                         Obrigado, volte sempre!");
                doc.add(mensagemObrigado);
                abrirPDF.abrirPorId(idPedido);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            doc.close();

            setVisible(false);
            new GerenciarPedido().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor adicione um produto ou selecione um cliente");
        }

    }//GEN-LAST:event_btnSalvarDetalhesPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAoCarrinho;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSalvarDetalhesPedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCarrinho;
    private javax.swing.JLabel lblClienteSelecionado;
    private javax.swing.JLabel lblDescricaoProduto;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblListaClientes;
    private javax.swing.JLabel lblListaProdutos;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeProduto;
    private javax.swing.JLabel lblPrecoFinalTotal;
    private javax.swing.JLabel lblPrecoProduto;
    private javax.swing.JLabel lblProdutoSelecionado;
    private javax.swing.JLabel lblQuantidadeProduto;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JTable tabelaCarrinho;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTextField txtDescricaoProduto;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPrecoProduto;
    private javax.swing.JTextField txtQuantidadeProduto;
    private javax.swing.JTextField txtTelefoneCliente;
    // End of variables declaration//GEN-END:variables
}
