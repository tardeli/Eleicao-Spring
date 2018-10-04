package br.com.tardeli.eleicao.service;

import java.util.List;

import br.com.tardeli.eleicao.model.Voto;

public interface VotoService {
	public void salvar(Voto voto);
	public void excluir(Voto voto);
	public List<Voto> listar();
	public Voto buscarPorCodigo(Long codigo);
}
