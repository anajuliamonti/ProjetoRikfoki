package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;

public class ViewPedido2 extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public ViewPedido2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 499);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\anaju\\Documents\\Inatel\\Eng. Software\\Projeto Rikifoki\\logotam3.png"));
		lblNewLabel.setBounds(10, 11, 100, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblPedido = new JLabel("PEDIDO");
		lblPedido.setForeground(Color.LIGHT_GRAY);
		lblPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedido.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblPedido.setBounds(10, 90, 464, 33);
		contentPane.add(lblPedido);
		
		JLabel lblPedidosDoCliente = new JLabel("PEDIDOS DO CLIENTE ");
		lblPedidosDoCliente.setForeground(Color.LIGHT_GRAY);
		lblPedidosDoCliente.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblPedidosDoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidosDoCliente.setBounds(10, 134, 464, 14);
		contentPane.add(lblPedidosDoCliente);
		
		JButton AddPedidoButton = new JButton("ADICIONAR");
		AddPedidoButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		AddPedidoButton.setBounds(306, 196, 95, 33);
		contentPane.add(AddPedidoButton);
		
		JButton VoltarButton = new JButton("VOLTAR");
		VoltarButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		VoltarButton.setBounds(379, 416, 95, 33);
		contentPane.add(VoltarButton);
		
		JButton EditarPedidoButton = new JButton("EDITAR");
		EditarPedidoButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		EditarPedidoButton.setBounds(306, 240, 95, 33);
		contentPane.add(EditarPedidoButton);
		
		JList listPedidos = new JList();
		listPedidos.setBounds(82, 335, 210, -138);
		contentPane.add(listPedidos);
	}

}
