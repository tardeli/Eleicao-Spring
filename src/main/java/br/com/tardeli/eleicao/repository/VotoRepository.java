package br.com.tardeli.eleicao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tardeli.eleicao.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {
	@Query("select v from Voto v where v.candidato.codigoRegistro = :candidato")
	List<Voto> porCandidato(@Param("candidato") Integer candidato);
}
