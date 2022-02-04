package com.estacionamento.controle.domain.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.estacionamento.controle.domain.VagasEstacionamento;
import com.estacionamento.controle.domain.Veiculo;

@Entity
public class VeiculoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private String tipo;
	
	@ManyToOne(cascade=CascadeType.ALL) @JoinColumn(name = "VagasEstacionamento_id")
	private VagasEstacionamento vaga;
	
	public VeiculoDto() {}

	public VeiculoDto(Integer id, String marca, String modelo, String cor, String placa, String tipo) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.tipo = tipo;
	}

	public VeiculoDto(Veiculo entity) {
		this.id = entity.getId();
		this.marca = entity.getMarca();
		this.modelo = entity.getModelo();
		this.cor = entity.getCor();
		this.placa = entity.getPlaca();
		this.tipo = entity.getTipo();
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

	public Integer getId() {
		return id;
	}
	
	public Veiculo to() {
		return new Veiculo(null, this.marca, this.modelo, this.cor, this.placa, this.tipo);
	}
	
	public VeiculoDto from(Veiculo veiculo) {
		return new VeiculoDto(veiculo);
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VagasEstacionamento getVaga() {
		return vaga;
	}

	public void setVaga(VagasEstacionamento vaga) {
		this.vaga = vaga;
	}
	
}
