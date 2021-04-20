package br.com.gellog.controller;

import br.com.gellog.dao.SimpleQueries;
import br.com.gellog.dao.TabelaFreteQueries;
import br.com.gellog.model.TabelaFreteModel;

public class TabelaController {
	
	public void updateTabelaPadrao(TabelaFreteModel tabelaController) {
		new SimpleQueries().simpleInsert(tabelaController);
	}
	public TabelaFreteModel valorTabelaPadrao() {
		return new TabelaFreteQueries().lastResult();
	}
}
