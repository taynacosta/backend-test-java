package com.estacionamento.controle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estacionamento.controle.domain.VagasEstacionamento;

public interface VagasEstacionamentoRepository extends JpaRepository<VagasEstacionamento, Integer>{

}
