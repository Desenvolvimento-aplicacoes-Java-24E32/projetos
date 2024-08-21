package br.edu.infnet.appElberth.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appElberth.model.domain.Eletronico;
import br.edu.infnet.appElberth.model.repository.EletronicoRepository;

@Service
public class EletronicoService {

	@Autowired
	private EletronicoRepository eletronicoRepository;
	
	public void incluir(Eletronico eletronico) {
		try {
			eletronicoRepository.save(eletronico);
		} catch (Exception e) {
			System.err.println("[ERROR] " + e.getMessage());
		}
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
	
	public Collection<Eletronico> obterPorMarca(String marca){
		return eletronicoRepository.findByMarcaContaining(marca);
	}
}