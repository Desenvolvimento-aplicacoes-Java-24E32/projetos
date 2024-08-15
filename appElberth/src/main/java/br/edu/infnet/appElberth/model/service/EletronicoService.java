package br.edu.infnet.appElberth.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appElberth.model.domain.Eletronico;
import br.edu.infnet.appElberth.model.repository.EletronicoRepository;

@Service
public class EletronicoService {

	@Autowired
	private EletronicoRepository eletronicoRepository;
	
	public void incluir(Eletronico eletronico) {
		eletronicoRepository.save(eletronico);
	}
	
	public Iterable<Eletronico> obterLista(){
		return eletronicoRepository.findAll();
	}
	
	public Eletronico obterPorId(Integer id) {
		return eletronicoRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		eletronicoRepository.deleteById(id);
	}

	public long obterQtde() {
		return eletronicoRepository.count();
	}
}