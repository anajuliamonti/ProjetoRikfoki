package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.BancoDeDados;

public class PedidoDAO {

	private static PreparedStatement ps = null;
	private static BancoDeDados bd = new BancoDeDados();

	public static void create(Pedido pedido) throws SQLException {

		bd.conectar("db_rikifoki");

		String sql;
		sql = "INSERT INTO pedido (ReferenciaPed,DataVencimento,Pedidoscol,QuantProd,Cliente_CPF_CNPJ) VALUES (?,?,?,?,?)";

		try {
			ps = BancoDeDados.connection.prepareStatement(sql);
			ps.setString(1, pedido.getReferenciaPed());
			ps.setString(2, pedido.getDataVencimento());
			ps.setString(3, pedido.getPedidoscol());
			ps.setInt(4, pedido.getQuantProd());
			ps.setString(5, pedido.getCpf_cliente());

			ps.executeUpdate();

			ps = BancoDeDados.connection.prepareStatement(sql);
			ps.executeUpdate();


		} catch (Exception e) {
			System.out.println("Erro cadastro = "+e);
		}

		bd.FecharBanco();

	}	

	public static void edit (Pedido pedido) throws SQLException{

		bd.conectar("db_rikifoki");

		String sql;
		sql = "UPDATE pedido SET DataVencimento = ?, Pedidoscol = ?, QuantProd = ?, Cliente_CPF_CNPJ = ? WHERE ReferenciaPed = ?";

		ps = BancoDeDados.connection.prepareStatement(sql);
		
		ps.setString(1, pedido.getDataVencimento());
		ps.setString(2, pedido.getPedidoscol());
		ps.setInt(3, pedido.getQuantProd());
		ps.setString(4, pedido.getCpf_cliente());
		ps.setString(5, pedido.getReferenciaPed());

		ps.executeUpdate();

		ps.close();
		bd.FecharBanco();

	}

	public static void delete(String ref) throws SQLException{

		bd.conectar("db_rikifoki");

		String sql;
		sql = "DELETE FROM pedido WHERE ReferenciaPed = ?";

		ps = BancoDeDados.connection.prepareStatement(sql);
		ps.setString(1, ref);

		ps.executeUpdate();

		ps.close();
		bd.FecharBanco();
	}

	public static ArrayList<Pedido> read (String tabela) throws SQLException {

		bd.conectar("db_rikifoki");

		String sql;
		sql = "select * from " + tabela;
		ps = BancoDeDados.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Pedido> listaDePedidos = new ArrayList<>();

		while (rs.next()) {
			Pedido pedido = new Pedido();
			pedido.setReferenciaPed(rs.getString("ReferenciaPed"));
			pedido.setDataVencimento(rs.getString("DataVencimento"));
			pedido.setPedidoscol(rs.getString("Pedidoscol"));
			pedido.setQuantProd(rs.getInt("QuantProd"));
			pedido.setCpf_cliente(rs.getString("Cliente_CPF_CNPJ"));

			listaDePedidos.add(pedido);
		}

		rs.close();
		ps.close();
		bd.FecharBanco();

		return listaDePedidos;

	}

	public static ArrayList<Pedido> search (String tabela, String cpf_desejado) throws SQLException {

		Pedido pedido_encontrado = new Pedido();
		ArrayList<Pedido> listaDePedidos = new ArrayList<>();
		ArrayList<Pedido> listaDePedidosEncontrados = new ArrayList<>();
		listaDePedidos = read("pedido");

		for(int i = 0; i <listaDePedidos.size(); i++) {

			pedido_encontrado = listaDePedidos.get(i);
			if(pedido_encontrado.getCpf_cliente().equalsIgnoreCase(cpf_desejado)) {
				listaDePedidosEncontrados.add(pedido_encontrado);
			}

		}
		return listaDePedidosEncontrados;
	}
	
	public static Pedido searchOne (String tabela, String ref) throws SQLException {

		Pedido pedido_encontrado = new Pedido();
		ArrayList<Pedido> listaDePedidos = new ArrayList<>();
		listaDePedidos = read("pedido");

		for(int i = 0; i <listaDePedidos.size(); i++) {

			pedido_encontrado = listaDePedidos.get(i);
			if(pedido_encontrado.getReferenciaPed().equalsIgnoreCase(ref)) {
				return pedido_encontrado;
			}

		}
		return null;
	}
}
