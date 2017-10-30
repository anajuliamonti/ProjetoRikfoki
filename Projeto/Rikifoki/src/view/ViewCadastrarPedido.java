package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Cadastrar;
import model.Pedido;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ViewCadastrarPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public ViewCadastrarPedido() {
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
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setForeground(Color.LIGHT_GRAY);
		lblCliente.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblCliente.setBounds(10, 162, 139, 14);
		contentPane.add(lblCliente);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00BA DO BLOCO");
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
		lblProdutosContidos.setBounds(10, 237, 139, 14);
		contentPane.add(lblProdutosContidos);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnVoltar.setBounds(375, 417, 100, 34);
		contentPane.add(btnVoltar);
		
		textField = new JTextField();
		textField.setBounds(159, 159, 316, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 184, 316, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(159, 209, 316, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(159, 234, 316, 80);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnGravar = new JButton("GRAVAR");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Pedido pedido = new Pedido();
					
					Cadastrar.fazCadastroPedido(pedido);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGravar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnGravar.setBounds(265, 417, 100, 34);
		contentPane.add(btnGravar);
	}
}
