package com.estacionamento.controle.domain.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.estacionamento.controle.domain.EmpresaCadastrada;
import com.estacionamento.controle.domain.Endereco;

public class EmpresaCadastradaDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cnpj;
	private Endereco endereco;
	private String telefone;
	private Integer qtdeVagasMotos;
	private Integer qtdeVagasCarros;
	
	public EmpresaCadastradaDto() {}

	public EmpresaCadastradaDto(Integer id,String nome, String cnpj, Endereco endereco, String telefone, Integer qtdeVagasMotos,
			Integer qtdeVagasCarros) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.qtdeVagasMotos = qtdeVagasMotos;
		this.qtdeVagasCarros = qtdeVagasCarros;
	}
	public EmpresaCadastradaDto(EmpresaCadastrada entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cnpj = entity.getCnpj();
		this.endereco = entity.getEndereco();
		this.telefone = entity.getTelefone();
		this.qtdeVagasCarros = entity.getQtdeVagasCarros();
		this.qtdeVagasMotos = entity.getQtdeVagasMotos();
	}

	public Integer getId() {
		return id;
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
	
	public EmpresaCadastrada to() {
		return new EmpresaCadastrada(null, this.nome, this.cnpj, this.endereco, this.telefone, this.qtdeVagasMotos, this.qtdeVagasCarros);
	}
	
	public EmpresaCadastradaDto from(EmpresaCadastrada empresaCadastrada) {
		return new EmpresaCadastradaDto(empresaCadastrada);
	}
}
