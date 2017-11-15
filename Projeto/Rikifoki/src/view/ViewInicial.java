package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewInicial extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public ViewInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\anaju\\Documents\\Inatel\\Eng. Software\\Projeto Rikifoki\\logotam1.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 83, 484, 50);
		contentPane.add(lblNewLabel);
		
		JButton ProdutoButton = new JButton("PRODUTO");
		ProdutoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewProduto produtoview = new ViewProduto();
				produtoview.setLocationRelativeTo(null);
				produtoview.setVisible(true);
				dispose();
			}
		});
		ProdutoButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		ProdutoButton.setBounds(161, 218, 163, 34);
		contentPane.add(ProdutoButton);
		
		JButton ClienteButton = new JButton("CLIENTE");
		ClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCliente clienteview = new ViewCliente();
				clienteview.setLocationRelativeTo(null);
				clienteview.setVisible(true);
				dispose();
			}
		});
		ClienteButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		ClienteButton.setBounds(161, 173, 163, 34);
		contentPane.add(ClienteButton);
		
		JButton PedidoButton = new JButton("PEDIDO");
		PedidoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPedido1 pedido1view = new ViewPedido1();
				pedido1view.setLocationRelativeTo(null);
				pedido1view.setVisible(true);
				dispose();
			}
		});
		PedidoButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		PedidoButton.setBounds(161, 263, 163, 34);
		contentPane.add(PedidoButton);
		
		JButton VoltarButton = new JButton("VOLTAR");
		VoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewLogin telaLogin = new ViewLogin();
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setVisible(true);
				dispose();
			}
		});
		VoltarButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		VoltarButton.setBounds(385, 416, 89, 34);
		contentPane.add(VoltarButton);
	}
}
