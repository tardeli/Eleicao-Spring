package br.com.tardeli.eleicao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tardeli.eleicao.model.Eleitor;
import br.com.tardeli.eleicao.repository.EleitorRepository;
import br.com.tardeli.eleicao.service.EleitorService;

@Service
public class EleitorServiceImpl implements EleitorService {

	@Autowired
	private EleitorRepository eleitorRepository;
	
	@Override
	public void salvar(Eleitor eleitor) {
		eleitorRepository.save(eleitor);
	}

	@Override
	public void excluir(Eleitor eleitor) {
		eleitorRepository.delete(eleitor);
	}

	@Override
	public List<Eleitor> listar() {
		return eleitorRepository.findAll();
 	}

	@Override
	public Eleitor buscarPorTitulo(Long titulo) {
		return eleitorRepository.buscarPorTitulo(titulo);
	}
	
}
