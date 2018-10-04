package br.com.tardeli.eleicao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tardeli.eleicao.model.Eleitor;

public interface EleitorRepository extends JpaRepository<Eleitor, Integer> {
	@Query("select e from Eleitor e where e.numeroTitulo = :titulo")
	Eleitor buscarPorTitulo(@Param("titulo") Long titulo);
}
