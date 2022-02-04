package com.estacionamento.controle.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Veiculo implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private String tipo;
	
	@ManyToOne(cascade=CascadeType.ALL) @JoinColumn(name = "VagasEstacionamento_id") //@JsonIgnore
	private VagasEstacionamento vaga;
	
	public Veiculo() {}

	public Veiculo(Integer id, String marca, String modelo, String cor, String placa, String tipo) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCor() {
		return cor;
	}

	public String getPlaca() {
		return placa;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public VagasEstacionamento getVaga() {
		return vaga;
	}
	
}
