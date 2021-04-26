package br.com.gellog.view.util.Events;

import java.util.Optional;
import javax.swing.JFormattedTextField;
import javax.swing.SwingUtilities;

import org.apache.commons.lang3.StringUtils;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class OnlyWords implements DocumentListener {

	public OnlyWords(final JFormattedTextField jFormattedTextField) {
		super();
		// TODO Auto-generated constructor stub
		jFormattedTextField.getDocument().addDocumentListener(new DocumentListener() {

			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

				Runnable format = new Runnable() {

					public void run() {
						// TODO Auto-generated method stub

						if (!StringUtils.isAlphaSpace(jFormattedTextField.getText())) {
							String text = jFormattedTextField.getText();
							jFormattedTextField.setText(Optional.ofNullable(text).filter(str -> str.length() != 0)
									.map(str -> str.substring(0, str.length() - 1)).orElse(text));
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
