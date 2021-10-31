package br.com.gellog.controller;

import br.com.gellog.dao.PessoaDAO;
import br.com.gellog.model.Pessoa;

public class PessoaController {
	private static Pessoa pessoa;
	static public void pessoa(String nome, String telefone, String email) {
		
		pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setTelefone(telefone);
		pessoa.setEmail(email);
		
		new PessoaDAO().adiconaPessoa(pessoa);
	}
	/*
	static public void updateMotorista(Motorista pessoa, String nome, String cpf, String telefone, String telefone2, String email) {
		pessoa.setNome(nome);
		pessoa.setCpf(cpf);
		pessoa.setTelefone(telefone);
		pessoa.setTelefone2(telefone2);
		pessoa.setEmail(email);
		pessoa.setEndereco(new EnderecoDAO().lastResult());
		new PessoaDAO().updatePessoa(pessoa);
	}
	*/
}
