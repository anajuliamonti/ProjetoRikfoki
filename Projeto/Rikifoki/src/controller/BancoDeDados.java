package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;

public class BancoDeDados {

    private Connection connection = null;
    private PreparedStatement ps = null;

    public void conectar(String database) throws SQLException{
        String servidor = "jdbc:mysql://localhost:3306/" + database;
        String usuario = "root";
        String senha = "root";
        try {
        
           // Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(servidor,usuario,senha);
            System.out.println("Conectado? "+estaConectado());
          
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

    public void CadastrarCliente(Cliente cliente) throws SQLException {
        String sql;
        sql = "INSERT INTO cliente (CPF_CNPJ,Nome,Endereco,Contato,Email) VALUES (?,?,?,?,?)";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getCpf_cnpj());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getContato());
            ps.setString(5, cliente.getEmail());
            ps.executeUpdate();
           
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println("Erro cadastro = "+e);
        }

    }
    
    public void FecharBanco() throws SQLException
    {
        connection.close();
    }

    public void EditarCliente(String cpf_cnpj_buscado, Cliente cliente) throws SQLException
    {
        String sql;
        sql = "UPDATE cliente SET Nome = ?, Endereco = ?, Contato = ?, Email = ? WHERE CPF_CNPJ = ?";
        
        ps = connection.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getEndereco());
        ps.setString(3, cliente.getContato());
        ps.setString(4, cliente.getEmail());
        ps.setString(5, cpf_cnpj_buscado);
        
        ps.executeUpdate();
        
    }
    
    public void LerBanco() throws SQLException
    {
        String sql;
        sql = "select * from cliente order by 1";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next())
        {
            System.out.println("CPF/CNPJ = " + rs.getString("CPF_CNPJ"));
            System.out.println("Nome = " + rs.getString("Nome"));
            System.out.println("Endereco = " + rs.getString("Endereco"));
            System.out.println("Contato = " + rs.getString("Contato"));
            System.out.println("Email = " + rs.getString("Email"));
        }
        
        rs.close();
        ps.close();
        
    }
    
}
