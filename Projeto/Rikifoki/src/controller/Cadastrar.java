package controller;

import java.sql.SQLException;

import model.Cliente;
import view.ViewCadastrar;

public class Cadastrar {
	
	public static ViewCadastrar registrationScreen = new ViewCadastrar();
	
	public static void iniciaCadastro() {
		registrationScreen.setVisible(true);
	}

	public static void fazCadastro(Cliente cliente) throws SQLException {

		BancoDeDados bd = new BancoDeDados();
				
		// connect to database
		bd.conectar("softwareeng");

		// is connected ?
		boolean x = bd.estaConectado();
		System.out.println("Esta conectado? = " + x);

		// Database functions
		bd.CadastrarCliente(cliente);
		bd.LerBanco();
		
		// close database
		bd.FecharBanco();

	}
	
	public static void editaCadastro(String cpf_cnpj_buscado, Cliente cliente) throws SQLException {

		BancoDeDados bd = new BancoDeDados();
				
		// connect to database
		bd.conectar("softwareeng");

		// is connected ?
		boolean x = bd.estaConectado();
		System.out.println("Esta conectado? = " + x);

		// Database functions
		bd.EditarCliente(cpf_cnpj_buscado, cliente);
		bd.LerBanco();
		
		// close database
		bd.FecharBanco();

	}

}
