package br.com.tardeli.eleicao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tardeli.eleicao.model.Partido;
import br.com.tardeli.eleicao.repository.PartidoRepository;
import br.com.tardeli.eleicao.service.PartidoService;

@Service
public class PartidoServiceImpl implements PartidoService {

	@Autowired
	private PartidoRepository partidoRepository;
	
	@Override
	public void salvar(Partido partido) {
		partidoRepository.save(partido);
		
	}

	@Override
	public void excluir(Partido partido) {
		partidoRepository.delete(partido);
	}

	@Override
	public List<Partido> listar() {
		return partidoRepository.findAll();
 	}

	@Override
	public Partido buscarPorCodigo(Integer codigo) {
		return partidoRepository.findById(codigo).orElse(new Partido());
	}
}
