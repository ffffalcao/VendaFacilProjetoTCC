//Classe responsável por criar tabelas no banco de dados SQLite.

package bancoDeDados;

import java.sql.*;
import javax.swing.*;

public class tables {
//Método principal que cria as tabelas necessárias para a aplicação.

    public static void main(String[] args) {
        Statement st = null;
        try (Connection connection = ProvedorConexao.connect()) {
            st = connection.createStatement();
// Criação da tabela de usuários do aplicativo (desativada por enquanto)
            //st.executeUpdate("create table appusuario (appusuario_pk int AUTO_INCREMENT primary key, cargo varchar(50), nome varchar(200), numeroTelefone varchar(50), email varchar(200), senha varchar(50), endereco varchar(200), status varchar(50))");

// Inserção de exemplo para o usuário SuperAdmin (desativada por enquanto)
            //st.executeUpdate("insert into appusuario (cargo, nome, numeroTelefone, email, senha, endereco, status) values('SuperAdmin', 'Super Admin', '12345', 'superadmin@testemail.com', 'admin', 'Brasil', 'Ativo')");
// Criação da tabela de categorias de produtos
            //st.executeUpdate("create table categoria (categoria_pk INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(200))");
// Criação da tabela de produtos
            //st.executeUpdate("create table produto (produto_pk INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, quantidade INTEGER, preco REAL, descricao TEXT, categoria_fk INTEGER)");
// Criação da tabela de clientes            
            //st.executeUpdate("create table cliente (cliente_pk INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(200), telefone VARCHAR(200), email VARCHAR(200))");
// Criação da tabela de detalhes do pedido
            st.executeUpdate("create table detalhePedido (pedido_pk INTEGER PRIMARY KEY AUTOINCREMENT, idPedido VARCHAR(200), cliente_fk INTEGER, dataPedido VARCHAR(200), totalPago INTEGER)");

            JOptionPane.showMessageDialog(null, "Tabela criada com sucesso");
        } catch (Exception e) {
// Tratamento de exceção caso ocorra algum erro ao criar as tabelas
            JOptionPane.showMessageDialog(null, e);
        } finally {
// Garantia de fechamento do statement
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar statment: " + e);
                }
            }
        }
    }

}
