package db;

import java.sql.*;
import javax.swing.*;

public class tables {

    public static void main(String[] args) {
        Statement st = null;
        try (Connection connection = ProvedorConexao.connect()) {
            st = connection.createStatement();
            //st.executeUpdate("create table appusuario (appusuario_pk int AUTO_INCREMENT primary key, cargo varchar(50), nome varchar(200), numeroTelefone varchar(50), email varchar(200), senha varchar(50), endereco varchar(200), status varchar(50))");
            //st.executeUpdate("insert into appusuario (cargo, nome, numeroTelefone, email, senha, endereco, status) values('SuperAdmin', 'Super Admin', '12345', 'superadmin@testemail.com', 'admin', 'Brasil', 'Ativo')");
            //st.executeUpdate("create table categoria (categoria_pk INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(200))");
            //st.executeUpdate("create table produto (produto_pk INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(200), quantidade int, preco int, descricao VARCHAR(200), categoria_fk int)");
            //st.executeUpdate("create table cliente (cliente_pk INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(200), telefone VARCHAR(200), email VARCHAR(200))");
            st.executeUpdate("create table detalhePedido (pedido_pk INTEGER PRIMARY KEY AUTOINCREMENT, idPedido VARCHAR(200), cliente_fk INTEGER, dataPedido VARCHAR(200), totalPago INTEGER)");
            JOptionPane.showMessageDialog(null, "Tabela criada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
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
