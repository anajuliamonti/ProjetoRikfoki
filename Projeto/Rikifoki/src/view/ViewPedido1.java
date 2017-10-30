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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPedido1 extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public ViewPedido1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\anaju\\Documents\\Inatel\\Eng. Software\\Projeto Rikifoki\\logotam3.png"));
		lblNewLabel.setBounds(10, 11, 105, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblPedido = new JLabel("PEDIDO");
		lblPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedido.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblPedido.setForeground(Color.LIGHT_GRAY);
		lblPedido.setBounds(10, 90, 465, 33);
		contentPane.add(lblPedido);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnVoltar.setBounds(386, 417, 89, 33);
		contentPane.add(btnVoltar);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnNewButton.setBounds(287, 417, 89, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblSelecioneOCliente = new JLabel("SELECIONE O CLIENTE: ");
		lblSelecioneOCliente.setForeground(Color.LIGHT_GRAY);
		lblSelecioneOCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneOCliente.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblSelecioneOCliente.setBounds(10, 134, 465, 14);
		contentPane.add(lblSelecioneOCliente);
		
		JList listClientes = new JList();
		listClientes.setBounds(70, 322, 349, -151);
		contentPane.add(listClientes);
	}

}
