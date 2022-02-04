package com.estacionamento.controle.resource;

import java.net.URI;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estacionamento.controle.domain.Veiculo;
import com.estacionamento.controle.domain.dto.VeiculoDto;
import com.estacionamento.controle.services.VeiculosService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculosResource {

	@Autowired
	private VeiculosService service;

	@GetMapping
	public ResponseEntity<Iterable<Veiculo>> findAll() {
		Iterable<Veiculo> list = service.findAll();
		//Stream<Object> listDto = list.stream().map(
		//		obj -> new VeiculosDto(obj.getId(), obj.getMarca(), obj.getModelo(), obj.getCor(), obj.getPlaca(), obj.getTipo()));
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		var veiculoDto = service.find(id);
		return ResponseEntity.ok().body(veiculoDto);
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody VeiculoDto veiculoDto){
		var veiculosDto = service.insert(veiculoDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculosDto.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
}
