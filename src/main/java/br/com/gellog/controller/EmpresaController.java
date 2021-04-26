package br.com.gellog.controller;

import br.com.gellog.dao.EmpresaDAO;
import br.com.gellog.dao.EnderecoDAO;
import br.com.gellog.dao.FuncionarioClienteDAO;
import br.com.gellog.dao.SimpleQueries;
import br.com.gellog.dao.TabelaFreteDAO;
import br.com.gellog.model.Empresa;
import br.com.gellog.model.TabelaFreteModel;

public class EmpresaController {
	private static Empresa empresa;
	private static TabelaFreteModel tabela;

	static public void empresa(boolean tabelaPadrao, String cnpj, String email, String inscricaoEstadual, String RazaoSocial,
			String telefone) {
		empresa = new Empresa();

		empresa.setCnpj(cnpj);
		empresa.setEmail(email);
		empresa.setInscricaoEstadual(inscricaoEstadual);
		empresa.setNome(RazaoSocial);
		empresa.setTelefone(telefone);
		empresa.setEndereco(new EnderecoDAO().lastResult());
		empresa.setFuncionario(new FuncionarioClienteDAO().resultList());
		
		if(!tabelaPadrao) {
		empresa.setTabelaPadrao(false);
		} else {
			empresa.setTabelaPadrao(true);
		}
		
		empresa.setLogin(LoginController.getUltimoLogado());

		new EmpresaDAO().adiconaEmpresa(empresa);
		
		if(!tabelaPadrao) {
			tabela.setEmpresa(new EmpresaDAO().lastResult());
			new SimpleQueries().simpleInsert(tabela);
			} else {
				new TabelaFreteDAO().tabelaPadrao();
			}
	}

	public static TabelaFreteModel getTabelaFrete() {
		return tabela;
	}

	public static void setTabelaFrete(TabelaFreteModel tabelaFrete) {
		tabela = tabelaFrete;
	}


	
}
