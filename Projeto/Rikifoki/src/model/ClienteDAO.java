package model;

import java.nio.channels.ClosedByInterruptException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.BancoDeDados;

public class ClienteDAO {

	private static BancoDeDados bd = new BancoDeDados();
	private PreparedStatement ps = null;
	
	public void create(Cliente cliente) throws SQLException {
		
		bd.conectar("db_rikifoki");
		
        String sql;
        sql = "INSERT INTO cliente (Nome,Endereco,Contato,Email,CPF_CNPJ) VALUES (?,?,?,?,?)";
        
        try {
            ps = BancoDeDados.connection.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getContato());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getCpf_cnpj());
            ps.executeUpdate();
           
            ps = BancoDeDados.connection.prepareStatement(sql);
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println("Erro cadastro = "+e);
        }
        
        ps.close();
        bd.FecharBanco();

    }
	
	public void edit(String cpf_cnpj_buscado, Cliente cliente) throws SQLException{
    	
		bd.conectar("db_rikifoki");
		
      String sql;
      sql = "UPDATE cliente SET Nome = ?, Endereco = ?, Contato = ?, Email = ? WHERE CPF_CNPJ = ?";
      
      ps = BancoDeDados.connection.prepareStatement(sql);
      ps.setString(1, cliente.getNome());
      ps.setString(2, cliente.getEndereco());
      ps.setString(3, cliente.getContato());
      ps.setString(4, cliente.getEmail());
      ps.setString(5, cpf_cnpj_buscado);
      
      ps.executeUpdate();
      
      ps.close();
      bd.FecharBanco();
      
  }
	
	public void delete(String cpf_cnpj_buscado) throws SQLException{
		
		bd.conectar("db_rikifoki");
		
		String sql;
	    sql = "DELETE FROM cliente WHERE CPF_CNPJ = ?";
	    
	    ps = BancoDeDados.connection.prepareStatement(sql);
	    ps.setString(1, cpf_cnpj_buscado);
      
	    ps.executeUpdate();
	    
	    ps.close();
	      bd.FecharBanco();
	}
	
	public ArrayList<Cliente> lerTabelaCliente (String tabela) throws SQLException {
		
		bd.conectar("db_rikifoki");
		
		String sql;
		sql = "select * from " + tabela;
		ps = BancoDeDados.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Cliente> listaDeClientes = new ArrayList<>();
		
		while (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setNome(rs.getString("Nome"));
			cliente.setEndereco(rs.getString("Endereco"));
			cliente.setContato(rs.getString("Contato"));
			cliente.setEmail(rs.getString("Email"));
			cliente.setCpf_cnpj(rs.getString("CPF_CNPJ"));
			
			listaDeClientes.add(cliente);
		}
		
		rs.close();
		ps.close();
		bd.FecharBanco();
		
		return listaDeClientes;
		
	}
	
	public Cliente search (String tabela, String cpf_cnpj_buscado) throws SQLException {
		
		Cliente cliente_encontrado = new Cliente();
		ArrayList<Cliente> listaDeClientes = new ArrayList<>();
		listaDeClientes = lerTabelaCliente("cliente");
		
		for(int i = 0; i <listaDeClientes.size(); i++) {
		
			cliente_encontrado = listaDeClientes.get(i);
			if(cliente_encontrado.getCpf_cnpj().equalsIgnoreCase(cpf_cnpj_buscado)) {
				return cliente_encontrado;
			}
		
		}
		return null;
	}
	
}
