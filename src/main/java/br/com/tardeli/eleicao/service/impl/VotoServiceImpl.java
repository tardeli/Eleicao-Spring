package br.com.tardeli.eleicao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tardeli.eleicao.model.Voto;
import br.com.tardeli.eleicao.repository.VotoRepository;
import br.com.tardeli.eleicao.service.VotoService;

@Service
public class VotoServiceImpl implements VotoService {

	@Autowired
	private VotoRepository votoRepository;
	
	@Override
	public void salvar(Voto voto) {
		votoRepository.save(voto);
	}

	@Override
	public void excluir(Voto voto) {
		votoRepository.delete(voto);
	}

	@Override
	public List<Voto> listar() {
		return votoRepository.findAll();
 	}

	@Override
	public Voto buscarPorCodigo(Long codigo) {
		return votoRepository.findById(codigo).orElse(new Voto());
	}
}
