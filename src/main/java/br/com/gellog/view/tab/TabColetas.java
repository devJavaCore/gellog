package br.com.gellog.view.tab;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JButton;

import br.com.gellog.view.util.CreateTabStructureAndContent;
import br.com.gellog.view.util.GenerateIcon;
import br.com.gellog.view.util.JXTabbedPane;

public class TabColetas extends CreateTabStructureAndContent{
	private Icon icon;
	public void tabColetas(JXTabbedPane tabbedPane) {

		CreateTabStructureAndContent createTabStructureAndContent = new CreateTabStructureAndContent();
		createTabStructureAndContent.tabStructureAndContent(tabbedPane, 4);
		icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/adicionarArquivo.png");
		JButton jButtonAddFile = new JButton("", icon);
		jButtonAddFile.setBorderPainted(false);
		jButtonAddFile.setFocusable(false);
		jButtonAddFile.setBorder(null);
		jButtonAddFile.setMargin(new Insets(0, 0, 0, 0));
		jButtonAddFile.setContentAreaFilled(false);
		icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/adicionarArquivoSelected.png");
		jButtonAddFile.setRolloverIcon(icon);
				
		createTabStructureAndContent.panel_north.add(jButtonAddFile, BorderLayout.EAST);
	}
}
