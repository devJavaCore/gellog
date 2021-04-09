package br.com.gellog.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.TabbedPaneUI;

public class Test extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 70, 75));
		contentPane.setForeground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("src/main/java/br/com/gellog/view/img/home.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon imgIcon;
		imgIcon = new ImageIcon(img);
		
		
		JTabbedPane tabbedPane = new JTabbedPane();
		getContentPane().add(tabbedPane);
		
		
		
		

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tabbedPane.add(panel, null);
		tabbedPane.remove(0);

		JTextField jThome = new JTextField("Home");
		tabbedPane.add(jThome, "Home");
		
		tabbedPane.setIconAt(0, imgIcon);

		JTextField jTclientes = new JTextField("Clientes");
		tabbedPane.add(jTclientes, "Clientes");
		
		JTextField jTmotoristas = new JTextField("Motoristas");
		tabbedPane.add(jTmotoristas, "Motoristas");

		JTextField jTtabela = new JTextField("Tabela", JTextField.LEFT);
		tabbedPane.add(jTtabela, "Tabela");
		
		
		JTextField jTcoletas = new JTextField("Coletas");
		tabbedPane.add(jTcoletas, "Coletas");

		JTextField jTentregas = new JTextField("Entregas");
		tabbedPane.add(jTentregas, "Entregas");

		JTextField jTfaturamento = new JTextField("Faturamento");
		tabbedPane.add(jTfaturamento, "Faturamento");

		JTextField jTrelatorios = new JTextField("Relatórios");
		tabbedPane.add(jTrelatorios, "Relatórios");

		JTextField jTgellog = new JTextField("Gellog");
		tabbedPane.add(jTgellog, "Gellog");

		tabbedPane.setFont(new Font("Dialog", Font.TRUETYPE_FONT, 17));

		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setBackground(new Color(70, 70, 75));
		

		for (int i = 0; i < 7; i++) {
			tabbedPane.getComponentAt(i).setBackground(new Color(230, 230, 235));

		}

		int comp = tabbedPane.getComponentCount();
		for (Component sc : tabbedPane.getComponents()) {
			if (sc instanceof javax.swing.JLabel) {
				JLabel lbl = (JLabel) sc;
				// lbl.setForeground(Color.red);
			}
			if (sc instanceof javax.swing.JPanel) {
				JPanel pnl = (JPanel) sc;
				pnl.setName(pnl.getName());
			}
			if (sc instanceof javax.swing.JTextField) {
				JTextField txt = (JTextField) sc;
				// txt.setForeground(Color.blue);
				// txt.setDisabledTextColor(Color.red);
			}
		}
		// UIManager.put("TabbedPane.selected", Color.red);
		// UIManager.put("tabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
		// UIManager.put("tabbedPane.highlight", new Color(255, 0, 0));
		// UIManager.put("tabbedPane.lightHighlight", new Color(0, 255, 0));
		// UIManager.put("tabbedPane.darkShadow", new Color(0, 255, 0));
		// UIManager.put("TabbedPane.shadow", new Color(0, 0, 255));
		// UIManager.put("TabbedPane.light", new Color(0, 255, 0));
		// UIManager.put("TabbedPane.foreground", new Color(0, 0, 0));
		// UIManager.put("JTabbedPane.font", new Font("Dialog", Font.ITALIC, 12));
		UIManager.put("TabbedPane.selected", new Color(50, 50, 60));

		// UIManager.put("disable", new Color(255, 0, 0));
		// UIManager.put("TabbedPane.selectHighlight", new Color(0, 0, 0));
		// UIManager.put("TabbedPane.background", new Color(0, 0, 0));
		SwingUtilities.updateComponentTreeUI(tabbedPane);
		// tabbedPane.setTitleAt(2, "<html><font color=" + (tabbedPane.isEnabledAt(2) ?
		// "black" : "red") + ">"
		// tabbedPane.getTitleAt(2) + "</font></html>");

		tabbedPane.setTabPlacement(JTabbedPane.LEFT);
		
		
		
		
		tabbedPane.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
			
			@Override
			protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
				return 42;
			}

			@Override
			protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
				return 200;
			}

			private final Insets borderInsets = new Insets(0, 0, 0, 0);

			@Override
			protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
			}

			@Override
			protected Insets getContentBorderInsets(int tabPlacement) {
				return borderInsets;
			}

			@Override
			protected void installDefaults() {
				super.installDefaults();
				highlight = new Color(70, 70, 75);
				lightHighlight = new Color(70, 70, 75);
				shadow = new Color(70, 70, 75);
				darkShadow = new Color(70, 70, 75);
				focus = new Color(70, 70, 75);
			}
		});
	}
}
