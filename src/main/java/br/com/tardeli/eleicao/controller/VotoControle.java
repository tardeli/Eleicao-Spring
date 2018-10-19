package br.com.tardeli.eleicao.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tardeli.eleicao.model.Voto;
import br.com.tardeli.eleicao.model.Cargo;
import br.com.tardeli.eleicao.service.impl.VotoServiceImpl;
import br.com.tardeli.eleicao.service.impl.CandidatoServiceImpl;
import br.com.tardeli.eleicao.service.impl.EleitorServiceImpl;
import br.com.tardeli.eleicao.service.impl.PartidoServiceImpl;

@Controller
@RequestMapping("/voto")
public class VotoControle {
	
	@Autowired
	private VotoServiceImpl votoServiceImpl;
	
	@Autowired
	private CandidatoServiceImpl candidatoServiceImpl;
	
	@Autowired
	private EleitorServiceImpl eleitorServiceImpl;
	
	@GetMapping("/")
	public String home() {
		return "../index";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("candidatos", candidatoServiceImpl.listar());
		model.addAttribute("votos", votoServiceImpl.listar());
		return "voto/listar";
	}
	
	@GetMapping("/listarporcandidato/{candidato}")
	public String listarPorCandidato(@PathVariable("candidato") Integer candidato, Model model) {
		model.addAttribute("candidatos", candidatoServiceImpl.listar());
		model.addAttribute("votos", votoServiceImpl.porCandidato(candidato));
		return "voto/listar";
	}
	
	@GetMapping("/novo")
	public String formulario(Model model) {
		model.addAttribute("candidatos", candidatoServiceImpl.listar());
		model.addAttribute("eleitores", eleitorServiceImpl.listar());	
		return "voto/novo";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Voto voto, BindingResult erros) {
		if (erros.hasErrors()) {
			return "voto/novo";
		}
		votoServiceImpl.salvar(voto);
		return "redirect:/voto/listar";
	}
	
	@GetMapping("/visualizar/{codigo}")
	public String visualizar(@PathVariable("codigo") Long codigo, Model model) {
		model.addAttribute("voto", votoServiceImpl.buscarPorCodigo(codigo));
		model.addAttribute("candidatos", candidatoServiceImpl.listar());
		model.addAttribute("eleitores", eleitorServiceImpl.listar());
		return "voto/visualizar";
	}
	
	@PostMapping("/alterar")
	public String alterar(@Valid Voto voto, BindingResult erros) {
		if (erros.hasErrors()) {
			return "voto/visualizar";
		}
		votoServiceImpl.salvar(voto);
		return "redirect:/voto/listar";
	}
	
	@GetMapping("/deletar/{codigo}")
	public String deletar(@PathVariable("codigo") Long codigo) {
		Voto voto = votoServiceImpl.buscarPorCodigo(codigo);
		votoServiceImpl.excluir(voto);
		return "redirect:/voto/listar";
	}

}
