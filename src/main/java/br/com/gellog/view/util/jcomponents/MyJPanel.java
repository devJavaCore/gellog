package br.com.gellog.view.util.jcomponents;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MyJPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyJPanel() {
		super();
		// TODO Auto-generated constructor stub
		setBackground(new Color(255,255,255));
		setBorder(BorderFactory.createBevelBorder(0, new Color(230,230,240), new Color(110,110,135)));
	}	
}
