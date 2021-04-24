package br.com.gellog.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tabelaFrete")
public class TabelaFreteModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private BigDecimal bh10kg, rmbh10kg, interior10kg, bhExcedente, rmbhExcedente, interiorExcedente, confinsTaxa,
			kmFiorino, kmVanHR, taxaFiorino1h, taxaVan1h, taxaFiorino2h, taxaVan2h, taxaFiorino4h, taxaVan4h, taxaFiorino6h, taxaVan6h, taxaFiorino8h, taxaVan8h;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;
	
	@ManyToOne
	@JoinColumn(name = "LOGIN_ID")
	private Login login;	
	
	@OneToOne(mappedBy="tabela")	 
	private Empresa empresa;
	 
	public TabelaFreteModel() {
		super();
		date = Calendar.getInstance();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getBh10kg() {
		return bh10kg;
	}

	public void setBh10kg(BigDecimal bh10kg) {
		this.bh10kg = bh10kg;
	}

	public BigDecimal getRmbh10kg() {
		return rmbh10kg;
	}

	public void setRmbh10kg(BigDecimal rmbh10kg) {
		this.rmbh10kg = rmbh10kg;
	}

	public BigDecimal getInterior10kg() {
		return interior10kg;
	}

	public void setInterior10kg(BigDecimal interior10kg) {
		this.interior10kg = interior10kg;
	}

	public BigDecimal getBhExcedente() {
		return bhExcedente;
	}

	public void setBhExcedente(BigDecimal bhExcedente) {
		this.bhExcedente = bhExcedente;
	}

	public BigDecimal getRmbhExcedente() {
		return rmbhExcedente;
	}

	public void setRmbhExcedente(BigDecimal rmbhExcedente) {
		this.rmbhExcedente = rmbhExcedente;
	}

	public BigDecimal getInteriorExcedente() {
		return interiorExcedente;
	}

	public void setInteriorExcedente(BigDecimal interiorExcedente) {
		this.interiorExcedente = interiorExcedente;
	}

	public BigDecimal getConfinsTaxa() {
		return confinsTaxa;
	}

	public void setConfinsTaxa(BigDecimal confinsTaxa) {
		this.confinsTaxa = confinsTaxa;
	}

	public BigDecimal getKmFiorino() {
		return kmFiorino;
	}

	public void setKmFiorino(BigDecimal kmFiorino) {
		this.kmFiorino = kmFiorino;
	}

	public BigDecimal getKmVanHR() {
		return kmVanHR;
	}

	public void setKmVanHR(BigDecimal kmVanHR) {
		this.kmVanHR = kmVanHR;
	}

	public BigDecimal getTaxaFiorino1h() {
		return taxaFiorino1h;
	}

	public void setTaxaFiorino1h(BigDecimal taxaFiorino1h) {
		this.taxaFiorino1h = taxaFiorino1h;
	}

	public BigDecimal getTaxaVan1h() {
		return taxaVan1h;
	}

	public void setTaxaVan1h(BigDecimal taxaVan1h) {
		this.taxaVan1h = taxaVan1h;
	}

	public BigDecimal getTaxaFiorino2h() {
		return taxaFiorino2h;
	}

	public void setTaxaFiorino2h(BigDecimal taxaFiorino2h) {
		this.taxaFiorino2h = taxaFiorino2h;
	}

	public BigDecimal getTaxaVan2h() {
		return taxaVan2h;
	}

	public void setTaxaVan2h(BigDecimal taxaVan2h) {
		this.taxaVan2h = taxaVan2h;
	}

	public BigDecimal getTaxaFiorino4h() {
		return taxaFiorino4h;
	}

	public void setTaxaFiorino4h(BigDecimal taxaFiorino4h) {
		this.taxaFiorino4h = taxaFiorino4h;
	}

	public BigDecimal getTaxaVan4h() {
		return taxaVan4h;
	}

	public void setTaxaVan4h(BigDecimal taxaVan4h) {
		this.taxaVan4h = taxaVan4h;
	}

	public BigDecimal getTaxaFiorino6h() {
		return taxaFiorino6h;
	}

	public void setTaxaFiorino6h(BigDecimal taxaFiorino6h) {
		this.taxaFiorino6h = taxaFiorino6h;
	}

	public BigDecimal getTaxaVan6h() {
		return taxaVan6h;
	}

	public void setTaxaVan6h(BigDecimal taxaVan6h) {
		this.taxaVan6h = taxaVan6h;
	}

	public BigDecimal getTaxaFiorino8h() {
		return taxaFiorino8h;
	}

	public void setTaxaFiorino8h(BigDecimal taxaFiorino8h) {
		this.taxaFiorino8h = taxaFiorino8h;
	}

	public BigDecimal getTaxaVan8h() {
		return taxaVan8h;
	}

	public void setTaxaVan8h(BigDecimal taxaVan8h) {
		this.taxaVan8h = taxaVan8h;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

		public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	}