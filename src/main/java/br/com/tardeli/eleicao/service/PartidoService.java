package br.com.tardeli.eleicao.service;

import java.util.List;

import br.com.tardeli.eleicao.model.Partido;

public interface PartidoService {
	public void salvar(Partido partido);
	public void excluir(Partido partido);
	public List<Partido> listar();
	public Partido buscarPorCodigo(Integer codigo);
}
