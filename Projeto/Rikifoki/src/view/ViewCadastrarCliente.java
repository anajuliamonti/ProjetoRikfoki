package view;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.VerificacaoDeCampos;
import model.Cliente;
import model.ClienteDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ViewCadastrarCliente extends JFrame {
	
	ClienteDAO clienteDAO = new ClienteDAO();
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public ViewCadastrarCliente() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNome.setForeground(Color.LIGHT_GRAY);
		lblNome.setBounds(10, 178, 80, 14);
		contentPane.add(lblNome);
		
		JLabel lblEndereco = new JLabel("ENDERE\u00C7O");
		lblEndereco.setForeground(Color.LIGHT_GRAY);
		lblEndereco.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblEndereco.setBounds(10, 203, 80, 14);
		contentPane.add(lblEndereco);
		
		JLabel lblContato = new JLabel("CONTATO");
		lblContato.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblContato.setForeground(Color.LIGHT_GRAY);
		lblContato.setBounds(10, 228, 80, 14);
		contentPane.add(lblContato);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblEmail.setForeground(Color.LIGHT_GRAY);
		lblEmail.setBounds(10, 253, 80, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setForeground(Color.LIGHT_GRAY);
		lblCpfcnpj.setFont(new Font("DialogInput", Font.PLAIN, 11));
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
		btnGravar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(VerificacaoDeCampos.verificaCPF_CNPJ(textField_4) && 
					VerificacaoDeCampos.verificaEmail(textField_3) &&
					VerificacaoDeCampos.verificaVazio(textField) &&
					VerificacaoDeCampos.verificaVazio(textField_1) &&
					VerificacaoDeCampos.verificaVazio(textField_2)) {
					try {
						Cliente cliente = new Cliente();
						cliente.setCpf_cnpj(textField_4.getText());
						cliente.setNome(textField.getText());
						cliente.setEndereco(textField_1.getText());
						cliente.setContato(textField_2.getText());
						cliente.setEmail(textField_3.getText());
						clienteDAO.create(cliente);
						JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
						ViewCliente clienteView = new ViewCliente();
						clienteView.setLocationRelativeTo(null);
						clienteView.setVisible(true);
						dispose();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnGravar.setBounds(272, 415, 96, 35);
		contentPane.add(btnGravar);
		
		JLabel lblCadastroDeClientes = new JLabel("CADASTRO DE CLIENTE");
		lblCadastroDeClientes.setForeground(Color.LIGHT_GRAY);
		lblCadastroDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeClientes.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblCadastroDeClientes.setBounds(0, 74, 485, 35);
		contentPane.add(lblCadastroDeClientes);
		
		JButton btnSair = new JButton("VOLTAR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewCliente clienteView = new ViewCliente();
				clienteView.setLocationRelativeTo(null);
				clienteView.setVisible(true);
				dispose();
			}
		});
		btnSair.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnSair.setBounds(378, 415, 96, 35);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\anaju\\Documents\\Inatel\\Eng. Software\\Projeto Rikifoki\\logotam3.png"));
		lblNewLabel.setBounds(10, 11, 96, 26);
		contentPane.add(lblNewLabel);
		
		JButton AddProdutoButton = new JButton("ADICIONAR PEDIDO");
		AddProdutoButton.setVisible(false);
		AddProdutoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastrarPedido cadastrarpedidoview = new ViewCadastrarPedido(textField_4.getText());
				cadastrarpedidoview.setLocationRelativeTo(null);
				cadastrarpedidoview.setVisible(true);
			}
		});
		AddProdutoButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		AddProdutoButton.setBounds(101, 318, 170, 35);
		contentPane.add(AddProdutoButton);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente cliente = new Cliente();
					cliente.setCpf_cnpj(textField_4.getText());
					cliente.setNome(textField.getText());
					cliente.setEndereco(textField_1.getText());
					cliente.setContato(textField_2.getText());
					cliente.setEmail(textField_3.getText());
					clienteDAO.edit(textField_4.getText(), cliente);
					JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");
					ViewCliente clienteView = new ViewCliente();
					clienteView.setLocationRelativeTo(null);
					clienteView.setVisible(true);
					dispose();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnEditar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnEditar.setBounds(173, 415, 89, 35);
		contentPane.add(btnEditar);
		btnEditar.setVisible(false);
	}
	
	public ViewCadastrarCliente(Cliente cliente) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNome.setForeground(Color.LIGHT_GRAY);
		lblNome.setBounds(10, 178, 80, 14);
		contentPane.add(lblNome);
		
		JLabel lblEndereco = new JLabel("ENDERE\u00C7O");
		lblEndereco.setForeground(Color.LIGHT_GRAY);
		lblEndereco.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblEndereco.setBounds(10, 203, 80, 14);
		contentPane.add(lblEndereco);
		
		JLabel lblContato = new JLabel("CONTATO");
		lblContato.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblContato.setForeground(Color.LIGHT_GRAY);
		lblContato.setBounds(10, 228, 80, 14);
		contentPane.add(lblContato);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblEmail.setForeground(Color.LIGHT_GRAY);
		lblEmail.setBounds(10, 253, 80, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setForeground(Color.LIGHT_GRAY);
		lblCpfcnpj.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblCpfcnpj.setBounds(10, 278, 80, 14);
		contentPane.add(lblCpfcnpj);
		
		textField = new JTextField();
		textField.setBounds(100, 175, 374, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(cliente.getNome());
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 200, 374, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(cliente.getEndereco());
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 225, 374, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(cliente.getContato());
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 250, 374, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(cliente.getEmail());
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 275, 374, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText(cliente.getCpf_cnpj());
		
		JButton btnGravar = new JButton("GRAVAR");
		btnGravar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnGravar.setVisible(false);
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Cliente cliente = new Cliente();
					cliente.setCpf_cnpj(textField_4.getText());
					cliente.setNome(textField.getText());
					cliente.setEndereco(textField_1.getText());
					cliente.setContato(textField_2.getText());
					cliente.setEmail(textField_3.getText());
					clienteDAO.create(cliente);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnGravar.setBounds(272, 415, 96, 35);
		contentPane.add(btnGravar);
		
		JLabel lblCadastroDeClientes = new JLabel("CADASTRO DE CLIENTE");
		lblCadastroDeClientes.setForeground(Color.LIGHT_GRAY);
		lblCadastroDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeClientes.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblCadastroDeClientes.setBounds(0, 74, 485, 35);
		contentPane.add(lblCadastroDeClientes);
		
		JButton btnSair = new JButton("VOLTAR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewCliente clienteView = new ViewCliente();
				clienteView.setLocationRelativeTo(null);
				clienteView.setVisible(true);
				dispose();
			}
		});
		btnSair.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnSair.setBounds(378, 415, 96, 35);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\anaju\\Documents\\Inatel\\Eng. Software\\Projeto Rikifoki\\logotam3.png"));
		lblNewLabel.setBounds(10, 11, 96, 26);
		contentPane.add(lblNewLabel);
		
		JButton AddProdutoButton = new JButton("ADICIONAR PEDIDO");
		AddProdutoButton.setVisible(false);
		AddProdutoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente cliente = new Cliente();
					cliente.setCpf_cnpj(textField_4.getText());
					cliente.setNome(textField.getText());
					cliente.setEndereco(textField_1.getText());
					cliente.setContato(textField_2.getText());
					cliente.setEmail(textField_3.getText());
					clienteDAO.create(cliente);
					ViewCliente clienteView = new ViewCliente();
					clienteView.setLocationRelativeTo(null);
					clienteView.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				ViewCadastrarPedido cadastrarpedidoview = new ViewCadastrarPedido(textField_4.getText());
				cadastrarpedidoview.setLocationRelativeTo(null);
				cadastrarpedidoview.setVisible(true);
			}
		});
		AddProdutoButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		AddProdutoButton.setBounds(101, 318, 170, 35);
		contentPane.add(AddProdutoButton);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente cliente = new Cliente();
					cliente.setCpf_cnpj(textField_4.getText());
					cliente.setNome(textField.getText());
					cliente.setEndereco(textField_1.getText());
					cliente.setContato(textField_2.getText());
					cliente.setEmail(textField_3.getText());
					clienteDAO.edit(textField_4.getText(), cliente);
					JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");
					ViewCliente clienteView = new ViewCliente();
					clienteView.setLocationRelativeTo(null);
					clienteView.setVisible(true);
					dispose();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnEditar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnEditar.setBounds(173, 415, 89, 35);
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
