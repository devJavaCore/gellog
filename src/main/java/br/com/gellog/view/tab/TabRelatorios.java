package br.com.gellog.view.tab;

import br.com.gellog.view.util.CreateTabStructureAndContent;
import br.com.gellog.view.util.JXTabbedPane;

public class TabRelatorios {
	public void tabRelatorios(JXTabbedPane tabbedPane) {
		new CreateTabStructureAndContent().tabStructureAndContent(tabbedPane, 8);	
	}

}
