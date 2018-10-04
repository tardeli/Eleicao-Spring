package br.com.tardeli.eleicao.service;

import java.util.List;

import br.com.tardeli.eleicao.model.Candidato;;;

public interface CandidatoService {
	public void salvar(Candidato candidato);
	public void excluir(Candidato candidato);
	public List<Candidato> listar();
	public List<Candidato> listarPorNome(String nome);
	public List<Candidato> listarPorCPF(Long cpf);
	public Candidato buscarPorCodigo(Integer codigo);
	public List<Candidato> dadosGrid();
}
