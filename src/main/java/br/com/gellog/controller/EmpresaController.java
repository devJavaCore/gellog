package br.com.gellog.controller;

import br.com.gellog.dao.EnderecoDAO;
import br.com.gellog.dao.FuncionarioClienteDAO;
import br.com.gellog.dao.SimpleQueries;
import br.com.gellog.dao.TabelaFreteDAO;
import br.com.gellog.model.Empresa;
import br.com.gellog.model.TabelaFreteModel;

public class EmpresaController {
	private static Empresa empresa;

	static public void adicionaEmpresa(boolean tabelaPadrao, String cnpj, String email, String inscricaoEstadual, String RazaoSocial,
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
		empresa.setTabela(new TabelaFreteDAO().lastResult());
		} else {
			empresa.setTabela((TabelaFreteModel) new SimpleQueries().idSearch(new TabelaFreteModel(), 1));
		}
		empresa.setLogin(LoginController.getUltimoLogado());
		
		new SimpleQueries().simpleInsert(empresa);
	}
}
