package com.estacionamento.controle.domain;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VagasEstacionamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private final Integer vagasDecarro = 15;

	private final Integer vagasDeMoto = 5;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaga")
	private Set<Veiculo> veiculos = new LinkedHashSet<>();

	public VagasEstacionamento() {
	}

	public VagasEstacionamento(Integer id, Set<Veiculo> veiculos) {
		super();
		this.id = id;
		this.veiculos = veiculos;
	}



	/*public void estacionar(Veiculo veiculo) throws Exception {
		if (getVeiculos().contains(veiculo)) {
			throw new Exception("veiculo já esta estacionado");
		}

		if (getVeiculos().size() < 15) {
			getVeiculos().add(veiculo);
			
		} else {
			throw new Exception("Estacionamento cheio");
		}
	}*/

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

}
