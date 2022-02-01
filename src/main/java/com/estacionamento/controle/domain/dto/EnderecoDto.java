package com.estacionamento.controle.domain.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.estacionamento.controle.domain.EmpresaCadastrada;
import com.estacionamento.controle.domain.Endereco;

@Entity
public class EnderecoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String estado;
	private String cidade;
	private String rua;
	private Integer numero;
	private String referencia;
	private EmpresaCadastrada empresa;

	public EnderecoDto() {}

	public EnderecoDto(Integer id, String estado, String cidade, String rua, Integer numero, String referencia) {
		this.id = id;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.numero = numero;
		this.referencia = referencia;
	}
	
	public EnderecoDto(Endereco entity) {
		this.id = entity.getId();
		this.estado = entity.getEstado();
		this.cidade = entity.getCidade();
		this.rua = entity.getRua();
		this.numero = entity.getNumero();
		this.referencia = entity.getReferencia();
	}
	
	public Endereco to() {
		return new Endereco(null, this.estado, this.cidade, this.rua, this.numero, this.referencia);
	}
	
	public EnderecoDto from(Endereco endereco) {
		return new EnderecoDto(endereco);
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
}
