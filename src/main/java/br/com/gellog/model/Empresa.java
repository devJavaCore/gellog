package br.com.gellog.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;
	
	private String nome, cnpj, inscricaoEstadual, telefone, email;
	
	@OneToMany(mappedBy = "empresa")
	private List<FuncionarioCliente> funcionario = new ArrayList<>();
		 
	 @OneToOne
	 private Endereco endereco;
	 
	 @OneToOne
	 private TabelaFreteModel tabela;
	 
	 @ManyToOne
		@JoinColumn(name = "LOGIN_ID")
		private Login login;

	public Empresa() {
		super();
		date = Calendar.getInstance();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public TabelaFreteModel getTabela() {
		return tabela;
	}

	public void setTabela(TabelaFreteModel tabela) {
		this.tabela = tabela;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<FuncionarioCliente> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<FuncionarioCliente> funcionario) {
		this.funcionario = funcionario;
	}
	
}
