package com.estacionamento.controle.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamento.controle.domain.VagasEstacionamento;
import com.estacionamento.controle.domain.Veiculo;
import com.estacionamento.controle.domain.dto.VeiculoDto;
import com.estacionamento.controle.repositories.VagasEstacionamentoRepository;
import com.estacionamento.controle.repositories.VeiculosRepository;

@Service
public class VagasService {

	@Autowired
	private VeiculosRepository veiculosRepository;
	
	@Autowired
	private VagasEstacionamentoRepository vagasRepository;
	
	Set<Veiculo> veiculo = new HashSet<>();
	VagasEstacionamento carroEstacionado = new VagasEstacionamento();
	// estaciona
	public VeiculoDto insert(VeiculoDto veiculoDto) {
		return null;
	}
	// metodo para retirar carro estacionado

	
	public VagasEstacionamento estacionar(VeiculoDto veiculoDto) throws Exception {
		List<VagasEstacionamento> vagas = vagasRepository.findAll();
		if (vagas.contains(veiculoDto)) {
			throw new Exception("veiculo já está estacionado");
		}

		if (vagas.size() < 15) {
			veiculo.add(veiculoDto.to());
			carroEstacionado.setVeiculos(veiculo);
			vagasRepository.save(carroEstacionado);
			return carroEstacionado;
			
		} else {
			throw new Exception("Estacionamento cheio");
		
		}
	}
}
