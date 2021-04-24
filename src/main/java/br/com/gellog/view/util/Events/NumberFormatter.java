package br.com.gellog.view.util.Events;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import br.com.gellog.view.util.jcomponents.JIconTextField;

public class NumberFormatter implements DocumentListener {
	
public NumberFormatter(final JIconTextField jIconTextField) {
	super();
	// TODO Auto-generated constructor stub
	
	
	jIconTextField.getDocument().addDocumentListener(new DocumentListener() {
		
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
		}
		
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
			Runnable format = new Runnable() {
				
				public void run() {		
					// TODO Auto-generated method stub
					String text = jIconTextField.getText();
					if (!text.matches("\\d*(\\.\\d{0,2})?")) {
						jIconTextField.setText(text.substring(0, text.length() - 1));
					}
				}
			};
			SwingUtilities.invokeLater(format);
			
		}
		
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
		}
	});
	
}

	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
