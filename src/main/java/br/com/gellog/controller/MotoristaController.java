package br.com.gellog.controller;

import java.util.Calendar;
import java.util.List;

import br.com.gellog.dao.EnderecoDAO;
import br.com.gellog.dao.MotoristaDAO;
import br.com.gellog.dao.PessoaDAO;
import br.com.gellog.dao.VeiculoDAO;
import br.com.gellog.model.Motorista;
import br.com.gellog.model.Pessoa;

public class MotoristaController {
	private static Motorista motorista;

	
	static public void adicionaMotorista(String nome, String cpf, String telefone, String telefone2, String email) {
		motorista = new Motorista();
		motorista.setNome(nome);
		motorista.setCpf(cpf);
		motorista.setTelefone(telefone);
		motorista.setTelefone2(telefone2);
		motorista.setEmail(email);
		motorista.setEndereco(new EnderecoDAO().lastResult());
		
		new PessoaDAO().adiconaPessoa(motorista);	
		motorista.setVeiculo(new VeiculoDAO().resultList());
		motorista.setLogin(LoginController.getUltimoLogado());
		new PessoaDAO().updatePessoa(motorista);
	}
	
	static public void updateMotorista(Motorista motorista, String nome, String cpf, String email, String telefone, String telefone2) {

		motorista.setCpf(cpf);
		motorista.setEmail(email);
		motorista.setNome(nome);
		motorista.setTelefone(telefone);
		motorista.setTelefone2(telefone2);
		motorista.setLogin(LoginController.getUltimoLogado());
		motorista.setDate(Calendar.getInstance());
		
		new PessoaDAO().updatePessoa(motorista);
	}
	
	public static List<Pessoa> getMotoristaPeloNome(String nome) {

		return new MotoristaDAO().comparaNome(nome);
	}

	public static List<Motorista> getMotoristaPeloCPF(String cPF) {

		return new MotoristaDAO().comparaCPF(cPF);
	}
	
	public static Motorista getMotoristaPeloId(int id) {

		return new MotoristaDAO().procuraMotoristaid(id);
	}
}
