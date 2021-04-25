package br.com.gellog.controller;

import br.com.gellog.dao.EmpresaDAO;
import br.com.gellog.dao.EnderecoDAO;
import br.com.gellog.dao.FuncionarioClienteDAO;
import br.com.gellog.dao.TabelaFreteDAO;
import br.com.gellog.model.Empresa;

public class EmpresaController {
	private static Empresa empresa;

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
		empresa.setTabela(new TabelaFreteDAO().lastResultEmpresa());
		empresa.setTabelaPadrao(false);
		} else {
			empresa.setTabelaPadrao(true);
			empresa.setTabela(new TabelaFreteDAO().tabelaPadrao());
		}
		
		empresa.setLogin(LoginController.getUltimoLogado());

		new EmpresaDAO().adiconaEmpresa(empresa);
	}
}
