package view;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Cadastrar;
import model.Cliente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ViewCadastrar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public ViewCadastrar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 178, 80, 14);
		contentPane.add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(10, 203, 80, 14);
		contentPane.add(lblEndereco);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setBounds(10, 228, 80, 14);
		contentPane.add(lblContato);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 253, 80, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setBounds(10, 278, 80, 14);
		contentPane.add(lblCpfcnpj);
		
		textField = new JTextField();
		textField.setBounds(100, 175, 374, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 200, 374, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 225, 374, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 250, 374, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 275, 374, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnGravar = new JButton("GRAVAR");
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Cliente cliente = new Cliente();
					cliente.setCpf_cnpj(textField_4.getText());
					cliente.setNome(textField.getText());
					cliente.setEndereco(textField_1.getText());
					cliente.setContato(textField_2.getText());
					cliente.setEmail(textField_3.getText());
					Cadastrar.fazCadastro(cliente);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGravar.setBounds(10, 415, 110, 35);
		contentPane.add(btnGravar);
		
		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeClientes.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblCadastroDeClientes.setBounds(10, 70, 464, 35);
		contentPane.add(lblCadastroDeClientes);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.setBounds(364, 415, 110, 35);
		contentPane.add(btnSair);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente cliente = new Cliente();
					String cpf = textField_4.getText();
					cliente.setNome(textField.getText());
					cliente.setEndereco(textField_1.getText());
					cliente.setContato(textField_2.getText());
					cliente.setEmail(textField_3.getText());
					Cadastrar.editaCadastro(cpf, cliente);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(186, 415, 110, 35);
		contentPane.add(btnEditar);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}
	
}
