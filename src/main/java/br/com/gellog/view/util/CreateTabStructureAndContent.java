package br.com.gellog.view.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateTabStructureAndContent {
	/**
	 * 
	 */
	public JPanel panel_north, panel_south, panel_east, panel_west, panel_center;
	
	public String complementoTitulo;

	public void tabStructureAndContent(JXTabbedPane tabbedPane, int index) {
		
		JPanel panel_main = new JPanel();
		GridBagConstraints gbc_panel_main = new GridBagConstraints();
		gbc_panel_main.fill = GridBagConstraints.BOTH;
		gbc_panel_main.gridx = 0;
		gbc_panel_main.gridy = 1;
		panel_main.setLayout(new BorderLayout(0, 0));
		
		panel_north = new JPanel();
		panel_main.add(panel_north, BorderLayout.NORTH);
		panel_north.setLayout(new BorderLayout(0, 0));
		panel_north.setPreferredSize(new Dimension(200, 80));
		panel_north.setBackground(new Color(110, 110, 135));
		
		if (complementoTitulo == null) {
			complementoTitulo = "";
		}
		JLabel jLMenu = new JLabel(tabbedPane.getTitleAt(index) + complementoTitulo);
		
		jLMenu.setForeground(new Color(255, 255, 255));
		jLMenu.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		panel_north.add(jLMenu, BorderLayout.WEST);

		
		panel_east = new JPanel();
		panel_main.add(panel_east, BorderLayout.EAST);
				
		panel_south = new JPanel();
		panel_main.add(panel_south, BorderLayout.SOUTH);
		
		panel_west = new JPanel();
		panel_main.add(panel_west, BorderLayout.WEST);
		
		panel_center = new JPanel();
		panel_main.add(panel_center, BorderLayout.CENTER);
		
		tabbedPane.setComponentAt(index, panel_main);
		
	}
}
