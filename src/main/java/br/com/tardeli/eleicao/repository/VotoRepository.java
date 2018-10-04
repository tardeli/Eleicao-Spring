package br.com.tardeli.eleicao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tardeli.eleicao.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {
	
}
