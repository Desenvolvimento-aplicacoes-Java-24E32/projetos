package br.edu.infnet.appElberth.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appElberth.model.domain.Alimenticio;
import br.edu.infnet.appElberth.model.repository.AlimenticioRepository;

@Service
public class AlimenticioService {

	@Autowired
	private AlimenticioRepository alimenticioRepository;

	public void incluir(Alimenticio alimenticio) {
		try {
			alimenticioRepository.save(alimenticio);
		} catch (Exception e) {
			System.err.println("[ERROR] " + e.getMessage());
		}
	}
	
	public Iterable<Alimenticio> obterLista(){
		return alimenticioRepository.findAll();
	}
	
	public Alimenticio obterPorId(Integer id) {
		return alimenticioRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		alimenticioRepository.deleteById(id);
	}
	
	public long obterQtde() {
		return alimenticioRepository.count();
	}
	
}