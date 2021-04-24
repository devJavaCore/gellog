package br.com.gellog.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tabelaLogin")
public class TabelaLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;
	
	@ManyToOne
	@JoinColumn(name = "LOGIN_ID")
	private Login login;
	
	public TabelaLogin() {
		super();
	}

	public TabelaLogin(Login login) {
		super();
		this.login = login;
		date = Calendar.getInstance();
	}
	
}
