package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Pedido;
import model.PedidoDAO;
import model.Produto;
import model.ProdutoDAO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.LineNumberInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;

public class ViewCadastrarPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	/**
	 * Create the frame.
	 */
	public ViewCadastrarPedido(String cpf_cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 501);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\anaju\\Documents\\Inatel\\Eng. Software\\Projeto Rikifoki\\logotam3.png"));
		lblNewLabel.setBounds(10, 11, 100, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRO DE PEDIDO");
		lblNewLabel_1.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(10, 89, 465, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("REFERENCIA");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(10, 187, 139, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DATA DE VENCIMENTO");
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(10, 212, 139, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblProdutosContidos = new JLabel("PRODUTOS CONTIDOS");
		lblProdutosContidos.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblProdutosContidos.setForeground(Color.LIGHT_GRAY);
		lblProdutosContidos.setBounds(10, 262, 139, 14);
		contentPane.add(lblProdutosContidos);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewPedido2 pedido2 = new ViewPedido2(cpf_cliente);
				pedido2.setLocationRelativeTo(null);
				pedido2.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnVoltar.setBounds(375, 417, 100, 34);
		contentPane.add(btnVoltar);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 184, 316, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(159, 209, 316, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(159, 234, 316, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnGravar = new JButton("GRAVAR");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Pedido pedido = new Pedido();
					pedido.setReferenciaPed(textField_1.getText());
					pedido.setDataVencimento(textField_2.getText());
					pedido.setQuantProd(Integer.parseInt(textField_3.getText()));
					pedido.setPedidoscol(textField_4.getText());
					pedido.setCpf_cliente(cpf_cliente);
					PedidoDAO.create(pedido);
					ViewPedido2 pedido2 = new ViewPedido2(cpf_cliente);
					pedido2.setLocationRelativeTo(null);
					pedido2.setVisible(true);
					dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGravar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnGravar.setBounds(265, 417, 100, 34);
		contentPane.add(btnGravar);
		
		JLabel lblQuantidadeProdutos = new JLabel("QUANTIDADE PRODUTOS");
		lblQuantidadeProdutos.setForeground(Color.LIGHT_GRAY);
		lblQuantidadeProdutos.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblQuantidadeProdutos.setBounds(10, 237, 139, 14);
		contentPane.add(lblQuantidadeProdutos);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(159, 259, 316, 80);
		contentPane.add(textField_4);
		
		ArrayList<Produto> listaDeProdutos = new ArrayList<>();
		String[] produtosCadastrados;
		try {
			
			listaDeProdutos = ProdutoDAO.read("produto");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		produtosCadastrados = new String[listaDeProdutos.size()];
		
		for(int i = 0; i < listaDeProdutos.size(); i++) {
			produtosCadastrados[i] = listaDeProdutos.get(i).getDescricao();
		}
		
		JComboBox comboBox = new JComboBox(produtosCadastrados);
		comboBox.setBounds(159, 350, 206, 23);
		contentPane.add(comboBox);
		
		JButton btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = comboBox.getSelectedIndex();
				String p = produtosCadastrados[i];
				
				if(textField_4.getText().equalsIgnoreCase("")) {
					textField_4.setText(textField_4.getText() + p);
				} else {
					textField_4.setText(textField_4.getText() + " , " + p);
				}
			}
		});
		btnAdicionar.setBounds(375, 350, 100, 23);
		contentPane.add(btnAdicionar);
		
	}
	
	
	/**
	 * @wbp.parser.constructor
	 */
	public ViewCadastrarPedido(Pedido p, String cpf_cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 501);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\anaju\\Documents\\Inatel\\Eng. Software\\Projeto Rikifoki\\logotam3.png"));
		lblNewLabel.setBounds(10, 11, 100, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRO DE PEDIDO");
		lblNewLabel_1.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(10, 89, 465, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("REFERENCIA");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(10, 153, 139, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DATA DE VENCIMENTO");
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(10, 178, 139, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblProdutosContidos = new JLabel("PRODUTOS CONTIDOS");
		lblProdutosContidos.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblProdutosContidos.setForeground(Color.LIGHT_GRAY);
		lblProdutosContidos.setBounds(10, 228, 139, 14);
		contentPane.add(lblProdutosContidos);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewPedido2 pedido2 = new ViewPedido2(cpf_cliente);
				pedido2.setLocationRelativeTo(null);
				pedido2.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnVoltar.setBounds(375, 417, 100, 34);
		contentPane.add(btnVoltar);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 150, 316, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(p.getReferenciaPed());
		
		textField_2 = new JTextField();
		textField_2.setBounds(159, 175, 316, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(p.getDataVencimento());
		
		textField_3 = new JTextField();
		textField_3.setBounds(159, 200, 316, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(Integer.toString(p.getQuantProd()));
		
		JButton btnGravar = new JButton("GRAVAR");
		btnGravar.setVisible(false);
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Pedido pedido = new Pedido();
					pedido.setReferenciaPed(textField_1.getText());
					pedido.setDataVencimento(textField_2.getText());
					pedido.setQuantProd(Integer.parseInt(textField_3.getText()));
					pedido.setPedidoscol(textField_4.getText());
					pedido.setCpf_cliente(cpf_cliente);
					
					PedidoDAO.create(pedido);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGravar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnGravar.setBounds(159, 417, 100, 34);
		contentPane.add(btnGravar);
		
		JLabel lblQuantidadeProdutos = new JLabel("QUANTIDADE PRODUTOS");
		lblQuantidadeProdutos.setForeground(Color.LIGHT_GRAY);
		lblQuantidadeProdutos.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblQuantidadeProdutos.setBounds(10, 203, 139, 14);
		contentPane.add(lblQuantidadeProdutos);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(159, 225, 316, 80);
		contentPane.add(textField_4);
		textField_4.setText(p.getPedidoscol());
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido pedido = new Pedido();
				pedido.setReferenciaPed(textField_1.getText());
				pedido.setDataVencimento(textField_2.getText());
				pedido.setQuantProd(Integer.parseInt(textField_3.getText()));
				pedido.setPedidoscol(textField_4.getText());
				pedido.setCpf_cliente(cpf_cliente);
				try {
					PedidoDAO.edit(pedido);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ViewPedido2 pedido2 = new ViewPedido2(cpf_cliente);
				pedido2.setLocationRelativeTo(null);
				pedido2.setVisible(true);
				dispose();
			}
		});
		btnEditar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnEditar.setBounds(265, 417, 100, 34);
		contentPane.add(btnEditar);
		
		ArrayList<Produto> listaDeProdutos = new ArrayList<>();
		String[] produtosCadastrados;
		try {
			
			listaDeProdutos = ProdutoDAO.read("produto");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		produtosCadastrados = new String[listaDeProdutos.size()];
		
		for(int i = 0; i < listaDeProdutos.size(); i++) {
			produtosCadastrados[i] = listaDeProdutos.get(i).getDescricao();
		}
		
		JComboBox comboBox = new JComboBox(produtosCadastrados);
		comboBox.setBounds(159, 316, 206, 23);
		contentPane.add(comboBox);
		
		JButton btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = comboBox.getSelectedIndex();
				String p = produtosCadastrados[i];
				if(textField_4.getText().equalsIgnoreCase("")) {
					textField_4.setText(textField_4.getText() + p);
				} else {
					textField_4.setText(textField_4.getText() + " - " + p);
				}
			}
		});
		btnAdicionar.setBounds(375, 316, 100, 23);
		contentPane.add(btnAdicionar);
		
	}
}
