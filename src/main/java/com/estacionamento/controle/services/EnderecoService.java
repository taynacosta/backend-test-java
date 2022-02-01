package com.estacionamento.controle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamento.controle.domain.Endereco;
import com.estacionamento.controle.domain.dto.EnderecoDto;
import com.estacionamento.controle.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;

	public Iterable<Endereco> findAll() {
		return repository.findAll();
	}

	public Endereco find(Integer id) {
		Endereco obj = repository.findById(id).get();
		return obj;
	}
	
	public EnderecoDto insert(EnderecoDto enderecoDto) {
		var endereco = enderecoDto.to();
		repository.save(endereco);
		return enderecoDto.from(endereco);
	}
}
