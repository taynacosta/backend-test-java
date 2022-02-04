package com.estacionamento.controle.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estacionamento.controle.domain.VagasEstacionamento;
import com.estacionamento.controle.domain.dto.VeiculoDto;
import com.estacionamento.controle.services.VagasService;

@RestController
@RequestMapping(value = "/estacionamento")
public class VagasEstacionamentoResource {

	@Autowired
	private VagasService service;
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody VeiculoDto veiculoDto) throws Exception{
		VagasEstacionamento vagasEstacionamento = service.estacionar(veiculoDto);
		return ResponseEntity.ok().body(vagasEstacionamento);
	}
}
