package br.com.gellog.controller;

import br.com.gellog.dao.EmpresaDAO;
import br.com.gellog.dao.PessoaDAO;
import br.com.gellog.dao.SimpleQueries;
import br.com.gellog.model.FuncionarioCliente;

public class FuncionarioClienteController {
	private static FuncionarioCliente funcionario;
	static public void funcionario(String descricao) {
		funcionario = new FuncionarioCliente();
		
		funcionario.setDescricao(descricao);
		
		funcionario.setPessoa(new PessoaDAO().lastResult());
		funcionario.setEmpresa(new EmpresaDAO().lastResult());
		
		new SimpleQueries().simpleInsert(funcionario);
	}
}
