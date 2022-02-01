package com.estacionamento.controle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamento.controle.repositories.VeiculosRepository;

@Service
public class DBServices {

	@Autowired
	private VeiculosRepository veiculosRepository;
	
	public void instantiateTestDatabase() {
		
	}
	
	
}
