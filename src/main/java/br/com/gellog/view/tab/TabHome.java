package br.com.gellog.view.tab;

import br.com.gellog.view.util.CreateTabStructureAndContent;
import br.com.gellog.view.util.JXTabbedPane;

public class TabHome {
	public void tabHome(JXTabbedPane tabbedPane) {
		new CreateTabStructureAndContent().tabStructureAndContent(tabbedPane, 0);	
	}
}
