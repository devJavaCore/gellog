package br.com.gellog.view.tab;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JButton;

import br.com.gellog.view.tab.content.ContentCliente;
import br.com.gellog.view.util.CreateTabStructureAndContent;
import br.com.gellog.view.util.GenerateIcon;
import br.com.gellog.view.util.JXTabbedPane;

public class TabCliente extends CreateTabStructureAndContent {
	private Icon icon;

	public void tabCliente(JXTabbedPane tabbedPane) {

		CreateTabStructureAndContent createTabStructureAndContent = new CreateTabStructureAndContent();
		createTabStructureAndContent.tabStructureAndContent(tabbedPane, 1);
		icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/addClient.png");
		JButton jButtonAddCliente = new JButton("", icon);
		jButtonAddCliente.setBorderPainted(false);
		jButtonAddCliente.setBorder(null);
		jButtonAddCliente.setFocusable(false);
		jButtonAddCliente.setMargin(new Insets(0, 0, 0, 0));
		jButtonAddCliente.setContentAreaFilled(false);
		jButtonAddCliente.setDisabledIcon(icon);
		jButtonAddCliente.setPressedIcon(icon);
		icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/addClientSelected.png");
		jButtonAddCliente.setRolloverIcon(icon);
		
		

		createTabStructureAndContent.panel_north.add(jButtonAddCliente, BorderLayout.EAST);
		createTabStructureAndContent.panel_center.add(new ContentCliente().contentCliente());
		
		
	}
}