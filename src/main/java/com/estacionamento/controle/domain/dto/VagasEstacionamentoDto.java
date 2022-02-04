package com.estacionamento.controle.domain.dto;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.estacionamento.controle.domain.VagasEstacionamento;
import com.estacionamento.controle.domain.Veiculo;

@Entity
public class VagasEstacionamentoDto implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private final Integer vagasDecarro = 15;

	private final Integer vagasDeMoto = 5;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaga")
	private Set<Veiculo> veiculos = new LinkedHashSet<>();

	public VagasEstacionamentoDto(VagasEstacionamento vagas) {
	}
	public VagasEstacionamentoDto() {
	}	

	public VagasEstacionamentoDto(Integer id, Set<Veiculo> veiculos) {
		this.id = id;
		this.veiculos = veiculos;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Set<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Integer getVagasDecarro() {
		return vagasDecarro;
	}

	public Integer getVagasDeMoto() {
		return vagasDeMoto;
	}
	

	public VagasEstacionamento to() {
		return new VagasEstacionamento(null, this.veiculos);
	}
	
	public VagasEstacionamentoDto from(VagasEstacionamento vagas) {
		return new VagasEstacionamentoDto(vagas);
	}
}
