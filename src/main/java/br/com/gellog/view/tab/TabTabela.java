package br.com.gellog.view.tab;

import br.com.gellog.view.tab.content.ContentTabela;
import br.com.gellog.view.util.CreateTabStructureAndContent;
import br.com.gellog.view.util.JXTabbedPane;
import br.com.gellog.view.util.buttons.BotaoAtualizar;
import br.com.gellog.view.util.buttons.BotaoCancelar;

public class TabTabela extends CreateTabStructureAndContent {

	public void tabTabela(JXTabbedPane tabbedPane) {
		CreateTabStructureAndContent createTabStructureAndContent = new CreateTabStructureAndContent();
		createTabStructureAndContent.complementoTitulo = " de Frete";
		createTabStructureAndContent.tabStructureAndContent(tabbedPane, 3);

		createTabStructureAndContent.panel_center.add(new ContentTabela().contentTabela());
		
		createTabStructureAndContent.panel_south.add(new BotaoCancelar().botaoCancelar());
		createTabStructureAndContent.panel_south.add(new BotaoAtualizar().botaoAtualizar());
	}
}
