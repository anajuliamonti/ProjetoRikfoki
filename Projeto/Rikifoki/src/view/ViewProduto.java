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
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewProduto extends JFrame {

	private JPanel contentPane;
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
				cadastrarprodutoview.setVisible(true);
			}
		});
		CadastrarProdButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		CadastrarProdButton.setBounds(306, 193, 100, 34);
		contentPane.add(CadastrarProdButton);
		
		JButton EditarProdButton = new JButton("EDITAR");
		EditarProdButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		EditarProdButton.setBounds(306, 238, 100, 34);
		contentPane.add(EditarProdButton);
		
		JButton ExcluirProdButton = new JButton("EXCLUIR");
		ExcluirProdButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		ExcluirProdButton.setBounds(306, 281, 100, 34);
		contentPane.add(ExcluirProdButton);
		
		JButton VoltarButton = new JButton("VOLTAR");
		VoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		VoltarButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		VoltarButton.setBounds(374, 416, 100, 34);
		contentPane.add(VoltarButton);
	}
}
