package view;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.VerificaLogin;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public ViewLogin() {
		setResizable(false);
		setSize(new Dimension(200, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBounds(new Rectangle(0, 0, 500, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRikifoki = new JLabel("");
		lblRikifoki.setIcon(new ImageIcon("C:\\Software Enginnering\\ProjetoRikfoki\\Projeto\\Rikifoki\\src\\logo.jpeg"));
		lblRikifoki.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblRikifoki.setHorizontalAlignment(SwingConstants.CENTER);
		lblRikifoki.setBounds(10, 34, 474, 145);
		contentPane.add(lblRikifoki);
		
		JLabel lblNewLabel = new JLabel("USU\u00C1RIO");
		lblNewLabel.setFont(new Font("DialogInput", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(119, 207, 58, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SENHA");
		lblNewLabel_1.setFont(new Font("DialogInput", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(119, 244, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(209, 204, 149, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(209, 243, 149, 20);
		contentPane.add(passwordField);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean x = VerificaLogin.fazVerificacao();
				if(x) dispose();
				
			}
		});
		btnEntrar.setBounds(296, 425, 89, 35);
		contentPane.add(btnEntrar);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnSair.setBounds(395, 425, 89, 35);
		contentPane.add(btnSair);
	}
	
	public JTextField getTextField() {
		return textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
