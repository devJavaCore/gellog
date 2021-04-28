package br.com.gellog.controller;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.gellog.dao.EmpresaDAO;
import br.com.gellog.dao.TabelaFreteDAO;
import br.com.gellog.model.Empresa;
import br.com.gellog.model.TabelaFreteModel;
import br.com.gellog.view.tab.content.ContentTabela;

public class TabelaController {
	private static TabelaFreteModel tabelaFrete;
	private static ContentTabela campos;
	

	static public void updateInsertTabela(boolean tabelaPadrao, BigDecimal bh10kg, BigDecimal bhExcedente,
			BigDecimal rmbh10Kg, BigDecimal rmbhExcedente, BigDecimal interior10kg, BigDecimal interiorExcedente,
			BigDecimal confinsTaxa, BigDecimal kmFiorino, BigDecimal kmVanHR, BigDecimal taxaFiorino1h,
			BigDecimal taxaVan1h, BigDecimal taxaFiorino2h, BigDecimal taxaVan2h, BigDecimal taxaFiorino4h,
			BigDecimal taxaVan4h, BigDecimal taxaFiorino6h, BigDecimal taxaVan6h, BigDecimal taxaFiorino8h,
			BigDecimal taxaVan8h) {
		tabelaFrete = new TabelaFreteModel();
		
		tabelaFrete.setTabelaPadrao(tabelaPadrao);
		tabelaFrete.setBh10kg(bh10kg);
		tabelaFrete.setBhExcedente(bhExcedente);
		tabelaFrete.setRmbh10kg(rmbh10Kg);
		tabelaFrete.setRmbhExcedente(rmbhExcedente);
		tabelaFrete.setInterior10kg(interior10kg);
		tabelaFrete.setInteriorExcedente(interiorExcedente);
		tabelaFrete.setConfinsTaxa(confinsTaxa);
		tabelaFrete.setKmFiorino(kmFiorino);
		tabelaFrete.setKmVanHR(kmVanHR);
		tabelaFrete.setTaxaFiorino1h(taxaFiorino1h);
		tabelaFrete.setTaxaVan1h(taxaVan1h);
		tabelaFrete.setTaxaFiorino2h(taxaFiorino2h);
		tabelaFrete.setTaxaVan2h(taxaVan2h);
		tabelaFrete.setTaxaFiorino4h(taxaFiorino4h);
		tabelaFrete.setTaxaVan4h(taxaVan4h);
		tabelaFrete.setTaxaFiorino6h(taxaFiorino6h);
		tabelaFrete.setTaxaVan6h(taxaVan6h);
		tabelaFrete.setTaxaFiorino8h(taxaFiorino8h);
		tabelaFrete.setTaxaVan8h(taxaVan8h);
		tabelaFrete.setLogin(LoginController.getUltimoLogado());
		
		tabelaFrete.setEmpresa(new EmpresaDAO().lastResult());
		if(tabelaPadrao) {
			try {
				new TabelaFreteDAO().adiconaTabelaFrete(tabelaFrete);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			EmpresaController.setTabelaFrete(tabelaFrete);
		}
	}
	static public void updateTabelaEmpresa(Empresa empresa, BigDecimal bh10kg, BigDecimal bhExcedente,
			BigDecimal rmbh10Kg, BigDecimal rmbhExcedente, BigDecimal interior10kg, BigDecimal interiorExcedente,
			BigDecimal confinsTaxa, BigDecimal kmFiorino, BigDecimal kmVanHR, BigDecimal taxaFiorino1h,
			BigDecimal taxaVan1h, BigDecimal taxaFiorino2h, BigDecimal taxaVan2h, BigDecimal taxaFiorino4h,
			BigDecimal taxaVan4h, BigDecimal taxaFiorino6h, BigDecimal taxaVan6h, BigDecimal taxaFiorino8h,
			BigDecimal taxaVan8h) {
		
		tabelaFrete.setId(null);
		tabelaFrete.setDate(Calendar.getInstance());
		tabelaFrete.setBh10kg(bh10kg);
		tabelaFrete.setBhExcedente(bhExcedente);
		tabelaFrete.setRmbh10kg(rmbh10Kg);
		tabelaFrete.setRmbhExcedente(rmbhExcedente);
		tabelaFrete.setInterior10kg(interior10kg);
		tabelaFrete.setInteriorExcedente(interiorExcedente);
		tabelaFrete.setConfinsTaxa(confinsTaxa);
		tabelaFrete.setKmFiorino(kmFiorino);
		tabelaFrete.setKmVanHR(kmVanHR);
		tabelaFrete.setTaxaFiorino1h(taxaFiorino1h);
		tabelaFrete.setTaxaVan1h(taxaVan1h);
		tabelaFrete.setTaxaFiorino2h(taxaFiorino2h);
		tabelaFrete.setTaxaVan2h(taxaVan2h);
		tabelaFrete.setTaxaFiorino4h(taxaFiorino4h);
		tabelaFrete.setTaxaVan4h(taxaVan4h);
		tabelaFrete.setTaxaFiorino6h(taxaFiorino6h);
		tabelaFrete.setTaxaVan6h(taxaVan6h);
		tabelaFrete.setTaxaFiorino8h(taxaFiorino8h);
		tabelaFrete.setTaxaVan8h(taxaVan8h);
		tabelaFrete.setLogin(LoginController.getUltimoLogado());
		
		new TabelaFreteDAO().adiconaTabelaFrete(tabelaFrete);
	}


	
	static public void preencheTabela(ContentTabela contentTabela, Empresa empresa) {
 
		if(empresa == null) {
		try {
			tabelaFrete = new TabelaFreteDAO().tabelaPadrao().get(0);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		campos = contentTabela;
		} else {
			try {
				tabelaFrete = new TabelaFreteDAO().procuraTabelaEmpresa(empresa.getId());
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			campos = contentTabela;
		}
		
		
		try {
			campos.setTxFBHKG(tabelaFrete.getBh10kg().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFBHExc(tabelaFrete.getBhExcedente().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFRMBHKg(tabelaFrete.getRmbh10kg().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFRMBHExc(tabelaFrete.getRmbhExcedente().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFInterirorKG(tabelaFrete.getInterior10kg().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFInterirorExc(tabelaFrete.getInteriorExcedente().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFTxConfins(tabelaFrete.getConfinsTaxa().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFKmRodadoFiorino(tabelaFrete.getKmFiorino().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFKmRodadoVan(tabelaFrete.getKmVanHR().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFFiorinoh(tabelaFrete.getTaxaFiorino1h().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFVanh(tabelaFrete.getTaxaVan1h().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFFiorino2h(tabelaFrete.getTaxaFiorino2h().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFVan2h(tabelaFrete.getTaxaVan2h().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFFiorino4h(tabelaFrete.getTaxaFiorino4h().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFVan4h(tabelaFrete.getTaxaVan4h().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFFiorino6h(tabelaFrete.getTaxaFiorino6h().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFVan6h(tabelaFrete.getTaxaVan6h().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFFiorino8h(tabelaFrete.getTaxaFiorino8h().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			campos.setTxFVan8h(tabelaFrete.getTaxaVan8h().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
