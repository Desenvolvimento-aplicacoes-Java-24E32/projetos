package br.edu.infnet.appElberth.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appElberth.model.domain.Alimenticio;

@Service
public class AlimenticioService {

	private Map<Integer, Alimenticio> mapa = new HashMap<Integer, Alimenticio>();
	private Integer id = 0;			
	
	public void incluir(Alimenticio alimenticio) {
		alimenticio.setId(++id);
		
		mapa.put(alimenticio.getId(), alimenticio);
	}
	
	public Collection<Alimenticio> obterLista(){
		return mapa.values();
	}
	
	public Alimenticio obterPorId(Integer id) {
		return mapa.get(id);
	}
	
	public void excluir(Integer id) {
		mapa.remove(id);
	}
	
	public int obterQtde() {
		return mapa.size();
	}
	
}