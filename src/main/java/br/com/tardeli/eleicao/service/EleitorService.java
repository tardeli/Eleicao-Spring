package br.com.tardeli.eleicao.service;

import java.util.List;

import br.com.tardeli.eleicao.model.Eleitor;

public interface EleitorService {
	public void salvar(Eleitor eleitor);
	public void excluir(Eleitor eleitor);
	public List<Eleitor> listar();
	public Eleitor buscarPorTitulo(Long titulo);
}
