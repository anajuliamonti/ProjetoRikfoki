package controller;

import java.util.Arrays;

import javax.swing.JOptionPane;

import model.Login;
import view.ViewInicial;

public class VerificaLogin {
	
	static char[] correctPassword = {'1','2','3','4','5','6'};
	
	public static void fazVerificacao() {
		
		Login login = new Login();
		ViewInicial firstscreen = new ViewInicial();
		
		//System.out.println(Inicial.loginscreen.getTextField().getText());
		//System.out.println(Inicial.loginscreen.getPasswordField().getPassword());
		
		login.setNome(Inicial.loginscreen.getTextField().getText());
		login.setSenha(Inicial.loginscreen.getPasswordField().getPassword());
		
		System.out.println(login.getNome());
		System.out.println(login.getSenha());
		
		if(login.getNome().equals("rafael") && Arrays.equals(login.getSenha(), correctPassword)){
			firstscreen.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Login Invalido");
		}
	}
}
