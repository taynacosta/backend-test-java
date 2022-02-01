package com.estacionamento.controle.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String estado;
	private String cidade;
	private String rua;
	private Integer numero;
	private String referencia;
	
	@OneToOne @JsonIgnore
	private EmpresaCadastrada empresa;
	
	public Endereco() {}

	public Endereco(Integer id, String estado, String cidade, String rua, Integer numero, String referencia) {
		this.id = id;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.numero = numero;
		this.referencia = referencia;
	}

	public Integer getId() {
		return id;
	}
	
	public String getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}

	public String getRua() {
		return rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getReferencia() {
		return referencia;
	}

	public EmpresaCadastrada getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(EmpresaCadastrada empresa) {
		this.empresa = empresa;
	}
	
}
