package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import model.MyTable;
import model.Produto;
import model.ProdutoDAO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ViewProduto extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JScrollPane scrollPane;
	
	private static ProdutoDAO produtoDAO = new ProdutoDAO();
	/**
	 * Create the frame.
	 */
	public ViewProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\anaju\\Documents\\Inatel\\Eng. Software\\Projeto Rikifoki\\logotam3.png"));
		lblNewLabel.setBounds(10, 11, 100, 24);
		contentPane.add(lblNewLabel);

		JLabel lblProdutdo = new JLabel("PRODUTO");
		lblProdutdo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutdo.setForeground(Color.LIGHT_GRAY);
		lblProdutdo.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblProdutdo.setBounds(10, 80, 464, 43);
		contentPane.add(lblProdutdo);

		JList listProdutos = new JList();
		listProdutos.setBounds(82, 308, 199, -111);
		contentPane.add(listProdutos);

		JButton CadastrarProdButton = new JButton("CADASTRAR");
		CadastrarProdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewCadastrarProduto cadastrarprodutoview = new ViewCadastrarProduto();
				cadastrarprodutoview.setLocationRelativeTo(null);
				cadastrarprodutoview.setVisible(true);
				dispose();
			}
		});
		CadastrarProdButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		CadastrarProdButton.setBounds(10, 329, 100, 34);
		contentPane.add(CadastrarProdButton);

		JButton EditarProdButton = new JButton("EDITAR");
		EditarProdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String referencia_desejada = JOptionPane.showInputDialog("Entre com a referencia do produto a ser editado");
				Produto produto_encontrado;
				try {
					produto_encontrado = produtoDAO.search("produto", Integer.parseInt(referencia_desejada));
					if(produto_encontrado != null) {
						ViewCadastrarProduto edicaoProdutoView = new ViewCadastrarProduto(produto_encontrado);
						edicaoProdutoView.setLocationRelativeTo(null);
						edicaoProdutoView.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Produto não encontrado");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		EditarProdButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		EditarProdButton.setBounds(188, 329, 100, 34);
		contentPane.add(EditarProdButton);

		JButton ExcluirProdButton = new JButton("EXCLUIR");
		ExcluirProdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProdutoDAO.delete(Integer.parseInt(JOptionPane.showInputDialog("Entre com a referencia do produto a ser excluido")));
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				MyTable table_1 = new MyTable(getTableInfo(), Produto.getAtributes());
				int [] sizes = {50, 100, 30};
				table_1.setTableColumns(sizes);
				scrollPane.setViewportView(table_1);
				table_1.setFillsViewportHeight(true);
				contentPane.setLayout(null);
			}
		});
		ExcluirProdButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		ExcluirProdButton.setBounds(374, 329, 100, 34);
		contentPane.add(ExcluirProdButton);

		JButton VoltarButton = new JButton("VOLTAR");
		VoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewInicial telaInicial = new ViewInicial();
				telaInicial.setLocationRelativeTo(null);
				telaInicial.setVisible(true);
				dispose();
			}
		});
		VoltarButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		VoltarButton.setBounds(374, 416, 100, 34);
		contentPane.add(VoltarButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 464, 192);
		contentPane.add(scrollPane);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		MyTable table_1 = new MyTable(getTableInfo(), Produto.getAtributes());
		int [] sizes = {50, 100, 30};
		table_1.setTableColumns(sizes);
		scrollPane.setViewportView(table_1);
		table_1.setFillsViewportHeight(true);
		contentPane.setLayout(null);
	}

	private Object [] [] getTableInfo() {

		Object [] produtos;

		try {
			produtos = ProdutoDAO.read ("produto").toArray();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Object [1] [3];
		}

		Object [] [] tableInfo = new Object[produtos.length] [Produto.getAtributes().length];

		for (int i = 0; i < produtos.length; i++) {
			tableInfo[i] = ((Produto) produtos[i]).getInfo();
		}

		return tableInfo;
	}
}
