package br.com.gellog.view.util;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import br.com.gellog.view.TesteOutro;

public class JTextFiledSettings {

	private GridBagConstraints gbc_txFBHKG;

	public GridBagConstraints basicAndGbConstrainstConfig(JIconTextField jTextField, int insetsA, int insetsB,
			int insetsC, int insetsD, int gridX, int gridY) {
		jTextField.setHorizontalAlignment(SwingConstants.CENTER);
		jTextField.setIcon(new ImageIcon(TesteOutro.class.getResource("/br/com/gellog/view/img/currency.png")));
		gbc_txFBHKG = new GridBagConstraints();
		gbc_txFBHKG.insets = new Insets(insetsA, insetsB, insetsC, insetsD);
		gbc_txFBHKG.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFBHKG.gridx = gridX;
		gbc_txFBHKG.gridy = gridY;
		jTextField.setColumns(10);

		return gbc_txFBHKG;
	}
}