// Classe que fornece a conexão com o banco de dados SQLite, facilitando o acesso ao banco para outras classes.

package bancoDeDados;

import javax.swing.*;
import java.sql.*;

public class ProvedorConexao {

// Método para estabelecer a conexão com o banco de dados SQLite.
    public static Connection connect() {
        Connection connection = null;
        try {
// Constrói a URL do banco de dados utilizando o diretório do usuário e estabelece a conexão.
            String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\inventario.db";
            System.out.println(url);
            connection = DriverManager.getConnection(url);
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        System.out.println(connection);
        return connection;
    }
}
