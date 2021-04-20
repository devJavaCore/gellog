package br.com.gellog.view.util.Events;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FormatPhone implements DocumentListener {
	private String aux;

	public FormatPhone(final JFormattedTextField jFormattedTextField) {
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

						String regex = "([\\(0-9\\)\\s-]+)";
						Pattern pattern = Pattern.compile(regex);
						Matcher matcher = pattern.matcher(jFormattedTextField.getText());
						if (matcher.matches()) {

							if (jFormattedTextField.getText().length() <= 14) {
								aux = jFormattedTextField.getText();
								aux = jFormattedTextField.getText().replaceAll("(^\\d{2})", "\\($1\\) ");
								aux = aux.replaceAll("-", "");
								aux = aux.replaceAll("( \\d{4})(\\d)", "$1-$2");

							} else if (jFormattedTextField.getText().length() == 15) {
								aux = jFormattedTextField.getText();
								aux = jFormattedTextField.getText().replaceAll("-", "");
								aux = aux.replaceAll("( \\d{5})(\\d)", "$1-$2");
							} 
							jFormattedTextField.setText(aux);
						} else {
							jFormattedTextField.setText(null);
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
