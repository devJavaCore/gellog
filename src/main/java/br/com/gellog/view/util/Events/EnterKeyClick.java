package br.com.gellog.view.util.Events;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.com.gellog.view.util.jcomponents.JIconButton;

public class EnterKeyClick implements KeyListener{
	
	public EnterKeyClick(final JIconButton jIconButton) {
	jIconButton.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyTyped(e);
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				jIconButton.doClick();

			}
		}
	});
	
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
