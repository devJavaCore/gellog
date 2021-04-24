package br.com.gellog.view.util.Events;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import br.com.gellog.view.util.jcomponents.JIconTextField;

public class SetZero implements FocusListener {

	public SetZero(final JIconTextField jIconTextField) {
		super();
		// TODO Auto-generated constructor stub
		jIconTextField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(jIconTextField == null || jIconTextField.getText().isEmpty()) {
					jIconTextField.setText("0.00");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
