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

import br.com.tardeli.eleicao.model.Eleitor;
import br.com.tardeli.eleicao.service.impl.EleitorServiceImpl;

@Controller
@RequestMapping("/eleitor")
public class EleitorControle {
	
	@Autowired
	private EleitorServiceImpl eleitorServiceImpl;
	
	@GetMapping("/")
	public String home() {
		return "../index";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("eleitores", eleitorServiceImpl.listar());
		return "eleitor/listar";
	}
	
	@GetMapping("/novo")
	public String formulario() {
		return "eleitor/novo";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Eleitor eleitor, BindingResult erros) {
		if (erros.hasErrors()) {
			return "eleitor/novo";
		}
		eleitorServiceImpl.salvar(eleitor);
		return "redirect:/eleitor/listar";
	}
	
	@GetMapping("/visualizar/{codigo}")
	public String visualizar(@PathVariable("codigo") Long titulo, Model model) {
		model.addAttribute("eleitor", eleitorServiceImpl.buscarPorTitulo(titulo));
		return "eleitor/visualizar";
	}
	
	@PostMapping("/alterar")
	public String alterar(@Valid Eleitor eleitor, BindingResult erros) {
		if (erros.hasErrors()) {
			return "eleitor/visualizar";
		}
		eleitorServiceImpl.salvar(eleitor);
		return "redirect:/eleitor/listar";
	}
	
	@GetMapping("/deletar/{codigo}")
	public String deletar(@PathVariable("codigo") Long titulo) {
		Eleitor eleitor = eleitorServiceImpl.buscarPorTitulo(titulo);
		eleitorServiceImpl.excluir(eleitor);
		return "redirect:/eleitor/listar";
	}

}
