package br.com.gellog.controller;

import java.util.List;

import br.com.gellog.dao.EmpresaDAO;
import br.com.gellog.dao.FuncionarioClienteDAO;
import br.com.gellog.dao.PessoaDAO;
import br.com.gellog.model.Empresa;
import br.com.gellog.model.FuncionarioCliente;

public class FuncionarioClienteController {
	private static FuncionarioCliente funcionario;
	static public void funcionario(String descricao) {
		funcionario = new FuncionarioCliente();
		
		funcionario.setDescricao(descricao);
		
		funcionario.setPessoa(new PessoaDAO().lastResult());
		funcionario.setEmpresa(new EmpresaDAO().lastResult());
		
		new FuncionarioClienteDAO().adiconaFuncionario(funcionario);
	}
	
	static public void updateFuncionario(String descricao, Empresa empresa) {
		
		funcionario = new FuncionarioCliente();
		
		funcionario.setDescricao(descricao);
		
		funcionario.setPessoa(new PessoaDAO().lastResult());
		funcionario.setEmpresa(empresa);
		
		new FuncionarioClienteDAO().adiconaFuncionario(funcionario);
	}
	
	public static List<FuncionarioCliente> getFuncionarioEmpresa(int id) {

		return new FuncionarioClienteDAO().funcionarioPorEmpresaId(id);
	}

	public static void deletaFuncionarioEmpresa(Empresa empresa) {
		List<FuncionarioCliente> funcionarios = new FuncionarioClienteDAO().funcionarioPorEmpresaId(empresa.getId());
		for (FuncionarioCliente funcionarioCliente : funcionarios) {
			new FuncionarioClienteDAO().deleteById(funcionarioCliente, funcionarioCliente.getId());
		}
	}
}
