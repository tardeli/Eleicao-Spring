package br.com.tardeli.eleicao.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tardeli.eleicao.model.Candidato;
import br.com.tardeli.eleicao.model.Cargo;
import br.com.tardeli.eleicao.repository.CandidatoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CandidatoTest {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void criar() {
		Candidato candidato = new Candidato(null, "Altobeli", 12L, null, Cargo.DEPUTADO_FEDERAL);
		this.candidatoRepository.save(candidato);
	}

}
