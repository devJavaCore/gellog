package br.com.gellog.view.util.buttons;

import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JButton;

import br.com.gellog.view.util.GenerateIcon;

public class BotaoAtualizar {
	private Icon icon, iconSelected;
	
	public JButton botaoAtualizar() {
		JButton jButton = new JButton("", icon);
		icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/atualizar.png");
		jButton = new JButton("", icon);
		jButton.setBorderPainted(false);
		jButton.setBorder(null);
		// jButton.setFocusable(false);
		jButton.setMargin(new Insets(0, 0, 0, 0));
		jButton.setContentAreaFilled(false);
		iconSelected = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/atualizarSelected.png");
		jButton.setRolloverIcon(iconSelected);
		jButton.setPressedIcon(icon);
		jButton.setDisabledIcon(iconSelected);
		return jButton;
	}
}
