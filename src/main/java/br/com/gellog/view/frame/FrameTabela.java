package br.com.gellog.view.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.gellog.view.tab.content.ContentTabela;

public class FrameTabela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static private FrameTabela frame;
	public void createAndShow() {

		frame = new FrameTabela();
		frame.setVisible(true);
		//frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 880, 690);
		frame.setTitle("Gellog");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		JPanel panel_north = new JPanel();
		contentPane.add(panel_north, BorderLayout.NORTH);
		panel_north.setLayout(new BorderLayout(0, 0));
		panel_north.setPreferredSize(new Dimension(200, 80));
		panel_north.setBackground(new Color(110, 110, 135));

		JLabel jLMenu = new JLabel("  Cadastro de Tarifas de Frete personalizado");
		jLMenu.setForeground(new Color(255, 255, 255));
		jLMenu.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		panel_north.add(jLMenu, BorderLayout.WEST);

		JPanel panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.add(new ContentTabela().contentTabela(false));

	}
	static public void setInvisible() {
		frame.setVisible(false);
	}
}
