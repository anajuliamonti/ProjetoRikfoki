package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Cadastrar;
import model.Produto;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ViewCadastrarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public ViewCadastrarProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 501);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\anaju\\Documents\\Inatel\\Eng. Software\\Projeto Rikifoki\\logotam3.png"));
		label.setBounds(10, 11, 100, 28);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE PRODUTO");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 89, 464, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblReferncia = new JLabel("REFER\u00CANCIA");
		lblReferncia.setForeground(Color.LIGHT_GRAY);
		lblReferncia.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblReferncia.setBounds(10, 187, 100, 14);
		contentPane.add(lblReferncia);
		
		JLabel lblNewLabel_1 = new JLabel("QTDE PRODUZIDA");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 212, 110, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCustoUnitrio = new JLabel("CUSTO UNIT\u00C1RIO");
		lblCustoUnitrio.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblCustoUnitrio.setForeground(Color.LIGHT_GRAY);
		lblCustoUnitrio.setBounds(10, 237, 100, 14);
		contentPane.add(lblCustoUnitrio);
		
		JLabel lblNewLabel_2 = new JLabel("CUSTO DO LOTE");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(10, 262, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PRE\u00C7O DE VENDA");
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(10, 287, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(120, 184, 354, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 209, 354, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(120, 234, 354, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(120, 259, 354, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(119, 284, 355, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton VoltarButton = new JButton("VOLTAR");
		VoltarButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		VoltarButton.setBounds(374, 417, 100, 34);
		contentPane.add(VoltarButton);
		
		JButton GravarButton = new JButton("GRAVAR");
		GravarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Produto produto = new Produto();
					produto.setReferencia(Integer.parseInt(textField.getText()));
					produto.setQuantidade(Integer.parseInt(textField_1.getText()));
					produto.setCustoUnit(Double.parseDouble(textField_2.getText()));
					produto.setPrecoVenda(Double.parseDouble(textField_4.getText()));
					Cadastrar.fazCadastroProduto(produto);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GravarButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		GravarButton.setBounds(264, 417, 100, 34);
		contentPane.add(GravarButton);
	}
}
