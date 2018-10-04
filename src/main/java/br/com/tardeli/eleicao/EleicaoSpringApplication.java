package br.com.tardeli.eleicao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import br.com.tardeli.eleicao.model.Candidato;
import br.com.tardeli.eleicao.model.Cargo;
import br.com.tardeli.eleicao.model.Eleitor;
import br.com.tardeli.eleicao.model.Partido;
import br.com.tardeli.eleicao.model.Voto;
import br.com.tardeli.eleicao.repository.CandidatoRepository;
import br.com.tardeli.eleicao.repository.PartidoRepository;
import br.com.tardeli.eleicao.service.impl.CandidatoServiceImpl;
import br.com.tardeli.eleicao.service.impl.EleitorServiceImpl;
import br.com.tardeli.eleicao.service.impl.PartidoServiceImpl;
import br.com.tardeli.eleicao.service.impl.VotoServiceImpl;

@SpringBootApplication
public class EleicaoSpringApplication implements CommandLineRunner {

	@Autowired
	private CandidatoServiceImpl candidatoServiceImpl;
	
	@Autowired
	private PartidoServiceImpl partidoServiceImpl;
	
	@Autowired
	private EleitorServiceImpl eleitorServiceImpl;
	
	@Autowired
	private VotoServiceImpl votoServiceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(EleicaoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		/*
		//------------------Cadastrar um partido-------------
		Partido p_1 = new Partido(null, "Partido Social", "PS");
		Partido p_2 = new Partido(null, "Partido do Brasil", "PB");
		Partido p_3 = new Partido(null, "Partido Social brasileiro", "PSL");
		Partido p_4 = new Partido(null, "Partido Republicado", "PR");
		
		partidoServiceImpl.salvar(p_1);
		partidoServiceImpl.salvar(p_2);
		partidoServiceImpl.salvar(p_3);
		partidoServiceImpl.salvar(p_4);
			
		Partido p = new Partido();
		p = partidoServiceImpl.buscarPorCodigo(38);
		System.out.println(p);
		
		//------------------Cadastrar um eleitor-------------
		Eleitor e_1 = new Eleitor(12345L, "Fernando Cardoso", "Joana da silva", (short) 12345, (short) 197);
		Eleitor e_2 = new Eleitor(12346L, "Maria da Silva", "Lucia de Almeida", (short) 12346, (short) 198);
		eleitorServiceImpl.salvar(e_1);
		eleitorServiceImpl.salvar(e_2);
		

		Eleitor e = eleitorServiceImpl.buscarPorTitulo(12345L);
		System.out.println(e);
		
		
		//------------------Cadastrar um candidato-------------
		Partido p_1 =  partidoServiceImpl.buscarPorCodigo(40);
		Partido p_2 =  partidoServiceImpl.buscarPorCodigo(37);
		 
		Candidato c_1 = new Candidato(null,"João Rodrigues", 123L, p_1, Cargo.GOVERNADOR);
		Candidato c_2 = new Candidato(null,"Marilse Siqueira", 1243L, p_2, Cargo.DEPUTADO_ESTADUAL);
		candidatoServiceImpl.salvar(c_1);
		candidatoServiceImpl.salvar(c_2);
		
		
		
		//------------------Cadastrar um voto-----------------
		Eleitor e_1 = eleitorServiceImpl.buscarPorTitulo(12345L);
		Eleitor e_2 = eleitorServiceImpl.buscarPorTitulo(12346L);
		Candidato c_1 = candidatoServiceImpl.buscarPorCodigo(42);
		Candidato c_2 = candidatoServiceImpl.buscarPorCodigo(41);
		
		Voto v_1 = new Voto(null, new Date(), 12L, c_1, e_1);
		Voto v_2 = new Voto(null, new Date(), 12L, c_2, e_2);
		
		votoServiceImpl.salvar(v_1);
		votoServiceImpl.salvar(v_2);
		*/
	}
	
}
