package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import model.ClienteDAO;
import model.MyTable;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

public class ViewCliente extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	
	private static ClienteDAO clienteDAO = new ClienteDAO();

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "serial", "unchecked" })
	public ViewCliente() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 501);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTelaInicial = new JLabel("CLIENTE");
		lblTelaInicial.setForeground(Color.LIGHT_GRAY);
		lblTelaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelaInicial.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblTelaInicial.setBounds(10, 46, 464, 62);
		contentPane.add(lblTelaInicial);
		
		JButton ExcluirButton = new JButton("EXCLUIR");
		ExcluirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf_cnpj_desejado = JOptionPane.showInputDialog("Entre com o CPF ou CNPJ do cliente a ser excluido");
				try {
					clienteDAO.delete(cpf_cnpj_desejado);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				MyTable table = new MyTable(getTableInfo(), Cliente.getAtributes());
				int [] sizes = {70, 100, 30};
				table.setTableColumns(sizes);
				scrollPane.setViewportView(table);
				table.setFillsViewportHeight(true);
				contentPane.setLayout(null);
			}
		});
		ExcluirButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		ExcluirButton.setBounds(376, 364, 98, 34);
		contentPane.add(ExcluirButton);
		
		JButton CadastrarButton = new JButton("CADASTRAR");
		CadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewCadastrarCliente registrationScreen = new ViewCadastrarCliente();
				registrationScreen.setLocationRelativeTo(null);
				registrationScreen.setVisible(true);
				dispose();
			}
		});
		CadastrarButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		CadastrarButton.setBounds(10, 364, 98, 34);
		contentPane.add(CadastrarButton);
		
		JButton VoltarButton = new JButton("VOLTAR");
		VoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewInicial telaInicial = new ViewInicial();
				telaInicial.setLocationRelativeTo(null);
				telaInicial.setVisible(true);
				dispose();
			}
		});
		VoltarButton.setForeground(Color.BLACK);
		VoltarButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		VoltarButton.setBounds(376, 417, 98, 34);
		contentPane.add(VoltarButton);
		
		JButton EditarButton = new JButton("EDITAR");
		EditarButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		EditarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf_cnpj_desejado = JOptionPane.showInputDialog("Entre com o CPF ou CNPJ do cliente a ser editado");
				Cliente cliente_encontrado;
				try {
					cliente_encontrado = clienteDAO.search("cliente", cpf_cnpj_desejado);
					if(cliente_encontrado != null) {
						ViewCadastrarCliente edicaoClienteView = new ViewCadastrarCliente(cliente_encontrado);
						edicaoClienteView.setLocationRelativeTo(null);
						edicaoClienteView.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Cliente não encontrado");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		EditarButton.setBounds(191, 364, 98, 34);
		contentPane.add(EditarButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 464, 234);
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
			// TODO Auto-generated catch block
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
