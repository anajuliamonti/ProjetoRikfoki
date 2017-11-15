package controller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VerificacaoDeCampos {
	
	public static boolean verificaVazio(JTextField jf) {
		//verificando se esta vazio
		if (jf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campo noo pode estar vazio!!!");
			return false;
		}
		return true;
	}
	
	//CPF e CNPJ devem ser inseridos sem formatacao
	public static boolean verificaCPF_CNPJ(JTextField jf) {
		if (jf.getText().length() != 11 && jf.getText().length() != 14 ) {
			JOptionPane.showMessageDialog(null, "CPF ou CNPJ invalido!");
			return false;
		}
		return true;
	}
	
	//Verifica @ no email
	public static boolean verificaEmail(JTextField jf) {
		if (jf.getText().contains("@") == false) {
			JOptionPane.showMessageDialog(null, "E-mail invalido!");
			return false;
		}
		return true;
	}
	
}
