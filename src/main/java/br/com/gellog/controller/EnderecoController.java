package br.com.gellog.controller;

import br.com.gellog.dao.SimpleQueries;
import br.com.gellog.model.Endereco;

public class EnderecoController {
	private static Endereco endereco;

	static public void endereco(String Bairro, String Cep, String Cidade, String complemento,
			String estado, String logradouro, Integer numero) {
		endereco = new Endereco();

		endereco.setBairro(Bairro);
		endereco.setCep(Cep);
		endereco.setCidade(Cidade);
		endereco.setComplemento(complemento);
		endereco.setEstado(estado);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		
		new SimpleQueries().simpleInsert(endereco);
	}
}
