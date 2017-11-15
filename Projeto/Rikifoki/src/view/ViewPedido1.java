package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import model.ClienteDAO;
import model.MyTable;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewPedido1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private static ClienteDAO clienteDAO = new ClienteDAO();
	
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
				ViewInicial telaInicial = new ViewInicial();
				telaInicial.setLocationRelativeTo(null);
				telaInicial.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnVoltar.setBounds(386, 417, 89, 33);
		contentPane.add(btnVoltar);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cliente_selecionado = JOptionPane.showInputDialog("Entre com o cpf do cliente que deseja ver os pedidos");
				try {
					if(clienteDAO.search("cliente", cliente_selecionado) != null) {
						ViewPedido2 pedido2View = new ViewPedido2(cliente_selecionado);
						pedido2View.setLocationRelativeTo(null);
						pedido2View.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnNewButton.setBounds(287, 417, 89, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblSelecioneOCliente = new JLabel("CLIENTES CADASTRADOS NO SISTEMA: ");
		lblSelecioneOCliente.setForeground(Color.LIGHT_GRAY);
		lblSelecioneOCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneOCliente.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblSelecioneOCliente.setBounds(10, 134, 465, 14);
		contentPane.add(lblSelecioneOCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 159, 465, 170);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		MyTable table = new MyTable(getTableInfo(), Cliente.getAtributes());
		int [] sizes = {70, 100, 30};
		table.setTableColumns(sizes);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		contentPane.setLayout(null);
	}
	
private Object [] [] getTableInfo() {
		
		Object [] clientes;
		
		try {
			clientes = clienteDAO.lerTabelaCliente("cliente").toArray();
		} catch (SQLException e) {
			e.printStackTrace();
			return new Object [1] [3];
		}
		
		Object [] [] tableInfo = new Object[clientes.length] [Cliente.getAtributes().length];
		
		for (int i = 0; i < clientes.length; i++) {
			tableInfo[i] = ((Cliente) clientes[i]).getInfo();
		}
		
		return tableInfo;
	}

}
