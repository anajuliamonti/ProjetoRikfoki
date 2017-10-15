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

public class ViewInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ViewInicial() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton LoginButton = new JButton("LOGIN NI");
		LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LoginButton.setBounds(333, 219, 141, 40);
		contentPane.add(LoginButton);
		
		JButton CadastrarButton = new JButton("CADASTRAR");
		CadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastrar.iniciaCadastro();				
			}
		});
		CadastrarButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CadastrarButton.setBounds(10, 219, 141, 40);
		contentPane.add(CadastrarButton);
		
		JButton SairButton = new JButton("SAIR");
		SairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		SairButton.setForeground(Color.BLACK);
		SairButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SairButton.setBounds(333, 411, 141, 40);
		contentPane.add(SairButton);
		
		JLabel lblTelaInicial = new JLabel("Tela Inicial");
		lblTelaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelaInicial.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTelaInicial.setBounds(10, 89, 464, 46);
		contentPane.add(lblTelaInicial);
		
		JButton btnNewButton = new JButton("EDITAR");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastrar.iniciaCadastro();
			}
		});
		btnNewButton.setBounds(170, 219, 141, 40);
		contentPane.add(btnNewButton);
	}
}
