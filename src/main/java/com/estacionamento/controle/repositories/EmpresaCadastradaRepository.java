package com.estacionamento.controle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estacionamento.controle.domain.EmpresaCadastrada;
import com.estacionamento.controle.domain.dto.EmpresaCadastradaDto;

public interface EmpresaCadastradaRepository extends JpaRepository<EmpresaCadastrada, Integer>{

	void save(EmpresaCadastradaDto empresaCadastrada);

}
