package com.estacionamento.controle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamento.controle.domain.Veiculo;
import com.estacionamento.controle.domain.dto.VeiculoDto;
import com.estacionamento.controle.repositories.VeiculosRepository;

@Service
public class VeiculosService {
	
	@Autowired
	private VeiculosRepository repository;

	public Iterable<Veiculo> findAll() {
		return repository.findAll();
	}

	public Veiculo find(Integer id) {
		Veiculo obj = repository.findById(id).get();
		return obj;
	}
	
	public VeiculoDto insert(VeiculoDto veiculoDto) {
		var veiculos = veiculoDto.to();
		repository.save(veiculos);
		return veiculoDto.from(veiculos);
	}
}
