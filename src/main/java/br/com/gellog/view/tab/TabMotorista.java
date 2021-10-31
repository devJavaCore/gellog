package br.com.gellog.view.tab;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

import br.com.gellog.model.Motorista;
import br.com.gellog.view.tab.content.ContentMotorista;
import br.com.gellog.view.tab.content.ContentMotoristaBusca;
import br.com.gellog.view.util.CreateTabStructureAndContent;
import br.com.gellog.view.util.GenerateIcon;
import br.com.gellog.view.util.JXTabbedPane;

public class TabMotorista extends CreateTabStructureAndContent {
	private Icon icon;
	private static CreateTabStructureAndContent createTabStructureAndContent;
	private static JButton jButtonAddMotorista;
	
	private static ContentMotorista contentMotorista;
	private static ContentMotoristaBusca contentMotoristaBusca ;
	
	public void tabMotorista(JXTabbedPane tabbedPane) {
	createTabStructureAndContent = new CreateTabStructureAndContent();
	createTabStructureAndContent.tabStructureAndContent(tabbedPane, 2);
	icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/addMotorista.png");
	jButtonAddMotorista = new JButton("", icon);
	jButtonAddMotorista.setBorderPainted(false);
	jButtonAddMotorista.setBorder(null);
	jButtonAddMotorista.setFocusable(false);
	jButtonAddMotorista.setMargin(new Insets(0, 0, 0, 0));
	jButtonAddMotorista.setContentAreaFilled(false);
	jButtonAddMotorista.setDisabledIcon(icon);
	jButtonAddMotorista.setPressedIcon(icon);
	icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/addMotoristaSelected.png");
	jButtonAddMotorista.setRolloverIcon(icon);
	createTabStructureAndContent.panel_north.add(jButtonAddMotorista, BorderLayout.EAST);
	contentMotorista = new ContentMotorista();
	contentMotoristaBusca = new ContentMotoristaBusca();
	createTabStructureAndContent.panel_center.add(contentMotoristaBusca.contentMotoristaBusca());
	
	
	jButtonAddMotorista.addActionListener(new ActionListener() {
		
	

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			createTabStructureAndContent.panel_north.remove(jButtonAddMotorista);
			createTabStructureAndContent.panel_north.revalidate();
			createTabStructureAndContent.panel_north.repaint();
			createTabStructureAndContent.panel_center.removeAll();
			createTabStructureAndContent.panel_center.add(contentMotorista.contentMotorista(true, null));
			createTabStructureAndContent.panel_center.revalidate();
			createTabStructureAndContent.panel_center.repaint();
		}
	});
}
static public void voltarListaMotorista() {
	createTabStructureAndContent.panel_north.add(jButtonAddMotorista, BorderLayout.EAST);
	createTabStructureAndContent.panel_north.revalidate();
	createTabStructureAndContent.panel_north.repaint();
	createTabStructureAndContent.panel_center.removeAll();
	createTabStructureAndContent.panel_center.add(contentMotoristaBusca.contentMotoristaBusca());
	createTabStructureAndContent.panel_center.revalidate();
	createTabStructureAndContent.panel_center.repaint();
}
static public void alteraMotorista(Motorista motorista) { 
	createTabStructureAndContent.panel_north.remove(jButtonAddMotorista);
	createTabStructureAndContent.panel_north.revalidate();
	createTabStructureAndContent.panel_north.repaint();
	createTabStructureAndContent.panel_center.removeAll();
	createTabStructureAndContent.panel_center.add(contentMotorista.contentMotorista(false, motorista));
	createTabStructureAndContent.panel_center.revalidate();
	createTabStructureAndContent.panel_center.repaint();
}
}