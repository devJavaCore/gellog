package br.com.gellog.view.tab;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JButton;

import br.com.gellog.view.util.CreateTabStructureAndContent;
import br.com.gellog.view.util.GenerateIcon;
import br.com.gellog.view.util.JXTabbedPane;

public class TabMotorista extends CreateTabStructureAndContent {
	private Icon icon;
	public void tabMotorista(JXTabbedPane tabbedPane) {
	CreateTabStructureAndContent createTabStructureAndContent = new CreateTabStructureAndContent();
	createTabStructureAndContent.tabStructureAndContent(tabbedPane, 2);
	icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/addMotorista.png");
	JButton jButtonAddMotorista = new JButton("", icon);
	jButtonAddMotorista.setBorderPainted(false);
	jButtonAddMotorista.setFocusable(false);
	jButtonAddMotorista.setBorder(null);
	jButtonAddMotorista.setMargin(new Insets(0, 0, 0, 0));
	jButtonAddMotorista.setContentAreaFilled(false);
	icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/addMotoristaSelected.png");
	jButtonAddMotorista.setRolloverIcon(icon);

	createTabStructureAndContent.panel_north.add(jButtonAddMotorista,  BorderLayout.EAST);
	}
}
