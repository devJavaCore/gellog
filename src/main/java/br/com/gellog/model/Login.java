package br.com.gellog.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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

import br.com.gellog.util.NivelUsuario;

@Entity
@Table(name = "login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String userName, password;

	@Enumerated
	private NivelUsuario NivelUsuario;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;

	@OneToOne
	private Pessoa pessoa;
	//
	@OneToMany(mappedBy = "login")
	private List<TabelaFreteModel> tabelafretemodel = new ArrayList<>();

	@OneToMany(mappedBy = "login")
	private List<Empresa> empresa = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "TABELALOGIN_ID")
	private TabelaLogin tabelaLogin;

	public Login() {
		super();
		date = Calendar.getInstance();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public NivelUsuario getNivelUsuario() {
		return NivelUsuario;
	}

	public void setNivelUsuario(NivelUsuario nivelUsuario) {
		NivelUsuario = nivelUsuario;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<TabelaFreteModel> getTabelafretemodel() {
		return tabelafretemodel;
	}

	public void setTabelafretemodel(List<TabelaFreteModel> tabelafretemodel) {
		this.tabelafretemodel = tabelafretemodel;
	}

	public List<Empresa> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(List<Empresa> empresa) {
		this.empresa = empresa;
	}

	public TabelaLogin getTabelaLogin() {
		return tabelaLogin;
	}

	public void setTabelaLogin(TabelaLogin tabelaLogin) {
		this.tabelaLogin = tabelaLogin;
	}

}
