package com.estacionamento.controle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamento.controle.domain.EmpresaCadastrada;
import com.estacionamento.controle.domain.dto.EmpresaCadastradaDto;
import com.estacionamento.controle.repositories.EmpresaCadastradaRepository;
import com.estacionamento.controle.repositories.EnderecoRepository;

@Service
public class EmpresasService {

	@Autowired
	private EmpresaCadastradaRepository empresasRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Iterable<EmpresaCadastrada> findAll() {
		return empresasRepository.findAll();
	}

	public EmpresaCadastrada find(Integer id) {
		EmpresaCadastrada obj = empresasRepository.findById(id).get();
		return obj;
	}
	
	public EmpresaCadastradaDto insert(EmpresaCadastradaDto empresasCadastradasDto) {
		var empresasCadastradas = empresasCadastradasDto.to();
		
		enderecoRepository.save(empresasCadastradas.getEndereco());
		empresasRepository.save(empresasCadastradas);
		return empresasCadastradasDto.from(empresasCadastradas);
	}
}
