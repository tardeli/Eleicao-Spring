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

import br.com.tardeli.eleicao.model.Candidato;
import br.com.tardeli.eleicao.model.Cargo;
import br.com.tardeli.eleicao.service.impl.CandidatoServiceImpl;
import br.com.tardeli.eleicao.service.impl.PartidoServiceImpl;

@Controller
@RequestMapping("/candidato")
public class CandidatoControle {
	
	@Autowired
	private CandidatoServiceImpl candidatoServiceImpl;
	
	@Autowired
	private PartidoServiceImpl partidoServiceImpl;
	
	@GetMapping("/")
	public String home() {
		return "../index";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("candidatos", candidatoServiceImpl.listar());
		return "candidato/listar";
	}
	
	@GetMapping("/novo")
	public String formulario(Model model) {
		model.addAttribute("partidos", partidoServiceImpl.listar());
		model.addAttribute("cargos", Arrays.asList(Cargo.values()));
		return "candidato/novo";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Candidato candidato, BindingResult erros) {
		if (erros.hasErrors()) {
			return "candidato/novo";
		}
		candidatoServiceImpl.salvar(candidato);
		return "redirect:/candidato/listar";
	}
	
	@GetMapping("/visualizar/{codigo}")
	public String visualizar(@PathVariable("codigo") Integer codigo, Model model) {
		model.addAttribute("candidato", candidatoServiceImpl.buscarPorCodigo(codigo));
		model.addAttribute("partidos", partidoServiceImpl.listar());
		model.addAttribute("cargos", Arrays.asList(Cargo.values()));
		return "candidato/visualizar";
	}
	
	@PostMapping("/alterar")
	public String alterar(@Valid Candidato candidato, BindingResult erros) {
		if (erros.hasErrors()) {
			return "candidato/visualizar";
		}
		candidatoServiceImpl.salvar(candidato);
		return "redirect:/candidato/listar";
	}
	
	@GetMapping("/deletar/{codigo}")
	public String deletar(@PathVariable("codigo") Integer codigo) {
		Candidato candidato = candidatoServiceImpl.buscarPorCodigo(codigo);
		candidatoServiceImpl.excluir(candidato);
		return "redirect:/candidato/listar";
	}

}
