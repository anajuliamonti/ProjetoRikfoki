package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Cadastrar;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class ViewCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
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
		lblTelaInicial.setBounds(10, 73, 464, 62);
		contentPane.add(lblTelaInicial);
		
		JButton ExcluirButton = new JButton("EXCLUIR");
		ExcluirButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		ExcluirButton.setBounds(307, 283, 98, 34);
		contentPane.add(ExcluirButton);
		
		JButton CadastrarButton = new JButton("CADASTRAR");
		CadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastrar.iniciaCadastro();				
			}
		});
		CadastrarButton.setFont(new Font("DialogInput", Font.PLAIN, 11));
		CadastrarButton.setBounds(307, 193, 98, 34);
		contentPane.add(CadastrarButton);
		
		JButton VoltarButton = new JButton("VOLTAR");
		VoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				Cadastrar.iniciaCadastro();
			}
		});
		EditarButton.setBounds(307, 238, 98, 34);
		contentPane.add(EditarButton);
		
		JList listClientes = new JList();
		listClientes.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listClientes.setBounds(65, 321, 215, -127);
		contentPane.add(listClientes);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\anaju\\Documents\\Inatel\\Eng. Software\\Projeto Rikifoki\\logotam3.png"));
		label.setBounds(10, 11, 98, 27);
		contentPane.add(label);
	}
}
