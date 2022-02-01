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

import com.estacionamento.controle.domain.EmpresaCadastrada;
import com.estacionamento.controle.domain.dto.EmpresaCadastradaDto;
import com.estacionamento.controle.services.EmpresasService;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresasResource {

	@Autowired
	private EmpresasService service;

	@GetMapping
	public ResponseEntity<Iterable<EmpresaCadastrada>> findAll() {
		Iterable<EmpresaCadastrada> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		var EmpresasCadastradasDto = service.find(id);
		return ResponseEntity.ok().body(EmpresasCadastradasDto);
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody EmpresaCadastradaDto empresaCadastradasDto){
		var empresasCadastradasDto = service.insert(empresaCadastradasDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empresasCadastradasDto.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
}
