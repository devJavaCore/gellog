package br.com.gellog.view.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import br.com.gellog.view.tab.TabCliente;
import br.com.gellog.view.tab.TabColetas;
import br.com.gellog.view.tab.TabConfirmacoes;
import br.com.gellog.view.tab.TabEntregas;
import br.com.gellog.view.tab.TabFaturamento;
import br.com.gellog.view.tab.TabHome;
import br.com.gellog.view.tab.TabInstitucional;
import br.com.gellog.view.tab.TabMotorista;
import br.com.gellog.view.tab.TabRelatorios;
import br.com.gellog.view.tab.TabTabela;

public class CreateAndShowGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JXTabbedPane tabbedPane;
	private static JPanel contentPane;
	
	public void createAndShowGUI() {
		CreateAndShowGUI frame = new CreateAndShowGUI();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1100, 700);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Gellog");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 70, 75));
		contentPane.setForeground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		tabbedPane = new JXTabbedPane(JTabbedPane.LEFT);
		frame.getContentPane().add(tabbedPane);
		tabbedPane.setBackground(new Color(70, 70, 75));
		UIManager.put("TabbedPane.contentAreaColor", new ColorUIResource(new Color(110,110,135)));
		UIManager.put("TabbedPane.selected", new Color(50, 50, 60));
		UIManager.put("TabbedPane.highlight", new Color(50, 50, 60));
		UIManager.put("TabbedPane.lightHighlight", new Color(50, 50, 60));
		UIManager.put("TabbedPane.shadow", new Color(50, 50, 60));
		UIManager.put("TabbedPane.darkShadow", new Color(50, 50, 60));
		UIManager.put("TabbedPane.focus", new Color(50, 50, 60));
		SwingUtilities.updateComponentTreeUI(tabbedPane);

		AbstractTabRenderer renderer = (AbstractTabRenderer) tabbedPane.getTabRenderer();
		renderer.setPrototypeText("Gellog Logistica");
		renderer.setHorizontalTextAlignment(SwingConstants.LEADING);

		new CreateTab().createTab(tabbedPane);
		
		new TabHome().tabHome(tabbedPane);
		new TabCliente().tabCliente(tabbedPane);
		new TabMotorista().tabMotorista(tabbedPane);
		new TabTabela().tabTabela(tabbedPane);
		new TabColetas().tabColetas(tabbedPane);
		new TabEntregas().tabEntregas(tabbedPane);
		new TabConfirmacoes().tabConfirmacoes(tabbedPane);
		new TabFaturamento().tabFaturamento(tabbedPane);
		new TabRelatorios().tabRelatorios(tabbedPane);
		new TabInstitucional().tabInstitucional(tabbedPane);
		
		tabbedPane.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
			@Override
			protected void installDefaults() {
				// TODO Auto-generated method stub
				super.installDefaults();
			}
		});
	}
}
