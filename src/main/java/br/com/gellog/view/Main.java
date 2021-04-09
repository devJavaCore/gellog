package br.com.gellog.view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import br.com.gellog.view.util.CreateAndShowGUI;

public class Main extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CreateAndShowGUI().createAndShowGUI();
			}
		});
	}

}