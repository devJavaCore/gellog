package br.com.gellog.view.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.gellog.view.TesteOutro;
import br.com.gellog.view.util.GenerateIcon;
import br.com.gellog.view.util.JSearchPasswordField;
import br.com.gellog.view.util.JSearchTextField;
import br.com.gellog.view.util.MyJButton;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSearchTextField txtUsurio;
	private JSearchPasswordField pwdSenha;
	private static MyJButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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
	public LoginFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Login Gellog");
		// setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLayeredPane panel = new JLayeredPane();
		panel.setBounds(0, 0, 479, 521);
		contentPane.add(panel);
		panel.setLayout(null);

		GenerateIcon generateIcon = new GenerateIcon();
		JLabel imageHolder = new JLabel("New label");
		imageHolder.setBounds(0, 0, 479, 521);
		imageHolder.setIcon(generateIcon.generateIcon("src/main/java/br/com/gellog/view/img/backgroundLogin.png"));
		panel.add(imageHolder, 1, 0);

		txtUsurio = new JSearchTextField();
		txtUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsurio.setBorder(null);
		txtUsurio.setTextWhenNotFocused("Usuário");
		txtUsurio.setBounds(150, 230, 180, 30);
		panel.add(txtUsurio, 2, 0);
		txtUsurio.setColumns(10);
		txtUsurio.setIcon(new ImageIcon(TesteOutro.class.getResource("/br/com/gellog/view/img/userIcon.png")));

		pwdSenha = new JSearchPasswordField();
		pwdSenha.setHorizontalAlignment(SwingConstants.CENTER);
		pwdSenha.setBorder(null);
		pwdSenha.setTextWhenNotFocused("Senha");
		pwdSenha.setBounds(150, 280, 180, 30);
		panel.add(pwdSenha, 2, 0);
		pwdSenha.setIcon(new ImageIcon(TesteOutro.class.getResource("/br/com/gellog/view/img/password.png")));

		btnLogin = new MyJButton("Login");
		btnLogin.setBounds(150, 330, 180, 30);
		btnLogin.setBackground(new Color(3, 59, 90));
		btnLogin.setForeground(new Color(0, 135, 200).brighter());
		btnLogin.setBorderPainted(false);
		panel.add(btnLogin, 2, 0);
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.setBorder(null);
		btnLogin.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		btnLogin.setPressedBackgroundColor(new Color(50, 100, 150));

		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyTyped(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnLogin.doClick();
				}
			}
		});
	}
}
