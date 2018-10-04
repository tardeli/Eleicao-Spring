package br.com.tardeli.eleicao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tardeli.eleicao.model.Candidato;
import br.com.tardeli.eleicao.model.Cargo;
import br.com.tardeli.eleicao.repository.CandidatoRepository;

@SpringBootApplication
public class EleicaoSpringApplication implements CommandLineRunner {

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EleicaoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Candidato candidato = new Candidato();
		candidato.setCargo(Cargo.GOVERNADOR);
		candidato.setCpf(1545L);
		candidato.setNome("Marilse");
		candidato.setPartido(null);
		
		candidatoRepository.save(candidato);
		
	}
	
	
}
