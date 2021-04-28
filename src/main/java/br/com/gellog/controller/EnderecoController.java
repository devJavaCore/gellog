package br.com.gellog.controller;

import br.com.gellog.dao.EnderecoDAO;
import br.com.gellog.model.Endereco;

public class EnderecoController {
	private static Endereco endereco;

	static public void endereco(String Bairro, String Cep, String Cidade, String complemento,
			String estado, String logradouro, String numero) {
		endereco = new Endereco();

		endereco.setBairro(Bairro);
		endereco.setCep(Cep);
		endereco.setCidade(Cidade);
		endereco.setComplemento(complemento);
		endereco.setEstado(estado);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		
		new EnderecoDAO().adicionaEndereco(endereco);
	}
	static public void updateEndereco(Endereco endereco, String Bairro, String Cep, String Cidade, String complemento,
			String estado, String logradouro, String numero) {
		endereco = new Endereco();

		endereco.setId(null);
		endereco.setBairro(Bairro);
		endereco.setCep(Cep);
		endereco.setCidade(Cidade);
		endereco.setComplemento(complemento);
		endereco.setEstado(estado);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		
		new EnderecoDAO().adicionaEndereco(endereco);
	}
}
