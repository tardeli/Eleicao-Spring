package br.com.tardeli.eleicao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tardeli.eleicao.model.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Integer> {
	
}
