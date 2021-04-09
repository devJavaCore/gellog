package br.com.gellog.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tabelaFrete")
public class TabelaFrete {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// (link to login)
	// registroPor
	// modificadoPor

	private BigDecimal bh10kg, rmbh10kg, interior10kg, bhExcedente, rmbhExcedente, interiorExcedente, confinsTaxa,
			kmFiorino, kmVanHR;
	private boolean ativo;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;

	public TabelaFrete() {
		super();
	}

	public TabelaFrete(BigDecimal bh10kg, BigDecimal rmbh10kg, BigDecimal interior10kg, BigDecimal bhExcedente,
			BigDecimal rmbhExcedente, BigDecimal interiorExcedente, BigDecimal confinsTaxa, BigDecimal kmFiorino,
			BigDecimal kmVanHR) {
		super();
		this.bh10kg = bh10kg;
		this.rmbh10kg = rmbh10kg;
		this.interior10kg = interior10kg;
		this.bhExcedente = bhExcedente;
		this.rmbhExcedente = rmbhExcedente;
		this.interiorExcedente = interiorExcedente;
		this.confinsTaxa = confinsTaxa;
		this.kmFiorino = kmFiorino;
		this.kmVanHR = kmVanHR;
		ativo = true;
		date = Calendar.getInstance();
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "TabelaFrete [id=" + id + ", bh10kg=" + bh10kg + ", rmbh10kg=" + rmbh10kg + ", interior10kg="
				+ interior10kg + ", bhExcedente=" + bhExcedente + ", rmbhExcedente=" + rmbhExcedente
				+ ", interiorExcedente=" + interiorExcedente + ", confinsTaxa=" + confinsTaxa + ", kmFiorino="
				+ kmFiorino + ", kmVanHR=" + kmVanHR + ", ativo=" + ativo + ", date=" + date + "]";
	}
	
	
}