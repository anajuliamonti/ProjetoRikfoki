import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class ViewInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInicial frame = new ViewInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton LoginButton = new JButton("LOGIN");
		LoginButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		LoginButton.setBounds(201, 216, 100, 28);
		contentPane.add(LoginButton);
		
		JButton CadastrarButton = new JButton("CADASTRAR");
		CadastrarButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		CadastrarButton.setBounds(201, 255, 100, 28);
		contentPane.add(CadastrarButton);
		
		JButton SairButton = new JButton("SAIR");
		SairButton.setForeground(Color.BLACK);
		SairButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		SairButton.setBounds(201, 294, 100, 28);
		contentPane.add(SairButton);
		
		JLabel InicialLabel = new JLabel("New label");
		InicialLabel.setBackground(Color.GRAY);
		InicialLabel.setIcon(new ImageIcon("C:\\Users\\anaju\\Downloads\\Design sem nome.png"));
		InicialLabel.setBounds(0, 0, 484, 462);
		contentPane.add(InicialLabel);
	}
}
