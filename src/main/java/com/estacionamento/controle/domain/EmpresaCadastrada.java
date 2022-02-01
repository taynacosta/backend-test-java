package com.estacionamento.controle.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EmpresaCadastrada implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cnpj;
	
	@OneToOne
	private Endereco endereco;
	private String telefone;
	private Integer qtdeVagasMotos;
	private Integer qtdeVagasCarros;
	
	public EmpresaCadastrada() {}

	public EmpresaCadastrada(Integer id, String nome, String cnpj, Endereco endereco, String telefone, Integer qtdeVagasMotos,
			Integer qtdeVagasCarros) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.qtdeVagasMotos = qtdeVagasMotos;
		this.qtdeVagasCarros = qtdeVagasCarros;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public Integer getQtdeVagasMotos() {
		return qtdeVagasMotos;
	}

	public Integer getQtdeVagasCarros() {
		return qtdeVagasCarros;
	}
	
}
