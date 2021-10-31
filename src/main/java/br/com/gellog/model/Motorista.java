package br.com.gellog.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "motorista")
public class Motorista extends Pessoa {
	
	@OneToOne
	private Pessoa pessoa;
	
	@OneToMany(mappedBy = "motorista")
	private List<Veiculo> veiculo = new ArrayList<>();
		
	private BigDecimal recebido, areceber;
	String descricao;

	public Motorista() {
		super();
	}


	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}




	public BigDecimal getRecebido() {
		return recebido;
	}

	public void setRecebido(BigDecimal recebido) {
		this.recebido = recebido;
	}

	public BigDecimal getAreceber() {
		return areceber;
	}

	public void setAreceber(BigDecimal areceber) {
		this.areceber = areceber;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}	

	
}
