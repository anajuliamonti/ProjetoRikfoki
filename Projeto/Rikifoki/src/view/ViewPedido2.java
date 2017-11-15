package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import model.MyTable;
import model.Pedido;
import model.PedidoDAO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPedido2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	/**
	 * Create the frame.
	 */
	public ViewPedido2(String cpf_cliente) {
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
		AddPedidoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastrarPedido cadastrarPedidoView = new ViewCadastrarPedido(cpf_cliente);
				cadastrarPedidoView.setLocationRelativeTo(null);
				cadastrarPedidoView.setVisible(true);
				dispose();
			}
		});
		AddPedidoButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		AddPedidoButton.setBounds(10, 315, 115, 33);
		contentPane.add(AddPedidoButton);

		JButton VoltarButton = new JButton("VOLTAR");
		VoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewPedido1 pedido1View = new ViewPedido1();
				pedido1View.setLocationRelativeTo(null);
				pedido1View.setVisible(true);
				dispose();
			}
		});
		VoltarButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		VoltarButton.setBounds(379, 416, 95, 33);
		contentPane.add(VoltarButton);

		JButton EditarPedidoButton = new JButton("EDITAR");
		EditarPedidoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ref = JOptionPane.showInputDialog("Entre com a referencia do pedido a ser editado");
				Pedido pedido_encontrado;
				try {
					pedido_encontrado = PedidoDAO.searchOne("pedido", ref);
					if(pedido_encontrado != null) {
						ViewCadastrarPedido edicaoPedidoView = new ViewCadastrarPedido(pedido_encontrado, cpf_cliente);
						edicaoPedidoView.setLocationRelativeTo(null);
						edicaoPedidoView.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Pedido não encontrado");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		EditarPedidoButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		EditarPedidoButton.setBounds(201, 315, 95, 33);
		contentPane.add(EditarPedidoButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 159, 464, 145);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ref = JOptionPane.showInputDialog("Entre com a referencia do pedido a ser excluido");
				try {
					PedidoDAO.delete(ref);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				MyTable table = new MyTable(getTableInfo(cpf_cliente), Pedido.getAtributes());
				int [] sizes = {70, 100, 30};
				table.setTableColumns(sizes);
				scrollPane.setViewportView(table);
				table.setFillsViewportHeight(true);
				contentPane.setLayout(null);
				
			}
		});
		btnExcluir.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnExcluir.setBounds(379, 315, 95, 33);
		contentPane.add(btnExcluir);
		
		MyTable table = new MyTable(getTableInfo(cpf_cliente), Pedido.getAtributes());
		int [] sizes = {70, 100, 30};
		table.setTableColumns(sizes);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		contentPane.setLayout(null);
	}

	private Object [] [] getTableInfo(String cpf_cliente) {

		Object [] pedidos;

		try {
			pedidos = PedidoDAO.search("pedido", cpf_cliente).toArray();
		} catch (SQLException e) {
			e.printStackTrace();
			return new Object [1] [3];
		}

		Object [] [] tableInfo = new Object[pedidos.length] [Pedido.getAtributes().length];

		for (int i = 0; i < pedidos.length; i++) {
			tableInfo[i] = ((Pedido) pedidos[i]).getInfo();
		}

		return tableInfo;
	}
}
