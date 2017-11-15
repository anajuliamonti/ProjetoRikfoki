package controller;

import java.util.Arrays;

import javax.swing.JOptionPane;

import model.Login;
import view.ViewCliente;
import view.ViewInicial;

public class VerificaLogin {
	
	static char[] correctPassword = {'a','d','m','i','n'};
	
	public static boolean fazVerificacao() {
		
		Login login = new Login();
		ViewInicial firstscreen = new ViewInicial();
		
		login.setNome(Inicial.loginscreen.getTextField().getText());
		login.setSenha(Inicial.loginscreen.getPasswordField().getPassword());
		
		if(login.getNome().equals("admin") && Arrays.equals(login.getSenha(), correctPassword)){
			JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
			firstscreen.setLocationRelativeTo(null);
			firstscreen.setVisible(true);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Login Invalido");
			return false;
		}
	}
}
