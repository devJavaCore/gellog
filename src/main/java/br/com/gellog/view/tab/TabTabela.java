package br.com.gellog.view.tab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gellog.controller.TabelaController;
import br.com.gellog.view.tab.content.ContentTabela;
import br.com.gellog.view.util.CreateTabStructureAndContent;
import br.com.gellog.view.util.JIconButton;
import br.com.gellog.view.util.JXTabbedPane;

public class TabTabela {

	private JButton botaoCancelar, botaoAtualizar;

	public void tabTabela(JXTabbedPane tabbedPane) {
		CreateTabStructureAndContent createTabStructureAndContent = new CreateTabStructureAndContent();
		createTabStructureAndContent.complementoTitulo = " de Frete";
		createTabStructureAndContent.tabStructureAndContent(tabbedPane, 3);
		final ContentTabela tabela = new ContentTabela();
		createTabStructureAndContent.panel_center.add(tabela.contentTabela());
		tabela.setTextfromjfields(new TabelaController().valorTabelaPadrao());

		botaoCancelar = new JIconButton().botaoCancelar();
		botaoAtualizar = new JIconButton().botaoAtualizar();

		botaoAtualizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TabelaController().updateTabelaPadrao(tabela.getTextfromjfields());
			}
		});
		createTabStructureAndContent.panel_south.add(botaoCancelar);
		createTabStructureAndContent.panel_south.add(botaoAtualizar);
	}
}
