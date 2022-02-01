package com.estacionamento.controle.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estacionamento.controle.domain.Endereco;
import com.estacionamento.controle.domain.dto.EnderecoDto;
import com.estacionamento.controle.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService service;

	@GetMapping
	public ResponseEntity<Iterable<Endereco>> findAll() {
		Iterable<Endereco> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		var enderecoDto = service.find(id);
		return ResponseEntity.ok().body(enderecoDto);
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody EnderecoDto enderecosDto){
		var enderecoDto = service.insert(enderecosDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(enderecoDto.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
}
