package br.com.gellog.view.util.jcomponents;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JTextFiledSettings {
	private GridBagConstraints gbc_txFBHKG;

	public GridBagConstraints basicAndGbConstrainstConfig(JIconTextField jTextField, int insetsA, int insetsB,
			int insetsC, int insetsD, int gridX, int gridY) {
		jTextField.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			jTextField.setIcon(new ImageIcon(ImageIO.read(new File("src/main/java/br/com/gellog/view/img/currency.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gbc_txFBHKG = new GridBagConstraints();
		gbc_txFBHKG.insets = new Insets(insetsA, insetsB, insetsC, insetsD);
		gbc_txFBHKG.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFBHKG.gridx = gridX;
		gbc_txFBHKG.gridy = gridY;
		jTextField.setColumns(10);

		return gbc_txFBHKG;
	}
}