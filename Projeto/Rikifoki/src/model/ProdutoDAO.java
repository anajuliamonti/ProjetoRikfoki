package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.BancoDeDados;

public class ProdutoDAO {

	private static BancoDeDados bd = new BancoDeDados();
	private static PreparedStatement ps = null;

	public static void create (Produto produto) throws SQLException {

		bd.conectar("db_rikifoki");

		String sql;
		sql = "INSERT INTO produto (Referencia,QuantidadeProd,CustoUnit,CustoLote,PrecoVendaUnit,DescricaoProduto) VALUES (?,?,?,?,?,?)";

		try {
			ps = BancoDeDados.connection.prepareStatement(sql);
			ps.setInt(1, produto.getReferencia());
			ps.setInt(2, produto.getQuantidade());
			ps.setDouble(3, produto.getCustoUnit());
			ps.setDouble(4, produto.getCustoLote());
			ps.setDouble(5,produto.getPrecoVenda());
			ps.setString(6, produto.getDescricao());

			ps.executeUpdate();

			ps = BancoDeDados.connection.prepareStatement(sql);
			ps.executeUpdate();


		} catch (Exception e) {
			System.out.println("Erro cadastro = " + e);
		}

		ps.close();
		bd.FecharBanco();

	}

	public static void edit (Produto produto) throws SQLException{

		bd.conectar("db_rikifoki");

		String sql;
		sql = "UPDATE produto SET QuantidadeProd = ?, CustoUnit = ?, CustoLote = ?, PrecoVendaUnit = ?,  DescricaoProduto = ? WHERE Referencia = ?";

		ps = BancoDeDados.connection.prepareStatement(sql);

		ps.setInt(1, produto.getQuantidade());
		ps.setDouble(2, produto.getCustoUnit());
		ps.setDouble(3, produto.getCustoLote());
		ps.setDouble(4,produto.getPrecoVenda());
		ps.setString(5, produto.getDescricao());
		ps.setInt(6, produto.getReferencia());

		ps.executeUpdate();

		ps.close();
		bd.FecharBanco();

	}

	public static void delete(int produto_buscado) throws SQLException{

		bd.conectar("db_rikifoki");

		String sql;
		sql = "DELETE FROM produto WHERE Referencia = ?";

		ps = BancoDeDados.connection.prepareStatement(sql);
		ps.setInt(1, produto_buscado);

		ps.executeUpdate();

		ps.close();
		bd.FecharBanco();
	}

	public static ArrayList<Produto> read (String tabela) throws SQLException {

		bd.conectar("db_rikifoki");

		String sql;
		sql = "select * from " + tabela;
		ps = BancoDeDados.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Produto> listaDeProdutos = new ArrayList<>();

		while (rs.next()) {
			Produto produto = new Produto();
			produto.setReferencia(rs.getInt("Referencia"));
			produto.setQuantidade(rs.getInt("QuantidadeProd"));
			produto.setCustoUnit(rs.getDouble("CustoUnit"));
			produto.setCustoLote(rs.getDouble("CustoLote"));
			produto.setPrecoVenda(rs.getDouble("PrecoVendaUnit"));
			produto.setDescricao(rs.getString("DescricaoProduto"));

			listaDeProdutos.add(produto);
		}

		rs.close();
		ps.close();
		bd.FecharBanco();

		return listaDeProdutos;

	}

	public Produto search (String tabela, int referencia_desejada) throws SQLException {

		Produto produto_encontrado = new Produto();
		ArrayList<Produto> listaDeProdutos = new ArrayList<>();
		listaDeProdutos = read("produto");

		for(int i = 0; i <listaDeProdutos.size(); i++) {

			produto_encontrado = listaDeProdutos.get(i);
			if(produto_encontrado.getReferencia() == referencia_desejada) {
				return produto_encontrado;
			}

		}
		return null;
	}

}
