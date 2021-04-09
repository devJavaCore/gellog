package br.com.gellog.view.util.buttons;

import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JButton;

import br.com.gellog.view.util.GenerateIcon;

public class BotaoVoltar {
	private Icon icon, iconSelected;
	
	public JButton botaoVoltar() {
		icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/voltar.png");
		JButton jButton = new JButton("", icon);
		jButton.setBorderPainted(false);
		jButton.setBorder(null);
		// jButton.setFocusable(false);
		jButton.setMargin(new Insets(0, 0, 0, 0));
		jButton.setContentAreaFilled(false);
		iconSelected = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/voltarSelected.png");
		jButton.setRolloverIcon(iconSelected);
		jButton.setPressedIcon(icon);
		jButton.setDisabledIcon(iconSelected);
		return jButton;
	}

}
