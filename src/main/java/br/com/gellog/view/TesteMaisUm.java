package br.com.gellog.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.gellog.view.util.GenerateIcon;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class TesteMaisUm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsurio;
	private JPasswordField pwdSenha;
	private JTextField txtUsurio_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteMaisUm frame = new TesteMaisUm();
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
	public TesteMaisUm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLayeredPane panel = new JLayeredPane();
		panel.setBounds(0, 0, 480, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		GenerateIcon generateIcon = new GenerateIcon();
		JLabel imageHolder = new JLabel("New label");
		imageHolder.setBounds(0, 0, 480, 600);
		imageHolder.setIcon(generateIcon.generateIcon("src/main/java/br/com/gellog/view/img/backgroundLogin.png"));
		panel.add(imageHolder, 1,0);

		
		
		txtUsurio = new JTextField("Usuário");
		txtUsurio.setBounds(150, 250, 180, 30);
		panel.add(txtUsurio, 2,0);
		txtUsurio.setColumns(10);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setText("Senha");
		pwdSenha.setBounds(150, 300, 180, 30);
		panel.add(pwdSenha, 2,0);
		
	}
}
