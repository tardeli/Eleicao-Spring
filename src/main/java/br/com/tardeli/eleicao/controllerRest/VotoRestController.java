package br.com.tardeli.eleicao.controllerRest;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tardeli.eleicao.model.Voto;
import br.com.tardeli.eleicao.model.Cargo;
import br.com.tardeli.eleicao.service.impl.VotoServiceImpl;
import br.com.tardeli.eleicao.service.impl.CandidatoServiceImpl;
import br.com.tardeli.eleicao.service.impl.EleitorServiceImpl;
import br.com.tardeli.eleicao.service.impl.PartidoServiceImpl;

@RestController
@RequestMapping("/rest/voto")
@ResponseBody
public class VotoRestController {
	
	@Autowired
	private VotoServiceImpl votoServiceImpl;
	
	@Autowired
	private CandidatoServiceImpl candidatoServiceImpl;
	
	@Autowired
	private EleitorServiceImpl eleitorServiceImpl;
		
	@GetMapping("/listar")
	public List<Voto> listar() {
		return votoServiceImpl.listar();
	}
	
	@GetMapping("/listar/{codigo}")
	public Voto listarPorId(@PathVariable("codigo") Long codigo) {
		return votoServiceImpl.buscarPorCodigo(codigo);
	}
	
	@GetMapping("/listarporcandidato/{candidato}")
	public List<Voto> listarPorCandidato(@PathVariable("candidato") Integer candidato) {
		return votoServiceImpl.porCandidato(candidato);
	}
	
	@PostMapping("/salvar")
	public void salvar(@RequestBody Voto voto) {
		votoServiceImpl.salvar(voto);
	}
	
	@PutMapping("/atualizar")
	public void alterar(@RequestBody Voto voto) {
		votoServiceImpl.salvar(voto);
	}
	
	@DeleteMapping("/deletar/{codigo}")
	public void deletar(@PathVariable("codigo") Long codigo) {
		Voto voto = votoServiceImpl.buscarPorCodigo(codigo);
		votoServiceImpl.excluir(voto);
	}
	

}
