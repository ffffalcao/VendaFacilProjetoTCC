package bancoDeDados;
import javax.swing.*;
import java.sql.*;

public class ProvedorConexao {
    public static Connection connect(){
       Connection connection = null;
       try{
           String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\inventario.db";
           System.out.println(url);
           connection = DriverManager.getConnection(url);
       } catch (SQLException error){
           JOptionPane.showMessageDialog(null, error.getMessage());
       }
       System.out.println(connection);
       return connection;
   }   
}