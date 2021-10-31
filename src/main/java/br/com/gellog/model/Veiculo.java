package br.com.gellog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "MOTORISTA_ID")
	private Motorista motorista;
	
String modelo, placa, tipo, descricao;
public Veiculo() {
	super();
}

public Veiculo(String modelo, String placa, String tipo, String descricao) {
	super();
	this.modelo = modelo;
	this.placa = placa;
	this.tipo = tipo;
	this.descricao = descricao;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public String getPlaca() {
	return placa;
}

public void setPlaca(String placa) {
	this.placa = placa;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public Motorista getMotorista() {
	return motorista;
}

public void setMotorista(Motorista motorista) {
	this.motorista = motorista;
}	
	
}
