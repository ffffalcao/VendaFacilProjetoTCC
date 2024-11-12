package db;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.*;

public class tables {

    public static void main(String[] args) {
        Connection connection = null;
        Statement st = null;
        try {
            connection = ProvedorConexao.connect();
            st = connection.createStatement();
            //st.executeUpdate("create table appusuario (appusuario_pk int AUTO_INCREMENT primary key, cargo varchar(50), nome varchar(200), numeroTelefone varchar(50), email varchar(200), senha varchar(50), endereco varchar(200), status varchar(50))");
            st.executeUpdate("insert into appusuario (cargo, nome, numeroTelefone, email, senha, endereco, status) values('SuperAdmin', 'Super Admin', '12345', 'superadmin@testemail.com', 'admin', 'Brasil', 'Ativo')");
            JOptionPane.showMessageDialog(null,"Tabela criada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                connection.close();
                st.close();
            } catch (Exception e) {
            }
        }
    }

}
