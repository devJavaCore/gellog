package br.com.gellog.controller;

import br.com.gellog.dao.SimpleQueries;
import br.com.gellog.model.Pessoa;

public class PessoaController {
	private static Pessoa pessoa;
	static public void pessoa(String nome, String telefone, String email) {
		
		pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setTelefone(telefone);
		pessoa.setEmail(email);
		
		new SimpleQueries().simpleInsert(pessoa);
	}
}
