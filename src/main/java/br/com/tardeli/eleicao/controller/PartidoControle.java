package br.com.tardeli.eleicao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tardeli.eleicao.model.Partido;
import br.com.tardeli.eleicao.service.impl.PartidoServiceImpl;

@Controller
@RequestMapping("/partido")
public class PartidoControle {
	
	@Autowired
	private PartidoServiceImpl partidoServiceImpl;
	
	@GetMapping("/")
	public String home() {
		return "../index";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("partidos", partidoServiceImpl.listar());
		return "partido/listar";
	}
	
	@GetMapping("/novo")
	public String formulario() {
		return "partido/novo";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Partido partido, BindingResult erros) {
		if (erros.hasErrors()) {
			return "partido/novo";
		}
		partidoServiceImpl.salvar(partido);
		return "redirect:/partido/listar";
	}
	
	@GetMapping("/visualizar/{codigo}")
	public String visualizar(@PathVariable("codigo") Integer codigo, Model model) {
		model.addAttribute("partido", partidoServiceImpl.buscarPorCodigo(codigo));
		return "partido/visualizar";
	}
	
	@PostMapping("/alterar")
	public String alterar(@Valid Partido partido, BindingResult erros) {
		if (erros.hasErrors()) {
			return "partido/visualizar";
		}
		partidoServiceImpl.salvar(partido);
		return "redirect:/partido/listar";
	}
	
	@GetMapping("/deletar/{codigo}")
	public String deletar(@PathVariable("codigo") Integer codigo) {
		Partido partido = partidoServiceImpl.buscarPorCodigo(codigo);
		partidoServiceImpl.excluir(partido);
		return "redirect:/partido/listar";
	}

}
