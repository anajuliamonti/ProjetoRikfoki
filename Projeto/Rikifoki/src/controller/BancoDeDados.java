package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;
import model.Pedido;
import model.Produto;

public class BancoDeDados {

    public static Connection connection = null;

    public void conectar(String database) throws SQLException{
        String servidor = "jdbc:mysql://localhost:3306/" + database;
        String usuario = "root";
        String senha = "root";
        try {
        
            //Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(servidor,usuario,senha);
            //System.out.println("Conectado? "+ estaConectado());
          
        }

        catch (Exception e) {
            System.out.println("Erro conectar = "+e);
        }
    }

    public boolean estaConectado() {
        if (connection != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void FecharBanco() throws SQLException
    {
        connection.close();
    }
}
