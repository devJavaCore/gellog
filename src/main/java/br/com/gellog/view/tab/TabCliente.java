package br.com.gellog.view.tab;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

import br.com.gellog.model.Empresa;
import br.com.gellog.view.tab.content.ContentCliente;
import br.com.gellog.view.tab.content.ContentClienteBusca;
import br.com.gellog.view.util.CreateTabStructureAndContent;
import br.com.gellog.view.util.GenerateIcon;
import br.com.gellog.view.util.JXTabbedPane;

public class TabCliente extends CreateTabStructureAndContent {
	private Icon icon;
	private static CreateTabStructureAndContent createTabStructureAndContent;
	static private JButton jButtonAddCliente;
	private static ContentCliente contentCliente;
	private static ContentClienteBusca contentClienteBusca ;
	public void tabCliente(JXTabbedPane tabbedPane) {

		createTabStructureAndContent = new CreateTabStructureAndContent();
		createTabStructureAndContent.tabStructureAndContent(tabbedPane, 1);
		icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/addClient.png");
		jButtonAddCliente = new JButton("", icon);
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
		contentCliente = new ContentCliente();
		contentClienteBusca = new ContentClienteBusca();
		createTabStructureAndContent.panel_center.add(contentClienteBusca.contentClienteBusca());
		
		jButtonAddCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createTabStructureAndContent.panel_north.remove(jButtonAddCliente);
				createTabStructureAndContent.panel_north.revalidate();
				createTabStructureAndContent.panel_north.repaint();
				createTabStructureAndContent.panel_center.removeAll();
				createTabStructureAndContent.panel_center.add(contentCliente.contentCliente(true, null));
				createTabStructureAndContent.panel_center.revalidate();
				createTabStructureAndContent.panel_center.repaint();
			}
		});
	}
	static public void voltarListaClientes() {
		createTabStructureAndContent.panel_north.add(jButtonAddCliente, BorderLayout.EAST);
		createTabStructureAndContent.panel_north.revalidate();
		createTabStructureAndContent.panel_north.repaint();
		createTabStructureAndContent.panel_center.removeAll();
		createTabStructureAndContent.panel_center.add(contentClienteBusca.contentClienteBusca());
		createTabStructureAndContent.panel_center.revalidate();
		createTabStructureAndContent.panel_center.repaint();
	}
	static public void alteraClientes(Empresa empresa) { 
		createTabStructureAndContent.panel_north.remove(jButtonAddCliente);
		createTabStructureAndContent.panel_north.revalidate();
		createTabStructureAndContent.panel_north.repaint();
		createTabStructureAndContent.panel_center.removeAll();
		createTabStructureAndContent.panel_center.add(contentCliente.contentCliente(false, empresa));
		createTabStructureAndContent.panel_center.revalidate();
		createTabStructureAndContent.panel_center.repaint();
	}
}